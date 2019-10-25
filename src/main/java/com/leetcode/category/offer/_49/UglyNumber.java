package com.leetcode.category.offer._49;

/**
 * 求按从小到大的顺序的第N个丑数
 *
 * @author ZhouXu
 * @version v1.0 2018-07-24
 */
public class UglyNumber {
    public int getUglyNumbers(int index) {
        if (index <= 6) return index;
        int factor2 = 0;
        int factor3 = 0;
        int factor5 = 0;
        int[] dp = new int[index]; dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int next2 = dp[factor2] * 2;
            int next3 = dp[factor3] * 3;
            int next5 = dp[factor5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2) factor2++;
            if (dp[i] == next3) factor3++;
            if (dp[i] == next5) factor5++;

        }
        return dp[index -1];
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber().getUglyNumbers(10));
    }
}
