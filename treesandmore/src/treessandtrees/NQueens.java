package treessandtrees;

import java.util.Arrays;

import nontrees.NQueen;

public class NQueens {
    public boolean isValidPosition(int a[][], int x ,int y) {
        for(int i=0;i<a[0].length;i++) { // same row
            if (a[x][i] == 1) {
                return false;
            }
        }
        for(int i=x-1,j=y-1;i>=0 && j>=0; i--, j--) { // diagonal 00 to nn
            if (a[i][j] == 1) {
                return false;
            }
        }
        
        for(int i=x+1,j=y-1;i<a.length && j>=0 ; i++, j--) { // diagonal xy to n0
            if (a[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    public boolean formNQueens(int a[][], int y) {
        if (y >= a[0].length)
            return true;
        for(int x=0;x<a.length;x++) {
            System.out.println("x:" + x + " y:" + y);
            if(isValidPosition(a,x,y)) {
                a[x][y] = 1;
                if (formNQueens(a, y+1))
                    return true;
            }
            System.out.println("undo x:" + x + " undo y:" + y);
            a[x][y] = 0;
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
        NQueens obj = new NQueens();
        obj.formNQueens(a,0);
//        obj.solveNQueen(0,a);
        for(int i=0;i<a.length;i++)
            System.out.println(Arrays.toString(a[i]));
    }

}
