package com.leetcode.category.algorithms.medium._343;

import java.util.Scanner;

/**
 * @author ZhouXu
 * @version v1.0 2018-08-31
 */
public class IntegerBreak {
    /**
     * Given a positive integer n, break it into the sum of
     * at least two positive integers and maximize the product of those integers.
     * Return the maximum product you can get.
     * <p>
     * Example
     * Input: 10
     * Output: 36
     * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
     */
    public int integerBreak_01(int n) { // better
        if (n < 2)  return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int numbers_of_3 = n / 3;
        if (n - numbers_of_3 * 3 == 1) {
            numbers_of_3--;
        }
        int numbers_of_2 = (n - numbers_of_3 * 3) / 2;

        return (int) (Math.pow(3, numbers_of_3)) * (int) (Math.pow(2, numbers_of_2));
    }

    public int integerBreak_02(int n) { // worse
        if (n < 2)  return 0;
        if (n == 2) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int ret_01 = new IntegerBreak().integerBreak_01(n);
            int ret_02 = new IntegerBreak().integerBreak_02(n);
            System.out.println(ret_01);
            System.out.println(ret_02);
        }
    }
}
