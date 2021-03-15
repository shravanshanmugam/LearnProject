package com.shravan.learn.problems.medium.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

// Insert, Remove and Get random in O(1)
public class RandomizedSet {

    /**
     * Initialize your data structure here.
     */
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private int count;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        count = 0;
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, count++);
            list.add(val);
            return true;
        }
        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            // remove from list is O(n)
            // so we swap element with last element, then delete last element which is O(1)
            int last = list.get(count - 1);
            list.set(index, last);
            map.put(last, index);

            map.remove(val);
            list.remove(count - 1);
            count--;
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random(list.size()));
    }

    private int random(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }
}

