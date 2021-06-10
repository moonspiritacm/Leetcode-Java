package com.moonspirit;

public class MaxHeap {
    private int[] heap;
    private int size;

    private void swap(int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    private void siftUp(int k) {
        while (k > 1 && heap[k] > heap[k / 2]) {
            swap(k / 2, k);
            k /= 2;
        }
    }

    private void siftDown(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && heap[j] < heap[j + 1]) {
                j++;
            }
            if (heap[k] >= heap[j]) {
                break;
            } else {
                swap(j, k);
                k = j;
            }
        }
    }
}