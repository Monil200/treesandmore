package nontrees;
import java.util.*;

// wrong solution
public class MatchSticksToSquare {
    boolean done = false;
    public void makesquare(Integer[] nums, int side, int currentLength, int currentIndex, boolean available[]) {
        System.out.println("currentLength:" + currentLength + " currentIndex:" + currentIndex + " " + Arrays.toString(available));
        if (done) {
            return;
        }
        if (currentLength > side) {
            return;
        }
        if (currentLength == side) {
            System.out.println("yes---" + Arrays.toString(available));
            done = true;
            return;
        }
        if (currentIndex >= nums.length) {
            return;
        }
        for(int i=currentIndex;i<nums.length;i++) {
            if (available[i] && !done) {
                currentLength += nums[i];
                available[i] = false;
                makesquare(nums, side, currentLength, 1+i, available);
                currentLength -= nums[i];
                if (!done) {
                    available[i] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MatchSticksToSquare obj = new MatchSticksToSquare();
        Integer nums[] = {5,5,5,5,4,4,4,4,3,3,3,3}, perimeter = 0;
        
        for(int i=0;i<nums.length;i++) {
            perimeter += nums[i];
        }
//        int a[] = {5,5,5,5,3};
        boolean available[] = new boolean[nums.length];
        for(int i=0;i<nums.length;i++) {
            available[i] = true;
        }
        Arrays.sort(nums, Collections.reverseOrder());
        for(int i=0;i<4;i++) {
            obj.done= false;
            obj.makesquare(nums, perimeter/4, 0, 0,available);
            if (!obj.done) {
                System.out.println("Required side length not found");
            }
            System.out.println("**********" + Arrays.toString(available));
        }
        if (obj.done) { // check all boolean are false (available false), perimeter/4 is integer, and nums.length >=4 ..all base checks 
            System.out.println("Square formed");
        } else {
            System.out.println("Square NOT formed");
        }

    }

}
