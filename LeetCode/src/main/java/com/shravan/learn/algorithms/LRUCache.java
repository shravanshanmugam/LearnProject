package com.shravan.learn.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {

    private Map<Integer, DoublyLinkedList> map;
    private DoublyLinkedList head;
    private DoublyLinkedList tail;
    private int size;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = capacity;
    }

    public int get(int key) {
        DoublyLinkedList vNode = map.get(key);
        if (vNode != null) {
            if (vNode == head) {
                updateHead();
            } else if (vNode != tail) {
                removeNode(vNode);
                addToTail(vNode);
            }
            return vNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DoublyLinkedList vNode = map.get(key);
        if (vNode != null) {
            vNode.value = value;
            if (vNode == head) {
                updateHead();
            } else if (vNode != tail) {
                removeNode(vNode);
                addToTail(vNode);
            }
        } else {
            if (map.size() == 0) {
                DoublyLinkedList newVNode = new DoublyLinkedList(key, value);
                head = newVNode;
                tail = newVNode;
                map.put(key, newVNode);
            } else if (map.size() < size) {
                DoublyLinkedList newVNode = new DoublyLinkedList(key, value);
                addToTail(newVNode);
                map.put(key, newVNode);
            } else {
                DoublyLinkedList newVNode = new DoublyLinkedList(key, value);
                DoublyLinkedList currHead = head;
                map.remove(currHead.key);
                boolean shifted = shiftHead();
                if (shifted) {
                    addToTail(newVNode);
                } else {
                    head = newVNode;
                }
                map.put(key, newVNode);
            }
        }
    }

    private void updateHead() {
        DoublyLinkedList currHead = head;
        boolean shifted = shiftHead();
        if (shifted) {
            addToTail(currHead);
        }
    }

    private boolean shiftHead() {
        DoublyLinkedList next = head.next;
        if (next != null) {
            head = next;
            head.prev = null;
            return true;
        }
        return false;
    }

    private void removeNode(DoublyLinkedList curr) {
        DoublyLinkedList prev = curr.prev;
        DoublyLinkedList next = curr.next;
        if (prev != null)
            prev.next = next;
        if (next != null)
            next.prev = prev;
    }

    private void addToTail(DoublyLinkedList curr) {
        tail.next = curr;
        curr.prev = tail;
        tail = tail.next;
        tail.next = null;
    }

    static class DoublyLinkedList {
        int key;
        int value;
        DoublyLinkedList next;
        DoublyLinkedList prev;

        DoublyLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DoublyLinkedList that = (DoublyLinkedList) o;
            return key == that.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}
