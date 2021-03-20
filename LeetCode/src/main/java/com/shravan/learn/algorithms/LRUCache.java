package com.shravan.learn.algorithms;

import java.util.HashMap;
import java.util.Map;

class Node {
    int value;
    int key;
    Node pre;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    private int count, capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        count = 0;
        this.capacity = capacity;
        // empty head and tail nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);
        // link head and tail nodes
        // all other nodes go inbetween head and tail nodes
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
    }

    // most recently accessed element goes to head of node
    private void addToHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                // remove element from tail end of list
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
}
