package meituan;

import java.util.*;

public class Solution1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int j = 1; j <=n ; j++) {
                map.put(j, new ArrayList<>(j));
            }

            int r = 0;
            while (r < m) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                map.get(a).add(b);
                map.get(b).add(a);
                r++;
            }
            int s = 0;
            int pre = scanner.nextInt();
            while (s < k - 1) {
                int c = scanner.nextInt();
                if (!map.get(pre).contains(c)) {
                    System.out.println("NO");
                    return;
                }
                pre = c;
                s++;
            }
            System.out.println("YES");
        }
    }
}
