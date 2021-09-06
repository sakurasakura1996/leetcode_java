package 每日一题.problem897_递增顺序搜索树;


import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode increasingBST(TreeNode root){
        if(root == null){
            return root;
        }
        // 这里正好，我们熟悉熟悉用java来递归和非递归二叉树的中序遍历；
        // 非递归，用栈来存储
        Deque<TreeNode> stack = new ArrayDeque<>();
        Stack<TreeNode> stack1 = new Stack<>();
        TreeNode ans = new TreeNode();
        TreeNode cur = ans;
        while (!stack.isEmpty() || root != null){
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                TreeNode node = stack.pop();
                cur.right = new TreeNode(node.val);
                cur = cur.right;
                root = node.right;
            }
        }
        return ans.right;
    }
}
