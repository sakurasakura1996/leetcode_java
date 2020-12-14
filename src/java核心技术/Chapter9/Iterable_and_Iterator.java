package java核心技术.Chapter9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName Iterable_and_Iterator
 * @Date 2020/12/7 20:31
 * @Created by sakura
 * 分析：这里主要想研究下 Iterable 和 Iterator 两者之间的区别和联系。
 **/

public class Iterable_and_Iterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(90);

        // several traversal method
        System.out.println("The first method");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("The second method");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("The third method");
        for (Integer i :
                list) {
            System.out.println(i);
        }

    }
}
