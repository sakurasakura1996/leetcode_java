package leetcode周赛.第271周赛;

import shopee.interview.Solution;

/**
 * @author chenz
 * @ClassName Solution1
 * @Description TODO
 * @date 2021/12/12-11:17
 */
public class Solution1 {
    public int countPoints(String rings) {
        int len = rings.length()/2;
        int[][] nums = new int[10][3];   // 0-9分别存储 0-9个杆子的颜色，
        int ans = 0;
        for (int i = 0; i < len; i++) {
            char c = rings.charAt(2 * i);
            int n = Integer.parseInt(String.valueOf(rings.charAt(2 * i + 1)));
            if (c - 'a' == 'R' - 'a' && nums[n][0] == 0) {
                nums[n][0] = 1;
            } else if (c - 'a' == 'G' - 'a' && nums[n][1] == 0) {
                nums[n][1] = 1;
            } else if (c - 'a' == 'B' - 'a' && nums[n][2] == 0) {
                nums[n][2] = 1;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (nums[i][0] == 1 && nums[i][1] == 1 && nums[i][2] == 1) {
                ans ++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        String rings = "B9R9G0R4G6R8R2R9G9";
        int ans = new Solution1().countPoints(rings);
        System.out.println(ans);

    }
}
