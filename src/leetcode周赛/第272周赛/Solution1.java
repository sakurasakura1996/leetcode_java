package leetcode周赛.第272周赛;

/**
 * @author chenz
 * @ClassName Solution1
 * @Description TODO
 * @date 2021/12/19-10:34
 */
public class Solution1 {
    public String addSpaces(String s, int[] spaces) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = s.toCharArray();
        int pos = spaces.length - 1;
        for (int i = chars.length-1; i >=0; i--) {
            if (pos >= 0 && i == spaces[pos]) {
                stringBuffer.append(chars[i]);
                stringBuffer.append(' ');
                pos --;
            }else{
                stringBuffer.append(chars[i]);
            }
        }
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = {8,13,15};
        String s1 = new Solution1().addSpaces(s, spaces);
        System.out.println(s1);
    }
}
