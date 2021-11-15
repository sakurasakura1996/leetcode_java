package 回溯.problem401_二进制手表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 为了练习使用 回溯法
// 这道题，可不可以分别存起来顶部和底部几个灯的所有可能，然后再排列组合。
public class Solution {
//    public List<String> readBinaryWatch(int turnedOn) {
//        Map<Integer, List<Integer>> topMap = new HashMap<>();
//        Map<Integer, List<Integer>> botMap = new HashMap<>();
//
//        for (int i = 0; i < 5; i++) {
//
//        }
//    }
//
//
//    public List<Integer> backtrace(List<Integer> ans, List<Integer> list, int num, int start) {
//
//        if (num == 0) {
//
//
//        }
//    }

    // 枚举这方法，得好好记住啊
    public List<String> readBinaryWatch2(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    ans.add(i + ":" + (j < 10 ? "0" :"") + j);
                }
            }
        }
        return ans;
    }

}
