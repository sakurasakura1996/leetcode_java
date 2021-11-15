package wangyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "01");
        map.put(3, "11");
        map.put(4, "001");
        map.put(5, "101");
        map.put(6, "011");
        map.put(7, "111");
        map.put(8, "0001");
        map.put(9, "1001");
        for (int i = 0; i < n; i++) {
            solve(nums[i], map);
        }

    }

    public static void solve(int x, Map<Integer, String> map){
        StringBuilder stringBuilder = new StringBuilder();
        while(x != 0) {
            int temp = x % 10;
            stringBuilder.append(map.get(temp));
            x = x / 10;
        }
        // 去掉前导0
        while (stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }
        String ans = "";
        char prev = ' ';
        for (int i = 0; i < stringBuilder.length(); i++) {
            char cur = stringBuilder.charAt(i);
            if (i == 0) {
                prev = cur;
                ans += cur;
                continue;
            }
            if (cur == prev) {
                continue;
            } else {
                prev = cur;
                ans += cur;
            }
        }
        System.out.println(ans);
    }

}
