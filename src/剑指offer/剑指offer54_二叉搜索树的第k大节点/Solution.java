package 剑指offer.剑指offer54_二叉搜索树的第k大节点;

import sun.reflect.generics.tree.Tree;
import 二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution {
    public int kthLargest(TreeNode root, int k){
        // 简单粗暴点，就直接把二叉树的元素按序存下来。或者我们能不能倒序中序遍历呢，
        // 直接计数，计数到第k个值就是需要返回的答案。
        int start = 1;
        // 倒序中序遍历，同样还是使用栈结构。
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.right;
            }
            TreeNode node = stack.pop();
            if (start == k) {
                return node.val;
            }
            root = node.left;   //主要要反过来啊，正规中序遍历是 right，现在是left了啊
             start ++;
        }
        return 0;  // 这里要返回什么呢，或者说还是最好定义一个 ans，然后只在最后返回。循环内部用 break 终止。
    }
    int pos = 0;
    public int kthLargest2(TreeNode root, int k){
        // 用递归方法来写的话
        if (root == null){
            return 0;
        }
        int left = kthLargest2(root.right, k);
        pos ++;
        if (pos == k){
            return root.val;
        }
        int right = kthLargest2(root.left, k);
        return Math.max(left, right);   //这个返回语句有啥用啊。
    }
}
