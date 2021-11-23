package 按顺序刷题.problem6_Z字形变换;

public class Solution {
    public String convert(String s, int numRows) {
//        if (numRows == 1) return s;    //注意特殊情况，如果numRows = 1的时候，
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {

            int left = 2 * (numRows - i - 1);
            int right = 2 * i;
            if (left == 0 || right == 0) {
                for (int j = i; j < s.length(); j+=(2*numRows-2)) {
                    sb.append(s.charAt(j));
                }
            } else {
                for (int j = i; j < s.length(); j+=right) {
                    sb.append(s.charAt(j));
                    if (j+left< s.length()) {
                        j+=left;
                        sb.append(s.charAt(j));
                    } else {
                        break;
                    }

                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "2";
        int numRows = 1;
        String convert = new Solution().convert(s, numRows);
        System.out.println(convert);

    }
}
