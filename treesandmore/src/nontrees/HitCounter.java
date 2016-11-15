package nontrees;
//Design a hit counter which counts the number of hits received in the past 5 minutes.
// basically no of hits in 5 min window
import java.util.*;
public class HitCounter {
    
    List<Integer> hit = new ArrayList<Integer>();
    int counter;
    
    public HitCounter() {
        this.counter = 0;
    }
    
    void getCounter(int timestamp) {
        
        int firstHitInPipeline = (this.hit.size() > 0) ? this.hit.get(0) : -1;
        if (firstHitInPipeline == -1) {
            System.out.println(" No hits in last 5 min");
        } else {
            while(timestamp - firstHitInPipeline > 300) {
                this.hit.remove(0);
                firstHitInPipeline = this.hit.get(0);
            }
            System.out.println(" hits till now are " + this.hit.size());
        }
    }
    
    public void hit(int timestamp) {
        this.hit.add(timestamp);
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
        obj.getCounter(303);
    }

}
