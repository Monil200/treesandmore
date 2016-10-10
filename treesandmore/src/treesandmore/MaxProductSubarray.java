package treesandmore;

import java.util.Arrays;
public class MaxProductSubarray {
    
    
    
    
    public static int getMax(int a, int b,int c) {
        return Math.max(Math.max(a, b), c);
    }
    public static void main(String args[]) {
        
    int a[] = {1, -2, -3, 0, 7, -8, -2};
    int res[] = new int[a.length];
    if (a[0] > 0) {
        res[0] = a[0];
    } else {
        res[0] =1;
    }
    for(int i=1;i<a.length;i++) {
        res[i] = getMax(1, a[i]*res[i-1], a[i]*a[i-1]);
    }
    System.out.println(Arrays.toString(res));
    }
}
