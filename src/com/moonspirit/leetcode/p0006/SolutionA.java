package com.moonspirit.leetcode.p0006;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟打印。O(n) O(n)
 */
class SolutionA {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows < 2 || s.length() <= numRows) {
            return s;
        }

        int row = 0;
        boolean flag = false;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        for (char ch : s.toCharArray()) {
            list.get(row).append(ch);
            if (row == 0 || row == numRows - 1) {
                flag = !flag;
            }
            row += flag ? 1 : -1;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder tmp : list) {
            sb.append(tmp);
        }
        return sb.toString();
    }
}
