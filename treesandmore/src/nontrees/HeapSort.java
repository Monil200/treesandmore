package nontrees;

import java.util.*;

public class HeapSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[]={2,7,1,45,23,90,12,42,21};
        int temp;
        for(int i=a.length;i>=0;i--) {
            System.out.println("Before: " + Arrays.toString(a));
            maxHeapify(a, i, 0); // basically descending order;
            System.out.println("After:" + Arrays.toString(a) + "\n");
            try {
                temp = a[0];
                a[0] = a[i-1];
                a[i-1] = temp;
            } catch (Exception e) {}
        }
    }
    
    public static void maxHeapify(int a[], int end, int start) {
        int swapCount = 0;
        int leftChild;
        int rightChild;
        int parent;
        int parentLocation = start;
        int temp;
        boolean isLeftGreater = false;
        end = (end%2 == 1) ? end/2 : end/2-1;  
        do {
            swapCount = 0;
            while(parentLocation < end ) {
                parent = a[parentLocation];
                leftChild = a[2*parentLocation + 1];
                rightChild = a[2*parentLocation + 2];
                if (leftChild > rightChild) {
                    isLeftGreater = true;
                }
                if (parent < leftChild || parent < rightChild) {
                    swapCount++;
                    temp = parent;
                    if (isLeftGreater) {
                        a[parentLocation] = leftChild;
                        a[2*parentLocation + 1] = temp;
                    } else {
                        a[parentLocation] = rightChild;
                        a[2*parentLocation + 2] = temp;
                    }
                }
                isLeftGreater = false;
                parentLocation +=1;
            }
            parentLocation = start;
            isLeftGreater = false;
        } while(swapCount > 0);
    }

}
