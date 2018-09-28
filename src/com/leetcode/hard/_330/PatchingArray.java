package com.leetcode.hard._330;

import com._test_.MainClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a sorted positive integer array nums and an integer n,
 * add/patch elements to the array such that any number in range [1, n]
 * inclusive can be formed by the sum of some elements in the array.
 * countPatchesurn the minimum number of patches required.
 *
 * @author ZhouXu
 * @version V1.0 2018-09-28
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int i = 0, countPatches = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                ++countPatches;
            }
        }
        return countPatches;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = MainClass.stringToIntegerArray(line);
            line = in.readLine();
            int n = Integer.parseInt(line);
            int countPatches = new PatchingArray().minPatches(nums, n);
            String out = String.valueOf(countPatches);
            System.out.println(out);
        }
    }
}
