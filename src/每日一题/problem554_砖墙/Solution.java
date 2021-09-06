package 每日一题.problem554_砖墙;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int leastBricks(List<List<Integer>> wall){
        int m = wall.size();

        Map<Integer, Integer> hashMap = new HashMap<>();
        int ret = 0;
        for (List<Integer> list :
                wall) {
            int start = 0;
            for (int i = 0; i < list.size()-1; i++) {
                start += list.get(i);
                hashMap.put(start, hashMap.getOrDefault(start, 0) + 1);
                ret = Math.max(ret, hashMap.get(start));

            }
        }
        return m - ret;
    }

}
