package com.剑指Offer._04;

/**
 * 二维数组查找：
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15]
 *   [2,   5,  8, 12, 19]
 *   [3,   6,  9, 16, 22]
 *   [10, 13, 14, 17, 24]
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 *
 * @author ZhouXu
 * @version v1.0 2018-07-24
 */
public class Solution {
    public boolean find(int target, int[][] matrix) {
        if (matrix == null && matrix.length == 0
                && matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        // 从右上角开始查找
        int r = 0, c = cols - 1;
        while (r < rows && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                r++;
            } else c--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  4,  7, 11, 15},
                { 2,  5,  8, 12, 19},
                { 3,  6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(new Solution().find(20, matrix));
    }
}