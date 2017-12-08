package treessandtrees;

import java.util.Arrays;

public class BubleQuick {
    
    public static void bubbleSort(int a[]) {
        
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a.length-1-i && j>=0;j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
    
    public static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int x = partition(a,start,end);
            System.out.println("------------------X--------------------" + x);
            System.out.println(Arrays.toString(a));
            quickSort(a,start,x);
            quickSort(a,x+1,end);
        }
    }
    public static void quickSortOnlyK(int[] a, int start, int end, int k, int kth) {
        ++k;
        System.out.println("k?" + k);
        if (start < end && k<kth) {
            int x = partition(a,start,end);
            System.out.println(Arrays.toString(a));
            quickSortOnlyK(a,start,x, k, kth);
            quickSortOnlyK(a,x+1,end, k, kth);
        }
    }
    
    public static int partition(int a[], int start, int end) {
       int pivot = a[start];
       int i = start;
       int j = end;
       while(true) {
           while(a[start] < pivot && start < j) {
               start++;
           }
           while(a[end] > pivot && end > i) {
               end--;
           }
           if (start < end) {
               System.out.print("Swapping: " + a[start] + " and " + a[end]);
               int temp = a[start];
               a[start] = a[end];
               a[end] = temp;
               System.out.println("to get -> " + Arrays.toString(a));
           } else {
               return start;
           }
       }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {311 ,200 ,199, 99, 89, 12, 11};
//        bubbleSort(a);
        quickSort(a, 0 , a.length-1);
        System.out.println(Arrays.toString(a));
//        quickSortOnlyK(a, 0 , a.length-1, 0, 3);
//        System.out.println(Arrays.toString(a));
    }

}
