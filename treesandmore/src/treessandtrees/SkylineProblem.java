package treessandtrees;
import java.util.*;
class Bldg {
    int x,y;
    char point;
    Bldg(int xp, int yp, char pt) {
        x = xp;
        y = yp;
        point = pt;
    }
}
public class SkylineProblem {
    
    public PriorityQueue<Bldg> sortBldgPoints(ArrayList<Bldg> a) {
        if (a ==null || a.size() == 0)
            return null;
        
        PriorityQueue<Bldg> pq = new PriorityQueue<Bldg>(
            new Comparator<Bldg>(){
                public int compare(Bldg a , Bldg b) {
                    if (a.x == b.x) {
                        if (a.point == b.point && a.point == 's') {
                            return b.y - a.y;
                        } else if (a.point == b.point && a.point == 'e') {
                            return a.y - b.y;
                        }
                    }
                    return a.x - b.x;
                }
            }
        );
        
        pq.addAll(a);
        return pq;
    }
    public void getSkylinePoints(PriorityQueue<Bldg> pq) {
        
        ArrayList<Bldg> res = new ArrayList<Bldg>();
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return b -a;
                    }
                }
        );
        max.add(0);
        
        while(pq.size() > 0) {
            Bldg temp = pq.poll();
            if (temp.point == 's') {
                if (temp.y > max.peek()) { // it is candidate for output
                    res.add(temp);
                    System.out.println("\t ->" + temp.y + " currPeak:" + max.peek() + " s");
                }
                max.add(temp.y);
            } else if (temp.point == 'e') {
                int myEnd = temp.y;
                max.remove(temp.y);
                int newMax = max.peek();
                if (myEnd > newMax) { // if removed is tallest, add it to the res, else dont add
                    res.add(new Bldg(temp.x, newMax, 'e'));
                    System.out.println("adding ->" + temp.x + " " + newMax + " e");
                }
            }
        }
        
        System.out.println("Answer---------");
        Iterator<Bldg> it = res.iterator();
        while(it.hasNext()) {
            Bldg t = it.next();
            System.out.println("x:" + t.x + " y:" + t.y);
        }
    }
    
    public static void main(String args[]) {
        SkylineProblem obj = new SkylineProblem();
        ArrayList<Bldg> a = new ArrayList<Bldg>();
        
        a.add(new Bldg(2,10, 's'));
        a.add(new Bldg(3,15, 's'));
        a.add(new Bldg(5,12, 's'));
        a.add(new Bldg(7,15, 'e'));
        a.add(new Bldg(9,10, 'e'));
        a.add(new Bldg(12,12, 'e'));
        a.add(new Bldg(15,10, 's'));
        a.add(new Bldg(19,8, 's'));
        a.add(new Bldg(20,10, 'e'));
        a.add(new Bldg(24,8, 'e'));
//        a.add(new Bldg(0,2, 's'));
//        a.add(new Bldg(1,2, 'e'));
//        a.add(new Bldg(0,3, 's'));
//        a.add(new Bldg(2,3, 'e'));
        
        PriorityQueue<Bldg> pq = obj.sortBldgPoints(a);
        PriorityQueue<Bldg> pqTemp = new PriorityQueue<Bldg>(
                new Comparator<Bldg>(){
                    public int compare(Bldg a , Bldg b) {
                        if (a.x == b.x) {
                            if (a.point == b.point && a.point == 's') {
                                return b.y - a.y;
                            } else if (a.point == b.point && a.point == 'e') {
                                return a.y - b.y;
                            }
                        }
                        return a.x - b.x;
                    }
                }
            );
        
        while(pq.size() > 0) {
            Bldg temp = pq.poll();
            System.out.println("x:" + temp.x + " y:" + temp.y  + " s/e: " + temp.point);
            pqTemp.add(temp);
        }
        pq.addAll(pqTemp);
        
        obj.getSkylinePoints(pq);
    }
    
}
