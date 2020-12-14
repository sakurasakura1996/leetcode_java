package java核心技术.Chapter3;

/**
 * @ClassName StringUse
 * @Date 2020/10/1 14:36
 * @Created by sakura
 **/
public class StringUse {
    public static void main(String[] args) {
        String str = "abcd";
        char ch = str.charAt(3);
        System.out.println(ch);
        int flag = str.compareTo("rabcdef");
        System.out.println(flag);
        boolean flag2 = str.equals("abcd");
        System.out.println(flag2);
        int index = str.indexOf("bc");
        System.out.println(index);
    }
}
