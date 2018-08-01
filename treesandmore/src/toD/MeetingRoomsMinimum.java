package toD;
import java.util.*;
class Meeting {
    int start,end;
    Meeting(int s, int e) {
        start = s;
        end = e;
    }
}
public class MeetingRoomsMinimum {
    
    public void findMinimumMeetingRooms(int a[][]) {
        if (a.length == 0) return;
        
        PriorityQueue<Meeting> pq = new PriorityQueue<Meeting>(
                new Comparator<Meeting>() {
                    public int compare(Meeting a, Meeting b) {
                        return a.end - b.end;
                    }
                }
        );
        PriorityQueue<Meeting> pqRes = new PriorityQueue<Meeting>(
                new Comparator<Meeting>() {
                    public int compare(Meeting a, Meeting b) {
                        return a.end - b.end;
                    }
                }
        );
        for(int i=0;i<a.length;i++) {
            Meeting m = new Meeting(a[i][0], a[i][1]);
            pq.add(m);
        }
        
//        while(pq.size() > 0) {
//            System.out.println("S:" + pq.peek().start + " E:" + pq.poll().end);
//        }
        
        int count = Integer.MIN_VALUE;
        while(pq.size() > 0) {
            Meeting current = pq.poll();
            System.out.println("current:" + current.start + " e:" + current.end);
            while (pqRes.size() > 0 && current.start >= pqRes.peek().end) {
                pqRes.poll();
            }
            pqRes.add(current);
            if (pqRes.size() > count) {
                count = pqRes.size();
            }
            System.out.println("curr size:" + pqRes.size());
        }
        
        System.out.println("Max meetings needed is:" + count); // final answer
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MeetingRoomsMinimum obj = new MeetingRoomsMinimum();
        int a[][] = {{12,14},{9,12},{12,13},{9,10},{13,17}};
        obj.findMinimumMeetingRooms(a);
    }

}
