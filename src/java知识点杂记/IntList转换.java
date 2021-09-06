package java知识点杂记;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntList转换 {
    // java中会涉及到 int[] 和 List<Interger> 以及 int[][] 和　List<List<Integer>>的转化，这个过程不是很熟悉，这里学习学习。
    public static void main(String[] args) {
        // int[] -> List<Integer>
        int[] data = {4, 5, 6, 5, 6, 7};

        List<Integer> list1 = Arrays.stream(data).boxed().collect(Collectors.toList());
        System.out.println(list1);
        // Arrays.stream(arr) 可以替换成IntStream.of(arr)。
        // 1.使用Arrays.stream将int[]转换成IntStream。
        // 2.使用IntStream中的boxed()装箱。将IntStream转换成Stream<Integer>。
        // 3.使用Stream的collect()，将Stream<T>转换成List<T>，因此正是List<Integer>。

        // int[] 转 Integer[]
        Integer[] integers1 = Arrays.stream(data).boxed().toArray(Integer[]::new);
        // 前两步同上，此时是Stream<Integer>。
        // 然后使用Stream的toArray，传入IntFunction<A[]> generator。
        // 这样就可以返回Integer数组。
        // 不然默认是Object[]。

        // List<Integer> 转 Integer[]
        Integer[] integers2 = list1.toArray(new Integer[0]);
        // 调用toArray。传入参数T[] a。这种用法是目前推荐的。
        // List<String>转String[]也同理。

        // List<Integer> 转 int[]
        int[] arr1 = list1.stream().mapToInt(Integer::valueOf).toArray();
        // 想要转换成int[]类型，就得先转成IntStream。
        // 这里就通过mapToInt()把Stream<Integer>调用Integer::valueOf来转成IntStream
        // 而IntStream中默认toArray()转成int[]。

        // Integer[] 转 int[]
        int[] arr2 = Arrays.stream(integers1).mapToInt(Integer::valueOf).toArray();
        // 思路同上。先将Integer[]转成Stream<Integer>，再转成IntStream。

        // Integer[] 转 List<Integer>
        List<Integer> list2 = Arrays.asList(integers1);
        // 最简单的方式。String[]转List<String>也同理。

        // 同理
        String[] strings1 = {"a", "b", "c"};
        // String[] 转 List<String>
        List<String> list3 = Arrays.asList(strings1);
        // List<String> 转 String[]
        String[] strings2 = list3.toArray(new String[0]);


        // int[][] 和 List<List<Integer>>的相互转换
        // 这个过程可以说很麻烦，https://blog.csdn.net/liqi299616/article/details/110420540 自己去看吧
        // 一般遇到leetcode中需要返回 int[][]的时候，我们首先定义一个 List<int[]> and = new ArrayList<>();就好了，然后后续
        // 往其中加入 int[]就可以，最后转换为 int[][]的时候，也不是很难，如下：
        List<int[]> list = new ArrayList<>();
        int[][] ints = list.toArray(new int[0][0]);


    }



}
