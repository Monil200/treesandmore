package treesandmore;

public class SpiralMatrixPrint {
    static int a[][] = {{1,  2,  3,  4,  5,  6},
            {7,  8,  9,  10, 11, 12},
            {71,  81,  91,  101, 111, 121},
            {13, 14, 15, 16, 17, 18}
        };
    static int topRow = 0;
    static int rightCol = a[0].length -1;
    static int bottomRow = a.length -1;
    static int leftCol = 0;
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        while (topRow <= bottomRow  && rightCol >= leftCol) {
            printTopRow();
            printRightCol();
            printBottomRow();
            printLeftCol();
        }
            
       
    }
    
    public static void printTopRow() {
        for(int i=topRow; i<=rightCol;i++) {
            System.out.print(a[topRow][i] + " , ");
        }
        topRow++;
    }
    
    public static void printRightCol() {
        for(int i=topRow; i<=bottomRow;i++) {
            System.out.print(a[i][rightCol] + " , ");
        }
        rightCol--;
    }
    
    public static void printBottomRow() {
        if (bottomRow > topRow) {
            for(int i=rightCol; i>=leftCol;i--) {
                System.out.print(a[bottomRow][i] + " , ");
            }
            bottomRow--;
        }
    }
    
    public static void printLeftCol() {
        if (leftCol < rightCol) {
            for(int i=bottomRow; i>=topRow;i--) {
                System.out.print(a[i][leftCol] + " , ");
            }
            leftCol++;
        }
    }

}
