package com._test_;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZhouXu
 * @version v1.0 2018-08-07
 */
public class MainClass {
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
        Queue<TreeNode> nodeQueue = new LinkedList<>();
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
