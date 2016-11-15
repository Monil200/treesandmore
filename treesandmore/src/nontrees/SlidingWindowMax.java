package nontrees;

import java.util.Arrays;

public class SlidingWindowMax {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1,3,-1,-3,5,3,6,7};
        int k = 3; // window size
        
        for(int i=0;i<=a.length-k;i++) {
            System.out.println("Max for window from " + i + " to " + (i+k -1) + "is:" + getMaxinWindow(a, i , i+k-1, k));
        }
        
    }
    
    public static int getMaxinWindow(int a[], int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int temp[] = new int[k];
        int index = 0;
        for(int i=start;i<start+k;i++) {
            temp[index] = a[i];
            index++;
        }
        
//        System.out.println(Arrays.toString(temp));
        
        // heapify temp array;
        int swapCount = 0;
        int parent = 0, leftChild, rightChild;
        int parentLimit = (end -start)%2 == 1 ?  (end -start)/2 +1 : (end -start)/2;
        boolean isRightGreater = false;
        do{
            swapCount = 0;
            parent = 0;
            while(parent < parentLimit) {
                leftChild = 2*parent + 1;
                rightChild = 2*parent + 2;
                System.out.println("leftIndex" + leftChild + " rightIndex" + rightChild);
                if (temp[parent] < temp[leftChild] || temp[parent] < temp[rightChild]) {
                    isRightGreater = temp[rightChild] > temp[leftChild];
                    if (isRightGreater) {
                        int swap = temp[rightChild];
                        temp[rightChild] = temp[parent];
                        temp[parent] = swap;
                    } else {
                        int swap = temp[leftChild];
                        temp[leftChild] = temp[parent];
                        temp[parent] = swap;
                    }
                    swapCount++;
                }
                parent++;
            }
        } while(swapCount > 0);
        return temp[0];
    }

}
