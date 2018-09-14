package com.leetcode.medium._165;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Compare Version Numbers
 *
 * @author ZhouXu
 * @version V1.0 2018-09-14
 */
public class CompareVersion {
    /**
     * Compare two version numbers version1 and version2.
     * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
     */
    public int compareVersion(String version1, String version2) throws Exception {
        if (version1 == null || version2 == null) {
            throw new Exception("compareVersion error: illegal params.");
        }

        int i = 0, j = 0;
        int sum1, sum2;
        while (i < version1.length() && j < version2.length()) {
            sum1 = 0;
            sum2 = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                sum1 *= 10;
                sum1 += version1.charAt(i) - '0';
                i++;
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                sum2 *= 10;
                sum2 += version2.charAt(j) - '0';
                j++;
            }
            if (sum1 < sum2) {
                return -1;
            } else if (sum1 > sum2) {
                return 1;
            } else {
                i++;
                j++;
            }
        }

        if (i >= version1.length() && j >= version2.length()) {
            return 0;
        } else if (i > version1.length()) { // version1 = "1" version2 = "01"
            sum2 = 0;
            while (j < version2.length()) {
                while (j < version2.length() && version2.charAt(j) != '.') {
                    sum2 *= 10;
                    sum2 += version2.charAt(j) - '0';
                    j++;
                }
                if (sum2 != 0) {
                    return -1;
                }
                j++;
            }
            return 0;
        } else {
            sum1 = 0;
            while (i < version1.length()) {
                while (i < version1.length() && version1.charAt(i) != '.') {
                    sum1 *= 10;
                    sum1 += version1.charAt(i) - '0';
                    i++;
                }
                if (sum1 != 0) {
                    return 1;
                }
                i++;
            }
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String version1 = line;
            line = in.readLine();
            String version2 = line;
            int ret = new CompareVersion().compareVersion(version1, version2);
            System.out.println(ret);
        }
    }
}
