package 按顺序刷题.problem557_反转字符串中的单词III;

// 怎么说呢，这种题目，难度不高，但是我总是很麻烦才能找到其中的规律。。。。编程思维不是很好
public class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int prev = 0, next = 0;
        for (next = 0; next < chars.length; next ++){
            if (chars[next] == ' ') {
                reverseWord(chars, prev, next-1);
                prev = next+1;
            }
            if (next == chars.length-1) {
                reverseWord(chars, prev, next);
            }
        }
//        for (int i = 0; i < chars.length; i++) {
//            if (i+1 == chars.length || chars[i+1] == ' '){
//                prev = next;
//                next = i;
//                reverseWord(chars, prev, next);
//            } else if (i > 0 && chars[i] == ' ') {
//                prev = i;
//                next = prev;
//            }
//
//        }
        return String.valueOf(chars);
    }

    public static void reverseWord(char[] chars, int left, int right) {
        // 把字符数组 从left到right的字符串部分反转一下
//        for (int i = left; i <= left+(right-left)/2; i++) {
//            char temp = chars[left];
//            chars[left] = chars[right - i + left];
//            chars[right - i + left] = temp;
//        }
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left ++;
            right--;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String s1 = new Solution().reverseWords(s);
        System.out.println(s1);
    }
}
