package com.leetcode.category.others.songList;

import java.util.Scanner;

/**
 * 小Q的歌单
 *
 * @author ZhouXu
 * @version V1.0 2018-09-14
 */
public class SongList {
    private static long[][] c = new long[105][105];
    private final static long mod = 1000000007; // 组成歌单的方法取模

    private static void init() { // 计算组合数
        c[0][0] = 1;
        // C(n,k) = C(n-1,k) + C(n-1,k-1）
        for (int i = 1; i <= 100; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= 100; j++)
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % mod;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); // 歌单总长度
        int A = sc.nextInt(); // 长度为A的歌(A<=100)
        int X = sc.nextInt(); // 长度为A的歌有X首
        int B = sc.nextInt(); // 长度为B的歌(B<=100)
        int Y = sc.nextInt(); // 长度为B的歌有Y首
        init();
        long ret = 0;
        for (int i = 0; i <= X; i++) {
            if (i * A <= K && (K - i * A) % B == 0 && (K - i * A) / B <= Y) {
                ret = (ret + (c[X][i] * c[Y][(K - i * A) / B]) % mod) % mod;
            }
        }
        System.out.println(ret);
        sc.close();
    }
}
