package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int val = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            lifang(n, m, val, a);
        }

    }
    /* 打印出来结果，是否能够将 */
    public static void lifang(int n, int m, int val, int[] a){
        int sum = Arrays.stream(a).sum();



    }

    public static void backtrace(int[] a){

    }
}
