package treessandtrees;

import java.util.Arrays;

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
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RestoreIpAddressAgain obj = new RestoreIpAddressAgain();
        String s = "2552551113";
        int res[] = new int[4];
        obj.restore(s, res, 0, 0, "");
    }

}
