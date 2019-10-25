package com.leetcode.category.algorithms.medium._324;

import com.leetcode.category.common.util.ToolUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ZhouXu
 * @version v1.0 2018-08-30
 */
public class WiggleSortII {
    /**
     * Given an unsorted array nums, reorder it such that
     * nums[0] < nums[1] > nums[2] < nums[3]....
     *
     * Example
     * Input: nums = [1, 5, 1, 1, 6, 4]
     * Output: One possible answer is [1, 4, 1, 5, 1, 6].
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 2) { return; }

        int m = (nums.length + 1) >> 1;
        int t = nums.length;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = (i & 1) == 0 ? nums[--m] : nums[--t];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = ToolUtil.stringToIntegerArray(line);
            new WiggleSortII().wiggleSort(nums);
            String out = ToolUtil.integerArrayToString(nums);
            System.out.println(out);
        }
    }
}
