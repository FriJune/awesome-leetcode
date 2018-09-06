package com.剑指Offer._15;

import java.util.Scanner;

/**
 * 二进制中 1 的个数
 *
 * @author ZhouXu
 * @version V1.0 2018-09-06
 */
public class BinaryNumberOf1 {
    public static int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println("number of one-bits: " + numberOf1(n));
            System.out.println("number of one-bits: " + Integer.bitCount(n));
        }
    }
}
