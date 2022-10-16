package leetcode周赛.第272周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenz
 * @ClassName Solution4
 * @Description TODO
 * @date 2021/12/19-10:57
 */
public class Solution4 {
    // 下面这个方法肯定不能解决 hard的题目啊。。。。
    public int kIncreasing(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n - k; i++) {
            if (arr[i+k] < arr[i]) {
                arr[i+k]=arr[i];
                ans ++;
            }
        }
        return ans;
    }

    public int kIncreasing2(int[] arr, int k) {
        // 题解解法：分组 通过观察题目可知：arr[i]只受arr[i-k],arr[i-2k],arr[i-3k]...的影响，所以我们可以分组求出每个组的最长不下降子序列长度再累加。
        int ans = 0;
        for (int i = k; i < Math.min(2 * k, arr.length); i++) {
            List<Integer> list = new ArrayList<>();
            // 每次将所有与i下标相差k的元素加入到数组里面进行计算
            for (int j = Math.max(i-k, 0); j < arr.length;) {
                list.add(arr[j]);
                j+=k;
            }
            ans+= getSize(list);
        }
        return ans;
    }

    public int getSize(List<Integer> arr){
        // list用来存储  递增子序列元素
        List<Integer> list = new ArrayList<>();
        // 加入第一个头元素
        list.add(arr.get(0));
        int size = arr.size();
        for (int i = 1; i < size; i++) {
            int left = 0;
            int right = list.size() - 1;
            if (arr.get(i) >= list.get(right)) {
                // list将会是递增序列！！即如果是递增序列元素，则直接加入到list内！
                list.add(arr.get(i));
            } else {
                // 利用二分进行插值
                while(left < right) {
                    int mid = left + right >> 1;
                    if (list.get(mid) <= arr.get(i)) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                list.set(left, arr.get(i));
            }

        }
        return size - list.size();
    }

    public static void main(String[] args) {
        int[] arr = {12,6,12,6,14,2,13,17,3,8,11,7,4,11,18,8,8,3};
        int k = 1;
        int i = new Solution4().kIncreasing(arr, k);
        System.out.println(i);
    }
}