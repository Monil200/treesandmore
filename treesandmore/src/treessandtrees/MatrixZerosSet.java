package treessandtrees;

import java.util.Arrays;

public class MatrixZerosSet {
    public void setMatrixRowsColsToZeros(char a[][]) {
        if (a.length == 0 || a[0].length == 0)
            return;
        
        // store states of rows in first col for rows
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[i].length;j++) {
                if (a[i][j] == '0') {
                    a[i][0] = 'd';
                    break;
                }
            }
        }
        
        // store states of cols in first rows
        for(int i=0;i<a[0].length;i++) {
            for(int j=0;j<a.length;j++) {
                if (a[j][i] == '0') {
                    a[0][i] = 'd';
                    break;
                }
            }
        }
        
        for(int i=0;i<a.length;i++) {
            System.out.println(Arrays.toString(a[i])); // then walk through first row and first col, wherever d is found make entire row/col as 0
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char a[][] = {
                {'1', '0', '1', '1', '0'},
                {'1', '0', '0', '1', '1'},
                {'1', '1', '1', '1', '0'}
                };
        MatrixZerosSet obj = new MatrixZerosSet();
        obj.setMatrixRowsColsToZeros(a);
    }

}
