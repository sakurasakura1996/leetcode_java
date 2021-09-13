package 差分数组.计算并发任务数;

/* 小明在计算任务并发数的时候遇到了困难，在一次下载中有N个任务，每个任务在第 x 秒开始，并持续 y 秒，小明想知道，在一次下载中，最多同时有多少个任务在下载。

输入示例：
第一行一个数字 N，表示有 N 个任务
之后共 N 行，每行包括两个数字 x，y，x表示任务开始时间，y表示任务持续时间。

输出描述：
输出一个正整数，表示最大并发任务数。*/
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
