import org.junit.Test;

public class CalSimilarityTest {
    // hammingDistance
    CalSimilarity s = new CalSimilarity();
    @Test
    public void hammingDistanceTestRight () {
        System.out.println(s.hammingDistance("110100101001000011000011","110100101001011111000011"));
    }
    @Test
    public void hammingDistanceTestWrong () {
        System.out.println(s.hammingDistance("110100101001000011000011","1101001010010111110"));
    }
    @Test
    public void hammingDistanceTestNull () {
        try {
            System.out.println(s.hammingDistance(null,null));
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}
