package 剑指offerII;

/**
 * @author chenz
 * @ClassName Problem2
 * @Description 剑指 Offer II 002. 二进制加法
 * @date 2021/11/24-13:42
 */
public class Problem2 {
    // 你看看这个代码给你写的，笑死hhhh，
    public String addBinary(String a, String b) {
        StringBuilder stringBuilderA = new StringBuilder(a);
        StringBuilder stringBuilderB = new StringBuilder(b);
        stringBuilderA.reverse();
        stringBuilderB.reverse();
        StringBuilder ans = new StringBuilder();
        int flag = 0;
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            char charA = stringBuilderA.charAt(i);
            char charB = stringBuilderB.charAt(i);
            int numA = charA - '0';
            int numB = charB - '0';
            if (numA + numB + flag == 3) {
                flag = 1;
                ans.append('1');
            }else if (numA + numB + flag == 2) {
                flag = 1;
                ans.append('0');
            } else if (numA + numB + flag == 1){
                flag = 0;
                ans.append('1');
            } else {
                flag = 0;
                ans.append('0');
            }
        }
        if (a.length() > b.length()) {
            for (int i = b.length(); i < a.length(); i++) {
                int numA = stringBuilderA.charAt(i) - '0';
                if (numA + flag == 2) {
                    flag = 1;
                    ans.append('0');
                } else if (numA + flag == 1){
                    flag = 0;
                    ans.append('1');
                } else {
                    flag = 0;
                    ans.append('0');
                }
            }
        }else{
            for (int i = a.length(); i < b.length(); i++) {
                int numB = stringBuilderB.charAt(i) - '0';
                if (numB + flag == 2) {
                    flag = 1;
                    ans.append('0');
                } else if (numB + flag == 1){
                    flag = 0;
                    ans.append('1');
                } else {
                    flag = 0;
                    ans.append('0');
                }
            }
        }
        if (flag == 1){
            ans.append('1');
        }
        return ans.reverse().toString();

    }

    public String addBinary2(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    // 题解写的，和方法一类似，但是写法简洁太多
    public String addBinary3(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int n = Math.max(a.length(), b.length());
        int carry = 0;

        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - i - 1) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - i - 1) - '0') : 0;
            ans.append((char) (carry%2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            ans.append('1');
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1";
        String b = "1111";
        String s = new Problem2().addBinary3(a, b);
        System.out.println(s);
        int carry = 3;

    }
}
