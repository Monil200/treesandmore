package treessandtrees;
import java.util.*;

class PairXY {
    int x,y, val;
    PairXY(int xx, int yy, int a[]) {
        x = xx;
        y = yy;
        val = Math.abs(a[x] - a[y]);
    }
}
public class KthSmallestPair {
    
    public void getKthSmallestPair(int a[], int k) {
        
        PriorityQueue<PairXY> pq = new PriorityQueue<PairXY>(
            new Comparator<PairXY>() {
                public int compare(PairXY a, PairXY b) {
                    return a.val - b.val;
                }
            }
        );
        
        pq.add(new PairXY(0,1,a));
        int counter = 0;
        HashSet<String> uniques = new HashSet<String>();
        uniques.add("01");
        uniques.add("10");
        String next = "";
        String nextR = "";
        int newX , newY;
        PairXY pair = null;
        int distance = Integer.MAX_VALUE;
        PairXY result = null;
        while(!pq.isEmpty() && counter<2*k) {
            pair = pq.remove();
            System.out.println("Current Pair is: --- " + a[pair.x] + "-" + a[pair.y]);
            System.out.println(uniques);
            counter++;
            if (counter >= k) {
                if ((int) Math.abs(pair.x - pair.y) < distance) {
                    distance = (int) Math.abs(pair.x - pair.y);
                    result = pair;
                }
            }
            if (pair.x-1 >= 0) { // x decrement, y same
                newX = pair.x -1;
                newY = pair.y;
                next = String.valueOf((newX +""+ newY));
                nextR = String.valueOf((newY +""+ newX));
                if (!uniques.contains(next) && !uniques.contains(nextR) && newX != newY) {
                    uniques.add(next);
                    uniques.add(nextR);
                    pq.add(new PairXY(newX, newY, a));
                }
            }
            if (pair.y-1 >= 0) { // x same, y decrement
                newX = pair.x;
                newY = pair.y-1;
                next = String.valueOf((newX +""+ newY));
                nextR = String.valueOf((newY +""+ newX));
                if (!uniques.contains(next) && !uniques.contains(nextR) && newX != newY) {
                    uniques.add(next);
                    uniques.add(nextR);
                    pq.add(new PairXY(newX, newY, a));
                }
            }
            if ((pair.y+1) < a.length) { // x same, y increment
                newX = pair.x;
                newY = pair.y+1;
                next = String.valueOf((newX +""+ newY));
                nextR = String.valueOf((newY +""+ newX));
                if (!uniques.contains(next) && !uniques.contains(nextR) && newX != newY) {
                    uniques.add(next);
                    uniques.add(nextR);
                    pq.add(new PairXY(newX, newY, a));
                }
            }
            if ((pair.x+1) < a.length) { // x increment, y same
                newX = pair.x+1;
                newY = pair.y;
                next = String.valueOf((newX +""+ newY));
                nextR = String.valueOf((newY +""+ newX));
                if (!uniques.contains(next) && !uniques.contains(nextR) && newX != newY) {
                    uniques.add(next);
                    uniques.add(nextR);
                    pq.add(new PairXY(newX, newY, a));
                }
            }
            if (pair.x+1 < a.length && pair.y+1 < a.length) { // x increment, y increment
                newX = pair.x+1;
                newY = pair.y+1;
                next = String.valueOf((newX +""+ newY));
                nextR = String.valueOf((newY +""+ newX));
                if (!uniques.contains(next) && !uniques.contains(nextR) && newX != newY) {
                    uniques.add(next);
                    uniques.add(nextR);
                    pq.add(new PairXY(newX, newY, a));
                }
            }
            if (pair.x-1 >= 0 && pair.y-1 >= 0) { // x decrement, y decrement
                newX = pair.x-1;
                newY = pair.y-1;
                next = String.valueOf((newX +""+ newY));
                nextR = String.valueOf((newY +""+ newX));
                if (!uniques.contains(next) && !uniques.contains(nextR) && newX != newY) {
                    uniques.add(next);
                    uniques.add(nextR);
                    pq.add(new PairXY(newX, newY, a));
                }
            }
        }
        
        
        System.out.println("Pair is: --- " + a[result.x] + "-" + a[result.y]);
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1,3,1,4,5 ,6};
        Arrays.sort(a);
        int k =3;
        KthSmallestPair obj = new KthSmallestPair();
        System.out.println(Arrays.toString(a));
        obj.getKthSmallestPair(a, k);
    }

}
