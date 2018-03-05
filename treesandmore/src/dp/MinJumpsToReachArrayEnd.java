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
    }

}
