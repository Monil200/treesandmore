package dp;
class Game {
    int first, second;
    Game(int f, int s){
        first = f;
        second = s;
    }
}
public class OptimalStrategyForGame {
    
    
    public void canIWin(int a[]) {
        Game opt[][] = new Game[a.length][a.length];
        
        for(int i=0;i<a.length;i++) {
            opt[i][i] = new Game(a[i], 0);
        }
        
        int row =0;
        for(int i=1;i<a.length;i++) {
            opt[row][i] = new Game(Math.max(a[i], a[i-1]), Math.min(a[i], a[i-1]));
            row++;
        }
        
        int widths =1;
        row= 0;
        for(int i=0;i<a.length;i++) { // rows, as 2 bottom rows are taken care of
            widths++;
            row=0;
            for(int j=widths;j<a.length;j++) {
                int option1player1 = a[j] + opt[row][j-1].second;
                int option2player1 = a[j-widths] + opt[row+1][j].second;
                
                int option1player2 = opt[row][j-1].first;
                int option2player2 = opt[row+1][j].first;
                
                if(option1player1 > option2player1) {
                    opt[row][j] = new Game(option1player1, option1player2);
                } else {
                    opt[row][j] = new Game(option2player1, option2player2);
                }
                row++;
            }
        }
        
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a.length;j++) {
                if (opt[i][j] == null) {
                    System.out.print("(NA/NA), ");
                } else {
                    System.out.print("(" + opt[i][j].first + "," +  opt[i][j].second + "), ");
                }
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        OptimalStrategyForGame obj = new OptimalStrategyForGame();
        int a[] = {20,30,2,2,2,10};
        obj.canIWin(a);
    }

}
