package postbuilding42;
import java.util.*;
public class DPMinCOinsNeededToReachTarget {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int target = 35;
        int dim[] = {1,15,20};
        
        Integer opt[] = new Integer[target+1];
        opt[0] = 0;
        int coinsNeeded = 0;
        int minCoinsNeeded = 100;
        for(int i=1;i<=target;i++) {
            for(int j=0;j<dim.length;j++) {
                try {
                    coinsNeeded = opt[i-dim[j]] +1;
                    if (coinsNeeded < minCoinsNeeded) {
                        minCoinsNeeded = coinsNeeded; 
                    }
                } catch(Exception e) {
                    coinsNeeded = 101;
                }
            }
            if (minCoinsNeeded == 100) {
                opt[i] = -99; // change cannot be made;
            } else {
                opt[i] = minCoinsNeeded;
            }
            minCoinsNeeded = 100;
            coinsNeeded = 0;
        }
        
        System.out.println(Arrays.toString(opt));
    }

}
