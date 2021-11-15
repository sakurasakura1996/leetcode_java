package 每日一题.problem230_二叉搜索树中第K小的元素;

import java.util.*;

/* 二叉搜索树的话，那我们可以直接 中序遍历就完事了，但是改题目的进阶要求有一个问题，如果我们频繁修改二叉搜索树，执行插入删除操作，然后我们同时
* 需要频繁查找第 k 小的值，我们需要如何优化算法呢。*/
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

    public int kthSmallest(TreeNode root, int k) {
        // 先中序遍历一遍，递归，非递归都ok
        List<Integer> ans = new ArrayList<>();
        inOrder(ans, root);
        return ans.get(k-1);
    }

    public int kthSmallest2(TreeNode root, int k) {
        // 使用非递归的方法来中序遍历，使用栈
        int num = 0; // 记录当前出栈元素是第几个元素
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }

    public static void inOrder(List<Integer> ans, TreeNode root) {
        if (root == null) return;
        inOrder(ans, root.left);
        ans.add(root.val);
        inOrder(ans, root.right);
    }
}
