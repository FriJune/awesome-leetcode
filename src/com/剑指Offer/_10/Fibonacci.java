package com.剑指Offer._10;

import java.util.Scanner;

/**
 * 斐波那契数列
 *
 * @author ZhouXu
 * @version v1.0 2018-08-25
 */
public class Fibonacci {
    public int fibonacci(int n) {
        if (n <= 1) { return n; }
        int fib_n_1 = 1, fib_n_2 = 0;
        int fib = 0;

        for (int i = 2; i <= n; i++) {
            fib = fib_n_1 + fib_n_2;
            fib_n_2 = fib_n_1;
            fib_n_1 = fib;
        }

        return fib;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int ret = new Fibonacci().fibonacci(n);
            System.out.println(ret);
        }
    }
}
