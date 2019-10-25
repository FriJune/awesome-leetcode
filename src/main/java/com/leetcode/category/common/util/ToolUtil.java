package com.leetcode.category.common.util;

import com.leetcode.category.common.node.ListNode;
import com.leetcode.category.common.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZhouXu
 * @version v1.0 2018-08-07
 */
public class ToolUtil {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);

        if (input.length() == 0) return new int[0];

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) { return "[]"; }
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result.append(number).append(", ");
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) return "[]";
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ",";
            node = node.next;
        }

        return "[" + result.substring(0, result.length() - 1) + "]";
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            // Retrieves and removes the head of this queue
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftchild = Integer.parseInt(item);
                node.left = new TreeNode(leftchild);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightchild = Integer.parseInt(item);
                node.right = new TreeNode(rightchild);
                nodeQueue.add(node.right);
            }
        }

        return root;
    }
}