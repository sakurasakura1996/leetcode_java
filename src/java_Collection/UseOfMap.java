package java_Collection;

import com.sun.xml.internal.org.jvnet.fastinfoset.sax.FastInfosetReader;

import javax.transaction.TransactionRequiredException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UseOfMap {
    public Map<Integer, String> hashMap = new HashMap<>();   // 基于hash表实现
    public Map<String, String> hashMap2 = new HashMap<>();

    public Map<String, String> linkedHashMap = new LinkedHashMap<>();

    public Map<Integer, String> hashTable = new Hashtable<>();  // 遗留类，没用的，现在用 ConcurrentHashMap
    public Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();

    public Map<Integer, String> treeMap = new TreeMap<>();    //继承自 SortedMap， 基于红黑树实现

    public static void main(String[] args) {
        UseOfMap useOfMap = new UseOfMap();
        useOfMap.hashMap.put(0, "sakura");
        useOfMap.hashMap.put(1, "sakura");
        useOfMap.hashMap2.put("hello", "world");

        System.out.println(useOfMap.hashMap.get(0));
        useOfMap.hashMap2.remove("hello");
        System.out.println(useOfMap.hashMap2);

        useOfMap.treeMap.put(1, "sakura");
        useOfMap.treeMap.put(0, "sakura");
        System.out.println(useOfMap.treeMap);   //这样是不能直接输出内容了。

        // 怎么遍历呢？
        Iterator<Integer> iterator = useOfMap.hashMap.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(useOfMap.hashMap.get(iterator.next()));
        }








    }





}
