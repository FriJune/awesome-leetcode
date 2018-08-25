package com.剑指Offer._07;

import com._test_.MainClass;
import com._test_.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树
 *
 * @author ZhouXu
 * @version v1.0 2018-08-16
 */
public class RebuildBinaryTree {
    // 缓存中序遍历数组每个值对应的索引
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    /**
     * @param preorder 先序遍历
     * @param inorder 中序遍历
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexForInOrders.put(inorder[i], i);
        }
        return reConstructBinaryTree(preorder, 0, preorder.length - 1, 0);
    }

    /**
     * @param preorder 先序遍历
     * @param preStart 先序遍历开始位置
     * @param preEnd   先序遍历结束位置
     * @param inStart  中序遍历开始位置
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] preorder, int preStart, int preEnd, int inStart) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inorderIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inorderIndex - inStart;
        root.left  = reConstructBinaryTree(preorder, preStart + 1, preStart + leftTreeSize, inStart);
        root.right = reConstructBinaryTree(preorder, preStart + leftTreeSize + 1, preEnd, inStart + leftTreeSize + 1);

        return root;
    }

    // 二叉树打印：中序遍历
    private static void printTree (TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] preorder = MainClass.stringToIntegerArray(line);
            line = in.readLine();
            int[] inorder = MainClass.stringToIntegerArray(line);

            TreeNode ret = new RebuildBinaryTree().reConstructBinaryTree(preorder, inorder);
            printTree(ret);
        }
    }
}
