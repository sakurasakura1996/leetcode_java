/**
 * @ClassName problem27_移除元素
 * @Date 2020/9/28 17:02
 * @Created by sakura
 **/

class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int cur = 0;
        int common = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == val){
                common ++;
                continue;
            }else{
                nums[cur] = nums[i];
                cur ++;
            }

        }
        return n - common;

    }
}

public class problem27_移除元素 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int ans = solution.removeElement(nums, val);
        System.out.println(ans);
    }



}
