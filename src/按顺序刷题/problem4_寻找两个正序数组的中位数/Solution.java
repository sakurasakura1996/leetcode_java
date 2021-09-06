package 按顺序刷题.problem4_寻找两个正序数组的中位数;

import java.util.ArrayList;
import java.util.List;

// 设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题
public class Solution {
    double medium(int[] nums){
        int n = nums.length;
        if(n == 0) return 0;
        if(n%2==1){
            return nums[n/2];
        }else{
            return (nums[n/2]+nums[n/2 + 1])/2;
        }
    }

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int n1 = nums1.length, n2 = nums2.length;
//        // 思路简单点的话，我们可以先把两者存起来，然后取中位数，但是这不是困难程度吗
//        if(n1 == 0){
//            return medium(nums2);
//        }else if(n2 == 0){
//            return medium(nums1);
//        }else{
//            List<Integer> list = new ArrayList<>();
//            int p = 0, q = 0;
//            while(p < n1 && q < n2){
//                if (nums1[p] <= nums2[q]){
//                    list.add(nums1[p]);
//                    p ++;
//                }else{
//                    list.add(nums2[q]);
//                    q ++;
//                }
//            }
//            if(p<n1){
//                for (int i = p; i < n1; i++) {
//                    list.add(nums1[i]);
//                }
//            }
//            if(q<n2){
//                for (int i = q; i < n2; i++) {
//                    list.add(nums2[i]);
//                }
//            }
//            return medium(list.toArray());
//
//        }
//
//
//
//
//    }
}
