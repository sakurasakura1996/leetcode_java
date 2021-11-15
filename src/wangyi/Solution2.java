package wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            solution(arr, m-1);

        }
    }
    public static void solution(int[] arr, int m) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        int newM = m;
        for (int i = 0; i < arr.length; i++) {
            if (i==0) {
                list.add(arr[i]);
            }else{
                if (arr[i]!=arr[i-1]) list.add(arr[i]);
                if (i == m) newM = list.size() - 1;
            }
        }
        int l = newM, r = newM;
        while(l>=0 && list.get(l) <= list.get(newM)) l--;
        while (r<list.size() && list.get(r) <= list.get(newM)) r++;
        List<Integer> heep = new ArrayList<>();
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i-1) && list.get(i) > list.get(i+1)) {
                heep.add(i);
            }

        }
        for (int hep: heep) {
            if (hep <= l || hep >= r){
                res ++;
            }
        }
        System.out.println(res);
    }
}
