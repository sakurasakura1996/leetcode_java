package 剑指offer.剑指offer68_二叉树的最近公共祖先;

import sun.reflect.generics.tree.Tree;
import 二叉树.TreeNode;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 基于前一道题是二叉搜索树，我们可以用一次遍历来解决问题，现在不太行了，但是我们还是可以用二次遍历来解决啊。
    // 因为二次遍历并没有用 二叉搜索树的有序特性。
    // java的DFS还不是很熟悉，dfs函数返回类型我们不用直接定义需要的东西，而是先在类中定义为全局变量来做。
    public List<TreeNode> path_p = new ArrayList<>();
    public List<TreeNode> path_q = new ArrayList<>();

    // 先用递归写一遍，这个代码应该是最简洁的，但是我们需要好好理解递归的思路。
    // 主要是想清楚递归终止的判断条件，如果root为null，或者root等p，q中的一个，那么就可以直接返回了，因为我们是自顶向下的递归操作。

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    boolean flag = true;
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 这里的代码就是二次遍历完成之后再对比的方法。
        List<TreeNode> lup = new ArrayList<>();
        List<TreeNode> luq = new ArrayList<>();
        TreeNode ans = null;
        dfs(root, p, lup);
        flag = true;
        dfs(root, q, luq);
        int pLen = lup.size(), qLen = luq.size();
        int i = 0;
        // 找到两条路径重合的最后一个节点，就是答案
        while(i < pLen && i < qLen){
            if(lup.get(i) == luq.get(i)){
                ans = lup.get(i);
            } else{
                break;
            }
            i++;
        }
        return ans;
    }

    void dfs(TreeNode root, TreeNode target, List<TreeNode> t){
        if(root == target){
            t.add(root);
            // 标志已经找到
            flag = false;
            return;
        }
        if(root == null){
            return;
        }
        t.add(root);
        dfs(root.left, target, t);
        dfs(root.right, target, t);
        // 只有在没找到时才清理现场
        if(flag){
            t.remove(t.size()-1);
        }
    }
}
