package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        answer(a, n, m);
    }

    // 每次给当前最短的木板长度加一， 因为数据量太大，所以用二分。只通过了 9%。。。。
    public static void answer(int[] a, int n, int m) {
        Arrays.sort(a);
        int ans = 0;
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cur = getSum(mid, a);
            if (cur == m) {
                ans = a[mid];
                break;
            }else if (getSum(mid, a) < m) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (ans != 0) {
            System.out.println(ans);
        }else {
            System.out.println(left);
        }

    }

    // 换一种方法来写
    public static void answer2(int[] a, int n, int m) {
        Arrays.sort(a);

    }


    public static int getSum(int mid, int[] a) {
        int sum = 0;
        for (int i = 0; i < mid; i++) {
            sum += a[mid] - a[i];
        }
        return sum;
    }
}
