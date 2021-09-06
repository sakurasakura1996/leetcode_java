package 剑指offer.剑指offer39_数组中出现次数超过一半的数字;

public class Solution {
    public int majorityElement(int[] nums) {
        // 这种题目想得到的解答是位运算和逻辑运算的问题，但是不太会啊，简单方法就是记录下来
        // 但是这道题目不一样，上次蚂蚁面试遇到了，我们可以相互抵消着找到出现次数超过一半的
        int n = nums.length;
        if (n == 1) return nums[0];
        int ans = nums[0];
        int number = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == ans) {
                number++;
            } else if (nums[i] != ans) {
                if (number > 0) {
                    number--;
                } else {
                    ans = nums[i];
                    number = 1;
                }
            }
        }
        return ans;
    }

    public int majorityElement2(int[] nums) {
        int x = 0, votes = 0;
        for (int num :
                nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
