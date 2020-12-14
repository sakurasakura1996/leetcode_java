package 二叉树.problem590_N叉树的后序遍历;

import java.util.*;

/**
 * @ClassName Solution
 * @Date 2020/12/10 10:21
 * @Created by sakura
 * 分析：
 **/
class Node{
    public int val;
    public List<Node> children;

    public Node(){}

    public Node(int _val){
        val = _val;
    }

    public Node(int _val, List<Node> _children){
        val = _val;
        children = _children;
    }
};

public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        } else {
            for (Node i :
                    root.children) {
                ans.addAll(postorder(i));
            }
            ans.add(root.val);
        }
        return ans;
    }

    public List<Integer> postorder2(Node root) {
        //递归法比较简单，那么我们再用 java写一下非递归方法，即迭代，需要用到栈
        //题解中的代码用链表LinkedList来代替栈肯定也是可以的。
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();  //弹出栈顶元素
            output.addFirst(node.val);  //链表头部插入一个元素。
            for (Node item :
                    node.children) { //这里要考虑清楚哦，按顺序遍历node节点的子节点，前面的先压栈，所以会后访问，所以没毛病这里。
                if (item != null) {
                    stack.add(item);
                }

            }
        }
        return output;
    }

    // 当然我们当然可以用真实的栈结构来解决问题。
    public List<Integer> postorder3(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.addFirst(node.val); //还是用链表实现比较好，因为我们每次添加都是在List最前面添加，用链表会更加省时间
            for (Node item :
                    node.children) {
                stack.push(item);
            }

        }
        return ans;
    }
}