package toD;

import java.util.Arrays;

public class DPLCSubsequenceSubstringAgain {
    
    
    public void getLCSubsequence(String s) {
        if (s == null || s.length() == 0) return;
        int opt[][] = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++) {
            opt[i][i] = 1;
        }
        
        int length =0;
        int row;
        for(int i=1;i<s.length();i++) {
            length++;
            row = 0;
            for(int j=length;j<s.length();j++) {
                if (s.charAt(j) == s.charAt(j-length)) {
                    int candidateMax = Math.max(opt[row][j-1], opt[row+1][j]);
                    opt[row][j] = Math.max(opt[row+1][j-1] + 2, candidateMax);
                } else {
                    opt[row][j] = Math.max(opt[row][j-1], opt[row+1][j]);
                }
                row++;
            }
        }
        
        for(int i=0;i<s.length();i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
    }
    
    public void getLCSubstring(String s) {
        if (s == null || s.length() == 0) return;
        int opt[][] = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++) {
            opt[i][i] = 1;
        }
        
        int length =0;
        int row;
        for(int i=1;i<s.length();i++) {
            length++;
            row = 0;
            for(int j=length;j<s.length();j++) {
                if ((s.charAt(j) == s.charAt(j-length) && opt[row+1][j-1] > 0) || (s.charAt(j) == s.charAt(j-length) && length==1)) {
//                    int candidateMax = Math.max(opt[row][j-1], opt[row+1][j]);
                    opt[row][j] = opt[row+1][j-1] + 2;
                } else {
                    opt[row][j] = 0;
                }
                row++;
            }
        }
        
        for(int i=0;i<s.length();i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DPLCSubsequenceSubstringAgain obj = new DPLCSubsequenceSubstringAgain();
        obj.getLCSubsequence("maamadam");
        System.out.println();
        obj.getLCSubstring("maamadam");
    }

}
