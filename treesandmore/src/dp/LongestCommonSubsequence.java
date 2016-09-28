package dp;

public class LongestCommonSubsequence {
    public static String a = "sunday";
    public static String b = "saturday";
    public void longestCommonSubstring() {
        int lcs[][] = new int[a.length()+1][b.length()+1];
        for(int i=0;i<a.length();i++) {
            lcs[i][0] = 0;
        }
        for(int i=0;i<b.length();i++) {
            lcs[0][i] = 0;
        }
        int k,l;
        for(int i=0;i<a.length();i++) {
            for(int j=0;j<b.length();j++) {
                k = i+1;
                l = j+1;
                if (a.charAt(i) == b.charAt(j)) {
                    lcs[k][l] = lcs[k-1][l-1] +1;
                } else {
                    lcs[k][l] = Math.max(lcs[k-1][l], lcs[k][l-1]);
                }
            }
        }
        
        int currentLength = 0;
        int maxLength = 0;
        for(int i=1;i<a.length();i++) {
            for(int j=1;j<b.length();j++) {
                if (lcs[i][j] < lcs[i+1][j+1]) {
                    k = i;
                    l = j;
                    while(k<a.length() && l <b.length() && lcs[k][l] < lcs[k+1][l+1]) {
                        currentLength++;
                        if (maxLength < currentLength) {
                            maxLength = currentLength;
                        }
                        k++;
                        l++;
                    }
                }
                currentLength =0;
            }
//            System.out.println();
        }
        System.out.println("Length of longest common substring is:" + (maxLength + 1));
        
    }
    public void longestCommonSubsequence() {
        int lcs[][] = new int[a.length()+1][b.length()+1];
        for(int i=0;i<a.length();i++) {
            lcs[i][0] = 0;
        }
        for(int i=0;i<b.length();i++) {
            lcs[0][i] = 0;
        }
        int k,l;
        for(int i=0;i<a.length();i++) {
            for(int j=0;j<b.length();j++) {
                k = i+1;
                l = j+1;
                if (a.charAt(i) == b.charAt(j)) {
                    lcs[k][l] = lcs[k-1][l-1] +1;
                } else {
                    lcs[k][l] = Math.max(lcs[k-1][l], lcs[k][l-1]);
                }
            }
        }
        
        for(int i=1;i<a.length()+1;i++) {
          for(int j=1;j<b.length()+1;j++) {
              System.out.print(lcs[i][j] + ",");
          }
          System.out.println();
      }
        
        System.out.println("Length of longest common subseuqence is:" + lcs[a.length()][b.length()]);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        obj.longestCommonSubsequence();
        obj.longestCommonSubstring();
        
    }

}
