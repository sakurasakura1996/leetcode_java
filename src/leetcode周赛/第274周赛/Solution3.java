package leetcode周赛.第274周赛;

import java.util.Arrays;

/**
 * @author chenz
 * @ClassName Solution3
 * @Description 这道题的问题在于数据量是 10的五次方，所以如果直接排序的话可能会超时，不然直接排序就解决了
 * @date 2022/1/2-11:12
 */
public class Solution3 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long num = mass;
        for (int i = 0; i < asteroids.length; i++) {
            if (num >= asteroids[i]){
                num += asteroids[i];
            } else {
                return false;
            }
        }
        return true;
    }
}
