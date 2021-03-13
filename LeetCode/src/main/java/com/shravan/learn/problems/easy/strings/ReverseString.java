package com.shravan.learn.problems.easy.strings;

import com.shravan.learn.common.StringUtil;

public class ReverseString {
    public void reverseString(char[] s) {
        StringUtil.reverse(s, 0, s.length - 1);
    }
}
