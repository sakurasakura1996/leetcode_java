package 每日一题.problem437_路径总和III;


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
/* 路径不需要从根节点开始，也不需要从叶节点结束 */
public class Solution {
    /* 先说明，此解法有问题，但是错误的有点意义，就是递归的理解，我这里写错的问题就在于
    * 该解法没有考虑到有一种情况，如果父节点取了，递归到子节点的时候，我这里又不取，递归到子节点
    * 的子节点时候，又取了该节点，这个不能连起来，但是可能加起来等于targetSum了，所以会算进去
    * 问题就在于此，所以我们需要搞清楚每个函数的含义，需要再写一个函数*/
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null || targetSum == 0) {
            return 0;
        }
        if (root.val == targetSum) {
            return 1;
        }
        return pathSum(root.left, targetSum-root.val) + pathSum(root.right, targetSum-root.val) +
                pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }


    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) {   // targetSum == 0 不要作为判断条件
            return 0;
        }
        return pathSum2(root.left, targetSum) + pathSum2(root.right, targetSum) + rootSum(root, targetSum);
    }

    // 新定义的这个函数就是取当前节点，然后路径和为targetSum的路径总和
    public int rootSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int val = 0;
        if (root.val == targetSum) val ++;
        return val + rootSum(root.left, targetSum - root.val) + rootSum(root.right, targetSum - root.val);
    }
}
