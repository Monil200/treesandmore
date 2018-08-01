package toD;
import java.util.*;

class Slot {
    int start,end;
    Slot(int s, int e) {
      start =s;
      end = e;
    }
}
public class CalendarSlot {
    
    public void findSlot(int h, int a[][], int b[][]) {
        if (h == 0) {
            return;
        }
        
        
        
        PriorityQueue<Slot> pq = new PriorityQueue<Slot>(
            new Comparator<Slot>() {
                public int compare(Slot a, Slot b) {
                    if (a.end == b.end) {
                        return a.start - b.start;
                    }
                    return a.end - b.end;
                }
            }
        );
        int start = 9, end = 18;
        
        for(int i=0;i<a.length;i++) {
            Slot s = new Slot(a[i][0], a[i][1]);
            pq.add(s);
        }
        for(int i=0;i<a.length;i++) {
            Slot s = new Slot(b[i][0], b[i][1]);
            pq.add(s);
        }
        Slot current = null;
        while(pq.size() > 0) {
            current = pq.poll();
            if (pq.size() > 0 && current.end + h <= pq.peek().start && pq.peek().end >= current.end) {
                System.out.println("Meeting start at" + current.end);
            }
        }
        
        if (current != null && current.end + h <= end)
            System.out.println("Meeting start at:" + current.end);
                
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[][] = {{9,12},{13,14}};
        int b[][] = {{10,11},{14,15}};
        CalendarSlot obj = new CalendarSlot();
        obj.findSlot(2, a, b);
    }

}
