package treesandmore;
import java.util.*;
public class MZerosNOnes {
    int maxStringsSoFar;
    MZerosNOnes() {
        maxStringsSoFar = Integer.MIN_VALUE;
    }
    public void getMaxStringWithGivenZerosAndOnes(ArrayList<String> a, int m, int n, int currCount, int depth) {
        if (m == 0 && n == 0) {
            return;
        }
        if (a.size() == 0) {
            return;
        }
        boolean isValid = false;
        int currIndex = -1;
        int mCopy = m;
        int nCopy = n;
        ArrayList<String> aCopy = new ArrayList<String>(a);
        for(int i=0;i<a.size();i++) {
            if (isValid(a.get(i), mCopy, '0') && isValid(a.get(i), nCopy, '1'))  {
                isValid = true;
                currIndex = i;
                for(int j=0;j<a.get(i).length();j++) {
                    if (a.get(i).charAt(j) == '0') {
                        mCopy--;
                    }
                    if (a.get(i).charAt(j) == '1') {
                        nCopy--;
                    }
                }
            }
        
            if (isValid) {
                currCount++;
                if (nCopy ==0 && nCopy ==0) {
                    if (maxStringsSoFar < currCount) {
                        maxStringsSoFar = currCount;
                    }
                }
                System.out.println("Current valid:" + a.get(i) + " 0 mCopy:" + mCopy + " nCopy:" + nCopy + " depth:" + depth + " array" + aCopy);
                aCopy.remove(currIndex);
                getMaxStringWithGivenZerosAndOnes(aCopy, mCopy, nCopy, currCount, depth+1);
                a = aCopy;
                m = mCopy;
                n = nCopy;
            }
        }
    }
    
    public boolean isValid(String s, int a, char target) {
        if (a == 0) {
            return true;
        }
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == target) {
                a--;
            }
        }
        if (a>=0) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<String> a = new ArrayList<String>();
        a.add("10");
        a.add("0001");
        a.add("111001");
        a.add("1");
        a.add("0");
        MZerosNOnes obj = new MZerosNOnes();
        obj.getMaxStringWithGivenZerosAndOnes(a, 5, 3, 0, 0);
        System.out.println("Max strings:" + obj.maxStringsSoFar);
        
    }

}
