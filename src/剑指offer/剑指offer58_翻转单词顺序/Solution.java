package 剑指offer.剑指offer58_翻转单词顺序;

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length-1; i >= 0 ; i--) {
            if (strings[i].equals("")) continue;
            stringBuilder.append(strings[i]+" ");
        }
        return stringBuilder.toString().trim();

    }

    public static void main(String[] args) {
        String input = "the sky is blue";
        Solution solution = new Solution();
        String ans = solution.reverseWords(input);
        System.out.println(ans);
    }
}
