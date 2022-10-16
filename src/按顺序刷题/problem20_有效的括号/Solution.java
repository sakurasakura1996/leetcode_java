package 按顺序刷题.problem20_有效的括号;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * @author chenz
 * @ClassName Solution
 * @Description 这道题主要还是看对栈的使用，也可以直接用一个char数组充当栈
 * @date 2021/12/15-14:39
 */
public class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack.push(chars[i]);
            } else {
                // 千万不用忘了这里啊。
                if (stack.isEmpty()) {
                    return false;
                }
                char cur = stack.peek();
                if (chars[i] == ')' && cur == '(') {
                    stack.pop();
                } else if (chars[i] == '}' && cur == '{') {
                    stack.pop();
                } else if (chars[i] == ']' && cur == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
