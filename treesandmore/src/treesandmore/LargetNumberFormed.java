package treesandmore;
import java.util.*;
/*
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 */
public class LargetNumberFormed {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer a[] = {3, 30, 34, 500, 9};
        Comparator<Integer> specializedComparator= new Comparator<Integer>() {
            int max ;
            public int compare(Integer a, Integer b) {
                // convert number to string and make them equal size
                String a1 = a.toString();
                String b1 = b.toString();
                max = Math.max(a1.length(), b1.length());
                while (a1.length() < max) {
                    a1+="0";
                }
                while (b1.length() < max) {
                    b1+="0";
                }
                // convert string back to number for actual comparision
                a = Integer.parseInt(a1);
                b = Integer.parseInt(b1);
//                if (a==b) {
//                    return 0;
//                } else if(a>b) {
//                    return -1;
//                } else {
//                    return 1;
//                }
                return b - a; // descending order after they become equal lengths.
            }
        };
        
        Arrays.sort(a, specializedComparator);
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]);
        }

    }

}
