package treessandtrees;
import java.util.*;
class Pair {
    int a,b;
    int sum;
    Pair(int x,int y) {
        a = x;
        b= y;
        sum = a+b;
    }
}
public class KPairsWithSmallestSums {
    public void sort(int one[], int two[], int k) {
        Queue<Pair> pq = new PriorityQueue<Pair>(
            new Comparator<Pair>() {
                    public int compare(Pair x, Pair y) {
                        return x.sum - y.sum; 
                    }
            }
        );
        for(int i=0;i<k && i<one.length;i++) {
            for(int j=0;j<k&& j<two.length;j++) {
                System.out.println("adding [" + one[i] + "," + two[j] + "]");
                pq.add(new Pair(one[i], two[j]));
            }
        }
        
        Iterator<Pair> it = pq.iterator();
        int count =0;
        while(!pq.isEmpty() && count<k) {
            Pair temp = pq.poll();
            System.out.println("[" + temp.a + "," + temp.b + "]");
            count++;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int one[] = {1,1,2};
        int two[] = {1,1,3};
        KPairsWithSmallestSums obj = new KPairsWithSmallestSums();
        obj.sort(one, two, 4);
        
        System.out.println((int) (Math.random()*(6-3)) + 3);
        
    }

}
