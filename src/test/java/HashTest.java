import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HashTest {
    @Test
    public void simHashTestRight () {
        List<Word> words = WordSegmenter.seg("什么是分词 分词就是将连续的字序列按照一定的规范重新组合成词序列的过程。");
        CalSimilarity textSimilarity = new CalSimilarity();
        Hash h = new Hash();
        System.out.println(h.simHash(words));
    }
    @Test
    public void simHashTestEmpty () {
        List<Word> words = new ArrayList<>();
        Hash h = new Hash();
        System.out.println(h.simHash(words));
    }
    @Test
    public void simHashTestNull () {
        Hash h = new Hash();
        try{
            System.out.println(h.simHash(null));
        }catch (NullPointerException e) {
            System.out.println(e);
        }
    }


    @Test
    public void hashTestRight () {
        System.out.println(new Hash().hash("什么是分词 分词就是将连续的字序列按照一定的规范重新组合成词序列的过程。"));
    }
    @Test
    public void hashTestEmpty () {
        System.out.println(new Hash().hash(""));
    }
    @Test
    public void hashTestNull () {
        System.out.println(new Hash().hash(null));
    }
}
