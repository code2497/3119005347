import java.io.File;

public class Main {
    public static void main(String[] args) {

        if (args == null) {
            throw new NullPointerException("参数不能为null");
        }
        if (args.length != 3) {
            System.out.println("您调用main方法时没有指定任何参数！");
        } else {
            String text1 =  IOTxt.readTxt(args[0]);
            String text2 =  IOTxt.readTxt(args[1]);
            if (text1 == null || text2 == null) {
                System.out.println("文件读取失败！");
                return;
            }
            File tempFile =new File(args[0].trim());
            String fName1 = tempFile.getName();
            tempFile =new File(args[1].trim());
            String fName2 = tempFile.getName();

            CalSimilarity textSimilarity = new CalSimilarity();
            double score1pk2 = textSimilarity.similarScore(text1, text2);

            String writePath = args[2];
            String writeContent = fName1 + "与" + fName2 +"相似度分值为："+score1pk2;
            IOTxt.writeTxt(writePath, writeContent);

            System.out.println("程序结果已写入" + args[2]);
        }
    }
}
