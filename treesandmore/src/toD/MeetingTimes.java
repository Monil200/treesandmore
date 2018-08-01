package toD;
import java.util.*;
// find min rooms needed
public class MeetingTimes {
    public void findRooms(Integer times[][]) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>(
                new Comparator<Integer[]>() {
                    public int compare(Integer[] a, Integer[] b) {
                        return a[1] - b[1];
                    }
                }
        );
        Comparator<Integer[]> comparator = new Comparator<Integer[]>() {
            public int compare(Integer[] a, Integer[] b) {
                return a[1] - b[1];
            }
        }; 
        Arrays.sort(times, comparator);
//        for(int i=0;i<times.length;i++) {
//            pq.add(times[i]);
//        }
//        while(pq.size() > 0) {
//            System.out.println(Arrays.toString(pq.poll()));
//        }
        int minRooms = 1;
        pq.add(times[0]);
        for(int i=1;i<times.length;i++) {
            while(pq.size() > 0 && pq.peek()[1] <= times[i][0]) {
                pq.poll();
            }
            pq.add(times[i]);
            if (pq.size()>minRooms) {
                minRooms = pq.size();
            }
        }
        System.out.println("Min rooms needed:" + minRooms);
        
        
    }
    public static void main(String args[]) {
        Integer times[][] = {{11,12}, {11,13}, {12,16}, {14,15}};
        MeetingTimes obj = new MeetingTimes();
        obj.findRooms(times);
    }
}
