package java核心技术.Chapter9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @ClassName LinkedListTest
 * @Date 2020/12/8 11:03
 * @Created by sakura
 * 分析：测试使用java中的链表结构 LinkedList，
 * LinkedList的使用有几个注意的地方 add方法是将元素添加到链表尾部，我们常常将元素添加到中间，这时候需要由迭代器Iterator来负责。
 * 自然有序的集合使用迭代器中添加元素才有意义，比如set类型，元素无序，在Iterator接口中就没有add方法。
 * 集合类库提供了ListIterator接口，可以使用add方法，普通的Iterator接口中并没有add方法，ListIterator接口中还提供了反向遍历的
 * previous()和hasPrevious()方法。
 **/
public class LinkedListTest {
    public static void main(String[] args) {
        List<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(3);
        a.add(5);

        List<Integer> b = new LinkedList<>();
        b.add(2);
        b.add(4);
        b.add(6);

        // merge the words from b into a
        ListIterator<Integer> aIter = a.listIterator();
        Iterator<Integer> bIter = b.iterator();

        while (bIter.hasNext()){
            if (aIter.hasNext()) {
                aIter.next();
            }
            aIter.add(bIter.next());
        }
        System.out.println(a);


        // remove every second word from b
        bIter = b.iterator();
        while (bIter.hasNext()){
            bIter.next();
            if(bIter.hasNext()){
                bIter.next();
                bIter.remove(); // 通过迭代其删除该元素，必须先用next()方法让索引跳过该元素
            }
        }
        System.out.println(b);

        // bulk operation : remove all words in b from a
        a.removeAll(b);

        System.out.println(a);
    }
}
