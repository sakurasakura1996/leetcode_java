package meituan;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();

            int[] father = new int[n+1];
            for (int j = 1; j <=n; j++) {
                father[j] = j;
            }
            int r = 0;
            while (r < m) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                union(a, b, father);
                r++;
            }
            int s = 0;
            int temp = 0;
            int pre = findFather(scanner.nextInt(), father);
            while (s < k - 1) {
                int c = scanner.nextInt();
                temp = findFather(c, father);
                if (temp != pre) {
                    System.out.println("NO");
                    return;
                }
                pre = temp;
                s ++;
            }
            System.out.println("YES");
        }
    }

    public static void union(int a, int b, int[] father) {
        int fa = findFather(a, father);
        int fb = findFather(b, father);
        if (fa != fb) {
            father[fa] = fb;
        }
    }

    public static int findFather(int x, int[] father) {
        int a = x;
        while (x != father[x]) {
            x = father[x];
        }
        while (a != father[a]) {
            int z = a;
            a = father[a];
            father[z] = x;
        }
        return x;
    }
}
