import org.junit.Test;

public class ReadTxtTest {
    String root = System.getProperty("user.dir");

    @Test
    public void readTxtTestRight () {
        System.out.println(ReadTxt.readTxt(root + "\\src\\resource\\orig.txt"));
    }
    @Test
    public void readTxtTestError () {
        System.out.println(ReadTxt.readTxt(root + "\\src\\re\\orig.txt"));
    }
    @Test
    public void readTxtTestNull () {
        try {
            System.out.println(ReadTxt.readTxt(null));
        } catch (NullPointerException e){
            System.out.println(e);
        }
    }
}
