package 剑指offerII;

/**
 * @author chenz
 * @ClassName Problem6
 * @Description 剑指 Offer II 006. 排序数组中两个数字之和
 * @date 2021/11/25-10:17
 */
public class Problem6 {
    // 先使用双指针来做，升序的话，我们可以转换为降序，或者直接用升序，但是从末尾开始遍历
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length-1, left = 0;
        int[] ans = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                ans[0] = left;
                ans[1] = right;
                break;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left ++;
            }
        }
        return ans;
    }

    public int[] twoSum2(int[] numbers, int target) {
        // 再使用二分搜索试试看哈, 但是这个复杂度是O(nlogn)
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1, right = numbers.length - 1;
            while (left <= right) {   //注意这里left=right是可以的哦
                int mid = left + (right - left)/2;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i, mid};
                } else if (numbers[mid] > target - numbers[i]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return new int[]{-1,-1};
    }


}
