package nontrees;
import java.util.*;
class Location {
    int x;
    int y;
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class RottenOranges {
    
    public void getTimeFrameToRotAll(int[][] basket) {
        Queue<Location> q = new LinkedList<Location>();
        int visited[][] = new int[basket.length][basket[0].length];
        int passCount = 0;
        
        // add all initial rotten to queue
        for(int i=0;i<basket.length;i++) {
            for(int j=0;j<basket[0].length;j++) {
                if (basket[i][j] == 2) {
                    visited[i][j] = 1;
                    q.add(new Location(i,j));
                }
            }
        }
        
        for(Location x: q) {
            System.out.println(x.x + "- " + x.y);
        }
        
        while(!q.isEmpty()) {
            int qCount = q.size();
            while(qCount>0) {
                Location temp = q.poll();
                System.out.println(" temp x:" + temp.x + " temp.y" + temp.y);
                qCount--;
                if (isValid(temp.x-1, temp.y, basket)) {
                    if (visited[temp.x-1][temp.y] == 0 && basket[temp.x-1][temp.y] == 1) {
                        basket[temp.x-1][temp.y] = 2;
                        q.add(new Location(temp.x-1, temp.y));
                    }
                }
                if (isValid(temp.x+1, temp.y, basket)) {
                    if (visited[temp.x+1][temp.y] == 0 && basket[temp.x+1][temp.y] == 1) {
                        basket[temp.x+1][temp.y] = 2;
                        q.add(new Location(temp.x+1, temp.y));
                    }
                }
                if (isValid(temp.x, temp.y-1, basket)) {
                    if (visited[temp.x][temp.y-1] == 0 && basket[temp.x][temp.y-1] == 1) {
                        basket[temp.x][temp.y-1] = 2;
                        q.add(new Location(temp.x, temp.y-1));
                    }
                }
                if (isValid(temp.x, temp.y+1, basket)) {
                    if (visited[temp.x][temp.y+1] == 0 && basket[temp.x][temp.y+1] == 1) {
                        basket[temp.x][temp.y+1] = 2;
                        q.add(new Location(temp.x, temp.y+1));
                    }
                }
            }
            passCount++;
            if (allRotten(basket)) {
                System.out.println("We have rotten all oranges in : " + passCount + " time frames");
                break;
            }
        }
        if (!allRotten(basket)) {
            System.out.println("We cannot all oranges even after : " + passCount + " time frames");
        }
        
    }
    
    public boolean isValid(int i, int j, int[][] basket) {
        if (i < 0 || i >= basket.length || j < 0 || j >= basket[0].length) {
            return false;
        }
        return true;
    }
    public boolean allRotten(int[][] basket) {
        for(int i=0;i<basket.length;i++) {
            for(int j=0;j<basket[i].length;j++) {
                if (basket[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int basket[][] = { // basket of oranges. 2. rotten, 1 - good, 0 - empty space.
//                {2, 1, 0, 2, 1},
//                {1, 0, 1, 2, 1},
//                {1, 0, 0, 2, 1}
//        };
        
        int basket[][] = {{2, 1, 0, 2, 1},
                {0, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        
        RottenOranges obj = new RottenOranges();
        obj.getTimeFrameToRotAll(basket);
        
    }

}
