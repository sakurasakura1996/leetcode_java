package 每日一题.problem421_数组中两个数的最大异或值;
class Trie{
    Trie left = null;
    Trie right = null;
}

public class Solution {
    Trie root = new Trie();

    static final int HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums){
        int n = nums.length;
        int x = 0;
        for (int i = 1; i < n; i++) {
            add(nums[i-1]);
            x = Math.max(x, check(nums[i]));

        }
        return x;
    }

    public void add(int num){
        Trie cur = root;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 0){
                if (cur.left == null){
                    cur.left = new Trie();
                }
                cur = cur.left;
            }else{
                if (cur.right == null){
                    cur.right = new Trie();
                }
                cur = cur.right;
            }

        }
    }

    public int check(int num){
        Trie cur = root;
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; k--){
            int bit = (num >> k) & 1;
            if (bit == 0){
                if (cur.right != null){
                    cur = cur.right;
                    x = x * 2 + 1;
                }else{
                    cur = cur.left;
                    x = x * 2;
                }
            }else{
                if (cur.left != null){
                    cur = cur.left;
                    x = x * 2 + 1;
                }else{
                    cur = cur.right;
                    x = x * 2;
                }
            }
        }
        return x;
    }

}
