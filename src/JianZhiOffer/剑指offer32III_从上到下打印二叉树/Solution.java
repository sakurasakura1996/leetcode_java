package JianZhiOffer.剑指offer32III_从上到下打印二叉树;

import java.sql.Array;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/* 层序遍历的几个变种问题，核心思路都还是用队列来实现嘛  */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int num = 0;
        while (!deque.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.pop();
                cur.add(node.val);
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            if (num%2==1){
                Collections.reverse(cur);
                System.out.println(cur);
            }
            ans.add(cur);
            num ++;
        }
        return ans;
    }
}
