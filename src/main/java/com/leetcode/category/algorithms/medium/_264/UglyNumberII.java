package com.leetcode.category.algorithms.medium._264;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Write a program to find the n-th ugly number.
 *
 * @author ZhouXu
 * @version v1.0 2018-07-27
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] dpUgly = new int[n];
              dpUgly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(factor2, Math.min(factor3, factor5));
            dpUgly[i] = min;
            if (factor2 == min)
                factor2 = 2 * dpUgly[++index2];
            if (factor3 == min)
                factor3 = 3 * dpUgly[++index3];
            if (factor5 == min)
                factor5 = 5 * dpUgly[++index5];
        }
        return dpUgly[n - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            int ret = new UglyNumberII().nthUglyNumber(n);
            String out = String.valueOf(ret);
            System.out.println(out);
        }
    }
}
