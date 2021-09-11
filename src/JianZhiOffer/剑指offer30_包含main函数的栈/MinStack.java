package JianZhiOffer.剑指offer30_包含main函数的栈;

import java.util.Deque;
import java.util.LinkedList;

/*定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。*/
/* 我的想法是最小栈嘛，一个栈用于存储正常的出栈入栈整数，另一个栈用于存储当前最小元素的栈*/
public class MinStack {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MinStack() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();

    }

    public void push(int x) {
        if (stack1.isEmpty()) {
            stack1.push(x);
            stack2.push(x);
        } else if (x < stack2.getFirst()) {
            stack1.push(x);
            stack2.push(x);
        } else {
            stack1.push(x);
            stack2.push(stack2.getFirst());
        }
    }

    public void pop() {

        stack1.pop();
        stack2.pop();
    }

    public int top() {
        if (!stack1.isEmpty()) {
            return stack1.getFirst();
        }
        return -1;
    }

    public int min() {
        if (!stack2.isEmpty()) {
            return stack2.getFirst();
        }
        return -1;
    }
}
