package JianZhiOffer.剑指offer09_用两个栈实现队列;

import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/*用两个栈来实现队列，可以再队列尾部插入整数，队列头部删除整数的功能
* 插入删除操作会各执行 10000 次*/
public class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        // stack1 用于插入， stack2 用于删除完
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            int ans = stack2.pop();
            return ans;
        }
    }
}
