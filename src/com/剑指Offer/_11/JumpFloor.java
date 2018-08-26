package com.剑指Offer._11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZhouXu
 * @version v1.0 2018-08-26
 */
public class JumpFloor {
    /**
     * 跳台阶
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级
     * 该青蛙跳上一个 n 级的台阶总共有多少种跳法
     */
    public static int jumpFloorI(int target) {
        if (target <= 2) { return target; }
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for (int i = 2; i < target; i++) {
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    /**
     * 变态跳台阶
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级
     * 该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     */
    public static int jumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 0; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int target = sc.nextInt();
            System.out.println("跳台阶：  " + jumpFloorI(target));
            System.out.println("变态跳台阶： " + jumpFloorII(target));
        }
    }
}
