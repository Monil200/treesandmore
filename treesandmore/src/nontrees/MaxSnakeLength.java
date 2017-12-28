package nontrees;

import java.util.Arrays;

/*
 * Given a grid of numbers, find maximum length Snake sequence and print it. If multiple snake sequences exists with the maximum length, print any one of them.

A snake sequence is made up of adjacent numbers in the grid such that for each number, the number on the right or the number below it is +1 or -1 its value. For example, if you are at location (x, y) in the grid, you can either move right i.e. (x, y+1) if that number is ± 1 or move down i.e. (x+1, y) if that number is ± 1.

For example,

9, 6, 5, 2
8, 7, 6, 5
7, 3, 1, 6
1, 1, 1, 7

In above grid, the longest snake sequence is: (9, 8, 7, 6, 5, 6, 7)
 */
public class MaxSnakeLength {
    /**
     * 
     * 
     * basically check if diff of a[i][j] with neighbors (top & left), if diff is 1 then take the max(top, left) memorized values + 1 
     * or else if solution[i][j] not initialized then mark it as length 1.
     * Technically - extend current either from top or left, whichever is max, or start new length
     */
    public static void findLargestLengthSnake(int a[][], int mem[][]) { // memorized lengths
        int lengthFromLeft= 0, lengthFromTop = 0;
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                if(i-1 >= 0) { // left
                    if(Math.abs(a[i][j] - a[i-1][j]) == 1) {
                        lengthFromLeft = Math.max(mem[i-1][j] + 1, 1);
                    }
                }
                if(j-1 >= 0) { // left
                    if(Math.abs(a[i][j] - a[i][j-1]) == 1) {
                        lengthFromTop = Math.max(mem[i][j-1] + 1, 1);
                    }
                }
                mem[i][j] = Math.max(lengthFromLeft, lengthFromTop);
                lengthFromTop = lengthFromLeft = 0;
            }
        }
        System.out.println("---------NEW-----------");
        for(int i=0;i<mem.length;i++) {
            System.out.println(Arrays.toString(mem[i]));
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[][] = {
            {9, 6, 5, 2},
            {8, 7, 6, 5},
            {7, 3, 1, 6},
            {1, 1, 1, 7},
         };
        int maxSnakeLength[][] = new int[a.length][a[0].length];
        findLargestLengthSnake(a, maxSnakeLength);
    }
}
