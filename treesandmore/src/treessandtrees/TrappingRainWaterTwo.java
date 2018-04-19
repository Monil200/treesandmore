package treessandtrees;
import java.util.*;
class RainSlot {
    int x,y, val;
    RainSlot(int xx, int yy, int v) {
        val = v;
        x = xx;
        y = yy;
    }
}
public class TrappingRainWaterTwo {
    
    public void trapRainWater(int a[][]) {
        PriorityQueue<RainSlot> pq = new PriorityQueue<RainSlot>(
            new Comparator<RainSlot>() {
                public int compare(RainSlot a, RainSlot b) {
                    return a.val - b.val;
                }
            }
       );
        boolean visited[][] = new boolean[a.length][a[0].length];
        for(int i=0;i<a.length;i++) {
            pq.add(new RainSlot(i, 0, a[i][0]));
            pq.add(new RainSlot(i, a[0].length-1, a[i][a[0].length-1]));
            visited[i][0] = visited[i][a[0].length-1] = true;
        }
        for(int i=1;i<a[0].length-1;i++) {
            pq.add(new RainSlot(0, i, a[0][i]));
            pq.add(new RainSlot(a.length-1, i, a[a.length-1][i]));
            visited[0][i] = visited[a.length-1][i] = true;
        }
        
        
        int waterCollected = 0;
        int max = Integer.MIN_VALUE;
        
        while(pq.size() > 0) {
            RainSlot popped = pq.poll();
            if (popped.val > max) {
                max = popped.val;
            }
            int currX = popped.x;
            int currY = popped.y;
            if (isValid(a, visited, currX+1, currY)) {
                visited[currX+1][currY] = true;
                pq.add(new RainSlot(currX+1, currY, a[currX+1][currY]));
                if (a[currX+1][currY] < max) {
                    waterCollected += (max - a[currX+1][currY]);
                }
            }
            if (isValid(a, visited, currX-1, currY)) {
                visited[currX-1][currY] = true;
                pq.add(new RainSlot(currX-1, currY, a[currX-1][currY]));
                if (a[currX-1][currY] < max) {
                    waterCollected += (max - a[currX-1][currY]);
                }
            }
            if (isValid(a, visited, currX, currY+1)) {
                visited[currX][currY+1] = true;
                pq.add(new RainSlot(currX, currY+1, a[currX][currY+1]));
                if (a[currX][currY+1] < max) {
                    waterCollected += (max - a[currX][currY+1]);
                }
            }
            if (isValid(a, visited, currX, currY-1)) {
                visited[currX][currY-1] = true;
                pq.add(new RainSlot(currX, currY-1, a[currX][currY-1]));
                if (a[currX][currY-1] < max) {
                    waterCollected += (max - a[currX][currY-1]);
                }
            }
        }
        
        System.out.println("waterCollected:" + waterCollected);
    }
    
    public boolean isValid(int a[][], boolean visited[][], int x, int y) {
        if (x < 0 || x>= a.length || y < 0 || y >=a[0].length) {
            return false;
        }
        if (visited[x][y])
            return false;
        return true;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[][] = {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
              };
        TrappingRainWaterTwo obj = new TrappingRainWaterTwo();
        obj.trapRainWater(a);
    }

}
