package JianZhiOffer.剑指offer50_第一个只出现一次的字符;

import java.util.LinkedHashMap;
import java.util.Map;

/* 这里字符串长度的上界是 50000，有点大 */
public class Solution {
    public char firstUniqChar(String s) {
        if (s == null) return ' ';
        Map<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
