package leetcode周赛.第271周赛;

/**
 * @author chenz
 * @ClassName Solution3
 * @Description TODO
 * @date 2021/12/12-12:55
 */
public class Solution3 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int left = 0, right = plants.length-1;
        int ans = 0;
        int curA = capacityA;
        int curB = capacityB;
        while (left <= right) {
            if (left == right) {
                if (curA > curB || curA == curB) {
                    if (curA < plants[left]) {
                        ans ++;
                    }
                } else if (curA < curB) {
                    if (curB < plants[left]) {
                        ans ++;
                    }
                }
                break;
            } else {
                if (curA >= plants[left]) {
                    curA -= plants[left];
                } else {
                    curA = capacityA;
                    curA -= plants[left];
                    ans ++;
                }
                if (curB >= plants[right]) {
                    curB -= plants[right];
                } else {
                    curB = capacityB;
                    curB -= plants[right];
                    ans ++;
                }
                left++;
                right--;
            }

        }
        return ans;
    }
}
