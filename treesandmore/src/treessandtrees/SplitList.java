package treessandtrees;

import java.util.Arrays;

//https://leetcode.com/contest/weekly-contest-58/problems/split-linked-list-in-parts/
public class SplitList {
    
    public void splitListAsEqualAsPossible(int a[], int k) {
        if (a == null || a.length == 0)
            return;
        
        int splits[] = new int[k]; // k parts by default
        
        if (k >= a.length) {
            for(int i=0;i<a.length;i++) {
                splits[i] = 1;
            }
        } else {
            int pointerToTarget = 0;
            // definition of split[i] = number of elements in ith split. eg: split[0] = 4, 1st split has 4 elements
            int elementsCount = 0;
            for(int i=0;i<k;i++) {
                splits[i] = a.length/k;
                elementsCount += splits[i];
            }
            while (elementsCount < a.length) {
                splits[pointerToTarget++] += 1;
                elementsCount++;
                if (pointerToTarget == splits.length) {
                    pointerToTarget = 0; // like conveyer belt;
                }
            }
        }
        
        System.out.println(Arrays.toString(splits));
        
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SplitList obj = new SplitList();
        int a[] = {1,2,3,4,5,6,7,8,9,10};
        int k = 3;
        obj.splitListAsEqualAsPossible(a,k);
    }

}
