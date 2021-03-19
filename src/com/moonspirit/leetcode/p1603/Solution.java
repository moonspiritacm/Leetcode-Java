package com.moonspirit.leetcode.p1603;

/**
 * 编程练习。O(1) O(1)
 */
class ParkingSystem {
    private int[] spaces = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        spaces[0] = big;
        spaces[1] = medium;
        spaces[2] = small;
    }

    public boolean addCar(int carType) {
        if (spaces[carType - 1] == 0) {
            return false;
        } else {
            spaces[carType - 1]--;
            return true;
        }
    }
}
