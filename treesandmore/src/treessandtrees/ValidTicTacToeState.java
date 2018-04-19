package treessandtrees;

public class ValidTicTacToeState {
    
    public boolean isValid(String a[]) {
        if (a.length != 3) {
            return false;
        }
        
        int x[][] = new int [3][3];
        int o[][] = new int [3][3];
        int xTurn = 0;
        
        for(int i=0;i<3;i++) {
            String row = a[i];
            for(int j=0;j<row.length();j++) {
                if (row.charAt(j) == 'X') {
                    x[i][j] = 1;
                    xTurn++;
                }
                if (row.charAt(j) == 'O') {
                    o[i][j] = 1;
                    xTurn--;
                }
            }
        }
        
        boolean xWin = (
                (x[0][0] == 1 && x[0][1] == 1 && x[0][2] == 1) || 
                (x[1][0] == 1 && x[1][1] == 1 && x[1][2] == 1) || 
                (x[2][0] == 1 && x[2][1] == 1 && x[2][2] == 1) || 
                (x[0][0] == 1 && x[1][0] == 1 && x[2][0] == 1) || // cols
                (x[0][1] == 1 && x[1][1] == 1 && x[2][1] == 1) || 
                (x[0][2] == 1 && x[1][2] == 1 && x[2][2] == 1) || 
                (x[0][0] == 1 && x[1][1] == 1 && x[2][2] == 1) || // diag 
                (x[0][2] == 1 && x[1][1] == 1 && x[2][0] == 1));
                
        boolean oWin = (
                (o[0][0] == 1 && o[0][1] == 1 && o[0][2] == 1) || 
                (o[1][0] == 1 && o[1][1] == 1 && o[1][2] == 1) || 
                (o[2][0] == 1 && o[2][1] == 1 && o[2][2] == 1) || 
                (o[0][0] == 1 && o[1][0] == 1 && o[2][0] == 1) || // cols
                (o[0][1] == 1 && o[1][1] == 1 && o[2][1] == 1) || 
                (o[0][2] == 1 && o[1][2] == 1 && o[2][2] == 1) || 
                (o[0][0] == 1 && o[1][1] == 1 && o[2][2] == 1) || // diag 
                (o[0][2] == 1 && o[1][1] == 1 && o[2][0] == 1));
        
        if (!xWin && xTurn != 0) {
            return false;
        }
        if (xWin && xTurn != 1) {
            return false;
        }
        
        if (xWin && oWin) {
            return false;
        }
        if (xWin && xTurn == 1 && !oWin) {
            return true;
        }
        if (oWin && xTurn == 0 && !xWin) {
            return true;
        }
        if (!xWin && !oWin && xTurn == 0) {
            return true;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ValidTicTacToeState obj = new ValidTicTacToeState();
        String a[] = {"XXX", "O O", "XOX"};
        System.out.println(obj.isValid(a));
    }

}
