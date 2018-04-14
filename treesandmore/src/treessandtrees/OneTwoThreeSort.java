package treessandtrees;

import java.util.Arrays;

public class OneTwoThreeSort {
    public void sortDutch(int a[]) {
        
        int low = 0;
        int high = a.length-1;
        int curr = 0;
        while(curr<=high) {
            if (a[curr] == 0) {
                int temp = a[low];
                a[low] = a[curr];
                a[curr] = temp;
                low++;
            } else if (a[curr] == 1) {
            } else if (a[curr] == 2) {
                while(a[high] == 2) {
                    high--;
                }
                if (high > curr) {
                    int temp = a[high];
                    a[high] = 2;
                    a[curr] = temp;
                    high--;
                    
                    if (a[curr] == 0) {
                        int temp1 = a[low];
                        a[low] = a[curr];
                        a[curr] = temp1;
                        low++;
                    }
                }
            }
            curr++;
            System.out.println("low:" + low + " high:" + high);
        }
        
        System.out.println(Arrays.toString(a));
        
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {2,0,1,1,1,0,1,2,2,0};
        OneTwoThreeSort obj = new OneTwoThreeSort();
        obj.sortDutch(a);
    }

}
