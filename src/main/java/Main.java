public class Main {
    public static void main(String[] args) {

        if (args == null) {
            throw new NullPointerException("参数不能为null");
        }
        if (args.length != 3) {
            System.out.println("您调用main方法时没有指定任何参数！");
        } else {
            String text1 =  ReadTxt.readTxt(args[0]);
            String text2 =  ReadTxt.readTxt(args[1]);
            System.out.println(text1);
            if (text1 == null || text2 == null) {
                System.out.println("文件读取失败！");
                return;
            }
            CalSimilarity textSimilarity = new CalSimilarity();
            double score1pk2 = textSimilarity.similarScore(text1, text2);
            System.out.println("相似度分值："+score1pk2);
        }
    }
}
