package 按顺序刷题.problem11_盛最多水的容器;

/**
 * @author chenz
 * @ClassName Solution
 * @Description 使用双指针来解决问题。这里我们分析双指针的关键理解：left指针和right指针分别指向两边边界的时候，为什么我们可以
 * 通过移动一边指针但是能保证没有错过正确答案，这里我们可以分析下，比如 height[left] < height[right],那么我们left右移一位，为什么可以呢
 * 我们可以想想，如果右侧指针right值更大，且right左移，那么最后的结果，必定是减小的，这样的话，就可能错过本来left++，和right组合出的答案。、
 *
 * 综上：可以归纳成：对应数字较小的那个指针不可能作为容器的边界了，因为，假设移动较大值的指针，一定会比当前结果要小，从另一个角度来说，就是数字较小的
 * 指针不可能再作为边界了，所以可以把数字较小的边界移动了，而且这也并不会导致正确结果的丢失。这个思考过程还是蛮重要的。加油
 * @date 2021/12/14-22:25
 */
public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = Integer.MIN_VALUE;
        int left = 0, right = n-1;
        while (left < right) {
            int temp = area(height, left, right);
            if (ans < temp) {
                ans = temp;
            }
            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return ans;
    }

    public int area(int[] height, int left, int right) {
        // 计算当前情况下盛水的体积
        return Math.min(height[left], height[right]) * (right - left);
    }
}
