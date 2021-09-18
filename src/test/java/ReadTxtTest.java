import org.junit.Test;

public class ReadTxtTest {
    String root = System.getProperty("user.dir");

    @Test
    public void readTxtTestRight () {
        System.out.println(IOTxt.readTxt(root + "\\src\\resource\\orig.txt"));
    }
    @Test
    public void readTxtTestError () {
        System.out.println(IOTxt.readTxt(root + "\\src\\re\\orig.txt"));
    }
    @Test
    public void readTxtTestNull () {
        try {
            System.out.println(IOTxt.readTxt(null));
        } catch (NullPointerException e){
            System.out.println(e);
        }
    }

    @Test
    public void writeTxtTestRight () {
        IOTxt.writeTxt(root + "\\src\\resource\\test.txt", "TEST CONTENT");
    }
    @Test
    public void writeTxtTestNullPath () {
        try {
            IOTxt.writeTxt(null, "TEST CONTENT");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Test
    public void writeTxtTestNullContent () {
        IOTxt.writeTxt(root + "\\src\\resource\\test.txt", null);
    }
    @Test
    public void writeTxtTestNull () {
        try {
            IOTxt.writeTxt(null, null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
