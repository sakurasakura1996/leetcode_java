package 剑指offer数据结构入门;
/* 考察数据结构的
* 这道题晃着一看，我会用滑动窗口来写，但是这里说用数据结构，那到底怎么写呢？*/
public class Problem53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int left = 0, right = 0;
        int ans = Integer.MIN_VALUE, sum = 0;
        while (right < len) {
            sum += nums[right];
            ans = Math.max(ans, sum);
            if (sum < 0) {
                left = right+1;   //这里的left好像并没有卵用啊
                sum = 0;
            }
            right ++;
        }
        return ans;
    }

    public int maxSubArray2(int[] nums) {
        // 使用动态规划方法来写  dp[i]表示以i结尾的最大子序和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = Math.max(Integer.MIN_VALUE, nums[0]);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int maxSubArray3(int[] nums) {
        // 上面写的动态规划太丑了
        int pre = 0, maxAns = nums[0];
        for (int x: nums) {
            pre = Math.max(pre+x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;

    }

    public static void main(String[] args) {
        int[] nums = {-1};
        int ans = new Problem53().maxSubArray(nums);
        System.out.println(ans);
    }
}
