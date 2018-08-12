package com.leetcode.easy._263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * a program to check whether a given number is an ugly number
 *
 * @author ZhouXu
 * @version v1.0 2018-07-26
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }

    public static String booleanToString(boolean input) {
        return input ? "true" : "false";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);
            boolean ret = new UglyNumber().isUgly(num);
            String output = booleanToString(ret);
            System.out.println(output);
        }
    }
}
