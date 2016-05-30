package treesandmore;
// Count frequencies of all elements in array in O(1) extra space and O(n) time
public class DistinctNumberFrequency {
    public static void main(String args[]){
        int[] a = {0, 3, 3, 3, 2, 4};
        int temp;
        for (int i=1; i<a.length; i++) {
            // process and swap number
            while (a[i] > 0) { // this mean not processed
                if (a[a[i]] > 0) { // swap only if the counter position is not incremented even once
                    temp = a[i];
                    a[i] = a[a[i]];
                    a[temp] = -1;
                } else {
                    a[a[i]]--;
                    a[i] = 0;
                }
            }
        }
        for (int i=0; i<a.length; i++) {
            System.out.println(a[i] + " , ");
        }
    }
}
