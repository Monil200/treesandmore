package treessandtrees;
import java.util.*;

class Square {
    int start, end, height;
    Square() {}
    Square(int l, int h) {
        start = l;
        height = h;
        end = start + height;
    }
}
public class FallingSquares {
    
    public void maxSquaresHeightinGameSoFar(int a[][]) { 
        if (a.length == 0)
            return;
        
        ArrayList<Square> squares = new ArrayList<Square>();
        for(int i=0;i<a.length;i++) {
            squares.add(new Square(a[i][0], a[i][1]));
        }
        
        
        for(Square i : squares) {
            System.out.println("start:" + i.start + " height:" + i.height + " end:" + i.end);
        }
        
        int res[] = new int[a.length];
        res[0] = squares.get(0).height;
        int maxSoFar = res[0];
        
        for(int i=1;i<squares.size();i++) {
            if (squares.get(i).start < squares.get(i-1).end) {
                res[i] = Math.max(squares.get(i).height + res[i-1], maxSoFar);
            } else {
                res[i] = Math.max(squares.get(i).height, maxSoFar);
            }
            if (res[i] > maxSoFar) {
                maxSoFar = res[i];
            }
        }
        System.out.println("Max heights at each fall of square:");
        System.out.println(Arrays.toString(res));
        
    }
    public static void main(String args[]) {
        int a[][] = {{1,2}, {2,10}, {13,1}};
        FallingSquares obj = new FallingSquares();
        obj.maxSquaresHeightinGameSoFar(a);
    }
}
