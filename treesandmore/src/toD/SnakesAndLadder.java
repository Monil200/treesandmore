package toD;
import java.util.*;
class Move {
    int val;
    int stepCount;
    Move(int a, int b) {
        val = a;
        stepCount = b;
    }
}
public class SnakesAndLadder {
    
    
    public void getMinMoves(int a[], int moves[], int start) {
        if (start >= a.length) {
            return; // illegal start
        }
        
        Queue<Move> q = new LinkedList<Move>();
        q.add(new Move(start, 0));
        boolean visited[] = new boolean[a.length];
        visited[start] = true;
        Move current = null, next = null;
        while(!q.isEmpty()) {
            current = q.remove();
            System.out.println("Removed:" + current.val);
            for(int i=1;i<7;i++) {
                if (current.val + i < a.length && (current.val + moves[current.val] < a.length)) {
                    if (moves[current.val] > 0) {
                        next = new Move(moves[current.val], current.stepCount+1);
                    } else {
                        next = new Move(current.val + i, current.stepCount+1);
                    }
                    
                    if (next.val == a.length-1) {
                        System.out.println("We reached target:" + a.length + " in " + next.stepCount + " steps!!");
                        System.out.println("Next val was target:" + next.val);
                        return;
                    } else if (!visited[next.val]) {
                        visited[next.val] = true;
                        q.add(next);
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SnakesAndLadder obj = new SnakesAndLadder();
        int board[] = new int[9];
        int moves[] = new int[board.length];
        // up moves
        moves[1] = 7;
        
        obj.getMinMoves(board, moves, 0);
        
        
    }

}
