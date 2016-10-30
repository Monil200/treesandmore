package nontrees;

import java.util.Arrays;

public class DutchFlag {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int low=0,high=a.length-1;
        int temp;
        for(int i=0;i<=high;i++) {
            System.out.println(a[i] + ":" + Arrays.toString(a));
            if (a[i] == 0) {
                temp = a[low];
                a[low] = a[i];
                a[i] = temp;
                low++;
            } else if (a[i] == 1) {
                
            } else if (a[i] == 2) {
                temp = a[high];
                a[high] = a[i];
                a[i] = temp;
                high--;
                if (a[i] == 0) {
                    temp = a[i];
                    a[i] = a[low];
                    a[low] = temp;
                    low++;
                }
            }
        }
        System.out.println("Final");
        System.out.println(Arrays.toString(a));
    }

}
