package 每日一题.problem1190_反转每对括号间的子串;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String reverseParentheses(String s) {
        Deque<String> arrayDeque = new ArrayDeque<>();
        int n = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '('){
                arrayDeque.push(stringBuilder.toString());
                stringBuilder.setLength(0);
            }else if (ch == ')'){
                stringBuilder.reverse();
                stringBuilder.insert(0, arrayDeque.pop());

            }else{
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();


    }

}
