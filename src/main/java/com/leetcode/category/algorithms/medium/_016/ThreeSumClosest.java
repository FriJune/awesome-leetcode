package com.leetcode.category.algorithms.medium._016;

import com.leetcode.category.common.util.ToolUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * @author ZhouXu
 * @version v1.0 2018-7-30
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // invalid corner case check
        if (nums.length < 3) return -1;
        // sort is needed
        Arrays.sort(nums);

        int ret = 0;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int tempValue = nums[i] + nums[low] + nums[high];
                int tempDistance;
                if (tempValue < target) {
                    tempDistance = target - tempValue;
                    if (tempDistance < distance) {
                        distance = tempDistance;
                        ret = nums[i] + nums[low] + nums[high];
                    }
                    ++low;
                } else if (tempValue > target) {
                    tempDistance = tempValue - target;
                    if (tempDistance < distance) {
                        distance = tempDistance;
                        ret = nums[i] + nums[low] + nums[high];
                    }
                    --high;
                } else { // note: in this case, the sum is 0, 0 means the shortest distance
                    ret = nums[i] + nums[low] + nums[high];
                    return ret;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = ToolUtil.stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);
            int ret = new ThreeSumClosest().threeSumClosest(nums, target);
            String out = String.valueOf(ret);
            System.out.println(out);
        }
    }
}
