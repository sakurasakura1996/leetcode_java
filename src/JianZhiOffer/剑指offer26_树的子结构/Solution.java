package JianZhiOffer.剑指offer26_树的子结构;

import sun.reflect.generics.tree.Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
/* 需要注意的是，二叉树节点个数 最多可能有10000个 递归貌似会出问题啊 但是这里还是写一遍递归，好久没写了*/
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A== null || B == null) return false;
        boolean ans = helper(A, B);
        return ans;
    }

    public static boolean helper(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        else if (A != null && B == null) return false;
        else if (A != null && B != null) {
            if (A.val == B.val) {
                return helper(A.left, B) || helper(A.right, B) || (helper(A.left, B.left) && helper(A.right, B.right));
            } else {
                return helper(A.left, B) || helper(A.right, B);
            }
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(0);
        A.left.left = new TreeNode(-4);
        A.left.right = new TreeNode(-3);
        A.right = new TreeNode(1);
        TreeNode B = new TreeNode(1);
        B.left = new TreeNode(-4);
        boolean ans = new Solution().isSubStructure(A, B);
        System.out.println(ans);
    }

}
