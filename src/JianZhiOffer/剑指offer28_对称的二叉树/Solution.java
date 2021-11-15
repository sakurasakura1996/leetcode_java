package JianZhiOffer.剑指offer28_对称的二叉树;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null) {return right == null;}
        else if (right == null) {return left == null;}
        else {
            return left.val == right.val && helper(left.right, right.left) && helper(left.left, right.right);
        }
    }
}
