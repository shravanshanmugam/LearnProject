package com.shravan.learn.algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinkedHashMap extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCacheLinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public int get(int key) {
        return getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        put(key, value);
    }
}
