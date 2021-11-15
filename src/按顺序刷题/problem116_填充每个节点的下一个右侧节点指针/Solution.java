package 按顺序刷题.problem116_填充每个节点的下一个右侧节点指针;

import com.sun.org.apache.xml.internal.dtm.ref.DTMStringPool;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node left;
    Node right;
    Node next;
    Node(){}
    Node(int val){this.val = val;}
    Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

public class Solution {
    // 二叉树的层序遍历可不可以呢，但是要注意每一层，有点类似于按层输出层序遍历结果，因为某一层的最后的节点的next为null
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> tmpQueue = new LinkedList<>();
        queue.offer(root);
        Node pre = null;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                tmpQueue.offer(cur.left);
            }
            if (cur.right != null) {
                tmpQueue.offer(cur.right);
            }
            if (pre == null) {
                pre = cur;
            } else if (pre != null) {
                pre.next = cur;
                pre = cur;
            }
            if (queue.isEmpty()) {
                pre = null;
                queue.addAll(tmpQueue);
                tmpQueue.clear();
            }

        }
        return root;
    }
    // 上面的写法总归不是很好。。
    public Node connect2(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 这里直接记录大小，这样，while内部使用一个for循环就可以避免上面搞一个什么 tmpQueue了
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // 测试addAll 会不会因为
//        Queue<Integer> queue = new LinkedList<>();
//        Queue<Integer> tmpQueue = new LinkedList<>();
//        tmpQueue.offer(2);
//        queue.addAll(tmpQueue);
//        for (Integer i :
//                queue) {
//            System.out.println(i);
//        }
//        tmpQueue.clear();
//        for (Integer i :
//                queue) {
//            System.out.println(i);
//        }

    }
}
