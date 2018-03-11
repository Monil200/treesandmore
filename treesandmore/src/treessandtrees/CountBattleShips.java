package treessandtrees;
// similar to count islands, there is DP solution to this.
import java.util.*;
class Point {
    int x,y;
    Point(int xx, int yy) {
        x = xx;
        y = yy;
    }
}
public class CountBattleShips {
    
    
    public int getBattleShipCounts(char a[][], int x, int y, boolean visited[][]) {
        
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(x,y));
        
        while(!q.isEmpty()) {
            Point front = q.remove();
            visited[front.x][front.y] = true;
            if (isValid(a,front.x+1,front.y, visited)) {
                q.add(new Point(front.x+1,front.y));
            }
            if (isValid(a,front.x,front.y+1, visited)) {
                q.add(new Point(front.x,front.y+1));
            }
            if (isValid(a,front.x-1,front.y, visited)) {
                q.add(new Point(front.x-1,front.y));
            }
            if (isValid(a,front.x,front.y-1, visited)) {
                q.add(new Point(front.x,front.y-1));
            }
        }
        return 1;
        
    }
    
    public boolean isValid(char a[][], int x, int y, boolean visited[][]) {
        if (x <0 || x >= a.length || y < 0 || y >=a[0].length) {
            return false;
        }
        if (visited[x][y] || a[x][y] != 'X')
            return false;
        return true;
    }
    public static void main(String[] args) {
        CountBattleShips obj = new CountBattleShips();
        char a[][] = {
                {'X', '.', '.', 'X'},
                {'X', '.', '.', 'X'},
                {'X', '.', '.', 'X'},
                {'X', '.', '.', 'X'}
        };
        boolean visited[][] = new boolean[a.length][a[0].length];
        int result = 0;
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                if (!visited[i][j] && a[i][j] == 'X') {
                    result += obj.getBattleShipCounts(a,i,j,visited);
                }
            }
        }
        
        System.out.println("Number of battleShips are: " + result);
    }

}
