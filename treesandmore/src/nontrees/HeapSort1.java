package nontrees;

import java.util.Arrays;

public class HeapSort1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {9, 26 , 72, 1 ,11 , 100 , 74};
        
        for(int i=0;i<a.length-1;i++) {
            heapSort(a, i, a.length);
            System.out.println(Arrays.toString(a));
        }
        System.out.println(Arrays.toString(a));
    }
    
    public static void heapSort(int a[], int start, int end) {
        if (start > end)
            return;
        int parent = start;
        int left, right;
        int parentLimit = (end - start) /2 -1 ;
        int swapCount = 0;
        boolean isFirst = true, isLeftSmaller = false, isRightSmaller = false;
        while(swapCount > 0 || isFirst) {
            swapCount = 0;
            isFirst = false;
            parent = start;
            while(parent<=parentLimit) {
                left = parent*2 + 1;
                right = parent*2 + 2;
                System.out.println("parent:" + parent + "left:" + left + "right:" + right + "parentLimit:" + parentLimit);
                if (a[parent] >= a[left]) {
                    isLeftSmaller = true;
                    swapCount++;
                } else if (a[parent] > a[right]) {
                    isRightSmaller = true;
                    swapCount++;
                }
                if (isLeftSmaller) {
                    int temp = a[parent];
                    a[parent] = a[left];
                    a[left] = temp;
                } else if (isRightSmaller) {
                    int temp = a[parent];
                    a[parent] = a[right];
                    a[right] = temp;
                }
                isLeftSmaller = isRightSmaller = false;
                parent+= 1;
            }
        }
    }

}
