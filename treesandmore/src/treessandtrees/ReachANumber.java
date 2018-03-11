package treessandtrees;
/*
 * You are standing at position 0 on an infinite number line. There is a goal at position target.

On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.

Return the minimum number of steps required to reach the destination.

Example 1:
Input: target = 3
Output: 2
Explanation:
On the first move we step from 0 to 1.
On the second step we step from 1 to 3.
 */
import java.util.*;
public class ReachANumber {
    
    public void reachAnum(int target) { // start will always be 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        int moveStep = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int currOrigin = q.poll();
                if (currOrigin == target) {
                    System.out.println("We reached target in " + (moveStep-1) + " steps!!");
                    return; // no break, we need to return
                }
                
                // forward step
                System.out.println("Adding:" + (currOrigin + moveStep) + " currStep:" + moveStep);
                q.add(currOrigin + moveStep);
                
                // back step
                System.out.println("Adding:" + (currOrigin - moveStep) + " currStep (-ve):" + moveStep);
                q.add(currOrigin - moveStep);
                
                size--;
            }
            moveStep++;
        }
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReachANumber obj = new ReachANumber();
        obj.reachAnum(3);
    }

}
