package com.leetcode.medium._008;

/**
 * @author ZhouXu
 * @version v1.0 2018-07-17
 */
public class MyAtoi {
    public int myAtoi(String str) {
        int i = 0;
        int ans = 0;
        int sign = 1; // +/- sign
        int len = str.length();
        while (i < len && str.charAt(i) == ' ') ++i;
        if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = str.charAt(i++) == '+' ? 1 : -1;
        }
        for (; i < len; ++i) {
            int temp = str.charAt(i) - '0';
            if (temp < 0 || temp > 9) break;
            if (ans > Integer.MAX_VALUE / 10
                    || ans == Integer.MAX_VALUE / 10 && ((sign == 1 && temp > 7) || (sign == -1 && temp > 8))) {
                // out of the range of a 32-bit signed integer
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                ans = ans * 10 + temp;
            }
        }
        return sign * ans;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[5];
        MyAtoi atois  = new MyAtoi();

        /**
         *  Output: 42
         */
        arr[0] = atois.myAtoi("42");

        /**
         * Output: -42
         * Explanation: The first non-whitespace character is '-', which is the minus sign.
         *              Then take as many numerical digits as possible, which gets 42.
         */
        arr[1] = atois.myAtoi("   -42");

        /**
         * Output: 4193
         * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
         */
        arr[2] = atois.myAtoi("4193 with words");

        /**
         * Output: 0
         * Explanation: The first non-whitespace character is 'w', which is not a numerical
         *              digit or a +/- sign. Therefore no valid conversion could be performed.
         */
        arr[3] = atois.myAtoi("words and 987");

        /**
         * Output: -2147483648
         * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
         *              Thefore INT_MIN (−231) is returned.
         */
        arr[4] = atois.myAtoi("-91283472332");

        for (Integer a : arr) System.out.println(a);
    }
}
