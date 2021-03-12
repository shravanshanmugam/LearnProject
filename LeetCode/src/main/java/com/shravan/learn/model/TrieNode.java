package com.shravan.learn.model;

public class TrieNode {
    // change this value to adapt to different cases
    private static final int N = 26;
    public TrieNode[] children = new TrieNode[N];

    // you might need some extra values according to different cases
    public boolean exists;
}
