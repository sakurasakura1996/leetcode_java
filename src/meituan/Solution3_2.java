package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Solution3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int sum = 0;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int temp = (a[i] - a[i-1]) * i;
            sum += temp;
            if (sum <= m) {
                ans = a[i];
            } else {
                break;
            }
        }
        if (sum < m) {
            // 还没有填充完毕
            ans += (m - sum) / n;
        }



        System.out.println(ans);
    }

    public static int dfs(int[] nums, int m) {
        Arrays.sort(nums);
        int k = 0;
        int i;
        for (i = 1; i < nums.length; i++) {
            k += i * (nums[i] - nums[i-1]);
            if (k > m) return nums[i-1];
        }
        int c = m - k;
        return nums[nums.length - 1] + c / nums.length;
    }
}
