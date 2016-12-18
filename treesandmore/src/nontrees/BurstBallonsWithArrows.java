package nontrees;
import java.util.*;
public class BurstBallonsWithArrows {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer a[][] = {{10,16}, {2,8}, {1,6}, {7,12}};
        ArrayList<Integer[]> radius = new ArrayList<Integer[]>();
        for(int i=0;i<a.length;i++)
            radius.add(a[i]);
        
        Comparator<Integer[]> specialComparator = new Comparator<Integer[]>() {
            public int compare(Integer[] a, Integer[] b) {
                return a[0] - b[0];
            }
        };
        
        Collections.sort(radius, specialComparator);
        for(int i=0;i<radius.size();i++)
            System.out.println(Arrays.toString(radius.get(i)));
        
        int arrowsNeeded = 0;
        for(int i=0;i<radius.size();i++) {
            arrowsNeeded++;
            Integer[] temp = radius.get(i);
            int currentReach = temp[1];
            int indexStart = i+1;
            while(indexStart < radius.size() && currentReach >= radius.get(indexStart)[0]) {
                indexStart++;
            }
            i = indexStart;
        }
        System.out.println("Arrows needed are:" + arrowsNeeded);
    }

}
