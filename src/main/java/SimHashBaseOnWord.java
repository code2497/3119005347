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
        Hash s = new Hash();
    }

    public SimHashBaseOnWord(int hashBitCount) {
        this.hashBitCount = hashBitCount;
    }

    protected double scoreImpl(List<Word> words1, List<Word> words2){
        return 0;
    }

    /**
     * 计算等长的SimHash值的汉明距离
     * @param simHash1 SimHash值1
     * @param simHash2 SimHash值2
     * @return 汉明距离
     */
    public int hammingDistance(String simHash1, String simHash2) {
        if (simHash1.length() != simHash2.length()) {
            return this.hashBitCount;
        }

        int distance = 0;
        int len = simHash1.length();
        for (int i = 0; i < len; i++) {
            if (simHash1.charAt(i) != simHash2.charAt(i)) {
                distance++;
            }
        }

        return distance;
    }

    /**
     * 对文本进行分词
     * @param text
     * @return
     */
    private List<Word> seg(String text) {
        if(text == null){
            return Collections.emptyList();
        }

        Segmentation segmentation  = SegmentationFactory.getSegmentation(SegmentationAlgorithm.MaxNgramScore);
        List<Word> words = segmentation.seg(text);
        if(filterStopWord) {
            //停用词过滤
            StopWord.filterStopWords(words);
        }
        return words;
    }




}
