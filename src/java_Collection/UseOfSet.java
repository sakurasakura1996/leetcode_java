package java_Collection;

import sun.reflect.generics.tree.Tree;

import javax.jws.soap.SOAPBinding;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class UseOfSet {

    public Set<Integer> hashSet = new HashSet<>();   // 基于哈希表实现，O(1)查找效率， 不支持有序性操作，也就是说用Iterator遍历结果不确定
    public Set<String> stringHashSet = new HashSet<>();
    public Set<Integer> linkedHashSet = new LinkedHashSet<>();   // 具有HashSet的查找效率，且内部使用双链表维护元素的插入顺序。

    public Set<Integer> treeSet = new TreeSet<>();   // 基于红黑树实现 ， 查找效率 O(logN)


    public static void main(String[] args) {
        UseOfSet useOfSet = new UseOfSet();
        useOfSet.hashSet.add(3);
        useOfSet.hashSet.add(3);   // 还是具有set的功能，不存储重复元素，但这里是基本内省，如果String这种呢。
        useOfSet.hashSet.add(8);
        System.out.println(useOfSet.hashSet);

        String s1 = new String("string");
        String s2 = new String("string");
        useOfSet.stringHashSet.add("string");
        useOfSet.stringHashSet.add("string");   // hashset这种插入String还是这样
        System.out.println(useOfSet.stringHashSet);

        useOfSet.stringHashSet.clear();
        useOfSet.stringHashSet.add(s1);
        useOfSet.stringHashSet.add(s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(useOfSet.stringHashSet);

        // LinkedHashSet

        useOfSet.linkedHashSet.add(9);
        useOfSet.linkedHashSet.add(9);
        System.out.println(useOfSet.linkedHashSet);

        useOfSet.treeSet.add(3);
        useOfSet.treeSet.add(9);
        useOfSet.treeSet.add(4);
        System.out.println(useOfSet.treeSet);     // TreeSet继承自 SortedSet， 维护顺序。
        System.out.println(useOfSet.treeSet.contains(4));    // 利用红黑树查找元素，时间复杂度是 O(logN)



    }

}
