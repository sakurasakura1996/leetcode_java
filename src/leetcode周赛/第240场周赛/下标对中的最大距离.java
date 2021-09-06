package leetcode周赛.第240场周赛;

public class 下标对中的最大距离 {
    public int maxDistance(int[] nums1, int[] nums2) {
        // 可不可以nums1从左向右遍历，nums2从右向左遍历着来算呢
        // made，不想用暴力法，看这个数量级感觉暴力法通过不了啊
        // 还是超时啦。。。
        int n1 = nums1.length, n2 = nums2.length;
        int ans = 0;
        for (int i = 0; i < n1; i++) {
            if (i > 1 && nums1[i] == nums1[i-1]){
                continue;
            }
            for (int j = i; j < n2; j++) {
                if (nums2[j] >= nums1[i] && (j-i)>ans){
                    ans = j - i;
                }else if (nums2[j] < nums1[i]){
                    break; // 进行剪枝
                }
            }
        }
        return ans;
    }

    public int maxDistance2(int[] nums1, int[] nums2){
        // 可不可以用二分法来做呢
        int n1 = nums1.length, n2 = nums2.length;
        int ans = 0;
        for (int i = 0; i < Math.min(n1, n2); i++) {
            // 用二分法找到最右侧大于等于nums1[i]的数
            if (nums2[i] < nums1[i]){
                continue;
            }

            int left = i, right = n2-1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums2[mid] >= nums1[i]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
            ans = Math.max(ans, right-i);
        }
        return ans;
    }
    
    public int maxDistance3(int[] nums1, int[] nums2){
        // 完全不需要像上面那样写啊，我们可以用双指针，先固定nums2的下标j，然后找到符合条件的nums1下标i，然后j+1时，对应符合条件的nums1下标i‘肯定大于原来的i啊
        int n1 = nums1.length, n2 = nums2.length;
        int i = 0, ans = 0;
        for (int j = 0; j < n2; j++) {
            while (i < n1 && nums1[i] > nums2[j]){
                i ++;
            }
            if (i < n1){
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }
}
