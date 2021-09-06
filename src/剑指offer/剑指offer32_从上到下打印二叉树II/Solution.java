package 剑指offer.剑指offer32_从上到下打印二叉树II;
import sun.reflect.generics.tree.Tree;
import 二叉树.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root){
        // 层序遍历二叉树，只不过要分层保存起来
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root==null){
            return ans;
        }
        queue.add(root);
        List<TreeNode> temp = new ArrayList<>();

        List<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            tmp.add(node.val);
            if (node.left != null){
                temp.add(node.left);
            }
            if (node.right != null){
                temp.add(node.right);
            }
            if (queue.isEmpty()){
                ans.add(tmp);
                for (TreeNode node1:
                        temp) {
                    queue.add(node1);
                }
                tmp = new ArrayList<Integer>();
                temp = new ArrayList<TreeNode>();
            }
        }
        return ans;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            // 对奥，用for循环来做简洁很多啊。
//            for(int i = queue.size(); i > 0; i--) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
