package com.shravan.learn.problems.easy.sortandsearch;

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


}

class VersionControl {
    private final static int BAD_VERSION = 4;

    boolean isBadVersion(int version) {
        return version == BAD_VERSION;
    }
}