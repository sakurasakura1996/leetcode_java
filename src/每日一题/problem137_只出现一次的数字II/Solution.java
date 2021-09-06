package 每日一题.problem137_只出现一次的数字II;

import com.sun.deploy.panel.ITreeNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public int singleNumber(int[] nums){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num :
                nums) {
            if (hashMap.containsKey(num)){
                hashMap.replace(num, hashMap.get(num)+1);
            }else{
                hashMap.put(num, 1);
            }
        }
        int ans = 0;
//        Iterator<Integer> iterator = hashMap.keySet().iterator();
//        while (iterator.hasNext()){
//            if (hashMap.get(iterator.next()) == 1){
//                ans = iterator.next();
//            }
//        }
        for (Map.Entry<Integer, Integer> entry :
                hashMap.entrySet()) {
            int num = entry.getKey();
            int occ = entry.getValue();
            if (occ == 1){
                ans = num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 3, 2};
        int ans = solution.singleNumber(nums);
        System.out.println(ans);
    }
}
