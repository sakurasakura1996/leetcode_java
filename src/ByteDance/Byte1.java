package ByteDance;

import java.util.Scanner;
/* 差分数组 */
public class Byte1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] val = new int[10001];
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt(), r = scanner.nextInt();
            range(val, l, r, 1);
        }
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < 10000; i++) {   // 这里的上界并不是 n哦，而是val的长度。
            sum += val[i];
            ans = Math.max(sum, ans);
        }
        System.out.println(ans);
    }

    public static void range(int[] val, int l, int r, int value) {
        val[l] += value;
        val[l+r] -= value;
    }
}
