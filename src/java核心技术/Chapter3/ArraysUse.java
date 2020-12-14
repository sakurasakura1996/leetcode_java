package java核心技术.Chapter3;

import java.util.Arrays;

/**
 * @ClassName ArraysUse
 * @Date 2020/10/1 14:23
 * @Created by sakura
 **/
public class ArraysUse {



    public static void main(String[] args) {
        int[] a = {3, 56, 5, 34};
        Arrays.sort(a);
        for (int num:
             a) {
            System.out.println(num);
        }
        String aString = Arrays.toString(a);
        System.out.println(aString);
        int[] b = Arrays.copyOf(a, a.length);
        for (int bnum:
             b) {
            System.out.println(bnum);
        }
        int index = Arrays.binarySearch(b, 34);
        System.out.println(index);
        boolean flag = Arrays.equals(a, b);
        System.out.println(flag);

    }
}
