package treessandtrees;
/*
 * We are given an elevation map, heights[i] representing the height of the terrain at that index. The width at each index is 1. After V units of water fall at index K, how much water is at each index?

Water first drops at index K and rests on top of the highest terrain or water at that index. Then, it flows according to the following rules:

If the droplet would eventually fall by moving left, then move left.
Otherwise, if the droplet would eventually fall by moving right, then move right.
Otherwise, rise at it's current position.
Here, "eventually fall" means that the droplet will eventually be at a lower level if it moves in that direction. Also, "level" means the height of the terrain plus any water in that column.
We can assume there's infinitely high terrain on the two sides out of bounds of the array. Also, there could not be partial water being spread out evenly on more than 1 grid block - each unit of water has to be in exactly one block.

Input: heights = [2,1,1,2,1,2,2], V = 4, K = 3
Output: [2,2,2,3,2,2,2]
Explanation:
#       #
#       #
##  # ###
#########
 0123456    <- index

The first drop of water lands at index K = 3:

#       #
#   w   #
##  # ###
#########
 0123456    

When moving left or right, the water can only move to the same level or a lower level.
(By level, we mean the total height of the terrain plus any water in that column.)
Since moving left will eventually make it fall, it moves left.
(A droplet "made to fall" means go to a lower height than it was at previously.)

#       #
#       #
## w# ###
#########
 0123456    

Since moving left will not make it fall, it stays in place.  The next droplet falls:

#       #
#   w   #
## w# ###
#########
 0123456  

Since the new droplet moving left will eventually make it fall, it moves left.
Notice that the droplet still preferred to move left,
even though it could move right (and moving right makes it fall quicker.)

#       #
#  w    #
## w# ###
#########
 0123456  

#       #
#       #
##ww# ###
#########
 0123456  

After those steps, the third droplet falls.
Since moving left would not eventually make it fall, it tries to move right.
Since moving right would eventually make it fall, it moves right.

#       #
#   w   #
##ww# ###
#########
 0123456  

#       #
#       #
##ww#w###
#########
 0123456  

Finally, the fourth droplet falls.
Since moving left would not eventually make it fall, it tries to move right.
Since moving right would not eventually make it fall, it stays in place:

#       #
#   w   #
##ww#w###
#########
 0123456  

The final answer is [2,2,2,3,2,2,2]:

    #    
 ####### 
 ####### 
 0123456
 */
import java.util.*;
class Slot{
    int pos, depth;
    Slot(int p, int d) {
        pos = p;
        depth = d;
    }
}
public class PourWater {
    public void pourWater(int valley[], int target, int unit) {
        Queue<Slot> leftPq = new PriorityQueue<Slot>(
                new Comparator<Slot>(){
                    public int compare(Slot a, Slot b) {
                        if (b.depth != a.depth)
                            return b.depth -a.depth;
                        else {
                            return b.pos - a.pos;
                        }
                    }
                }
        );
        Queue<Slot> rightPq = new PriorityQueue<Slot>(
                new Comparator<Slot>(){
                    public int compare(Slot a, Slot b) {
                        if (b.depth != a.depth)
                            return b.depth -a.depth;
                        else {
                            return a.pos - b.pos;
                        }
                    }
                }
        );
        
        int avail[] = new int[valley.length];
        
        for(int i=1;i<valley.length-1;i++) {
            if (valley[i] < valley[target]) {
                avail[i] = valley[target] - valley[i]; // already levelled
            } else {
                avail[i] = 0; // already leveled
            }
        }
        System.out.println(Arrays.toString(avail));
        
        for(int i=1;i<target;i++) {
            leftPq.add(new Slot(i, avail[i]));
        }
        for(int i=target+1;i<valley.length-1;i++) {
            rightPq.add(new Slot(i, avail[i]));
        }

        Queue<Slot> holder = new PriorityQueue<Slot>(
                new Comparator<Slot>(){
                    public int compare(Slot a, Slot b) {
                        return b.depth -a.depth;
                    }
                }
        );
        
        while(leftPq.size() > 0) {
            Slot t = leftPq.poll();
            holder.add(t);
            System.out.print(t.depth + " : pos " + t.pos + "| ");
        }
        System.out.println();
        leftPq.addAll(holder);
        holder.clear();
        while(rightPq.size() > 0) {
            Slot t = rightPq.poll();
            holder.add(t);
            System.out.print(t.depth + " : pos " + t.pos + "| ");
        }
        rightPq.addAll(holder);
        holder.clear();
        // step 1.1- check if target can take water
        while(unit > 0) {
            boolean isConsumed = false;
            if (valley[target] < valley[target-1] && valley[target] < valley[target+1]) {
                isConsumed = true;
                int lower = Math.min(avail[target-1], avail[target+1]);
                int reduce = Math.min(lower - valley[target], unit);
                if (reduce < unit) {
                    valley[target] += reduce;
                    unit-= reduce;
                } else {
                    valley[target] += reduce;
                    unit-= reduce;
                    return; // the target itself can take all water, big enough hole.
                }
            }
            // step 2- flow water on left
            if(unit > 0 && leftPq.peek().depth > 0) {
                System.out.println("Left consumed at:" + leftPq.peek().pos);
                isConsumed = true;
                Slot obj = leftPq.poll();
                unit -= 1;
                obj.depth -= 1;
                valley[obj.pos] +=1;
                leftPq.add(obj);
            }
            // step 3- flow water on right
            if(unit > 0 && rightPq.peek().depth >0) {
                System.out.println("right consumed at:" + rightPq.peek().pos);
                isConsumed = true;
                Slot obj = rightPq.poll();
                unit -= 1;
                obj.depth -= 1;
                valley[obj.pos] +=1;
                rightPq.add(obj);
            }
            if (!isConsumed) {
                valley[target] += 1;
                unit-=1;
            }
        }
        
        System.out.println(Arrays.toString(valley));
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PourWater obj = new PourWater();
        int valley[] = {100,4,1,0,2,6,3,8,100};
        int target = 4;
        int unit = 5;
        obj.pourWater(valley, target, unit);
    }

}
