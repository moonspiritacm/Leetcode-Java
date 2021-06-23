package com.moonspirit.nowcode.p018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionA {
    private List<String> res;
    private StringBuilder sb;

    private void backtrace(char[] chs, boolean[] flags, int num) {
        if (num == chs.length) {
            res.add(new String(sb));
            return;
        }

        for (int i = 0; i < chs.length; i++) {
            if (!flags[i] && (i == 0 || flags[i - 1] || chs[i] != chs[i - 1])) {
                flags[i] = true;
                sb.append(chs[i]);
                backtrace(chs, flags, num + 1);
                sb.deleteCharAt(sb.length() - 1);
                flags[i] = false;
            }
        }
    }

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }

        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        res = new ArrayList<>();
        sb = new StringBuilder();
        backtrace(chs, new boolean[s.length()], 0);

        String[] arr = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}