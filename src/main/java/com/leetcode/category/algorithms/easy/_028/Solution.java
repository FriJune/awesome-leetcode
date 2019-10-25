package com.leetcode.category.algorithms.easy._028;

import java.util.Scanner;

/**
 * @author ZhouXu
 * @version V1.0 2018-09-28
 */
public class Solution {
    // Return the index of the first occurrence of needle in haystack,
    // or -1 if needle is not part of haystack.
    public static int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();

        if (haystackLen < needleLen) return -1;

        for (int i = 0; ; i++) {
            if (i + needleLen > haystackLen) return -1;
            for (int j = 0; ; j++) {
                if (j == needleLen) return i;
                if(haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String haystack = sc.nextLine();
            String needle = sc.nextLine();
            int ret = strStr(haystack, needle);
            System.out.println(ret);
        }
        sc.close();
    }
}
