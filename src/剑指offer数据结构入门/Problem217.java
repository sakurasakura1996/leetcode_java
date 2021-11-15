package 剑指offer数据结构入门;

import java.util.HashSet;
import java.util.Set;

/* 既然考察数据结构，使用优秀的数据结构来查看是否有重复元素
*
* 使用哈希表 */
public class Problem217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            if (hashSet.contains(i)) {
                return true;
            } else {
                hashSet.add(i);
            }

            // 上面可以改成下面这种写法，set.add()的时候会返回插入是否成功
//            if (!hashSet.add(i)) {
//                return true;
//            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        boolean b = new Problem217().containsDuplicate(nums);
        System.out.println(b);
    }
}