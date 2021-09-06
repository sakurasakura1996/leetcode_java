package 每日一题.problem692_前K个高频单词;

import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> hashMap = new HashMap<>();
        for (String word :
                words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }
        List<String> rec = new ArrayList<>();
        for (Map.Entry<String, Integer> entry :
                hashMap.entrySet()) {
            rec.add(entry.getKey());
        }
        Collections.sort(rec, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return hashMap.get(o1) == hashMap.get(o2) ? o1.compareTo(o2) : hashMap.get(o2) - hashMap.get(o1);
            }
        });
        return rec.subList(0, k);
    }
}
