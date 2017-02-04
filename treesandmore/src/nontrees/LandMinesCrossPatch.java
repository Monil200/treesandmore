package nontrees;
/*
 * Find shortest safe route in a path with landmines
Given a path in the form of a rectangular matrix having few 
landmines arbitrarily placed (marked as 0), 
calculate length of the shortest safe route possible from any cell in the first column 
to any cell in the last column of the matrix. We have to avoid landmines and 
their four adjacent cells (left, right, above and below) as they are also unsafe. 
We are allowed to move to only adjacent cells which are not landmines. i.e. the route cannot contains any diagonal moves.
 */
import java.util.*;
public class LandMinesCrossPatch {
    int shortestPathLength;
    LandMinesCrossPatch() {
        shortestPathLength = Integer.MAX_VALUE;
    }
    public void getShprtestPathAcrossPatch(int patch[][], int currentLength, int i, int j, int visited[][]) {
        if (i<0 || i >= patch.length || j<0 || j >= patch[0].length) {
            return;
        }
        
        if (patch[i][j] == 0) { // landMine
            return;
        }
        if (visited[i][j] == 1) {
            return;
        }
        
        System.out.println("i:" + i + " j:" + j + " currL:" + currentLength);
        currentLength++;
        visited[i][j] = 1;
        if (j == patch[0].length -1) {
            if (currentLength < shortestPathLength) {
                shortestPathLength = currentLength;
            }
            return;
        }
        
        // move to 4 directions
        getShprtestPathAcrossPatch(patch, currentLength, i, j+1, visited);
        getShprtestPathAcrossPatch(patch, currentLength, i+1, j, visited);
        getShprtestPathAcrossPatch(patch, currentLength, i-1, j, visited);
        getShprtestPathAcrossPatch(patch, currentLength, i, j-1, visited);
//        currentLength--; // backTrack
//        visited[i][j] = 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int landPatch[][] = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }
            };
        int visited[][] = new int[landPatch.length][landPatch[0].length];
        LandMinesCrossPatch obj = new LandMinesCrossPatch();
//        for(int i=0;i<landPatch.length;i++) {
            obj.getShprtestPathAcrossPatch(landPatch, 0, 0, 0, visited);
//        }
        
        System.out.println("Shortest path in patch is " + obj.shortestPathLength);
        
    }

}
