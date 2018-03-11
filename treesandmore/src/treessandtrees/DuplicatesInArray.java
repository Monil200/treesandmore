package treessandtrees;
import java.util.*;
// 1. We do the following
//    replace a[i] if a[i] != i with element element which is in a[a[i] -1] until a[i] == i.
// but there is a possibility that i+1 is not in the array itself so we do a[i]*=-1 so that we know how to end loop.

public class DuplicatesInArray {
    
    public void getDups(int a[]) {
        if (a.length == 0 || a == null)
            return;
        
        for(int i=0;i<a.length;i++) {
            while(a[i] != i+1 && a[i] > 0) {
                int temp = a[i];
                a[i] = a[a[i]-1];
                a[temp-1] = temp;
                if (a[i] == a[Math.abs(a[i]) -1] && i+1 != a[i]) {
                    System.out.println(a[i] + " i:" + i);
                    a[i] *= -1;
                }
            }
        }
        System.out.println(Arrays.toString(a)); // need to do second pass to find missing elements when input is in range 1 to n+1
    }
     public static void main(String[] args) {
        // TODO Auto-generated method stub
        DuplicatesInArray obj = new DuplicatesInArray();
        int a[] = {2,1,4,4,3};
        obj.getDups(a);
    }

}
