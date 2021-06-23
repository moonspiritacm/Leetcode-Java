package com.moonspirit.leetcode.p0172;

public class SolutionA {
    public static void main(String[] args) {
        long res = 1;
        for (int i = 1; i < 100; i++) {
            res *= i;
            int cnt = 0;
            while(res!=0&&res%10==0) {
                cnt++;
                res/=10;
            }
            res%=1000001;
            System.out.printf("%d %d %d\n", i, res, cnt);
        }
    }
}
