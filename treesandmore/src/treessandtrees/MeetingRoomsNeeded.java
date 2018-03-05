package treessandtrees;
import java.util.*;
public class MeetingRoomsNeeded {
    
    public void meetingRoomsV2(Integer a[][]) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        pq.add(a[0][1]); // add end time of first meeting
        int count = 1;
        int max = count;
        System.out.println(pq + " i:" + 0);
        for(int i=1;i<a.length;i++) {
            if (a[i][0] < pq.peek()) {
                // do nothing
            } else {
                while(pq.size() > 0 && a[i][0] >= pq.peek()) {
                    pq.poll();
                    count--;
                }
            }
            pq.add(a[i][1]); // add current end
            if (pq.size() > max) {
                max = pq.size();
            }
            System.out.println(pq + " i:" + i);
        }
        
        System.out.println("\n Max rooms needed in V2:" + max);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MeetingRoomsNeeded obj = new MeetingRoomsNeeded();
        Integer[][] times = {{1,2}, {1,4}, {6,9}, {2,4}, {3,5}, {4,5}, {4,8}, {5,6}};
        
        Comparator<Integer[]> special = new Comparator<Integer[]>() {
                public int compare(Integer a[], Integer b[]) {
                    return a[0] - b[0];
                }
        };
        
        Arrays.sort(times, special);
        for(int i=0;i<times.length;i++)
            System.out.print(Arrays.toString(times[i]) + ", ");
        System.out.println();
        obj.meetingRoomsV2(times);
        
        
        }

}
