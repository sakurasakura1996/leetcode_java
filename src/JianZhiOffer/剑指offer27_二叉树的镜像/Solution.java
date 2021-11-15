package JianZhiOffer.剑指offer27_二叉树的镜像;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {this.val = x;}
}

public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        mirrorTree(root.left);
        mirrorTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
