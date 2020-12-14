package java核心技术.Chapter6;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName ComparatorTest
 * @Date 2020/10/9 15:10
 * @Created by sakura
 * 分析：原来我们可以按照字典顺序对Employee对象进行排序，现在我想对一个字符串数组进行排序，但是按照字符串长度来排序。
 * Arrays.sort()提供了另一种方法，第一个参数是数组，第二个是实现了Comparator接口的类的实例。
 **/

public class ComparatorTest {
    static class LengthComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return -(o1.length() - o2.length());
        }
    }

    public static void main(String[] args) {
        String[] friends = {"peter", "paul", "sakura"};
        LengthComparator comp = new LengthComparator();
        Arrays.sort(friends, comp);
        for (String friend:
             friends) {
            System.out.println(friend);
        }
    }

}
