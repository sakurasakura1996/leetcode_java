package JianZhiOffer.剑指offer4_二维数组中的查找;

/* 使用二分法是肯定的，但是两个方向能同时使用二分吗，
* 比较好理解的就是，我们一行一行的看，然后每一行用二分搜索，时间复杂度是 O(nlogn)
* 那能不能更快呢，这题目应该已经做过2遍或者2遍以上了，为什么还是搞不清楚呢？？？
*
* 除了二分，我想到，可不可以从左下角或者右上角开始遍历，逐步缩小范围*/
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 注意特殊情况， matrix = []
        if (matrix.length == 0 ) return false;
        int m = matrix.length, n = matrix[0].length;

        int x = 0, y = n-1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                x ++;
            } else {
                y --;
            }
        }
        return false;
    }

    /* 这里运用二分搜索方法来做，时间复杂度的计算比较复杂啊。 O(logk!) k = min(m,n)*/
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        // 二维数组的二分查找
        if (matrix.length == 0) return false;
        return helper(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1, target);
    }


    public boolean helper(int[][] matrix, int xs, int xe, int ys, int ye, int target) {
        // 边界条件
        if (xs > xe || ys > ye) return false;
        int xmid = (xs + xe) >> 1;
        int ymid = (ys + ye) >> 1;
        // 如果相等，直接 true
        if (target == matrix[ymid][xmid]) return true;
        // 如果小于，查找除了右下角的三个区域
        if (target < matrix[ymid][xmid]) {
            return helper(matrix, xs, xmid - 1, ys, ymid - 1, target)
                    || helper(matrix, xmid, xe, ys, ymid - 1, target)
                    || helper(matrix, xs, xmid - 1, ymid, ye, target);
        }
        // 如果大于，则要查找除了左上角的三个区域
        if (target > matrix[ymid][xmid]) {
            return helper(matrix, xmid + 1, xe, ys, ymid, target)
                    || helper(matrix, xs, xmid, ymid+1, ye, target)
                    || helper(matrix, xmid + 1, xe, ymid + 1, ye, target);
        }
        return false;
    }
}
