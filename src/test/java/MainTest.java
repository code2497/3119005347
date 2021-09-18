import org.junit.Test;

public class MainTest {
    String root = "C:\\Users\\code\\Desktop\\text\\";
    @Test
    public void readTxtTestRight () {
        String args[] = {root + "orig.txt", root + "orig_0.8_del.txt", root};
        Main.main(args);
    }
    @Test
    public void readTxtTestNull () {
        try{
            Main.main(null);
        }catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    @Test
    public void readTxtTestWrong () {
        String args[] = {"","",""};
        Main.main(args);
    }



}
