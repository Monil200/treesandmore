package treessandtrees;
import java.util.*;
public class BoundedMinMaxNumberOfSubarrays {
    
    public void getNumOfSubarrays(int a[], int l, int r) {
        
        int res = 0, count = 0, j = 0;
        
        
        for(int i=0;i<a.length;i++) {
            if (a[i] < l) {
                res += count;
            } else if (a[i]>=l && a[i]<=r) {
                res += i - j +1;
                count += i-j+1;
            } else {
                j = i+1;
                count = 0; // streak broken
            }
         }
        
        System.out.println(res);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BoundedMinMaxNumberOfSubarrays obj = new BoundedMinMaxNumberOfSubarrays();
        int a[] = {1,2,1,4,3,1};
        obj.getNumOfSubarrays(a, 2, 3);
    }

}
