package treesandmore;

import java.util.ArrayList;

/*
 * Find zeroes to be flipped so that number of consecutive 1’s is maximized
Given a binary array and an integer m, find the position of zeroes flipping which creates maximum number of consecutive 1s in array.

Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
         m = 2
Output:  5 7
We are allowed to flip maximum 2 zeroes. If we flip
arr[5] and arr[7], we get 8 consecutive 1's which is
maximum possible under given constraints 

 */
public class MaxZerosFilpped {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        /*
         * zero locations  1, 2,5,7
         * 1count to left  1, 0,2,1
         * 1count to right 0,2,1,3 
         * 
         */
        int m = 2;
        ArrayList<Integer> windowLengthM=new ArrayList<Integer>();
        int lIndex=0,rIndex=0;
        int zerosSeen=0;
        int removedIndex;
        int previousZeroLocation=0;
        ArrayList<Integer> zeros=new ArrayList<Integer>();
        int currentLength = 0, maxLength =0;
        for(int i=0;i<a.length;i++) {
            if (a[i] == 1) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            } else {
                zeros.add(i+1-previousZeroLocation);
                previousZeroLocation = i+1;
                if (zeros.size() > m) {
                    removedIndex = zeros.remove(0);
                    System.out.println(currentLength + "before");
                    currentLength -= (removedIndex);
                    System.out.println(currentLength + "after");
                }
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }
            System.out.println("Current length is : " + currentLength + "for iteration:  "+i+" size of zeros:" + zeros.size());
        }
        System.out.println("Max length is : " + maxLength);

    }

}
