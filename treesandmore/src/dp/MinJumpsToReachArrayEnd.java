package dp;

import java.util.Arrays;

public class MinJumpsToReachArrayEnd {
    
    public static void getMinJumps(int a[]) {
        int opt[] = new int[a.length];
        opt[0] = 0;
        int jumpCount;
        for(int i=0;i<a.length;i++) {
            int jumpIndex = i+1;
            jumpCount = opt[i] +1;
            //int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
            while(jumpIndex < (a[i] + i +1) && jumpIndex < a.length) {
                if (opt[jumpIndex] == 0) {
                    opt[jumpIndex] = jumpCount;
                }
                jumpIndex++;
                System.out.println("\t" + Arrays.toString(opt) + " val:" + a[i] + " jimpIndex" + jumpIndex);
            }
            System.out.println(Arrays.toString(opt) + " val:" + a[i]);
            //jumpCount++;
        }
        System.out.println(Arrays.toString(opt));
    }
    
    
    public static void minStepsToReachArrayEnd(int a[]) {
        
        int opt[] = new int[a.length];
        opt[0] = 0;
        for(int i=1;i<a.length;i++) {
            opt[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0;i<a.length;i++) {
            int currJumpTo = 0;
            int stepsCount = 0; 
            
            currJumpTo = i+a[i];
            if (opt[i] == Integer.MAX_VALUE) {
                stepsCount = i + 1;
            } else {
                stepsCount = opt[i] + 1;
            }
            
            if (currJumpTo <= a.length -1) {
                opt[currJumpTo] = Math.min(stepsCount, opt[currJumpTo]);
            } else if (currJumpTo > a.length-1) {
                opt[a.length-1] = Math.min(stepsCount, opt[a.length-1]);
            }
        }
        
        System.out.println(Arrays.toString(opt));
        
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int jumps[] = new int[a.length];
        
        jumps[0] = 0; // we need 0 jumps to be in 1st location;
        int jumpsIndex = 1;
        int jumpsMade;
        for(int i=0;i<a.length;i++) {
            int toDo = a[i];
            int done = 0;
            jumpsIndex = i+1;
            jumpsMade = jumps[i] + 1;
            while(jumpsIndex < a.length) {
                while(done < toDo && jumps[jumpsIndex] == 0) {
                    jumps[jumpsIndex] = jumpsMade;
                    done++;
                }
                jumpsIndex++;
            }
        }
        System.out.println(Arrays.toString(jumps));
        System.out.println("New logic");
        getMinJumps(a);
        
        System.out.println("New logic-------V3--its perfect, rest others are O(n^2)");
        minStepsToReachArrayEnd(a);
    }

}
