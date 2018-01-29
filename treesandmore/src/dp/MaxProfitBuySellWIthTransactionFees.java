package dp;

import java.util.Arrays;

/*
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.
 */
public class MaxProfitBuySellWIthTransactionFees {
    
    public void getMaxProfit(int prices[], int fees) {
        int opt[][] = new int [(prices.length/2)+1][prices.length];
        for(int i=0;i<opt.length;i++) { // row initialize
            opt[i][0] = 0;
        }
        for(int i=0;i<opt[0].length;i++) { // col initialize
            opt[0][1] = 0;
        }
        int currMax = 0, max = 0;
        
        for(int i=1;i<opt.length;i++) {
            for(int j=1;j<opt[i].length;j++) {
                for(int k=0;k<j;k++) {
                    currMax = prices[j] - prices[k] - fees + opt[i-1][k]; // opt[i-1][k] previous calculation of best
                    if (currMax > max) {
                        max = currMax;
                    }
                    currMax = 0;
                }
                opt[i][j] = Math.max(opt[i][j-1], Math.max(0, max));
                max = 0;
            }
        }
        
        for(int i=0;i<opt.length;i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MaxProfitBuySellWIthTransactionFees obj = new MaxProfitBuySellWIthTransactionFees();
        int prices[] = {1, 3, 2, 8, 4, 9};
        int fees = 4;
        obj.getMaxProfit(prices, fees);
    }

}
