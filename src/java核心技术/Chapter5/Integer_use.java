package java核心技术.Chapter5;

/**
 * @ClassName Integer_use
 * @Date 2020/10/5 15:48
 * @Created by sakura
 **/
public class Integer_use {
    public static void main(String[] args) {
        //练习使用 对象包装器，int 这种为基本类型，与之对应的有一个包装器类。
        Integer n = 5;   // 自动装箱
        int num = n.intValue();
        System.out.println(num);
        int num1 = Integer.parseInt("45");
        System.out.println(num1);
        String nums1_str = Integer.toString(num1);
        System.out.println(nums1_str);
        Integer integer = Integer.valueOf("456");
        String num2_str = integer.toString();
        int num2 = integer.intValue();
        System.out.println(num2_str);
        System.out.println(num2);
    }
}
