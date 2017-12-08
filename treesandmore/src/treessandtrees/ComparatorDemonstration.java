package treessandtrees;
import java.util.*;
public class ComparatorDemonstration {
    int x,y;
    double dist;
    ComparatorDemonstration() {}
    ComparatorDemonstration(int a, int b) {
        x = a;
        y = b;
        dist = Math.sqrt(Math.pow(Math.abs(x-0), 2) +  (int) Math.pow(Math.abs(y-0), 2));
    }
    public static void twoDIntegerbBasedSort(ArrayList<Integer[]> a) {
        if (a == null || a.size() == 0)
            return;
        
        
        Comparator<Integer[]> specialComparator = new Comparator<Integer[]>() {
                public int compare(Integer[] x, Integer[] y) {
                    return x[0] - y[0];
                }
        };
        
        Collections.sort(a, specialComparator);
        for(int i=0;i<a.size();i++)
            System.out.println(Arrays.toString(a.get(i)));
    }
    
    public static void objectSortCustom(ArrayList<ComparatorDemonstration> a) {
        if (a.size() == 0 || a == null)
            return;
        
        PriorityQueue<ComparatorDemonstration> closest = new PriorityQueue<ComparatorDemonstration>( 
            new Comparator<ComparatorDemonstration>() {
                public int compare(ComparatorDemonstration x, ComparatorDemonstration y) {
                    if (x.dist >= y.dist)
                        return 1;
                    if (x.dist < y.dist)
                        return -1;
                    return 0;
                }
            }
        );
        
        for(int i=0;i<a.size();i++)
            closest.add(a.get(i));
        Iterator<ComparatorDemonstration> i = closest.iterator();
        while(!closest.isEmpty()) {
            ComparatorDemonstration j = closest.poll();
            System.out.println("i=" + j.x + " j=" + j.y + " dist=" + j.dist);
        }
    }
    public static void main(String[] args) {
        // Part 1 of this practice
        Integer a[][] = {{4,5},{2,6},{10,12},{4,6},{3,7},{2,5},{1,2}};
        ArrayList<Integer[]> times = new ArrayList<Integer[]>();
        for(int i=0;i<a.length;i++)
            times.add(a[i]);
        twoDIntegerbBasedSort(times);
        //Part 2 of this practice
        ComparatorDemonstration point1 = new ComparatorDemonstration(4,5);
        ComparatorDemonstration point2 = new ComparatorDemonstration(10,8);
        ComparatorDemonstration point3 = new ComparatorDemonstration(2,11);
        ArrayList<ComparatorDemonstration> points = new ArrayList<ComparatorDemonstration>();
        points.add(point1);
        points.add(point2);
        points.add(point3);
        objectSortCustom(points);
    }

}
