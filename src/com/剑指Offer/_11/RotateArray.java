package com.剑指Offer._11;

import com._test_.MainClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ZhouXu
 * @version v1.0 2018-08-26
 */
public class RotateArray {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转
     * 输入一个【非减】排序的数组的一个旋转，输出旋转数组的最小元素
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
     */
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) { return 0; }
        int low = 0, high = array.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[low] == array[mid] &&
                    array[mid] == array[high]) {
                return minNumber(array, low, high);
            } else if (array[mid] <= array[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return array[low];
    }

    /**
     * 数组元素允许重复，出现特殊情况：array[low]=array[mid]=array[high]
     * 此时无法确定解在哪个区间，切换到顺序查找
     * 例如： {1,1,1,0,1}
     */
    private static int minNumber (int[] array, int low, int high) {
        for (int i = low; i < high; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[low];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] array = MainClass.stringToIntegerArray(line);
            int ret = minNumberInRotateArray(array);
            System.out.println(ret);
        }
    }
}
