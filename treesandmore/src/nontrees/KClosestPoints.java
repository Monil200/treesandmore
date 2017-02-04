package nontrees;
import java.util.*;
class Points{
    int x,y;
    double dist;
    
    Points(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    Points(int x, int y, Points p) {
        this.x = x;
        this.y = y;
        dist = Math.sqrt(Math.pow(Math.abs(x-p.x), 2) + Math.pow(Math.abs(y-p.y), 2));
    }
    
    
}
public class KClosestPoints {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Points origin = new Points(0,0);
        Points p1 = new Points(3,4, origin);
        Points p2 = new Points(10,3, origin);
        Points p3 = new Points(-4,4, origin);
        Points p5 = new Points(112,1, origin);
        Points p4 = new Points(6,12, origin);
        
        
        Set<Points> s = new HashSet<Points>();
        s.add(p2);
        s.add(p1);
        s.add(p3);
        s.add(p4);
        s.add(p5);
        
        System.out.println("before:");
        Iterator<Points> i = s.iterator();
        while(i.hasNext()) {
            Points temp = i.next();
            System.out.println("x:" + temp.x + " y:" + temp.y + " dist:" + temp.dist);
        }
        PriorityQueue<Points> pq = new PriorityQueue<Points>(new Comparator<Points>(){
            public int compare(Points a, Points b) {
                if (a.dist < b.dist)
                    return +1;
                if (a.dist > b.dist) 
                    return -1;
                return 0;
            }
        });
        int k = 3;
        i = s.iterator();
        
        while(i.hasNext()) {
            Points temp = i.next();
            if (pq.size()< k) {
                pq.add(temp);
            } else if(pq.peek().dist > temp.dist) {
                pq.poll();
                pq.add(temp);
            }
        }
        
        
        i = pq.iterator();
        System.out.println("After:");
        while(i.hasNext()) {
            Points temp = i.next();
            System.out.println("x:" + temp.x + " y:" + temp.y + " dist:" + temp.dist);
        }
        
    }
    
    

}
