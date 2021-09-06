package 剑指offer.剑指offer55_二叉树的深度;

import 二叉树.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
