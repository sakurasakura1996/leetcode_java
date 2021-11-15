package JianZhiOffer.剑指offer32II_从上到下打印二叉树II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}

/* 层序遍历的变种 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> valueList = new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode newNode = queue.poll();
            valueList.add(newNode.val);
            if (newNode.left != null) nodeList.add(newNode.left);
            if (newNode.right != null) nodeList.add(newNode.right);
            if (queue.isEmpty()) {
                for (TreeNode node1 :
                        nodeList) {
                    queue.add(node1);
                }
                ans.add(valueList);
                valueList = new ArrayList<>();
                nodeList = new ArrayList<>();
            }
        }
        return ans;
    }

    /* 还是第二种解法比较简洁 高效，用for循环，也能省空间。*/
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            // 对奥，用for循环来做简洁很多啊。
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
