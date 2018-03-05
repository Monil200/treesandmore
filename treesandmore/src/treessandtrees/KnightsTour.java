package treessandtrees;

import java.util.Arrays;

public class KnightsTour {
    
    public void getTour(int a[][], int level, int x, int y, int visited[][]) {
        if (x < 0 || x >= a.length || y < 0 || y >= a[0].length) {
            return;
        }
        if (a[x][y] != 0 || visited[x][y] == 1) {
            return;
        }
        a[x][y] = level;
        visited[x][y] = 1;
        level++;
        getTour(a, level, x+1, y+2, visited);
        getTour(a, level, x+2, y+1, visited);
        getTour(a, level, x+2, y-1, visited);
        getTour(a, level, x+1, y-2, visited);
        getTour(a, level, x-1, y-2, visited);
        getTour(a, level, x-2, y-1, visited);
        getTour(a, level, x-2, y+1, visited);
        getTour(a, level, x-1, y+2, visited);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        KnightsTour obj = new KnightsTour();
        int n = 8;
        int a[][] = new int[n][n];
        int visited[][] = new int[n][n];
        obj.getTour(a, 0, 0, 0, visited);
        for(int i=0;i<n;i++)
            System.out.println(Arrays.toString(a[i]));
    }
}
