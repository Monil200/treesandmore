package nontrees;

import java.util.Arrays;
import java.util.HashSet;

public class UniquePermutations {
    public static HashSet<String> u = new HashSet<String>();
    public static void permutations(int[] a, int start) {
        if (start >= a.length) {
            System.out.println(Arrays.toString(a));
            String temp = "";
            for(int i=0;i<a.length;i++) {
                temp += a[i] + "|";
            }
            u.add(temp);
        } else {
            for(int i=start;i<a.length;i++) {
                int temp = a[start];
                a[start] = a[i];
                a[i] = temp;
                permutations(a, start+1);
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1,1,3};
        permutations(a,0);
        for(String i : u) {
            System.out.println(i);
        }
    }

}
