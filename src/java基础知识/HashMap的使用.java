package java基础知识;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMap的使用 {
    static Map<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        // add an element
        hashMap.put(2, 3);
        hashMap.put(3, 4);
        hashMap.put(4, 5);

        //remove an element: remove it by (key) or (key, value)
        hashMap.remove(2);
        hashMap.remove(3, 4);

        //iter the hashMap, it's difficult from python, we should use Iterator to iter the hashMap
        Iterator iterator = hashMap.keySet().iterator();
        while(iterator.hasNext()){
            int key = (int)iterator.next();
            System.out.println("key:"+key);
            System.out.println("value:"+hashMap.get(key));
        }

        //another way
        Set<Map.Entry<Integer, Integer>> sets = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> entry :
                sets) {
            System.out.print(entry.getKey()+": ");
            System.out.println(entry.getValue());
        }

        System.out.println(hashMap);


    }
}
