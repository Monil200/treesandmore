package treesandmore;
/*
 * Merge Overlapping Intervals
Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals. Let the intervals be represented as pairs of integers for simplicity. 
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}. Similarly {5, 7} and {6, 8} should be merged and become {5, 8}
 */
import java.util.*;
public class TimingMerge {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double[][] interval = {{2,3}, {1,2}, {6,8}, {5,7}};
        Comparator<double[]> intervalSort = new Comparator<double[]>() {
            public int compare(double[] a, double[] b){
                return Double.compare(a[0], b[0]);
            }
        };
        
        Arrays.sort(interval, intervalSort);
        int low = (int) interval[0][0], high = (int) interval[0][1];
        for(int i=0;i<interval.length; i++) {
            for(int j=0;j<interval[0].length; j++) {
                System.out.print(interval[i][j] + ",");
            }
            System.out.println();
        }
        
        for(int i=1;i<interval.length; i++) {
            if (interval[i][0] <= high && interval[i][1] > high) {
                high = (int) interval[i][1];
            }
            if (interval[i][0] > high) { // then print current high low
                System.out.println(low + " , " + high);
                low = (int) interval[i][0];
                high = (int) interval[i][1];
            }
        }
        System.out.println(low + " , " + high);
        
        // Russian Doll Envelopes
        /*
         * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

           What is the maximum number of envelopes can you Russian doll? (put one inside other)
         */
        System.out.println("Russian Doll Envelopes");
        double a[][] = {{5,4},{6,4},{6,7},{2,3}};
        Arrays.sort(a, intervalSort);
        low=(int) a[0][0];
        high=(int) a[0][1];
        System.out.print("[" + low + "," + high + "], ");
        for (int i=1;i<a.length;i++) {
            if (a[i][0] > low && a[i][1] > high) {
                low = (int) a[i][0];
                high = (int) a[i][1];
                System.out.print("[" + low + "," + high + "], ");
            }
        }
    }

}
