package com.leetcode.category.algorithms.medium._002;

import com.leetcode.category.common.node.ListNode;
import com.leetcode.category.common.util.ToolUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ZhouXu
 * @version v1.0 2018-08-11
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        int sum = 0;
        while (L1 != null || L2 != null) {
            sum /= 10;
            if (L1 != null) {
                sum += L1.val;
                L1 = L1.next;
            }
            if (L2 != null) {
                sum += L2.val;
                L2 = L2.next;
            }
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        if (sum / 10 != 0) {
            temp.next = new ListNode(1);
        }
        return node.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode L1 = ToolUtil.stringToListNode(line);
            line = in.readLine();
            ListNode L2 = ToolUtil.stringToListNode(line);
            ListNode ret = new AddTwoNumbers().addTwoNumbers(L1, L2);

            String out = ToolUtil.listNodeToString(ret);
            System.out.println(out);
        }
    }
}
