package nontrees;



import java.util.*;


class ValidSudoku {
    public static void main(String args[]) {
        
        int board[][] = {
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9} 
        };
        ValidSudoku obj = new ValidSudoku();
        
        boolean isValidSudoKu = obj.isValid(board);
        if (isValidSudoKu) {
            System.out.println("Valid sudoku");
        } else {
            System.out.println("Invalid Sudoku");
        }
        
    }
    
    public boolean isValid(int a[][]) {
        if (areSquaresValid(a) && areColumnsValid(a) && areRowsValid(a)) {
            return true;
        }
        return false;
    }
    public boolean areColumnsValid(int a[][]) {
        HashSet<Integer> nums = new HashSet<Integer>();
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                nums.add(a[j][i]);
            }
            for(int k=1;k<=9;k++) {
                if (!nums.contains(k)) {
                    return false;
                }
            }
            nums.clear();
        }
        return true;
        
    }
    
    public boolean areRowsValid(int a[][]) {
        HashSet<Integer> nums = new HashSet<Integer>();
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                nums.add(a[i][j]);
            }
            for(int k=1;k<=9;k++) {
                if (!nums.contains(k)) {
                    return false;
                }
            }
            nums.clear();
        }
        return true;
    }
    
    public boolean areSquaresValid(int a[][]) {
        HashSet<Integer> nums = new HashSet<Integer>();
        int squareColStart = 0;
        int squareRowStart = 0;
        
        int squareColEnd = 3;
        int squareRowEnd = 3;
        
        int counter = 0;
        
        while(squareColEnd < 9 && squareColEnd < 9) {
            for(int i=squareRowStart;i< squareRowEnd;i++) {
                for(int j=squareColStart;j < squareColEnd ;j++) {
                    nums.add(a[i][j]);
                }
            } // got required square
            counter++;
            for(int k=1;k<=9;k++) {
                if (!nums.contains(k)) {
                    return false;
                }
            }
            nums.clear();
            squareColStart+=3;
            squareColEnd+=3;
            if (counter % 3 == 0) {
                squareRowStart+=3;
                squareRowEnd+=3;
                // move to col zero
                squareColStart =0;
                squareColEnd = 3;
            }
        }
        return true;
    }
}




