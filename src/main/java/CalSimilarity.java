import org.apdplat.word.analysis.TextSimilarity;
import org.apdplat.word.recognition.StopWord;
import org.apdplat.word.segmentation.Segmentation;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.SegmentationFactory;
import org.apdplat.word.segmentation.Word;

import java.util.Collections;
import java.util.List;


public class CalSimilarity extends TextSimilarity  {

    // 生成 64 位的 SimHash
    private int hashBitCount = 64;

    public CalSimilarity(){
        Hash s = new Hash();
    }

    public CalSimilarity(int hashBitCount) {
        this.hashBitCount = hashBitCount;
    }

    protected double scoreImpl(List<Word> words1, List<Word> words2){
        //用词频来标注词的权重
        taggingWeightWithWordFrequency(words1, words2);
        //计算SimHash
        String simHash1 = new Hash().simHash(words1);
        String simHash2 = new Hash().simHash(words2);
        //计算SimHash值之间的汉明距离
        int hammingDistance = hammingDistance(simHash1, simHash2);
        if(hammingDistance == -1){
            return 0.0;
        }

        int maxDistance = simHash1.length();
        double score = (1 - hammingDistance / (double)maxDistance);
        return score;
    }

    /**
     * 计算等长的SimHash值的汉明距离
     * @param simHash1 SimHash值1
     * @param simHash2 SimHash值2
     * @return 汉明距离
     */
    public int hammingDistance(String simHash1, String simHash2) {
        if (simHash1 == null || simHash2 == null) {
            throw new NullPointerException("用于运算海明距离的字符串为空");
        }

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
