package treessandtrees;
//http://buttercola.blogspot.com/2016/06/leetcode-329-longest-increasing-path-in.html
    
public class LongestIncreasingpathMatrix {
    int maxLength = 0;
    public void longestPath(int a[][], int x, int y, int currLength, int prevVal) {
        if (x < 0 || x >= a.length || y < 0 || y >= a[0].length) {
            return;
        }
        if (a[x][y] <= prevVal && prevVal != -1) {
            return;
        }
        currLength++;
        if (maxLength<currLength) {
            maxLength = currLength;
        }
        longestPath(a, x+1, y, currLength, a[x][y]);
        longestPath(a, x, y+1, currLength, a[x][y]);
        longestPath(a, x-1, y, currLength, a[x][y]);
        longestPath(a, x, y-1, currLength, a[x][y]);
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[][] = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        LongestIncreasingpathMatrix obj = new LongestIncreasingpathMatrix();
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[i].length;j++) {
                obj.longestPath(a, i,j,0, -1);
                System.out.println("Longest poath val is : " + obj.maxLength + " i: "+ i + " j: " + j);
            }
        }
        System.out.println("Longest poath val is : " + obj.maxLength);
    }

}
