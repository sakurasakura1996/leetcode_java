package 二叉树.剑指offer55_I_二叉树的深度;

import 二叉树.TreeNode;

/**
 * @ClassName Solution
 * @Date 2020/12/9 21:32
 * @Created by sakura
 * 分析：简单的二叉树问题，基本上都可以用递归方法来解决啦。
 **/

public class Solution {
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        else{
            int left_depth = maxDepth(root.left);
            int right_depth = maxDepth(root.right);
            return Math.max(left_depth, right_depth) + 1;
        }
    }
    public static void main(String[] args) {
        TreeNode root  = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        root.left = root1;
        root.right = root2;
        int ans = new Solution().maxDepth(root);
        System.out.println(ans);

    }
}
