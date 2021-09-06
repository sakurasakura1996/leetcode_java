package 剑指offer.剑指offer68_二叉搜索树的最近公共祖先;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 虽然是简单题，但是这道题目做了很久，一直还是没那么顺畅。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if (root.val < p.val && root.val < q.val){
                root = root.right;
            }else if (root.val > p.val && root.val > q.val){
                root = root.left;
            }else{
                break;
            }
        }
        return root;
    }
    // 题解中还有一个二次遍历的方法，在二叉搜索树上，我们可以很轻松的找到从根节点到p，q节点的路径，两次遍历，把路径
    // 存起来，然后找到两个路径中离p，q最近的公共节点就ok了
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q){
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); i++) {
            if (path_p.get(i) == path_q.get(i)){
                ancestor = path_p.get(i);
            }else{
                break;
            }
        }
        return ancestor;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target){
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target){
            path.add(node);
            if (node.val < target.val){
                node = node.right;
            }else{
                node = node.left;
            }
        }
        path.add(node);
        return path;
    }
}
