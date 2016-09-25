package treesandmore;

public class NumberOfIslands {
    public static int a[][] = {
        {1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1},
        {0, 0, 0, 0, 0},
        {1, 1, 0, 0, 1}
    };
    public static int visited[][] = new int[a.length][a[0].length];
    
    public void markVisited(int i, int j) {
        
        //mark visited neighbors
        try {visited[i-1][j-1] = 1;} catch (Exception e) {}
        try {visited[i-1][j] = 1;} catch (Exception e) {}
        try {visited[i-1][j+1] = 1;} catch (Exception e) {}
        try {visited[i][j-1] = 1;} catch (Exception e) {}
        try {visited[i][j] = 1;} catch (Exception e) {}
        try {visited[i][j+1] = 1;} catch (Exception e) {}
        try {visited[i+1][j-1] = 1;} catch (Exception e) {}
        try {visited[i+1][j] = 1;} catch (Exception e) {}
        try {visited[i+1][j+1] = 1;} catch (Exception e) {}
    }
    public void countIslands() {
        int islandCount = 0;
        // we have to start from 1,1 and not 0,0 because we have to look at all 8 neighbors to start marking as visited.
        // In this process of marking visited neighbors we miss the topmost and leftmost (not all of them) cells and hence they...
        // ... have to taken care separately.
        for(int i=1;i<a.length;i++) {
            for(int j=1;j<a[0].length;j++) {
                if (a[i][j] == 1 && visited[i][j] == 0) {
                    System.out.println("i:" + i + "j:" + j + " islandCount:" + islandCount);
                    markVisited(i,j);
                    islandCount++;
                }
            }
        }
        // check for topmost row
        for(int i=0;i<a.length;i++) {
            if (a[i][0] == 0 && visited[i][0] == 0) {
                markVisited(i,0);
                islandCount++;
            }
        }
       // check for leftmost column
        for(int i=0;i<a[0].length;i++) {
            if (a[0][i] == 0 && visited[0][i] == 0) {
                markVisited(0,i);
                islandCount++;
            }
        }
        System.out.println("Numbers of Islands are :" + islandCount);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NumberOfIslands obj = new NumberOfIslands();
        obj.countIslands();
    }

}
