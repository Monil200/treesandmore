package treessandtrees;
//https://www.geeksforgeeks.org/find-shortest-distance-guard-bank/
import java.util.*;
class Position {
    int x,y,distance;
    Position(int xp, int yp, int d) {
        x= xp;
        y = yp;
        distance = d;
    }
}

public class GuardsAndWalls {
    
    public void getMinDistance(char a[][]) {
        
        boolean visited[][] = new boolean[a.length][a[0].length];
        int res[][] = new int[a.length][a[0].length];
        Queue<Position> q = new LinkedList<Position>();
        
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                if (a[i][j] == 'G') {
                    q.add(new Position(i,j,0));
                    System.out.println("Adding x:" + i + " y:" + j);
                }
            }
        }
        
        
        while(!q.isEmpty()) {
            Position front = q.poll();
            if (!visited[front.x][front.y]) {
                visited[front.x][front.y] = true;
                res[front.x][front.y] = front.distance;
                int currX = front.x;
                int currY = front.y;
                if (isValidCoord(currX+1, currY, a, visited)) { // down
                    q.add(new Position(currX+1, currY, front.distance+1));
                    res[currX+1][currY] =  front.distance+1;
                }
                if (isValidCoord(currX-1, currY, a,visited)) { // up
                    q.add(new Position(currX-1, currY, front.distance+1));
                    res[currX-1][currY] =  front.distance+1;
                }
                if (isValidCoord(currX, currY-1, a,visited)) { // left
                    q.add(new Position(currX, currY-1, front.distance+1));
                    res[currX][currY-1] =  front.distance+1;
                }
                if (isValidCoord(currX, currY+1, a,visited)) { // right
                    q.add(new Position(currX, currY+1, front.distance+1));
                    res[currX][currY+1] =  front.distance+1;
                }
            }
        }
        
        // print result
        for(int i=0;i<res.length;i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        
    }
    
    public boolean isValidCoord(int x,int y, char a[][], boolean visited[][]) {
        if (x < 0 || x >= a.length || y < 0 || y >= a[0].length) {
            return false;
        }
        if (a[x][y] == 'W') {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        return true;
    }
    public static void main(String args[]) {
        char input[][] = {
                {'O','O','O','O','G'},
                {'O','W','W','O','O'},
                {'O','O','O','W','O'},
                {'G','W','W','W','O'},
                {'O','O','O','O','G'}
        };
        GuardsAndWalls obj = new GuardsAndWalls();
        obj.getMinDistance(input);
    }
}
