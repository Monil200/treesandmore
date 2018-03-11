package treessandtrees;

import java.util.Arrays;

import javax.net.ssl.SSLContext;

public class PallindromePartitioning {
    
    public void partitionPallindrome(String s) {
        if (s== null || s.length() == 0)
            return;
        
        boolean opt[][] = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++) {
            opt[i][i] = true;
        }
        
        int row=0;
        int substringsize = 1;
        for(int i=0;i<s.length();i++) {
            row = 0;
            for(int j=substringsize; j<s.length();j++) {
                if (s.charAt(j) == s.charAt(j-substringsize)) {
                    if (j - (j-substringsize) > 1) {
                        opt[row][j] = opt[row+1][j-1]; 
                    } else {
                        opt[row][j] = true;
                    }
                } else {
                    opt[row][j] = false;
                }
                row++;
            }
            substringsize++;
        }
        
        for(int i=0;i<opt.length;i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PallindromePartitioning obj = new PallindromePartitioning();
        obj.partitionPallindrome("maam");
    }

}
