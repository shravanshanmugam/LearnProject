package com.shravan.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Vary the behavior of class at runtime
 * Use composition rather than inheritance
 */
public class StrategyPattern {

    public static void main(String[] args) {
        Collections.sort(new ArrayList<String>(), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }
}
