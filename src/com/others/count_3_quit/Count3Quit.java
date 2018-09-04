package com.others.count_3_quit;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZhouXu
 * @version v1.0 2018-09-03
 */

public class Count3Quit {
    // 数3退1游戏基础算法
    public static int result_01(int kidsNum) {
        int index       = 0;
        int countNum    = 0;
        int ret         = -1;
        int leftCount   = kidsNum;
        int[] markedArr = new int[kidsNum];

        Arrays.fill(markedArr, 1);
        while (leftCount != 1) {
            if (markedArr[index] == 1) {
                countNum++;
                if (countNum == 3) {
                    countNum = 0;
                    markedArr[index] = 0;
                    leftCount--;
                }
            }
            index++;
            if (index == markedArr.length) {
                index = 0;
            }
        }

        for (int i = 0; i < markedArr.length; i++) {
            if (markedArr[i] == 1)
                ret = i;
        }

        return ret;
    }

    // 面向对象处理
    public static int result_02(int kidsNum) {
        int countNum = 0;
        KidCircle kc = new KidCircle(kidsNum);
        KidNode k = kc.first;
        while (kc.count > 1) {
            countNum++;
            if (countNum == 3) {
                countNum = 0;
                kc.deleteKid(k);
            }
            k = k.right;
        }
        return k.id;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(result_01(n));
            System.out.println(result_02(n));
        }
        sc.close();
    }
}
