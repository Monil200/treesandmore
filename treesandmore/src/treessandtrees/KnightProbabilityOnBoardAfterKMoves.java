package treessandtrees;

import java.util.Arrays;

public class KnightProbabilityOnBoardAfterKMoves {
    
    public void getProbabilityfnBeingOnBoardAfterKMoves(int a[][], int stepCount, int x, int y, int k) {
        if (x < 0 || x >= a.length || y < 0 || y >=a[0].length) {
            return;
        }
        if (stepCount > k) {
            return;
        }
        a[x][y] = stepCount++; // doesnt matter if x,y is already visited, stepCount has ultimate say
        getProbabilityfnBeingOnBoardAfterKMoves(a, stepCount, x-2, y+1, k);
        getProbabilityfnBeingOnBoardAfterKMoves(a, stepCount, x-1, y+2, k);
        getProbabilityfnBeingOnBoardAfterKMoves(a, stepCount, x+1, y+2, k);
        getProbabilityfnBeingOnBoardAfterKMoves(a, stepCount, x+2, y+1, k);
        getProbabilityfnBeingOnBoardAfterKMoves(a, stepCount, x+2, y-1, k);
        getProbabilityfnBeingOnBoardAfterKMoves(a, stepCount, x+1, y-2, k);
        getProbabilityfnBeingOnBoardAfterKMoves(a, stepCount, x-1, y-2, k);
        getProbabilityfnBeingOnBoardAfterKMoves(a, stepCount, x-2, y-1, k);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        KnightProbabilityOnBoardAfterKMoves obj = new KnightProbabilityOnBoardAfterKMoves();
        int a[][] = new int[8][8];
        int k = 4;
        int stepCount = 0;
        obj.getProbabilityfnBeingOnBoardAfterKMoves(a, stepCount, 4, 4, k);
        
        for(int i=0;i<8;i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }

}
