package dp;

import java.util.Arrays;

class Words {
    String s;
    int len, cost;
    int w = 6;
    Words(int l) {
        len = l;
        cost = (int) Math.pow((w-len), 3);
    }
}
public class WordWrapTextJustification {
    
    public void getMinCostARrangement(String a[], int w) { // w - width of sentence
        int lengths[] = new int[a.length];
        Words opt[][] = new Words[a.length][a.length];
        for(int i=0;i<a.length;i++) {
            lengths[i] = a[i].length();
        }
        
        for(int i=0;i<a.length;i++) {
            opt[i][i] = new Words(lengths[i]);
        }
        
        int widths = 0, row = 0;
        for(int i=0;i<a.length;i++) {
            widths++;
            row=0;
            for(int j=widths;j<a.length;j++) {
                System.out.println("row:" + row + "col:" + (j-1));
                if (opt[row][j-1] != null &&  (lengths[j] + opt[row][j-1].len + 1) <= w) {
                    opt[row][j] = new Words((lengths[j] + opt[row][j-1].len + 1));
                } else {
                    opt[row][j] = null;
                }
                row++;
            }
        }
        
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a.length;j++) {
                if (opt[i][j] != null) {
                    System.out.print("(" + opt[i][j].len + "," + opt[i][j].cost + "), ");
                } else {
                    System.out.print("(NA), ");
                }
            }
            System.out.println();
        }
        
        // now get the min cost of indentation
        int cost[] = new int[a.length];
        cost[a.length-1] = opt[a.length-1][a.length-1].cost; // base
        int maxCost = Integer.MAX_VALUE;
        for(int i=a.length-2;i>=0;i--) {
            int currCost = 0;
            maxCost = Integer.MAX_VALUE;
            for(int j=a.length-1;j>=i;j--) {
                if (opt[i][j] != null) {
                    currCost = opt[i][j].cost;
                    if ((j+1) <= a.length-1) {
                        currCost += cost[j+1]; 
                    }
                    if (currCost < maxCost) {
                        maxCost = currCost;
                    }
                }
            }
            cost[i] = maxCost;
        }
        
        System.out.println(Arrays.toString(cost));
        
     }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WordWrapTextJustification obj = new WordWrapTextJustification();
        int w = 6;
        String a[] = {"aaa","bb", "cc", "ddddd"};
        obj.getMinCostARrangement(a, w);
    }

}
