package com.剑指Offer._13;

import java.util.Scanner;

/**
 * @author ZhouXu
 * @version v1.0 2018-09-03
 */
public class RobotMotion {
    private final static int[][] next = {
            { 0, -1},
            { 0,  1},
            {-1,  0},
            { 1,  0},
    };
    private int result = 0;
    private int rows;
    private int cols;
    private int threshold;
    private int[][] digitSum;

    /**
     * 地上有一个m行和n列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，
     * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
     * 请问该机器人能够达到多少个格子？
     */
    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        
        _initDigitSum();
        boolean[][] marked = new boolean[rows][cols];
        _dfs(marked, 0, 0);
        
        return result;
    }

    private void _dfs(boolean[][] marked, int _rows, int _cols) {
        if (_rows < 0 || _rows >= rows ||
            _cols < 0 || _cols >= cols ||
            marked[_rows][_cols]) {
            return;
        }

        marked[_rows][_cols] = true;
        if (this.digitSum[_rows][_cols] > this.threshold) {
            return;
        }

        result++;

        for (int[] n : next) {
            _dfs(marked, _rows + n[0], _cols + n[1]);
        }
    }

    private void _initDigitSum() {
        int[] digitSumOne = new int[Math.max(rows, cols)];
        for (int i = 0; i < digitSumOne.length; i++) {
            int n = i;
            while (n > 0) {
                digitSumOne[i] += n % 10;
                n /= 10;
            }
        }

        this.digitSum = new int[rows][cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int threshold = sc.nextInt();
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            System.out.println(new RobotMotion().movingCount(threshold, rows, cols));
        }
        sc.close();
    }
}
