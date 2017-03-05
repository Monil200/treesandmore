package aaplQuYelBay;

public class PallindromicPathsInMatrix {
    
    public void allPaths(char[][] m, int i, int j, int visited[][], String s) {
        if (i >= m.length || j >= m[0].length || visited[i][j] == 1) {
            return;
        }
//        System.out.println("i:" + i + "j:" + j);
        s += (m[i][j] + "");
        visited[i][j] = 1;
        if (i == m.length-1 && j == m[0].length-1) {
            System.out.println(s);
//            return;
        }
        allPaths(m, i+1, j, visited, s);
        allPaths(m, i, j+1, visited, s);
        visited[i][j] = 0;
        // lets see if we need to do backtrack, no i guess
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PallindromicPathsInMatrix obj = new PallindromicPathsInMatrix();
        char[][] m = { {'a', 'a', 'a', 'b'},
                {'b', 'a', 'a', 'a'},
                {'a', 'b', 'b', 'a'}
                };
        int visited[][] = new int[m.length][m[0].length];
        obj.allPaths(m, 0, 0, visited, "");
    }

}
