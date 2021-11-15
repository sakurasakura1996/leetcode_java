package 每日一题.problem447_回旋镖的数量;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points.length < 3) return 0;
        int m = points.length;
        Map<Integer, Map<Integer, Integer>> records = new HashMap<Integer, Map<Integer, Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                int dis = (int) ((int) Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                handle(records, i, dis);
                handle(records, j, dis);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Map<Integer, Integer>> entry :
                records.entrySet()) {
            Map<Integer, Integer> newMap = entry.getValue();
            for (Map.Entry<Integer, Integer> entry1: newMap.entrySet()) {
                int value = entry1.getValue();
                int tmp = value > 1 ? value * (value - 1) : 0;
                ans += tmp;
            }
        }
        return ans;
    }

    public static void handle(Map<Integer, Map<Integer, Integer>> records, int i, int dis) {
        if (records.containsKey(i) && records.get(i).containsKey(dis)) {
            int origin = records.get(i).get(dis);
            records.get(i).put(dis, origin+1);
        } else if (records.containsKey(i) && !records.get(i).containsKey(dis)) {
            records.get(i).put(dis, 1);
        } else {
            Map<Integer, Integer> newMap = new HashMap<>();
            newMap.put(dis, 1);
            records.put(i, newMap);
        }
    }

    /* 上面的方法可以，思路也是对的，但是想复杂了，存储结构不用那么复杂。
    * 下面这个写法虽然简单，但是写起来，比较难理解*/
    public int numberOfBoomerangs2(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            for (int[] q : points) {
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }

}
