package com.leetcode.category.algorithms.easy._001;

import com.leetcode.category.common.util.ToolUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhouxu
 * @create 2019-10-26
 */
public class TwoSum {

    // Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    // Example:
    // Given nums = [2, 7, 11, 15], target = 9,
    // Because nums[0] + nums[1] = 2 + 7 = 9,
    // return [0, 1].
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[0];
        }
        return new int[0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = ToolUtil.stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int[] ret = new TwoSum().twoSum(nums, target);

            String out = ToolUtil.integerArrayToString(ret);

            System.out.print(out);
        }
    }

}
