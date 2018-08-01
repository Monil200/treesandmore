package treessandtrees;

import java.util.Arrays;

// can knight cover all positions on chess board from a given position.?
public class KnightsPath {
    public static int level = 0;
    public void travel(int a[][], int x,int y) {
        if (x < 0 || x >= a.length || y < 0 || y >= a[0].length) {
            return;
        }
        if (a[x][y] > 0) {
            return; // already visited
        }
        level++;
        a[x][y] = level;
        if (level >= 63) {
            for(int i=0;i<a.length;i++) {
                System.out.println(Arrays.toString(a[i]));
            }
        }

        travel(a, x+1, y+2);
        travel(a, x+2, y+1);
        travel(a, x+2, y-1);
        travel(a, x+1, y-2);
        travel(a, x-1, y-2);
        travel(a, x-2, y-1);
        travel(a, x-2, y+1);
        travel(a, x-1, y+2);
//        --level;
//        a[x][y] = 0;
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
        obj.travel(a, 0, 0);
        
    }

}
