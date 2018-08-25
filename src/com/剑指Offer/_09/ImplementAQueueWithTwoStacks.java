package com.剑指Offer._09;

import com._test_.MainClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 两个栈实现队列
 *
 * @author ZhouXu
 * @version v1.0 2018-08-24
 */
public class ImplementAQueueWithTwoStacks {
    private Stack<Integer> inStack  = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public void push(int node) {
        inStack.push(node);
    }

    public int pop() throws Exception {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        if (outStack.isEmpty()) {
            throw new Exception("Queue is empty.");
        }
        return outStack.pop();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ImplementAQueueWithTwoStacks temp = new ImplementAQueueWithTwoStacks();
            int[] arrIn = MainClass.stringToIntegerArray(line);
            for (int i = 0; i < arrIn.length; i++) {
                temp.push(arrIn[i]);
            }

            for (int i = 0; i < arrIn.length; i++) {
                System.out.print(temp.pop() + " ");
            }
        }
    }
}
