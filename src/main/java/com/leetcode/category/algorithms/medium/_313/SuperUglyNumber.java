package com.leetcode.category.algorithms.medium._313;

import com.leetcode.category.common.util.ToolUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose
 * all prime factors are in the given prime list primes of size k.
 * <p>
 * # Note:
 * <p>
 * > 1 is a super ugly number for any given primes.
 * > The given numbers in primes are in ascending order.
 * > 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * > The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 *
 * @author ZhouXu
 * @version v1.0 2018-07-29
 */

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;
        Arrays.sort(primes);
        int[] indexes   = new int[primes.length];
        int[] dpUgly    = new int[n];
              dpUgly[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < primes.length; j++) {
                int curValue = primes[j] * dpUgly[indexes[j]];
                if (min > curValue) {
                    min = curValue;
                    minIndex = j;
                } else if (min == curValue) {
                    ++indexes[j];
                }
            }
            dpUgly[i] = min;
            indexes[minIndex]++;
        }

        return dpUgly[n - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;

        /**
         * Input: n = 12, primes = [2,7,13,19]
         * Output: 32
         * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
         *              super ugly numbers given primes = [2,7,13,19] of size 4.
         */
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            int[] primes = ToolUtil.stringToIntegerArray(line);
            int ret = new SuperUglyNumber().nthSuperUglyNumber(n, primes);
            String out = String.valueOf(ret);
            System.out.println(out);
        }
    }
}
