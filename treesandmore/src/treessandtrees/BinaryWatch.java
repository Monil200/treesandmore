package treessandtrees;

import java.util.Arrays;

public class BinaryWatch {
    public void getAllPossibleTimes(int k, int a[], int bitsSet, int start) {
        if (k == bitsSet) {
            System.out.println(Arrays.toString(a));
//            return;
        }
        for(int i=start;i<a.length;i++) {
//            System.out.println("i:" + i);
            a[i] = 1;
            ++bitsSet;
            getAllPossibleTimes(k ,a, bitsSet, ++start);
            a[i] = 0;
            bitsSet--;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinaryWatch obj = new BinaryWatch();
        int a[] = {0,0,0,0,0,0,0,0,0,0};
        obj.getAllPossibleTimes(2,a, 0, 0);
    }

}
