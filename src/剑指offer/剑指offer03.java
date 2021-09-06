package 剑指offer;

import java.util.HashMap;

public class 剑指offer03 {
    public int findRepeatNumber(int[] nums){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num :
                nums) {
            if (hashMap.containsKey(num)) {
                int tmp = hashMap.get(num);
                hashMap.put(num, tmp+1);
            }else{
                hashMap.put(num, 1);
            }
            }
        return -1;

    }

    public static void main(String[] args) {

    }
}
