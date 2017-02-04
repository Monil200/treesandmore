package nontrees;
/*
How many unique N-digit phone numbers can be dialed by a chess knight starting on the ‘1’ button of a standard 1-9+0 key pad?

1 2 3
4 5 6
7 8 9
  0
  
 * 1 1       => 1
 * 2 2       => 16 18
 * 3 5       => 161 167 160 181 183
 * 4 10
 * 5 26
...
*/
import java.util.*;

public class KnightPathsNumber {
    int paths;
    public void get(int n, int currentLimit, int maxLimit) {
        Map<Integer, List<Integer>> r = getTransitions();
        List<Integer> a = r.get(n);
        
        if (currentLimit == maxLimit-1) {
            paths++;
            return;
        }
        
//        currentLimit++;
        System.out.println("n:" + n + " currentLimit:" + currentLimit);
        
        for(Integer i: a) {
            get(i, currentLimit+1, maxLimit);
            // currentLimit--;
        }
        
        /*
        1 - 6 - 1
                7 - 2
                2 - 
        */
        
    }
    
    private static Map<Integer, List<Integer>> getTransitions() {
        Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();

        result.put(1, Arrays.asList(6, 8));
        result.put(2, Arrays.asList(7, 9));
        result.put(3, Arrays.asList(4, 8));
        result.put(4, Arrays.asList(3, 9, 0));
        result.put(6, Arrays.asList(1, 7, 0));
        result.put(7, Arrays.asList(2, 6));
        result.put(8, Arrays.asList(1, 3));
        result.put(9, Arrays.asList(2, 4));
        result.put(0, Arrays.asList(4, 6));

        return result;
    }


    public static void main(String[] args) {
        KnightPathsNumber soln = new KnightPathsNumber();
        
        // boolean visited[] = new boolean[10]; // false
        soln.get(1, 0, 3);
        System.out.println("The number of unique paths in horse behaviour is " + soln.paths);
    }

}







