package 每日一题.problem1610_可见点的最大数目;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenz
 * @ClassName Solution
 * @Description 我们可以以向东为开始，然后计算每个点相对观察点的角度，然后我们直接可以算角度就行了。
 * @date 2021/12/16-15:34
 */
public class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int sameCnt = 0;
        int x = location.get(0), y = location.get(1);
        List<Double> angles = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            int cur_x = points.get(i).get(0);
            int cur_y = points.get(i).get(1);
            // 计算cos值
            if (cur_x == x && cur_y == y) {
                sameCnt++;
                continue;
            }
            Double degree = Math.atan2(cur_y - y, cur_x - x);
            angles.add(degree);

        }
        Collections.sort(angles);
        int m = angles.size();
        for (int i = 0; i < m; i++) {
            angles.add(angles.get(i) + 2 * Math.PI);
        }

        int maxCnt = 0;
        int right = 0;
        double toDegree = angle * Math.PI / 180;
        for (int i = 0; i < m; i++) {
            Double curr = angles.get(i) + toDegree;
            while (right < angles.size() && angles.get(right) <= curr) {
                right ++;
            }
            maxCnt = Math.max(maxCnt, right - i);
        }
        return maxCnt + sameCnt;
    }
}
