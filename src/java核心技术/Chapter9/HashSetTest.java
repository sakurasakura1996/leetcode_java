package java核心技术.Chapter9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName HashSetTest
 * @Date 2020/12/8 11:28
 * @Created by sakura
 * 分析：测试使用下HashSet的使用
 **/
public class HashSetTest {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        long totalTime = 0;

        try(Scanner in = new Scanner(System.in)){
            while(in.hasNext()){
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }
        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext(); i++) {
            System.out.println(iter.next());
        }
        // unorderd
        System.out.println("...");
        System.out.println(words.size() + "distince words" + totalTime + "milliseconds");
    }
}
