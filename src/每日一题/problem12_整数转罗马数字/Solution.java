package 每日一题.problem12_整数转罗马数字;

public class Solution {
    public String intToRoman(int num){
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] keys = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String key = keys[i];
            while (num >= value){
                num -= value;
                roman.append(key);
            }
            if (num == 0){
                break;
            }
        }
        return roman.toString();
    }
}
