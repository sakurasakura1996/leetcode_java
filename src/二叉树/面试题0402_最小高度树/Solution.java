package 二叉树.面试题0402_最小高度树;


import java.util.Arrays;

/**
 * @ClassName Solution
 * @Date 2020/12/9 20:52
 * @Created by sakura
 * 分析：
 **/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums){
        int len = nums.length;
        if (len == 0){
            return null;
        }else if(len == 1) {
            return new TreeNode(nums[0]);
        }else{
            TreeNode root = new TreeNode(nums[len/2]);
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, len/2));
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, len/2+1, len));
            return root;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode ans = solution.sortedArrayToBST(nums);
        System.out.println(ans.val);
        System.out.println(ans.left.val);
        System.out.println(ans.right.val);
    }
}
