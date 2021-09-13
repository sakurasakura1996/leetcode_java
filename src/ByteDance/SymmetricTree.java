package ByteDance;

import JianZhiOffer.剑指offer35_复杂链表的复制.Solution;

import java.util.Arrays;
import java.util.Scanner;

public class SymmetricTree {
    public int findSymmetricTree(int[] preOrder, int[] inOrder) {
        // 先找到最大值的位置
        int pos = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] > maxValue) {
                pos = i;
                maxValue = inOrder[i];
            }
        }
        if (isSymmetricTree(preOrder, inOrder)) {
            return inOrder[inOrder.length-pos-1];
        }else{
            return inOrder[pos];
        }
    }

    public boolean isSymmetricTree(int[] preOrder, int[] inOrder) {
        // 判断是否对称二叉树，用递归来解决
        int n = inOrder.length;
        if (n == 1) return true;
        int mid = preOrder[0];
        int midIdx = -1;
        for (int i = 0; i < n; i++) {
            if (inOrder[i] == mid) {
                midIdx = i;
            }
        }
        if (n % 2 == 0 || midIdx != n / 2) return false;
        if (!isSymmetricTree(Arrays.copyOfRange(preOrder, 1, midIdx + 1), Arrays.copyOfRange(inOrder, 0, midIdx)) ||
                !isSymmetricTree(Arrays.copyOfRange(preOrder, midIdx + 1, n), Arrays.copyOfRange(inOrder, midIdx + 1, n))) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] preOrder = new int[num];
        int[] inOrder = new int[num];

        for (int i = 0; i < num; i++) {
            preOrder[i] = scanner.nextInt();
        }
        for (int i = 0; i < num; i++) {
            inOrder[i] = scanner.nextInt();
        }

        SymmetricTree symmetricTree = new SymmetricTree();
        int ans = symmetricTree.findSymmetricTree(preOrder, inOrder);
        System.out.println(ans);

    }
}
