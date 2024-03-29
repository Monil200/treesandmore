package dp;

import java.util.Arrays;

public class CoinVariations {
    
    public static int dimensions[] = {1,3,5};
//    public static int dimensions[] = {5,10,25};
    public void minimumCoindNeeded(int sum) {
        int numCoins[] = new int[sum+1]; // numCoins[i] = Minimum number of coins to make sum i
        numCoins[0] = 0; // we need zero coins to make sum 0
        int minSoFar = 1000; // random max number
        int temp = -1;
        boolean isDimOneIncluded = true;
        for(int i=1;i<=sum;i++) {
            for(int j=0;j<dimensions.length;j++) {
                try {
                    temp = numCoins[i - dimensions[j]];
                    if (minSoFar > temp) {
                        minSoFar = temp;
                    }
                } catch (Exception e) {
                }
            }
            if (isDimOneIncluded) {
                numCoins[i] = Math.min(numCoins[i-1] + 1, minSoFar + 1);
            } else {
                if (minSoFar != 1000) {
                    numCoins[i] = minSoFar + 1;
                }
            }
            System.out.println(Arrays.toString(numCoins));
//            System.out.println("Choose min from 1. " + (numCoins[i-1] + 1) + "  2. " + (minSoFar +1 ));
//            System.out.println("Minimum coins needed to sum:" + i + " is:" + numCoins[i]);
            minSoFar = 1000;
        }
        System.out.println("Minimum coins needed to sum:" + sum + " is:" + numCoins[sum]);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CoinVariations obj = new CoinVariations();
        obj.minimumCoindNeeded(35);
    }

}
