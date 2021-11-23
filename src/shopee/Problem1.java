package shopee;

import java.util.Arrays;

public class Problem1 {
    public long Solve(int n, int[] lens) {
        Arrays.sort(lens);
        long ans = 0L;
        for (int first = 0; first < n - 2; first++) {
            for (int second = first + 1, third = second + 1; second < n - 1; second++) {
                while (third < n && lens[first] + lens[second] > lens[third]) {
                    third++;
                }
                ans += third - second - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lens = {9,3,5,1,16};
        long solve = new Problem1().Solve(n, lens);
        System.out.println(solve);
    }
}
