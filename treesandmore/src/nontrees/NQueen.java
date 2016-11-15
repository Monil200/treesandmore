package nontrees;
import java.util.*;
public class NQueen {
    
    int N;
    
    public boolean isSafe(int row, int col, int[][] a) {
        
        for(int i=0;i<N;i++) { // same row?
            if (a[row][i] == 1) {
                return false;
            }
        }
        
        for(int i=0, j=0; i<N && j<col; i++, j++) { // diagonal from top left to bottom right
            if (a[i][j] == 1) {
                return false;
            }
        }
        
        for(int i=row+1, j=col-1; i<N && j>=0;i++, j--) { // diagonal from current to bottom left 
            if (a[i][j] == 1) {
                return false;
            }
        }
        
        return true;
        
    }
    
    public boolean solveNQueen(int col, int[][] a) {
        if (col >= N)
            return true;
        
        for(int i=0;i<N;i++) {
            if (isSafe(i, col, a)) {
                a[i][col] = 1;
                if (solveNQueen(col+1, a) == true) {
                    return true;
                }
            }
            
            a[i][col] = 0; // backtrack
        }
        return false;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[][] = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
            };
        NQueen obj = new NQueen();
        obj.N = 4;
        obj.solveNQueen(0, a);
        for(int i=0;i<obj.N;i++)
            System.out.println(Arrays.toString(a[i]));
    }

}
