package com.leetcode.category.others.parenthesesSequences;

import java.util.Scanner;

/**
 * 括号匹配
 *
 * @author ZhouXu
 * @version V1.0 2018-09-09
 */
public class ParenthesesSequences {
    private boolean _isPalindrome(char[] chars) {
        int count = 0;
        for (char c : chars) {
            if (c == '(') {
                count++;
            } else {
                if (count <= 0) return false;
                count--;
            }
        }
        return count == 0;
    }

    private void _swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public boolean check(char[] chars) {
        int leftCount = 0, rightCount = 0;
        for (char c : chars) {
            if (c == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
        }

        if (leftCount != rightCount) return false;

        for (int i = 1; i < chars.length; i++) {
            for (int j = 0; j < i; j++) {
                if (_isPalindrome(chars)) return true;
                _swap(chars, i, j);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            String str = sc.next();
            char[] chars = str.toCharArray();
            System.out.println(new ParenthesesSequences().check(chars) ? "Yes" : "No");
        }
        sc.close();
    }
}
