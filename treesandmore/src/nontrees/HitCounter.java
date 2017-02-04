package nontrees;
//Design a hit counter which counts the number of hits received in the past 5 minutes.
// basically no of hits in 5 min window
import java.util.*;
public class HitCounter {
    
    List<Integer> hit = new ArrayList<Integer>();
    int counter;
    int lastHitTimestampPos;
    
    public HitCounter() {
        lastHitTimestampPos = 0;
    }
    
    void getCounter(int timestamp) {
        counter = 0;
        
        if (timestamp < hit.get(lastHitTimestampPos-1)) {
            System.out.println("i m returning");
            return;
        }
        int start = lastHitTimestampPos-1;
        System.out.println(start + "--------");
        System.out.println(timestamp+ "=----------"+ hit.get(start));
        while((timestamp - hit.get(start)) <= 300 && start >= 0) {
            System.out.println(counter + "--------");
            counter++;
            start--;
        }
        System.out.println(counter + " - ");
        
        
        
        
    }
    
    public void hit(int timestamp) {
        this.hit.add(timestamp);
        lastHitTimestampPos++;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HitCounter obj = new HitCounter();
        obj.hit(1);
        obj.hit(2);
        obj.hit(3);
        obj.hit(4);
        obj.hit(301);
        obj.getCounter(302);
//        obj.getCounter(303);
    }

}
