package com.剑指Offer._05;

/**
 * 将一个字符串中的空格替换成 “%20”
 *
 * @author ZhouXu
 * @version v1.0 2018-07-26
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer sb) {
        int preLength = sb.length();
        for (int i = 0; i < preLength; i++) {
            // 一个空格要替换成三个字符（%20）, 追加两个任意字符
            if (sb.charAt(i) == ' ') sb.append("  ");
        }
        int p1 = preLength - 1;    // 指向字符串原来的末尾位置
        int p2 = sb.length() - 1;  // 指向字符串现在的末尾位置
        while (p1 >= 0 && p2 > p1) {
            char ch = sb.charAt(p1--);
            if (ch == ' ') {
                sb.setCharAt(p2--, '0');
                sb.setCharAt(p2--, '2');
                sb.setCharAt(p2--, '%');
            } else {
                sb.setCharAt(p2--, ch);
            }
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        System.out.println(new ReplaceSpace().replaceSpace
                (new StringBuffer("We Are Happy")));
    }
}