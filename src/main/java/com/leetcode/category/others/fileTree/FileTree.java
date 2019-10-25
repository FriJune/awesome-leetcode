package com.leetcode.category.others.fileTree;

import java.io.File;

/**
 * @author ZhouXu
 * @version v1.0 2018-08-28
 */
public class FileTree {
    /**
     * 递归输出目录树
     */
    public static void listAllFiles(File dir, int deep) {
        String preStr = "";
        for (int i = 0; i < deep; i++) {
            preStr += "|---";
        }

        System.out.println(preStr + dir.getName());

        if (!dir.isDirectory()) {
            return;
        }

        for (File file : dir.listFiles()) {
            listAllFiles(file, deep + 1);
        }
    }

    public static void main(String[] args) {
        File f = new File("D:\\opt"); // test your root directory
        listAllFiles(f, 0);
    }
}
