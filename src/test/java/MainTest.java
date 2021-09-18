import org.junit.Test;

public class MainTest {
    String root = "C:\\Users\\code\\Desktop\\text\\";
    @Test
    public void mainTestRight () {
        String args[] = {root + "orig.txt", root + "orig_0.8_del.txt", root + "result.txt"};
        Main.main(args);
    }
    @Test
    public void mainTestNull () {
        try{
            Main.main(null);
        }catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    @Test
    public void mainTestWrong_1 () {
        String args[] = {"","",""};
        Main.main(args);
    }

    @Test
    public void mainTestWrong_2 () {
        String args[] = {"",""};
        Main.main(args);
    }

    @Test
    public void mainTestWrong_3 () {
        String args[] = {""};
        Main.main(args);
    }
}
