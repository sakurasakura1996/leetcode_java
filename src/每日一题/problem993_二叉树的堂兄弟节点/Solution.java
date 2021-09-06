package 每日一题.problem993_二叉树的堂兄弟节点;




class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    TreeNode x_father, y_father;
    int x_depth, y_depth;
    boolean x_found, y_found;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, null, x, y);
        return x_depth == y_depth && x_father != y_father;
    }

    public void dfs(TreeNode root, int depth, TreeNode parent, int x, int y){
        if (root == null){
            return;
        }
        if (root.val == x){
            x_father = parent;
            x_depth = depth;
            x_found = true;
        }else if (root.val == y){
            y_father = parent;
            y_depth = depth;
            y_found = true;
        }
        if (x_found && y_found){
            return;
        }
        dfs(root.left, depth + 1, root, x, y);
        if (x_found && y_found){
            return;
        }
        dfs(root.right, depth + 1, root, x, y);
    }

}