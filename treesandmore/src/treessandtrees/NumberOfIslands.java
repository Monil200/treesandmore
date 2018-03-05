package treessandtrees;
import java.util.*;
class Coords {
    int x,y;
    Coords(int xp, int yp) {
        x = xp;
        y = yp;
    }
}
public class NumberOfIslands {
    public void numberOfIslands(int a[][], Queue<Coords> q, boolean visited[][]) {
        // do bfs
        
        while(!q.isEmpty()) {
            Coords front = q.remove();
            visited[front.x][front.y] = true;

            if (isValid(front.x+1, front.y, visited, a)) {
                q.add(new Coords(front.x+1, front.y));
            }

            if (isValid(front.x-1, front.y, visited,a)) {
                q.add(new Coords(front.x-1, front.y));
            }

            if (isValid(front.x, front.y+1, visited, a)) {
                q.add(new Coords(front.x, front.y+1));
            }

            if (isValid(front.x, front.y-1, visited,a)) {
                q.add(new Coords(front.x, front.y-1));
            }
        }
        
    }
    
    public boolean isValid(int x,int y, boolean visited[][], int a[][]) {
        if (x < 0 || x>= visited.length || y < 0 || y >=visited[0].length) {
            return false;
        }
        if (a[x][y] == 0) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NumberOfIslands obj = new NumberOfIslands();
        int a[][] = {
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1}
        };
        boolean visited[][] = new boolean[a.length][a[0].length];
        Queue<Coords> q = new LinkedList<Coords>();
        int islandCount = 0;
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                if (!visited[i][j] && a[i][j] == 1) {
                    System.out.println("Adding x:" + i + " y:" + j);
                    q.add(new Coords(i,j));
                    islandCount++;
                    obj.numberOfIslands(a, q, visited);
                }
            }
        }
        System.out.println("Island count is:" + islandCount);
    }

}
