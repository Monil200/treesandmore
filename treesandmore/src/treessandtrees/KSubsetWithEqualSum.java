package treessandtrees;
import java.util.*;
public class KSubsetWithEqualSum {
    
    boolean isSumFormed;
    KSubsetWithEqualSum() {
        isSumFormed = false;
    }
    
    public void makerequitedSum(int a[], boolean available[], int index, int currSum, int targetSum) {
        if (index >= a.length) {
            return;
        }
        if (currSum == targetSum && !isSumFormed) {
            isSumFormed = true;
            return;
        }
        for(int i=index;i<a.length;i++) {
            if (available[i] && (currSum + a[i]) <= targetSum && !isSumFormed) {
                available[i] = false;
                currSum += a[i];
                makerequitedSum(a, available,i+1, currSum, targetSum);
                currSum -= a[i];
                available[i] = true;
            }
        }
    }
    
    public static void main(String[] args) {
        KSubsetWithEqualSum obj = new KSubsetWithEqualSum();
        int a[] = {4, 3, 2, 3, 5, 2, 1};
        Arrays.sort(a);
        int k = 4;
        int sum = 0;
        boolean available[] = new boolean[a.length];
        
        for(int i=0;i<a.length;i++) {
            sum += a[i];
            available[i] = true;
         }
        if (sum%k != 0) {
            System.out.println("Cannot do partitioning");
        } else {
            
            for(int i=0;i<k;i++) {
                obj.isSumFormed = false;
                obj.makerequitedSum(a, available, 0, 0, sum/k);
                if (!obj.isSumFormed) {
                    System.out.println("Cannot do partitioning");
                    break;
                } else {
                    System.out.println("Partition " + i + " formed");
                }
            }
            
            if (!obj.isSumFormed) {
                System.out.println("Cannot do partitioning");
            } else {
                System.out.println("Success");
            }
            
            char temp[] = {'9', '9', '0'};
            int x = 54;
            temp[0] = (char) x;
            System.out.println(temp[0]);
        }
    }
}
