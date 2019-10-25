package com.leetcode.category.others.kolakoskisequence;

import com.leetcode.category.common.util.ToolUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Kolakoski sequence
 * wikipedia: https://en.wikipedia.org/wiki/Kolakoski_sequence
 *
 * @author ZhouXu
 * @version V1.0 2018-09-13
 */
public class Kolakoski {
    public static ArrayList<Integer> kolakoskiSequence(int[] array, int target) {
        int arrIndex = 0;
        int count = 0;

        ArrayList<Integer> retList = new ArrayList<>();

        while (count < target) {
            if (arrIndex == array.length) arrIndex = 0;
            retList.add(array[arrIndex]);
            for (int i = 0; i < retList.get(count) - 1; i++) {
                retList.add(array[arrIndex]);
            }
            ++arrIndex;
            ++count;
        }

        return retList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            /**
             * Input: [1, 2]  n
             * Output: [1, 2, 2, 1, 1, 2, 1, 2, 2, 1, 2, 2,...]
             *
             * Input: [2, 1, 3, 1]  n
             * Input: [2, 2, 1, 1, 3, 1, 2, 2, 2, 1, 3, 3,...]
             */
            int[] array = ToolUtil.stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);
            System.out.println(kolakoskiSequence(array, target));
        }
    }
}
