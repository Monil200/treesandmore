package post16;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int a[] = {22 ,55,11, 3 ,10 ,89 , 561};
        int a[] = {45 ,2 ,66, 71, 1 ,89, 10, 111};
        quickSort(a, 0 ,a.length-1);
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(a));
        
    }
    
    public static void quickSort(int a[], int low, int high) {
        if (low< high) {
            int p = partition(a, low, high);
            quickSort(a, low, p-1);
            quickSort(a, p+1, high);
        }
    }
    
    public static int partition(int a[], int l, int r) {
        int p = a[l]; //pivot
        int lower = l-1;
        int high = r+1;
        int temp;
        while(true) {
            lower++;
            while(lower<r && a[lower] < p) {
                lower++;
            }
            high--;
            while(high > l && a[high] > p) {
                high--;
            }
            if (high > lower) {
                temp = a[lower];
                a[lower] = a[high];
                a[high] = temp;
            } else {
                return high;
            }
        }
    }

}
