import org.apdplat.word.analysis.TextSimilarity;
import org.apdplat.word.recognition.StopWord;
import org.apdplat.word.segmentation.Segmentation;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.SegmentationFactory;
import org.apdplat.word.segmentation.Word;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;


public class SimHashBaseOnWord extends TextSimilarity  {
    // 生成 64 位的 SimHash
    private int hashBitCount = 64;
    public SimHashBaseOnWord(){
    }

    public SimHashBaseOnWord(int hashBitCount) {
        this.hashBitCount = hashBitCount;
    }

    protected double scoreImpl(List<Word> words1, List<Word> words2){
        return 0;
    }


    /**
     * 计算词列表的SimHash值，通过分词的时候已经统计了词的权重
     * @param words 词列表
     * @return SimHash值
     */
    private String simHash(List<Word> words) {
        float[] hashBit = new float[hashBitCount];
        words.forEach(word -> {
            float weight = word.getWeight()==null?1:word.getWeight();
            BigInteger hash = hash(word.getText());
            for (int i = 0; i < hashBitCount; i++) {
                BigInteger bitMask = new BigInteger("1").shiftLeft(i);
                if (hash.and(bitMask).signum() != 0) {
                    hashBit[i] += weight;
                } else {
                    hashBit[i] -= weight;
                }
            }
        });

        StringBuffer fingerprint = new StringBuffer();
        for (int i = 0; i < hashBitCount; i++) {
            if (hashBit[i] >= 0) {
                fingerprint.append("1");
            }else{
                fingerprint.append("0");
            }
        }

        return fingerprint.toString();
    }

    /**
     *  Hash 算法
     * @param word 词
     * @return 哈希值
     */
    private BigInteger hash(String word) {
        if (word == null || word.length() == 0) {
            return new BigInteger("0");
        }

        char[] charArray = word.toCharArray();
        BigInteger x = BigInteger.valueOf(((long) charArray[0]) << 7);
        BigInteger m = new BigInteger("1000003");
        BigInteger mask = new BigInteger("2").pow(hashBitCount).subtract(new BigInteger("1"));
        long sum = 0;
        for (char c : charArray) {
            sum += c;
        }

        x = x.multiply(m).xor(BigInteger.valueOf(sum)).and(mask);
        x = x.xor(new BigInteger(String.valueOf(word.length())));
        if (x.equals(new BigInteger("-1"))) {
            x = new BigInteger("-2");
        }

        return x;
    }


}
