package 每日一题.problem938_二叉搜索树的范围和;


import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int x){ this.val = x;}
    TreeNode(int x, TreeNode left, TreeNode right){
        this.val = x;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // 我们之前试过中序遍历非递归方法，这里复习下，然后再试试其他方法的编写
        Deque<TreeNode> stack = new ArrayDeque<>();
        int ans = 0;
        while (!stack.isEmpty() || root != null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                TreeNode node = stack.pop();
                if (node.val <= high && node.val >= low){
                    ans += node.val;
                }else if (node.val > high){
                    break;
                }
                root = node.right;
            }
        }
        return ans;
    }

    public int rangeSumBST2(TreeNode root, int low, int high){
        // 试试用层序遍历啊,BFS，使用队列来写。
        Deque<TreeNode> queue = new ArrayDeque<>();
        int ans = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.val >= low && node.val <= high){
                ans += node.val;
            }
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return ans;
    }

    public int rangeSumBST3(TreeNode root, int low, int high){
        // 试试递归吧, 提交之后，递归方法最快。
        if (root == null){
            return 0;
        }
        if (root.val > high){
            return rangeSumBST3(root.left, low, high);
        }
        if (root.val < low){
            return rangeSumBST3(root.right, low, high);
        }
        return root.val + rangeSumBST3(root.left, low, high) + rangeSumBST3(root.right, low, high);
    }
}
