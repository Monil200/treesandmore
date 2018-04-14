package treessandtrees;
/*
 * A triple booking happens when three events have some non-empty intersection (ie., there is some time that is common to all 3 events.)
 * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
 */
import java.util.*;
class CalendarSlot {
    int start,end, conflicts;
    CalendarSlot(int s, int e) {
        start = s;
        end = e;
        conflicts = 0;
    }
}
public class CalendarBooking {
    PriorityQueue<CalendarSlot> pq;
    PriorityQueue<CalendarSlot> pqHolder;
    CalendarBooking() {
        pq = new PriorityQueue<CalendarSlot>(
                new Comparator<CalendarSlot>() {
                    public int compare(CalendarSlot a, CalendarSlot b) {
                        return a.end - b.end;
                    }
                }
        );
        pqHolder = new PriorityQueue<CalendarSlot>(
                new Comparator<CalendarSlot>() {
                    public int compare(CalendarSlot a, CalendarSlot b) {
                        return a.end - b.end;
                    }
                }
        ); 
    }
    public void fillcalendar(int start, int end) {
        if (pq.size() == 0) {
            pq.add(new CalendarSlot(start,end));
            System.out.println("Adeed first entry - No conflicts");
        } else {
            CalendarSlot prev = null;
            CalendarSlot current = new CalendarSlot(start, end);
            
            while(pq.size() > 0) {
                prev = pq.poll();
                pqHolder.add(prev);
                System.out.println("prev start:" + prev.start + " prev end:" + prev.end + " curr start:" + current.start + " curr end:" + current.end);
                if (prev.start >= current.end) {
                    break;
                } else if ((current.end > prev.start && current.end <= prev.end) || 
                           (current.start>= prev.start && current.end<=prev.end) ||
                           (current.start < prev.end && current.end > prev.end) ||
                           (current.start < prev.start && current.end > prev.end)) {
                    prev.conflicts++;
                    current.conflicts++;
                } else if (prev.end >= current.start) {
                    prev = pq.poll();
                }
            }
            
            if (pqHolder != null && pqHolder.size() > 0) {
                    pq.addAll(pqHolder);
            }
            pq.add(current);
            pqHolder.clear();
            
            while(pq.size() > 0) {
                CalendarSlot temp = pq.poll();
                pqHolder.add(temp);
                System.out.println("\t Start:" + temp.start + " end:" + temp.end + " conflicts:" + temp.conflicts);
            }
            pq.addAll(pqHolder);
            pqHolder.clear();
        }
        
                
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CalendarBooking obj = new CalendarBooking();
        obj.fillcalendar(10, 15);
        System.out.println();
        obj.fillcalendar(15, 25);
        System.out.println();
        obj.fillcalendar(14, 30);
        System.out.println();
        obj.fillcalendar(24, 35);
        System.out.println();
        obj.fillcalendar(23, 36);
        System.out.println();
        obj.fillcalendar(5, 6);
    }

}
