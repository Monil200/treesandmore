package treessandtrees;
import java.util.*;
public class DiagonalTraversal {
    List<Integer> hold;
    DiagonalTraversal() {
        hold = new ArrayList<Integer>();
    }
    public void traverseDiagonal(int a[][], int x, int y) {
        while(x<a.length && y>=0) {
            hold.add(a[x][y]);
            x++;
            y--;
        }
    }
    
    public void showNormal(List<Integer> a) {
        if (a == null || a.size() == 0)
            return;
        int size = hold.size();
        for(int j=0;j<size;j++) {
            System.out.print(hold.get(j) + ", ");
        }
        System.out.println();
    }
    public void showReverse(List<Integer> a) {
        if (a == null || a.size() == 0)
            return;
        int size = hold.size();
        for(int j=size-1;j>=0;j--) {
            System.out.print(hold.get(j) + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DiagonalTraversal obj = new DiagonalTraversal();
        int a[][] = {
                {1,2,3,11},
                {4,5,6,11},
                {7,8,9,11},
                {10,11,12,11}
        };
        int counterMod = 0;
        for(int i=0;i<a[0].length;i++) {
            obj.traverseDiagonal(a, 0, i);
            if (counterMod % 2 == 0) {
                obj.showNormal(obj.hold);
                counterMod++;
            } else {
                obj.showReverse(obj.hold);
                counterMod++;
            }
            obj.hold.clear();
        }
        
        for(int i=1;i<a.length;i++) {
            obj.traverseDiagonal(a, i, a[0].length-1);
            if (counterMod % 2 == 0) {
                obj.showNormal(obj.hold);
                counterMod++;
            } else {
                obj.showReverse(obj.hold);
                counterMod++;
            }
            obj.hold.clear();
        }
    }

}
