package nontrees;

import java.util.Arrays;

public class QuickSortAndVAriations {
    static int xLargest = 3; 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {2, 11 ,12,45 ,67,3, 90,100,1,21};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
        
    }
    
    public static void quickSort(int a[], int p, int q) {
        if (p<q ) {
            int x = partition(a,p,q);
            if (x == xLargest) {
                System.out.println("xLargest number is:" + a[xLargest]);
            } else if (x > xLargest) {
                quickSort(a,p,x-1);
            } else {
                quickSort(a,x+1,q);
            }
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
