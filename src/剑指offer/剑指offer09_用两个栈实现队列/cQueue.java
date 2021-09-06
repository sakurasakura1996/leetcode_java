package 剑指offer.剑指offer09_用两个栈实现队列;

import java.util.Deque;
import java.util.LinkedList;

// 双栈维护一个队列的思路是一个比较经典的问题啊，想不起来不应该啊。
public class CQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue(){
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value){
        stack1.push(value);
    }

    public int deleteHead(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()){
            return -1;
        }else{
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }

}
