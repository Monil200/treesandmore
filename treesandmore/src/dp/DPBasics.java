package dp;

import java.util.Arrays;

public class DPBasics {
    
    
    // longest increasing subsequence
    public void getLCS(int a[]) {
        int opt[] = new int[a.length];
        opt[0] = 1;
        for(int i=1;i<a.length;i++) {
            int max = 0;
            for(int j=0;j<i;j++) {
                if (a[i] > a[j]) {
                    if (opt[j] > max) {
                        max = opt[j];
                    }
                }
            } // get max formed 
            opt[i] = max + 1;
        }
        
        System.out.println(Arrays.toString(opt));
    }
    
    public void getMaxProductSubarray(int a[]) {
        int product = 1;
        int maxProduct = 1;
        
        for(int i=0;i<a.length;i++) {
            if (a[i]!= 0) {
                product *= a[i];
                if (product > maxProduct) {
                    maxProduct = product;
                }
            } else {
                product = 1;
            }
        }
        
        System.out.println("Max product is:" + maxProduct);
    }
    
    
    public void getMaxPriceRodCutting(int a[]) { // a is prices at each cut
        int opt[] = new int[a.length];
        opt[0] = a[0];
        for(int i=1;i<a.length;i++) {
            int currMax = 0;
            //int cutCost[] = {1, 5, 8, 9, 10, 17, 17, 20};
            for(int j=0;j<i;j++) {
                int cutCost = opt[j] + opt[i-j-1];
                if (cutCost > currMax) {
                    currMax = cutCost;
                }
            }
            opt[i]= Math.max(currMax, a[i]);
        }
        
        System.out.println("\n Opt array for Max cost of rod cut:");
        System.out.println(Arrays.toString(opt));

    }
    
    public void getMaxProfitBuySellStock(int prices[]) {
        int opt[][] = new int[(prices.length/2) + 1][prices.length];
        
        for(int i=0;i<opt[0].length;i++)
            opt[0][i] = 0; // with 0 transactions , 0 profit
        for(int i=0;i<opt.length;i++)
            opt[i][0] = 0; // with just 1 day, no profit as u cannot by and sell on same day
        
        
        for(int i=1;i<opt.length;i++) { // row
            for(int j=1;j<opt[i].length;j++) { // col
                int noTransactionMax = Math.max(opt[i-1][j], opt[i][j-1]); // dont do the transaction on this day
                int transactionMax = 0;
                for(int k=0;k<j;k++) {
                    int candidateMax = opt[i-1][k] + prices[j] - prices[k]; // k-1 transaction max (sub problems solved) + sell at jth day
                    if (candidateMax > transactionMax) {
                        transactionMax = candidateMax; 
                    }
                }
                opt[i][j] = Math.max(noTransactionMax, transactionMax);
            }
        }
        
        System.out.println("\n Opt array for Max profit that u can get after buy/sell stocks:");
        for(int i=0;i<opt.length;i++) { // row
            System.out.println(Arrays.toString(opt[i]));
        }
        
    }
    
    // 0-1 knapsack
    public void zeroOneIntegerKnapsack(int a[], int w) { // can we get a knapsack of w with elements in a[]
        int opt[][] = new int[a.length+1][w+1];
        
        for(int i=0;i<=a.length;i++) {
            opt[i][0] = 1; // we can make 0 by not adding any elements in knspasack
        }
        for(int i=1;i<=w;i++) {
            opt[0][i] = 0;
        }
        
        for(int i=1;i<=a.length;i++) { // row
            for(int j=1;j<=w;j++) {
                int bool = 0;
                if (opt[i-1][j] == 1) {
                    bool = 1;
                } else if (j - a[i-1] >= 0 && opt[i-1][j-a[i-1]] == 1) {
                    bool =1;
                }
                opt[i][j] = bool;
            }
        }
        
        System.out.println("\n Opt array for 0-1 knapsack - can we get knapsack of " + w);
        for(int i=1;i<=a.length;i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
    }
    
    public void areStringInterleaved(String a, String b, String c) { // is c interleaving of a and b
        
        int opt[][] = new int[a.length() + 1][b.length() + 1];
        
        // first col
        opt[0][0] = 1; // null is interleaving of target c
        
//        obj.areStringInterleaved("aax", "aay", "aaaayx");
        for(int i=1;i<=b.length();i++) {
            System.out.println("b char:" + b.charAt(i-1) + " c char:" + c.charAt(i-1));
            if (b.charAt(i-1) == c.charAt(i-1)) {
                opt[0][i] = 1;
            }
        }
        // first row
        for(int i=1;i<=a.length();i++) {
            if (b.charAt(i-1) == c.charAt(i-1)) {
                opt[i][0] = 1;
            }
        }
        
        for(int i=1;i<=a.length();i++) { // row
            for(int j=1;j<=b.length();j++) {
                if (b.charAt(j-1) == c.charAt(i+j-1) && opt[i][j-1] == 1) { // string @ col
                    opt[i][j] = 1;
                } else if (a.charAt(i-1) == c.charAt(i+j-1) && opt[i-1][j] == 1) { // string @ row
                    opt[i][j] = 1;
                } else {
                    opt[i][j] = 0;
                }
            }
        }
        
        System.out.println("\n Opt array for string interleaving ");
        for(int i=0;i<opt.length;i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
    }
    
    public void longestCommonSubsequence(String a, String b) {
        int opt[][] = new int[a.length() +1][b.length()+1];
        
        for(int i=0;i<=a.length();i++) {
            opt[i][0] = 0;
        }
        for(int i=0;i<=b.length();i++) {
            opt[0][i] = 0;
        }
        
        for(int i=1;i<=a.length();i++) {
            for(int j=1;j<=b.length();j++) {
                int excludingMax = Math.max(opt[i-1][j], opt[i][j-1]);
                int includingMax = 0; // if they match, else 0
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    includingMax = 1 + opt[i-1][j-1];
                }
                opt[i][j] = Math.max(excludingMax, includingMax);
            }
        }
        
        System.out.println("\n Opt array for longest common subsequence:");
        for(int i=0;i<opt.length;i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
    }
    
    public void longestCommonSubstring(String a, String b) {
        int opt[][] = new int[a.length() +1][b.length()+1];
        
        for(int i=0;i<=a.length();i++) {
            opt[i][0] = 0;
        }
        for(int i=0;i<=b.length();i++) {
            opt[0][i] = 0;
        }
        
        for(int i=1;i<=a.length();i++) {
            for(int j=1;j<=b.length();j++) {
                // int excludingMax = Math.max(opt[i-1][j], opt[i][j-1]); - there is no excluding in substring
                int includingMax = 0; // if they match, else 0
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    includingMax = 1 + opt[i-1][j-1];
                }
                opt[i][j] = includingMax;
            }
        }
        
        System.out.println("\n Opt array for longest common substring:");
        for(int i=0;i<opt.length;i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
    }
    
    public void longestPallindromicSubsequence(String s) {
      
        int opt[][] = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++) {
            opt[i][i] = 1; // every 1 char substring is palindromic
        }
        
        int substring = 0;
        int row;
        for(int i=0;i<opt.length;i++) { // for every row
            substring++;
            row = 0;
            for(int j=substring;j<opt.length;j++) { // now going to all cols
                if (s.charAt(j)  == s.charAt(j-substring)) {
                    opt[row][j] = 2 + opt[row+1][j-1];
                } else {
                    opt[row][j] = Math.max(opt[row][j-1], opt[row+1][j]);
                }
                row++;
            }
        }
        
        System.out.println("\n Opt array for longest pallindromic subsequence:");
        for(int i=0;i<opt.length;i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
    }
    
    public void longestPallindromicSubstring(String s) {
        int opt[][] = new int[s.length()][s.length()];
        
        for(int i=0;i<s.length();i++) {
            opt[i][i] = 1; // 1 = T
        }
        int substring = 0;
        // need to handle length len2 separately
        
        int row;
        int currMax = 0, maxLen = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++) { // rows
            substring++;
            row = 0;
            for(int j=substring;j<s.length();j++) {
                if (s.charAt(j) == s.charAt(j-substring) && opt[row+1][j-1] == 1) {
                    opt[row][j] = 1;
                    currMax = substring +1;
                    if (currMax > maxLen) {
                        maxLen = currMax;
                    }
                } else {
                    opt[row][j] = 0;
                }
                row++;
            }
        }
        
        System.out.println("\n Opt array for longest pallindromic substring and max length substring is:" + maxLen);
        for(int i=0;i<opt.length;i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
    }

    // https://www.geeksforgeeks.org/find-the-minimum-cost-to-reach-a-destination-where-every-station-is-connected-in-one-direction/
    public void dpTrainStations(int cost[][]) {
        int opt[][] = new int[cost.length][cost[0].length];
        
        for(int i=1;i<cost[0].length;i++) {
            opt[0][i] = cost[0][i];
        }
        for(int i=0;i<cost.length;i++) {
            opt[i][i] = 0;
        }
        
        int col = 1;
        for(int i=1;i<opt.length;i++) {
            col++;
            for(int j = col;j<opt[0].length;j++) {
                int withoutThisStation = opt[i-1][j];
                int withThisStation = cost[i][j] + opt[i-1][col-1];
                opt[i][j] = Math.min(withoutThisStation, withThisStation);
            }
        }
        
        System.out.println("\n Opt array for min cost to reach from station 1 to station n");
        for(int i=0;i<opt.length;i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
    }
    
    public void weightedKnapsackNoReuse(int values[], int weights[], int w) {
        int opt[][] = new int[values.length + 1][w+1];
        
        for(int i=0;i<=w;i++) {
            opt[0][i] = 0;
        }
        for(int i=0;i<=values.length;i++) {
            opt[i][0] = 0;
        }
        
        // now solve
        for(int i=1;i<=values.length;i++) {
            for(int j=1;j<=w;j++) {
                if (j-weights[i-1] >= 0) {
                    int excluding = opt[i-1][j];
                    int including = opt[i-1][j-weights[i-1]] + values[i-1];
                    opt[i][j] = Math.max(including, excluding);
                } else {
                    opt[i][j] = opt[i-1][j];
                }
            }
        }
        
        System.out.println("\n Opt array for max value to achieve of knapsac of w:" + w);
        for(int i=0;i<opt.length;i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
    }
    
    public void weightedKnapsackYesReuse(int cost[], int weights[], int w) {
        int opt[][] = new int[cost.length+1][w+1];
        
        for(int i=1;i<=w;i++) {
            opt[1][i] = cost[0]*(i);
        }
        for(int i=0;i<=cost.length;i++) {
            opt[i][0] = 0;
        }
        
        // now solve
        for(int i=2;i<=cost.length;i++) {
            for(int j=1;j<=w;j++) {
                if (j-weights[i-1] >= 0) {
                    int excluding = opt[i-1][j];
                    int includingNoReuse = opt[i-1][j-weights[i-1]] + cost[i-1];
                    int includingYesReuse = opt[i][j-weights[i-1]] + cost[i-1];
                    System.out.println("i:" + i + " cost:" + cost[i-1] + " includingNoReuse:" + includingNoReuse + " includingYesReuse:" + includingYesReuse);
                    opt[i][j] = Math.min(excluding, Math.min(includingNoReuse, includingYesReuse));
                } else {
                    opt[i][j] = opt[i-1][j];
                }
            }
        }
        
        System.out.println("\n Opt array for max value to achieve of knapsac of w:" + w);
        for(int i=0;i<opt.length;i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
    }
    
    public void numberOfPossibleDecodings(String s) {
        int opt[] = new int[s.length()];
        
        opt[0] = 1;
        
        for(int i=1;i<s.length();i++) {
            if ((int) s.charAt(i) <= 54 && (int) s.charAt(i-1) <= 50) {
                opt[i] = opt[i-1] +1;
            } else {
                opt[i] = opt[i-1];
            }
        }
        System.out.println("\n Opt array for number of decodings of a string");
        System.out.println(Arrays.toString(opt));
        
    }
    
    public static void main(String[] args) {
        // LCS
        int a[] = {2,6,8,4,0,5,11,19,15};
        DPBasics obj = new DPBasics();
        obj.getLCS(a);
        
        // max product subarray
        int b[] = {3,-9, 1, 2, 1, -8, -3};
        obj.getMaxProductSubarray(b);
        
        // rod cut
        int cutCost[] = {1, 5, 8, 9, 10, 17, 17, 20};
        obj.getMaxPriceRodCutting(cutCost);
        
        // buy sell stock, as many times - but if u buy on a day, u can sell it on next day onwards only
        int stockPrice[] = {10, 22, 5, 75, 65, 80};
        obj.getMaxProfitBuySellStock(stockPrice);
        
        // 0-1 knapsack can we get a knapsack of w with elements in a[]
        int knapsackArray[] = {1,9,3,2};
        obj.zeroOneIntegerKnapsack(knapsackArray, 5);
        
        // string interleaving
        obj.areStringInterleaved("aax", "aay", "aaaayx");
        
        // longest common Subsequence
        obj.longestCommonSubsequence("nsduay", "monday");
        
        // longest common Substring
        obj.longestCommonSubstring("sunday", "monday");
        
        // longest palindromic subsequence
        obj.longestPallindromicSubsequence("maammadam");
        
        // longest palindromic substring
//        obj.longestPallindromicSubstring("maamm");
        obj.longestPallindromicSubstring("madamm");
        
        // min cost to reach source to destination - train problem
        int ticketCost[][] = {
                    {0, 15,  80, 90},
                    {0,  0,  40, 50},
                    {0,  0,   0, 70},
                    {0,  0,   0,  0} // dunno why is this row needed as per g4g
        };
        obj.dpTrainStations(ticketCost);
        
        // longest palindromic subsequence
        obj.longestPallindromicSubsequence("maammadam");
        
        // Max value to get to knapsack of w with values values[] - no reuse
        int values[] = {60,100,120};
        int weights[] = {1,2,3};
        obj.weightedKnapsackNoReuse(values,  weights, 5);
        
        // Min value to get to knapsack of w with values values[] - yes reuse
        int cost[] = {20, 10, 4, 50, 100};
        int weights1[] = {1,2,3,4,5};
        obj.weightedKnapsackYesReuse(cost,  weights1, 5);
        
        // number of possible decodings
        obj.numberOfPossibleDecodings("1234");
        
    }
    

}
