package 震坤行;

public class Problem1 {
    public int[] subtract (int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;
        int ansLen = Math.max(aLen, bLen);
        int[] ans = new int[ansLen];
        boolean flag = true;  // 表示结果为正
        int minLen = Math.min(aLen, bLen);
//        if (bLen > aLen) {
//            int[] newA = b;
//            int[] newB = a;
//        } else if (bLen == aLen) {
//            for (int i = 0; i < aLen; i++) {
//                if (b[i] > a[i]) {
//                    int[] newA = b;
//                    int[] newB = a;
//                    break;
//                }
//
//            }
//        }
        for (int i = 0; i < Math.min(aLen, bLen); i++) {
            if ((a[aLen - i - 1] - b[bLen - i - 1]) >= 0) {
                ans[ansLen - i - 1] = a[aLen - i - 1] - b[bLen - i - 1];
            } else {
                if (i < aLen - 1) {
                    a[aLen-i-2] --;
                    ans[ansLen-i-1] = 10 + a[aLen - i - 1] - b[bLen - i - 1];
                } else {
                    ans[ansLen-i-1] = b[bLen - i - 1] - a[aLen - i - 1];
                    flag = false;
                }
            }
        }
        if (aLen > bLen) {
            for (int i = bLen; i < aLen; i++) {
                ans[ansLen - i - 1] = a[aLen - i - 1];
            }
        }
        if (bLen > aLen) {
            for (int i = aLen; i < bLen; i++) {
                ans[ansLen - i - 1] = b[bLen - i - 1];
            }
        }
        int num = 0;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 0) {
                num ++;
            } else {
                break;
            }
        }
        int[] ansNew = new int[ansLen - num];
        for (int i = 0; i < ansLen - num; i++) {
            ansNew[i] = ans[i + num];
        }
        return ansNew;
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        int[] a = {1, 2, 3};
        int[] b = {7, 8, 9};
        int[] ans = problem1.subtract(a, b);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
