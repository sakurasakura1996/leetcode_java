package java_Collection;

import java.util.*;

public class UseOfList {
    //练习使用 List继承下来的容器类，包含 ArrayList, LinkedList, Vector（不怎么用了）

    public List<Integer> arrayList = new ArrayList<>();
    public List<Integer> linkedList = new LinkedList<>();
    public List<Integer> vector = new Vector<>();
    public List<Integer> stack = new Stack<>();



    public static void main(String[] args) {
        UseOfList useOfList = new UseOfList();
        useOfList.arrayList.add(1);
        useOfList.arrayList.add(0, 4);
        int[] a = {1, 2};
//      useOfList.arrayList.addAll(a);  为什么不行呢，应该不难理解，ArrayList 隶属于List接口，List继承自Collection，这里最起码要加入Collection类对象
        useOfList.linkedList.add(1);     // LinkedList 继承了 List和 Queue
        useOfList.linkedList.add(0, 4);
        useOfList.arrayList.addAll(1, useOfList.linkedList);   // 实际执行逻辑是 System.arraycopy(a, 0, elementData, size, numNew);

        System.out.println(useOfList.arrayList);  //[4,4,1,1]
        System.out.println(useOfList.linkedList);  //[4,1]
        useOfList.linkedList.add(3);
        System.out.println(useOfList.arrayList);   //[4,4,1,1]
        System.out.println(useOfList.linkedList);   //[4,1,3]  看来上面的 addAll并不是直接引用，而是copy了一份嘛

        // ArrayList 和 LinkedList 使用体验是一样的，只不过内部实现，一个是数组，一个是链表。
        // Vector类的使用
        useOfList.vector.add(1);
        useOfList.vector.addAll(0, useOfList.linkedList);
        System.out.println(useOfList.vector);

        for (Integer item :
                useOfList.arrayList) {
            System.out.println(item);
        }






    }


}
