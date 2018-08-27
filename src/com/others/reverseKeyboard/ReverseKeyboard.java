package com.others.reverseKeyboard;

import java.util.Scanner;

/**
 * @author ZhouXu
 * @version v1.0 2018-08-27
 */
public class ReverseKeyboard {
    /**
     * 功能：把“自然键盘”产生的类似"H kz k xif."这样的字符串转换为“标准键盘”的"I am a boy."
     */
    public static StringBuilder reverseKeyboard(char[] chars) {
        char[] naKeyboard = {
            'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'
        };
        char[] stKeyboard = {
            'Q', 'W', 'E', 'R', 'T',
            'Y', 'U', 'I', 'O', 'P',
            'A', 'S', 'D', 'F', 'G',
            'H', 'J', 'K', 'L', 'Z',
            'X', 'C', 'V', 'B', 'N', 'M'
        };

        StringBuilder builder = new StringBuilder();

        outer:
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < 26; j++) {
                if (chars[i] == naKeyboard[j]) {
                    builder.append(stKeyboard[j]);
                    continue outer;
                } else if (chars[i] == (char) (naKeyboard[j] + 32)) {
                    builder.append((char) (stKeyboard[j] + 32));
                    continue outer;
                }
            }
            builder.append(chars[i]);
        }
        return builder;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            System.out.println(reverseKeyboard(chars));
        }
        sc.close();
    }
}
