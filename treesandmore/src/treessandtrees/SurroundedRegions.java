package treessandtrees;

import java.util.Arrays;

/*
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 */
public class SurroundedRegions {
    
    public boolean flip(char a[][], boolean visited[][], int x, int y) {
        if (x < 0 || x >= a.length || y < 0 || y >= a[0].length) {
            return false;
        }
        if (a[x][y] == 'X' || visited[x][y]) {
            return true;
        }
        visited[x][y] = true;
        boolean shouldFlip = flip(a,visited,x+1, y) && flip(a,visited,x-1, y) && flip(a,visited,x, y-1) && flip(a,visited,x, y+1);
        if (shouldFlip) {
            a[x][y] = 'X';
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SurroundedRegions obj = new SurroundedRegions();
        char a[][] = {
                {'X','X','X','X','X'},
                {'X','O','O','O','X'},
                {'X','X','X','O','X'},
                {'X','O','X','X','X'}
        };
        boolean visited[][] = new boolean[a.length][a[0].length];
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                if (a[i][j] == 'O' && !visited[i][j]) {
                    boolean shouldFlip = obj.flip(a,visited,i,j);
                    if (shouldFlip) {
                        a[i][j] = 'X';
                    }
                }
            }
        }
        
        for(int i=0;i<a.length;i++) {
            System.out.println(Arrays.toString(a[i]));
        }

    }

}
