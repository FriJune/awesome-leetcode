package com.剑指Offer._10;

/**
 * @author ZhouXu
 * @version v1.0 2018-08-26
 */
public class RectCover {
    /**
     * 矩形覆盖
     * 用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形
     */
    public static int rectCover(int target) {
        if (target <= 2) { return target; }

        int pre2 = 1, pre1 = 2;
        int retsult = 0;
        for (int i = 3; i <= target; i++) {
            retsult = pre2 + pre1;
            pre2 = pre1;
            pre1 = retsult;
        }

        return retsult;
    }

    public static void main(String[] args) {
        // unit test
    }
}
