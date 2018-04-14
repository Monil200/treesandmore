package treessandtrees;
// https://leetcode.com/contest/leetcode-weekly-contest-53/problems/max-area-of-island/
import java.util.*;
public class MaxAreaOfIsland {
    int currMax = 0;
    public void getArea(int a[][], boolean visited[][], int x, int y) {
        
        Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
        q. add(new ArrayList(Arrays.asList(x,y)));
       
        while(!q.isEmpty()) {
            ArrayList<Integer> front = q.remove();
            currMax++;
            visited[front.get(0)][front.get(1)] = true;
            if (isValid(a,visited, front.get(0)+1, front.get(1))) {
                q. add(new ArrayList(Arrays.asList(front.get(0)+1, front.get(1))));
            }
            if (isValid(a,visited, front.get(0), front.get(1)+1)) {
                q. add(new ArrayList(Arrays.asList(front.get(0), front.get(1)+1)));
            }
            if (isValid(a,visited, front.get(0)-1, front.get(1))) {
                q. add(new ArrayList(Arrays.asList(front.get(0)-1, front.get(1))));
            }
            if (isValid(a,visited, front.get(0), front.get(1)-1)) {
                q. add(new ArrayList(Arrays.asList(front.get(0), front.get(1)-1)));
            }
        }
        
    }
    
    public boolean isValid(int a[][], boolean visited[][], int x, int y) {
        if (x <0 || x >= a.length || y < 0 || y >= a[0].length) {
            return false;
        }
        if (visited[x][y] || a[x][y] == 0) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[][] = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        boolean visited[][] = new boolean[a.length][a[0].length];
        int maxArea = Integer.MIN_VALUE;
        MaxAreaOfIsland obj = new MaxAreaOfIsland();
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                if (!visited[i][j] && a[i][j] == 1) {
                    obj.currMax = 0;
                    obj.getArea(a, visited, i, j);
                    if (obj.currMax > maxArea) {
                        maxArea = obj.currMax;
                    }
                }
            }
        }
        
        System.out.println("Max area = " + maxArea);
    }

}
