package JianZhiOffer.剑指offer32I_从上到下打印二叉树;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
/* 经典的二叉树层次遍历 */
public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> levelList = new ArrayList<>();
        // 这里写非递归方法来写，使用队列的数据结构可以解决
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode newNode = deque.pollFirst();
            levelList.add(newNode.val);
            if (newNode.left != null) deque.add(newNode.left);
            if (newNode.right != null) deque.add(newNode.right);
        }
        return levelList.stream().mapToInt(Integer::valueOf).toArray();
    }

}
