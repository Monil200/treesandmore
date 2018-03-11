package treessandtrees;

import java.util.*;

public class RestoreIpAddressAgain {
    
    public void restore(String s, int res[], int index, int pos, String currStr) {
//        System.out.println("i:" + index  + " res" + Arrays.toString(res) + " valid till:" + pos + " slen" + s.length());
        if (pos > 0 && pos <= 3 && res[pos-1] > 255) {
            return;
        }
        if(pos <= 3 && res[pos] > 255) {
            return;
        }
        if (index == s.length() && res[pos-1] < 256) {
            System.out.println(Arrays.toString(res) + "-------");
        }
        if (pos >= 4) {
            return;
        }
        
        if (index >= s.length()) {
            return;
        }
        
        //25525511135
        for(int i=index;i<s.length();i++) {
            currStr += s.charAt(i);
            res[pos] = Integer.parseInt(currStr);
            restore(s,res, i+1, 1+pos, "");
            if (Integer.parseInt(currStr) > 255) {
                res[pos] = -1; // placeholder
                break;
            }
        }
    }
    
    public void restoreV2(String s, int[] a, int index, int pos) {
        if (index > s.length()) {
            return;
        }
        if (pos>=1 && pos<=3  && a[pos-1] > 255) {
            return;
        }
        if (index == s.length() && a[pos-1] < 256) {
            System.out.println(Arrays.toString(a) + " ---V2");
            return;
        }
        if (pos >= 4)
            return;
        String num = "";
        for(int i=index;i<s.length();i++) {
            num += s.charAt(i) + "";
            a[pos] = Integer.parseInt(num);
            restoreV2(s, a, i+1, pos+1);
            if (a[pos] > 255) {
                a[pos] = -1;
                break;
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RestoreIpAddressAgain obj = new RestoreIpAddressAgain();
        String s = "2552551113";
        int res[] = new int[4];
        obj.restore(s, res, 0, 0, "");
        
        // v2
        int res1[] = new int[4];
        obj.restoreV2(s, res1, 0, 0);
    }

}
