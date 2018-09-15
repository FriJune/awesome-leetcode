package com.others.xiaoQDrawer;

import java.util.Scanner;

/**
 * 画家小Q
 *
 * @author ZhouXu
 * @version V1.0 2018-09-15
 */
public class XiaoQDrawer {
    // 当前位置斜率为 -1 画Y, 是否在后续位置继续画Y
    private void _dfsY(int x, int y, int n, int m, char[][] color) {
        if (x >= 0 && x < n && y >= 0 && y < m &&
                (color[x][y] == 'Y' || color[x][y] == 'G')) {
            if (color[x][y] == 'Y') {
                color[x][y] = 'X';
            } else {
                color[x][y] = 'B';
            }
            // 是否连笔继续画, Y对应的是画'\', 即左上或者右下
            _dfsY(x - 1, y - 1, n, m, color);
            _dfsY(x + 1, y + 1, n, m, color);
        }
    }

    // 当前位置斜率为 1 画B, 是否在后续位置继续画B
    private void _dfsB(int x, int y, int n, int m, char[][] color) {
        if (x >= 0 && x < n && y >= 0 && y < m &&
                (color[x][y] == 'B' || color[x][y] == 'G')) {
            if (color[x][y] == 'B') {
                color[x][y] = 'X';
            } else {
                color[x][y] = 'Y';
            }
            // 是否连笔继续画, Y对应的是画'/', 即右上或者左下
            _dfsB(x - 1, y + 1, n, m, color);
            _dfsB(x + 1, y - 1, n, m, color);
        }
    }

    public int getMinStep(int n, int m, char[][] color) {
        int step = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (color[i][j] == 'Y') {
                    _dfsY(i, j, n, m, color);
                    step++;
                } else if (color[i][j] == 'B') {
                    _dfsB(i, j, n, m, color);
                    step++;
                } else if (color[i][j] == 'G') {
                    _dfsY(i, j, n, m, color);
                    step++;
                    _dfsB(i, j, n, m, color);
                    step++;
                }
            }
        }
        return step;
    }

    /**
     * unit test
     * Input:
     * 4 4
     * YXXB
     * XYGX
     * XBYY
     * BXXY
     * Output:
     * 3
     * Explication:
     * XXXX      YXXX      YXXB      YXXB
     * XXXX  ->  XYXX  ->  XYBX  ->  XYGX
     * XXXX      XXYX      XBYX      XBYY
     * XXXX      XXXY      BXXY      BXXY
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int n = Integer.valueOf(line.split(" ")[0]);
        int m = Integer.valueOf(line.split(" ")[1]);
        char[][] color = new char[n][m];
        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                color[i][j] = line.charAt(j);
            }
        }
        System.out.println(new XiaoQDrawer().getMinStep(n, m, color));
        sc.close();
    }
}
