package treessandtrees;
/*
 * Maximum number of chocolates to be distributed equally among k students
4
Given n boxes containing some chocolates arranged in a row. There are k number of students. The problem is to distribute maximum number of chocolates equally among k students by selecting a consecutive sequence of boxes from the given lot. Consider the boxes are arranged in a row with numbers from 1 to n from left to right. We have to select a group of boxes which are in consecutive order that could provide maximum number of chocolates equally to all the k students. An array arr[] is given representing the row arrangement of the boxes and arr[i] represents number of chocolates in that box at position ‘i’.

Examples:

Input : arr[] = {2, 7, 6, 1, 4, 5}, k = 3
Output : 6
The subarray is {7, 6, 1, 4} with sum 18.
Equal distribution of 18 chocolates among
3 students is 6.
Note that the selected boxes are in consecutive order
with indexes {1, 2, 3, 4}.

// Also variation of many other problems
 * Technically - subarray with max sum which is multiple of target
 */
import java.util.*;
public class CandyDistribution {
    
    public void getMaxCandies(int candies[], int kids) { // candies is array of bags - each bag has n candies
        int currAverage = 0;
        int maxAverage = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // <mod, runningSum>
        int runningSum =0;
        for(int i=0;i<candies.length;i++) {
           runningSum += candies[i];
           int mod = runningSum%kids;
           System.out.print("runningSum:" + runningSum + " mod:" + mod);
           if (mod == 0) {
               currAverage = runningSum/ kids;
               if (currAverage > maxAverage) {
                   maxAverage = currAverage;
               }
           } else {
               if (map.containsKey(mod)) {
                   currAverage = (runningSum - map.get(mod))/ kids;
                   if (currAverage > maxAverage) {
                       maxAverage = currAverage;
                   }
               } else {
                   map.put(mod, runningSum);
               }
           }
           System.out.println(" maxAvg:" + maxAverage + " map" + map);
        }
        System.out.println("Max avg is:" + maxAverage);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {2, 7, 6, 1, 4, 5};
        int kids = 3;
        CandyDistribution obj = new CandyDistribution();
        obj.getMaxCandies(a, kids);
    }

}
