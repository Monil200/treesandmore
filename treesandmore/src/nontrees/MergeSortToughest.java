package nontrees;

import java.io.*;
import java.util.Arrays;

class MergeSortToughest {

    public void mergeSort(int a[], int start, int end, int mid) {
        System.out.println("start:" + start + " mid:" + mid + " end:" + end + " array:" + Arrays.toString(a));
        if (start == end)
            return;
        if (Math.abs(end - start) == 1) {
            if (a[start] > a[end]) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            return;
        }
        while(start < end) {
            mid = (end+start)/2;
            mergeSort(a, start, mid-1, mid);
            mergeSort(a, mid, end, mid);
        }
  }
  public static void main (String[] args) {
    int a[] = {5, 7, 2, 1};
    MergeSortToughest obj = new MergeSortToughest();
    obj.mergeSort(a, 0 , a.length-1, (a.length-1)/2);
    System.out.println(Arrays.toString(a));

  }
}