package com.shravan.learn.problems.easy.design;

public class MinStack {
    private Node head;

    public MinStack() {
    }

    public void push(int x) {
        // new head is the new node for item pushed into stack
        // current head is the next node
        head = new Node(x, Integer.min(x, head == null ? x : head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    // store min value in each node
    private static class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
