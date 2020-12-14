package java核心技术.Chapter9;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @ClassName SelfArrayList
 * @Date 2020/12/7 21:46
 * @Created by sakura
 * 分析：
 **/
public class SelfArrayList<T> extends ArrayList implements Iterable {

    public static void main(String[] args) {
        SelfArrayList<Integer> selfArrayList = new SelfArrayList<>();

        selfArrayList.add(2);
        selfArrayList.add("hello");
        selfArrayList.add("world");

        Iterator iterator = selfArrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
