package 每日一题.problem997_找到小镇的法官;

import java.util.*;

/**
 * @author chenz
 * @ClassName Solution
 * @Description TODO
 * @date 2021/12/19-10:15
 */
public class Solution {
    public int findJudge(int n, int[][] trust) {
        // 那其实就是找到 所有的第二个元素中没有放在第一个元素中的人  必须所有人都得相信法官才行
        if (n == 1) return 1;   // 特殊情况需要注意啊。
        Set<Integer> hashSet = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] tmpList: trust) {
            int a = tmpList[0];
            int b = tmpList[1];
            hashSet.add(a);
            map.put(b, map.getOrDefault(b, 0) +1);
        }
        int ans = -1;
        // 错误理解了题目，必须其余所有人都要相信法官，所以必须显式的表现出来。
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (hashSet.contains(entry.getKey())) {
                continue;
            } else if (entry.getValue() == n - 1){
                ans = entry.getKey();
            }
        }
        return ans;
    }

    public int findJudge2(int n, int[][] trust) {
        // 看到题解说到了有向图，图中节点入度和出度的概念。计算各节点的入度出度就行了。
        // 这个思路确实更牛逼啊。能够直接排除所有情况了。没有什么特殊情况，直接给你所有情况全部包含住。
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];

        for (int[] edge : trust) {
            int x = edge[0], y = edge[1];
            inDegrees[y] ++;
            outDegrees[x] ++;
        }
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
