package 每日一题.problem430_扁平化多级双向链表;

class Node {
    int val;
    Node prev;
    Node next;
    Node child;
}

public class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node node) {
        Node cur = node;
        Node last = null;

        while (cur != null){
            Node next = cur.next;
            if (cur.child != null) {
                Node childLast = dfs(cur.child);
                next = cur.next;

                cur.next = cur.child;
                cur.child.prev = cur;

                if (next != null) {
                    childLast.next = next;
                    next.prev= childLast;
                }
                // 将child置为空
                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }

    public Node dfs2(Node node) {
        // 自己再重新写一遍，还是比较考验思路的正确性的。 关键点我们要找到扁平化列表的尾部节点，我们可以通过递归来实现
        Node cur = node;
        Node last = null;

        while (cur != null) {
            Node next = cur.next;
            if (cur.child != null) {
                Node childLast = dfs2(cur.child);
                next = cur.next;

                cur.next = cur.child;
                cur.child.prev = cur;

                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }
}
