package nontrees;

public class PerimeterOfIsland {
    
    int perimeter=0;
    
    public void findPerimeter(int[][] land, int[][] visited, int i, int j) {
        if (i<0 || i>= land.length || j< 0 || j>=land[0].length) {
            return;
        }
        if (land[i][j] == 0) {
            return;
        }
        if (visited[i][j] ==1) {
            return;
        }
        perimeter += 4;
        if(i-1 >= 0 && land[i-1][j] == 1) {
            perimeter -=1;
        }
        if(i+1 < land.length && land[i+1][j] == 1) {
            perimeter -=1;
        }
        if(j-1 >= 0 && land[i][j-1] == 1) {
            perimeter -=1;
        }
        if(j+1 < land[0].length && land[i][j+1] == 1) {
            perimeter -=1;
        }
        visited[i][j] = 1;
        
        findPerimeter(land, visited, i+1, j);
        findPerimeter(land, visited, i-1, j);
        findPerimeter(land, visited, i, j-1);
        findPerimeter(land, visited, i, j+1);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PerimeterOfIsland obj = new PerimeterOfIsland();
//        int land[][] = {   
//                {0, 1, 0, 0, 0},
//                {1, 1, 1, 0, 0},
//                {1, 0, 0, 0, 0}
//            };
        
        int land[][] = {
                {1, 0},
                {1, 1},
              };
        
        int visited[][] = new int[land.length][land[0].length];
        obj.findPerimeter(land, visited, 0, 0); // 0 , 0 or whatever are the i,j arg, these are first 1 
        System.out.println(obj.perimeter);
        
    }

}
