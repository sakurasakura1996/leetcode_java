package JianZhiOffer.剑指offer35_复杂链表的复制;

import JianZhiOffer.Node;

import java.util.HashMap;
import java.util.Map;
/* 把一个复杂结构的链表复制下来，主要问题在于除了往常的 next指针，这里多加了一个random指针，可以随意指向其他节点
* 同时注意 Node.val 范围在 -10000 - 10000 节点数目不超过1000
* 1.首先想到的，能不能先遍历一遍，把普通的单链表构建起来，同时用哈希表存储起来所有的节点，然后再遍历一遍
*   时间复杂度是 O(n) 空间复杂度是O(n)
* 2. 第一种方法比较简单，但是空间复杂度从运行结果来看，应该是很差的，有没有方法改进空间复杂度呢*/

public class Solution {
    Map<Node, Node> cachedNode = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node ans = new Node(head.val);
        // hashmap 用来存储 原链表和新建链表的对应关系
        Map<Node, Node> map = new HashMap<>();
        map.put(head, ans);
        Node cur = head;
        cur = cur.next;
        Node newCur = ans;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newCur.next = newNode;
            newCur = newCur.next;
            map.put(cur, newNode);
            cur = cur.next;
        }
        while (head != null) {
            if (head.random != null && map.get(head) != null && map.get(head.random) != null) {
                map.get(head).random = map.get(head.random);
            }
            head = head.next;
        }
        return ans;
    }

    /*方法二和上面方法一差不太多，思路一样*/
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList2(head.next);
            headNew.random = copyRandomList2(head.random);
        }
        return cachedNode.get(head);
    }

    /*方法三是在看题解以后的编写，空间复杂度将为O（1）这里的方法是拼接+拆分
    * 原来的链表是 node1 -> node2 -> node3 拼接后的链表是  node1 -> node1new -> node2 -> nod2new -> node3 -> node3new
    * 拼成这样的好处就是因为 node1的复制节点 node1new 的next 就是它的next，而random 就是 node1的random的next
    * 然后再拆分现在的链表就可以了 */
    public Node copyRandomList3(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        // 1.复制各节点，并构建拼接链表
        while (cur != null) {
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        // 2.构建各新节点的random指向
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //3.拆分链表
        cur = head.next;
        Node pre = head, res = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表的尾节点
        return res;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        node2.random = node1;
        node3.random = node1;
        Solution solution = new Solution();
        Node node = solution.copyRandomList(node1);


    }
}
