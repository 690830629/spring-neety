package com.wanglei;

public class BinSearch {
    public int binSearch(int a[], int target) {
        int low = 0;
        int high = a.length;
        while (low < high) {
            int middle = (low + high) / 2;
            if (target < a[middle]) {
                middle = low;
            } else if (target > a[middle]) {
                middle = high;
            }
            return middle;
        }
        return 0;
    }
}
