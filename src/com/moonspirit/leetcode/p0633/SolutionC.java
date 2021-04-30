package com.moonspirit.leetcode.p0633;

/**
 * 费马平方和定理：任何形为 4n+1 的素数都能表示为两个平方数之和。
 */

费马平方和 : 奇质数能表示为两个平方数之和的充分必要条件是该质数被 4 除余 1 。

        翻译过来就是：当且仅当一个自然数的质因数分解中，满足 4k+3 形式的质数次方数均为偶数时，该自然数才能被表示为两个平方数之和。

        因此我们对 c 进行质因数分解，再判断满足 4k+3 形式的质因子的次方数是否均为偶数即可。

        作者：AC_OIer
        链接：https://leetcode-cn.com/problems/sum-of-square-numbers/solution/gong-shui-san-xie-yi-ti-san-jie-mei-ju-s-7qi5/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public boolean judgeSquareSum(int c) {
        for (int base = 2; base * base <= c; base++) {
            // 如果不是因子，枚举下一个
            if (c % base != 0) {
                continue;
            }

            // 计算 base 的幂
            int exp = 0;
            while (c % base == 0) {
                c /= base;
                exp++;
            }

            // 根据 Sum of two squares theorem 验证
            if (base % 4 == 3 && exp % 2 != 0) {
                return false;
            }
        }

        // 例如 11 这样的用例，由于上面的 for 循环里 base * base <= c ，base == 11 的时候不会进入循环体
        // 因此在退出循环以后需要再做一次判断
        return c % 4 != 3;
    }
}

作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/sum-of-square-numbers/solution/ping-fang-shu-zhi-he-by-leetcode-solutio-8ydl/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
