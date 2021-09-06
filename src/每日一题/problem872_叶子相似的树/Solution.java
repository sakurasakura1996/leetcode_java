package 每日一题.problem872_叶子相似的树;

import sun.reflect.generics.tree.Tree;
import 二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2){
        List<Integer> list1 = getTreeList(root1);
        List<Integer> list2 = getTreeList(root2);
//        if (list1.size() != list2.size()) return false;
//        for (int i = 0; i < list1.size(); i++) {
//            if (list1.get(i) != list2.get(i)) return false;
//        }
//        return true;
        // 上面的写法太蠢，有现成方法使用啊
        return list1.equals(list2);
    }

    public List<Integer> getTreeList(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null){
            while (root!= null){
//                stack.add(root);
                stack.push(root);  //终于遇到了这里入栈出栈不匹配写法造成的问题了， 对于栈用push，pop。
                root = root.left;
            }
            if (!stack.isEmpty()){
                TreeNode node = stack.pop();
                if (node.left == null && node.right == null){
                    ans.add(node.val);
                }
                root = node.right;
            }
        }
        return ans;
    }

    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        // 用此种dfs方法，比上面的中序遍历效率高出了很多啊
        List<Integer> seq1 = new ArrayList<Integer>();
        if (root1 != null) {
            dfs(root1, seq1);
        }

        List<Integer> seq2 = new ArrayList<Integer>();
        if (root2 != null) {
            dfs(root2, seq2);
        }

        return seq1.equals(seq2);
    }

    public void dfs(TreeNode node, List<Integer> seq) {
        if (node.left == null && node.right == null) {
            seq.add(node.val);
        } else {
            if (node.left != null) {
                dfs(node.left, seq);
            }
            if (node.right != null) {
                dfs(node.right, seq);
            }
        }
    }
}
