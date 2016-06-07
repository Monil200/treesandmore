package treesandmore;
//Majority Element
//Majority Element: A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element).
//
//Write a function which takes an array and emits the majority element (if it exists), otherwise prints NONE as follows:
public class VotingAlgorithm {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1, 3, 3, 3, 2,3, 2};
        int maxNumLocation = 0, count =1; // consider first number in array is majority element
        int appearenceCount =0;
        
        // Get the majority element's location - PHASE1
        for (int i=1;i <a.length; i++) {
            if (a[i] == a[maxNumLocation]) {
                count++; 
            } else {
                count--;
            }
            if (count == 0) {
                maxNumLocation = i;
                count =1;
            }
        }
        
        // PHASE 2 - verify if this a[maxNumLocation] is actually the majority element with one O(n) pass
        for (int i=0; i<a.length;i++) {
            if (a[i] == a[maxNumLocation]) {
                appearenceCount++;
                if (appearenceCount > a.length/2) {
                    System.out.println(" Majority element is " + a[maxNumLocation]);
                    break;
                }
            }
        }
        if (appearenceCount < a.length/2) {
            System.out.println("No majority element found, do the voting again");
        }
    }

}
