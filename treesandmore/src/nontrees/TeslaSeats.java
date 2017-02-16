package nontrees;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;
class TeslaSeats {
    public int solution(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8
        if (A.length == 0 || B.length == 0 || M == 0 || X == 0 || Y == 0) {
            return 0;
        }
        
        int i=0;
        int stops = 0;
        int currWeightRem = Y, currCountRem =X;
        HashSet<Integer> floors = new HashSet<Integer>();
        while(i<A.length) {
            System.out.println("i outer:" + i);
            while (i < A.length && currWeightRem >= A[i] && currCountRem > 0) {
                System.out.println("i inner:" + i);
                floors.add(B[i]);
                currWeightRem-=A[i];
                currCountRem-=1;
                i++;
            }
            currCountRem = X;
            currWeightRem = Y;
            stops += floors.size();
            System.out.println("stops" + stops);
            floors.clear();
            stops += 1; // to reach ground
        }
        return stops;
    }
    
    public static void main(String args[]) {
        TeslaSeats obj = new TeslaSeats();
        int A[] = {40,40,100,80,20};
        int B[] = {3,3,2,2,3};
        System.out.println(obj.solution(A,B,3,5,200));
    }
}