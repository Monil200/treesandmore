package treessandtrees;
/*
 * A triple booking happens when three events have some non-empty intersection (ie., there is some time that is common to all 3 events.)
 * For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
 */
import java.util.*;
class ClaendarSlot {
    int start,end, conflicts;
    ClaendarSlot(int s, int e) {
        start = s;
        end = e;
        conflicts = 0;
    }
}
public class CalendarBooking {
    TreeSet<ClaendarSlot> pq;
    CalendarBooking() {
        pq = new TreeSet<ClaendarSlot>(
                new Comparator<ClaendarSlot>() {
                    public int compare(ClaendarSlot a, ClaendarSlot b) {
                        if (a.start != b.start)
                            return a.start - b.start;
                        else 
                            return b.end - a.end;
                    }
                }
        );
    }
    public void fillcalendar(int start, int end) {
        if (pq.size() == 0) {
            System.out.println("First slot added successfully");
            pq.add(new ClaendarSlot(start, end));
            return;
        }
        Iterator<ClaendarSlot> it = pq.iterator();
        ClaendarSlot current = null;
        ClaendarSlot prev = null;
        boolean isSlotAdded = false;
        Stack<ClaendarSlot> stack = new Stack<ClaendarSlot>();
        while(it.hasNext()) {
            current = it.next();
//            System.out.println("current start" + current.start + " current end:" + current.end + " new start:" + start + " new end" + end);
            if (current.start >= end && ((prev != null && prev.end <= start) || prev == null)) { // Beginning of current slot
                System.out.println("adding in first if ");
                pq.add(new ClaendarSlot(start ,end));
                isSlotAdded = true;
                break;
            }
            if (current.start < end) {
                if (stack.size() > 0 && stack.peek().end > start) {
                    Stack<ClaendarSlot> temp = new Stack<ClaendarSlot>();
                    boolean isBadAdd = false;
                    while(stack.size() > 0 && !isBadAdd)  {
                        if (stack.peek().end > start && stack.peek().conflicts == 1) {
                            isBadAdd = true;
                            break;
                        } else if (stack.peek().end > start && stack.peek().conflicts == 1) {
                            temp.push(stack.pop());
                        }
                    }
                    // add back from temp to stack
                    while(temp.size() > 0) {
                        stack.push(temp.pop());
                    }
                    if (isBadAdd) {
                        System.out.println("Cannot be added to calendar");
                    } else {
                        current.conflicts = 1;
                        pq.add(new ClaendarSlot(start ,end));
                    }
                } else {
                    current.conflicts = 1;
                    pq.add(new ClaendarSlot(start ,end));
                }
            }

            stack.push(current);
            prev = current;
            
        }
        
        // check if it can be appended at end
        if (pq.last().end <= start) {
            System.out.println("adding last slot ");
            pq.add(new ClaendarSlot(start ,end));
            isSlotAdded = true;
        }
        
        it = pq.iterator(); // no guarantee of order
        if (isSlotAdded) {
            System.out.println("Slot added:");
        } else {
            System.out.println("Conflict:");
        }
        while(it.hasNext()) {
            ClaendarSlot slot = it.next();
            System.out.println("\tSlot start:" + slot.start + " slot end:" + slot.end);
        }
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CalendarBooking obj = new CalendarBooking();
        obj.fillcalendar(10, 15);
        obj.fillcalendar(15, 25);
        obj.fillcalendar(20, 30);
        obj.fillcalendar(5, 6);
    }

}
