package graphs;
import java.util.*;
class Cell {
    int val;
    int distance;
}
public class SnakeAndLadder {
    int V;
    
    public SnakeAndLadder(int v) {
        V = v; // no of cells on board
    }
    
    public void minStepsToReachTarget(Cell start, int [] visited, int[] moves) {
        Queue<Cell> q = new LinkedList<Cell>();
        q.add(start);
        while(!q.isEmpty()) {
            Cell temp = q.poll();
            visited[temp.val] = 1;
            int val = temp.val;
            if (val == this.V -1) {
                System.out.println("We reached target with distance: " + temp.distance);
                break;
            }
            for(int i=val+1;i<=(val+6) && i< V; i++) {
                Cell newCell = new Cell();
                newCell.distance = temp.distance + 1;
                newCell.val = i;
                if (moves[i] != 0) {
                    newCell.val = moves[i]; // either snake or ladder
                }
                if (visited[newCell.val] == 0) {
                    q.add(newCell);
                }
            }
        }
    }
    
    void DFS(Cell start, int[] moves) {
        int visited[] = new int[V];
        minStepsToReachTarget(start, visited, moves);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SnakeAndLadder obj = new SnakeAndLadder(30);
        Cell first = new Cell();
        first.val = 0;
        first.distance = 0;
        int moves[] = new int[obj.V];
        // ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;
        
        // snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;
        obj.DFS(first, moves);
    }

}
