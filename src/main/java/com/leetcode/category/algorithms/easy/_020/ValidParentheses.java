package com.leetcode.category.algorithms.easy._020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * @author ZhouXu
 * @version v1.0 2018-07-30
 */
public class ValidParentheses {
    public boolean isValid(String str) {
        char[] stack = new char[str.length() + 1];
        int top = 1;
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c;
            } else if (c == ')' && stack[--top] != '(') {
                return false;
            } else if (c == ']' && stack[--top] != '[') {
                return false;
            } else if (c == '}' && stack[--top] != '{') {
                return false;
            }
        }
        return top == 1;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            boolean ret = new ValidParentheses().isValid(line);
            String out = booleanToString(ret);
            System.out.println(out);
        }
    }
}