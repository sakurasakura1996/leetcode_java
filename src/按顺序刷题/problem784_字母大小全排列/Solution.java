package 按顺序刷题.problem784_字母大小全排列;


import java.util.ArrayList;
import java.util.List;

// 这里可以学习到 Character类的对字符的长统元年
public class Solution {
    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());

        for (char c :
                s.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; i++) {
                    ans.add(new StringBuilder(ans.get(i)));  // 复制一份，然后一份是小写，一份是大写。 全排列嘛
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; i++) {
                    ans.get(i).append(c);
                }
            }

        }
        List<String> ret = new ArrayList<>();
        for (StringBuilder sb :
                ans) {
            ret.add(sb.toString());
        }

        return ret;
    }
}
