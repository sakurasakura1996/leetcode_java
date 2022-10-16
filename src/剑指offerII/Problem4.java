package 剑指offerII;

/**
 * @author chenz
 * @ClassName Problem4
 * @Description 剑指 Offer II 004. 只出现一次的数字
 * @date 2021/11/25-10:50
 */
public class Problem4 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total%3!=0) {
                ans |= (1<<i);
            }
        }
        return ans;
    }
}
