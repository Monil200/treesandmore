package aaplQuYelBay;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {45 ,2 ,66, 71, 1 ,89, 10, 111};
        
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
    
    public static void quickSort(int a[], int start, int end) {
        if (start < end) {
            int x = partition(a, start, end);
            System.out.println(Arrays.toString(a));
            quickSort(a, start, x-1);
            quickSort(a, x+1, end);
        }
    }
    
    public static int partition(int a[], int start, int end) {
        int pivot = a[start];
        int p = start-1;
        int q = end+1;
        
        while(true) {
            p++;
            while(p < q && a[p] < pivot) {
                p++;
            }
            q--;
            while(q > p && a[q] > pivot) {
                q--;
            }
            if (q > p) {
                int temp = a[p];
                a[p] = a[q];
                a[q] = temp;
            } else {
                return q;
            }
        }
    }

}
