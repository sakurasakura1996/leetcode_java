package 按顺序刷题.problem165_比较版本号;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1_str = version1.split("\\.");
        String[] version2_str = version2.split("\\.");
        int[] version1_nums = new int[Math.max(version1_str.length, version2_str.length)];
        int[] version2_nums = new int[Math.max(version1_str.length, version2_str.length)];
        for (int i = 0; i < version1_str.length; i++) {
            version1_nums[i] = Integer.valueOf(version1_str[i]);
        }
        for (int i = 0; i < version2_str.length; i++) {
            version2_nums[i] = Integer.valueOf(version2_str[i]);
        }
        for (int i = 0; i < version1_nums.length; i++) {
            if (version1_nums[i] == version2_nums[i]){
                continue;
            }else if (version1_nums[i] < version2_nums[i]){
                return -1;
            }else if (version1_nums[i] > version2_nums[i]){
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String version1 = "1.01";
        String version2 = "1.001";
        int ans = solution.compareVersion(version1, version2);
        System.out.println(ans);
    }
}
