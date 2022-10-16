package 按顺序刷题.problem94_二叉树的中序遍历;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author chenz
 * @ClassName Solution
 * @Description 回顾下二叉树的中序遍历，递归和非递归方法。
 * @date 2021/12/16-22:30
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return ans;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        ans.add(root.val);
        if (root.right != null){
            inorderTraversal(root.right);
        }
        return ans;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        // 非递归方式——迭代  记得没错，应该是采用栈的方式来做
        Deque<TreeNode> deque = new ArrayDeque<>();
        while(root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            TreeNode curNode = deque.pop();
            ans.add(curNode.val);
            root = curNode.right;

        }
        return ans;
    }
}
