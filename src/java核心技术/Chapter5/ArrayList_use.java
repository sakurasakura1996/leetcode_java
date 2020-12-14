package java核心技术.Chapter5;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import java.util.ArrayList;

/**
 * @ClassName ArrayList_use
 * @Date 2020/10/5 14:59
 * @Created by sakura
 **/
public class ArrayList_use {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        System.out.println(arrayList.size());
        // ArrayList虽然可以动态的扩容，但是读取就变得麻烦了，要用get，set来实现访问和改变数组值
        Integer integer = arrayList.get(0);
        System.out.println(integer);
//        arrayList.set(1, 9);  因为这里arrayList只有1个数，所以并不能设置第2个数为9.
        arrayList.set(0, 9);
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(0));
        // 可以这样操作，既可以灵活扩展数组，又可以方便的访问数组元素.直接利用上面的arrayList数组了
        arrayList.add(4);
        arrayList.add(9);
        // 使用toArray()方法将数组元素拷贝到一个数组中。
        Integer[] a = new Integer[arrayList.size()];  //注意这里要用泛型，所以int会报错的
        arrayList.toArray(a);
        System.out.println(a[0]);
        for (int number:
             arrayList) {
            System.out.println(number);

        }
    }
}
