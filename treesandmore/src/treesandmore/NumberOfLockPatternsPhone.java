package treesandmore;

public class NumberOfLockPatternsPhone {
    public static int patternsTillNow=0;
    public static void findNumberOfLockPatterns(int x, int y, int[][] keypad, int[][] visited, int num, int count)  {
        if (x<0 || x>= keypad.length || y<0 || y>=keypad[0].length) {
            return;
        }
        if (visited[x][y] == 1) {
            return;
        }
        count++;
        visited[x][y] = 1;
        if (count == num) {
            patternsTillNow++;
            // if u want to see patterns
//            for(int i=0;i<keypad.length;i++) {
//                for(int j=0;j<keypad[0].length;j++) {
//                    System.out.print(visited[i][j] + ", ");
//                }
//                System.out.println();
//            }
//            System.out.println("======");
        }
        findNumberOfLockPatterns(x-1,y,keypad,visited,num,count);
        findNumberOfLockPatterns(x-1,y-1,keypad,visited,num,count);
        findNumberOfLockPatterns(x,y-1,keypad,visited,num,count);
        findNumberOfLockPatterns(x+1,y-1,keypad,visited,num,count);
        findNumberOfLockPatterns(x,y+1,keypad,visited,num,count);
        findNumberOfLockPatterns(x+1,y+1,keypad,visited,num,count);
        findNumberOfLockPatterns(x,y+1,keypad,visited,num,count);
        findNumberOfLockPatterns(x-1,y+1,keypad,visited,num,count);
        visited[x][y] = 0; // backtrack
        count=0;
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int keypad[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
        int visited[][] = new int[keypad.length][keypad[0].length];
        int exactNumOfButtons = 3;
        for(int i=0;i<keypad.length;i++) {
            for(int j=0;j<keypad[0].length;j++) {
                findNumberOfLockPatterns(i,j, keypad, visited, exactNumOfButtons, 0);
                // use this if u want number of patterns in range of min=a and max=b
//                findNumberOfLockPatterns(i,j, keypad, visited, exactNumOfButtons+1, 0);
//                findNumberOfLockPatterns(i,j, keypad, visited, exactNumOfButtons+1, 0);
//                findNumberOfLockPatterns(i,j, keypad, visited, exactNumOfButtons+1, 0);
            }
        }
        System.out.println(patternsTillNow);
    }

}
