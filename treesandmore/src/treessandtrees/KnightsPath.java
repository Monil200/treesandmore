package treessandtrees;

import java.util.Arrays;

// can knight cover all positions on chess board from a given position.?
public class KnightsPath {
    
    public void travel(int a[][], int x,int y, int level) {
        if (x < 0 || x >= a.length || y < 0 || y >= a[0].length) {
            return;
        }
        if (a[x][y] == 1 || level > 64) {
            return; // already visited
        }
        level++;
        a[x][y] = 1;
        if (level == (a.length * a[0].length)) {
            for(int i=0;i<a.length;i++) {
                System.out.println(Arrays.toString(a[i]));
            }
            return;
        }
        travel(a, x+1, y+2, level);
        travel(a, x+2, y+1, level);
        travel(a, x+2, y-1, level);
        travel(a, x+1, y-2, level);
        travel(a, x-1, y-2, level);
        travel(a, x-2, y-1, level);
        travel(a, x-2, y+1, level);
        travel(a, x-1, y+2, level);
        --level;
        a[x][y] = 0;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        KnightsPath obj = new KnightsPath();
        int a[][] = {
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0}
        };
        obj.travel(a, 0, 0, 0);
    }

}
