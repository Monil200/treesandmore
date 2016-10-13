package dp;

import java.util.Arrays;

public class MaxProfitByTradingMaxKtimes {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int price[] = {10, 22, 5, 75, 65, 80};
        int k =2;
        
        int opt[][] = new int[k+1][price.length];
        for(int i=0;i<price.length;i++) {
            opt[0][i] = 0; // no profit can be done by selling 0 times.
        }
        for(int i=0;i<=k;i++) {
            opt[i][0] = 0; // no profit can be done with just 1 trade. 10-10 = 0 profit
        }
        int noTrade;
        for(int i=1;i<=k;i++) {
            for(int j=1;j<price.length;j++) {
                noTrade =  opt[i][j-1];
                for(int l=0;l<j;l++) {
                    int previousDayMax = -100;
                    int profit = price[j] - price[l];
                    try {
                        previousDayMax = opt[i-1][l];
                    } catch (Exception e) {
                        previousDayMax = -100;
                    }
                    opt[i][j] = Math.max(noTrade, previousDayMax + profit);
                }
            }
        }
        
        for(int i=0;i<opt.length;i++) {
            for(int j = 0;j<opt[0].length;j++) {
                System.out.print(opt[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println("Max profit by making k:" + k + "trades is "+ opt[k][price.length-1]);
    }

}
