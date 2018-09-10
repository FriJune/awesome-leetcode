package com.leetcode.medium._055;

import com._test_.MainClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Jump Game
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * @author ZhouXu
 * @version V1.0 2018-09-10
 */
public class JumpGame {
    // better solution
    public boolean canJump(int[] nums) {
        int lastLocation = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if ((nums[i] + i) >= lastLocation) {
                lastLocation = i;
            }
        }
        return lastLocation == 0;
    }

    // // it's ok
    // public boolean canJump(int[] nums) {
    //     if (nums.length <= 1) return true;
    //     int max = nums[0]; // the largest index that can be reached
    //     for (int i = 0; i < nums.length; i++) {
    //         // if not enough to go to next
    //         if (max <= i && nums[i] == 0) return false;
    //         // update max
    //         if (i + nums[i] > max) max = i + nums[i];
    //         // max is enough to reach the end
    //         if (max >= nums.length - 1) return true;
    //     }
    //     return false;
    // }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = MainClass.stringToIntegerArray(line);
            boolean ret = new JumpGame().canJump(nums);
            System.out.println(ret);
        }
    }
}
