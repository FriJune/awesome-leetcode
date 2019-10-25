package com.leetcode.category.algorithms.medium._015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhouXu
 * @version v1.0 2018-07-23
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if (len < 2) return list;  // corner case invalid check
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            int low = i + 1;
            int high = len - 1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] == 0) {
                    list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    ++low;
                    --high;
                    // this two while loop is used to skip the duplication solution
                    while (low < high && nums[low - 1] == nums[low]) ++low;
                    while (low < high && nums[high] == nums[high + 1]) --high;
                } else if (nums[i] + nums[low] + nums[high] < 0) ++low;
                  else --high;
            }
            // this while loop also is used to skip the duplication solution
            while (i < len - 2 && nums[i] == nums[i + 1]) ++i;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum().threeSum(nums));
    }
}
