package nontrees;
import java.util.*;

class NodeG {
    int x,y,distance;
    public NodeG() {
        this.distance = 0;
    }
}

public class DistanceFromGuardQueue {
    
    char a[][] = {
            {'O', 'O', 'O', 'O', 'G'},
            {'O', 'W', 'W', 'O', 'O'},
            {'O', 'O', 'O', 'W', 'O'},
            {'G', 'W', 'W', 'W', 'O'},
            {'O', 'O', 'O', 'O', 'G'}
        };
    int visited[][] = new int[a.length][a[0].length];
    int output[][] = new int[a.length][a[0].length];
    public DistanceFromGuardQueue() {
        
    }
    
    public void claculateDistance() {
        Queue<NodeG> q = new LinkedList<NodeG>();
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[i].length;j++) {
                if (a[i][j] == 'G') {
                    NodeG guard = new NodeG();
                    guard.x = i;
                    guard.y = j;
                    guard.distance = 0;
                    q.add(guard);
                    visited[i][j] = 1;
                }
            }
        } // add all guards initially;
        
        
        while(!q.isEmpty()) {
            NodeG guard = q.poll();
            System.out.println("x: " + guard.x + " y:" + guard.y);
            int x= guard.x;
            int y= guard.y;
            int tempx, tempy;
            tempx = x-1;tempy = y;
            processCell(tempx,tempy, visited, output, guard, q,a);
            tempx = x;tempy = y-1;
            processCell(tempx,tempy, visited, output, guard, q,a);
            tempx = x+1;tempy = y;
            processCell(tempx,tempy, visited, output, guard, q,a);
            tempx = x;tempy = y+1;
            processCell(tempx,tempy, visited, output, guard, q,a);
        }
    }
    
    public static boolean isValid(int x, int y, char a[][]) {
        if (x >= 0 && x < a.length && y>=0 && y<a[0].length) {
            if (a[x][y] == 'O') {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    
    public static void processCell(int x, int y, int visited[][], int output[][], NodeG guard, Queue<NodeG> q, char[][] a) {
        if (isValid(x, y, a)) {
            if (visited[x][y] == 0) {
                output[x][y] = Math.abs(guard.x - x) + Math.abs(guard.y - y) + guard.distance;
                visited[x][y] = 1;
                NodeG temp = new NodeG();
                temp.x = x;
                temp.y = y;
                temp.distance = output[x][y];
                System.out.println("Neighbours x: " + x + " y:" + y + " distance?: " + temp.distance);
                q.add(temp);
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DistanceFromGuardQueue obj = new DistanceFromGuardQueue();
        obj.claculateDistance();
        for(int i=0;i<obj.a.length;i++) {
            System.out.println(Arrays.toString(obj.output[i]));
        }
    }

}
