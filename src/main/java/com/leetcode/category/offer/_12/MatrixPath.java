package com.leetcode.category.offer._12;

import java.util.Scanner;

/**
 * @author ZhouXu
 * @version v1.0 2018-08-27
 */
public class MatrixPath {
    private int rows;
    private int cols;
    private final static int[][] next = {
                { 0, -1},
                { 0,  1},
                {-1,  0},
                { 1,  0},
    };

    /**
     * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
     * 例如：下面 3 X 4 矩阵包含路径"b->c->c->e->d"
     *             矩阵中不包含路径"a->b->c->b"
     * [
     *  [a, b, c, e]
     *  [s, f, c, s]
     *  [a, d, e, e]
     * ]
     */
    public boolean hasPath(char[] array, int rows, int cols, char[] target) {
        if (rows == 0 || cols == 0) { return false; }

        this.rows = rows;
        this.cols = cols;

        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = _buildMatrix(array);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (_backTracking(matrix, target, marked, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean _backTracking(char[][] matrix, char[] target,
                                  boolean[][] marked,
                                  int pathLen, int _rows, int _cols) {
        if (pathLen == target.length) { return true; }
        if (_rows < 0 || _rows >= rows ||
            _cols < 0 || _cols >= cols ||
            matrix[_rows][_cols] != target[pathLen] ||
            marked[_rows][_cols]) {
            return false;
        }

        marked[_rows][_cols] = true;

        for (int[] n : next) {
            if (_backTracking(matrix, target, marked,
                    pathLen + 1,
                    _rows + n[0], _cols + n[1])) {
                return true;
            }
        }

        marked[_rows][_cols] = false;

        return false;
    }

    private char[][] _buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = array[index++];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            char[] matrix = sc.nextLine().toCharArray(); // abcesfcsadee
            char[] target = sc.nextLine().toCharArray(); // bcced   abcb

            // sc.nextInt()下一次循环输入抛出InputMismatchException异常
            int rows = Integer.parseInt(sc.nextLine());
            int cols = Integer.parseInt(sc.nextLine());

            boolean ret = new MatrixPath().hasPath(matrix, rows, cols, target);
            System.out.println(ret);
        }
        sc.close();
    }
}
