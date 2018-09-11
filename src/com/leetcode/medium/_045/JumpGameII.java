package com.leetcode.medium._045;

import com._test_.MainClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Jump Game II
 *
 * @author ZhouXu
 * @version V1.0 2018-09-10
 */
public class JumpGameII {
    // to reach the last index in the minimum number of jumps
    public int jump(int[] nums) {
        int ret = 0;
        int lastLocation = 0;
        int currLocation = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > lastLocation) {
                lastLocation = currLocation;
                ++ret;
            }
            currLocation = Math.max(currLocation, i + nums[i]);
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = MainClass.stringToIntegerArray(line);
            int ret = new JumpGameII().jump(nums);
            System.out.println(ret);
        }
    }
}
