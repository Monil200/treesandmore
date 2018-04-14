package graphs;
import java.util.*;
class DNode {
    int distance;
    boolean visited;
    HashMap<DNode, Integer> neighbours;
    DNode() {
        distance = Integer.MAX_VALUE;
        neighbours = new HashMap<DNode, Integer>();
    }
}
public class NetworkTime {
    public void addTimes(DNode from, DNode to, int distance) {
        from.neighbours.put(to, distance);
    }
    

    public void dijikstras(DNode start, DNode end) {
        if (!start.visited) {
            start.visited = true;
            PriorityQueue<DNode> pq = new PriorityQueue<DNode>(
                new Comparator<DNode>() {
                    public int compare(DNode a, DNode b) {
                        return a.distance - b.distance;
                    }
                }
            );
            
            Set<Map.Entry<DNode, Integer>> it = start.neighbours.entrySet();
            for(Map.Entry<DNode, Integer> i : it) {
                if (start.distance + start.neighbours.get(i.getKey()) < i.getKey().distance) {
                    i.getKey().distance = start.distance + start.neighbours.get(i.getKey());
                }
                pq.add(i.getKey());
            }
            
            Iterator<DNode> pqIt = pq.iterator();
            while(pqIt.hasNext()) {
                DNode thisNeighbour = pqIt.next();
                dijikstras(thisNeighbour, end);
            }
            
        }
        
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NetworkTime obj = new NetworkTime();
        DNode a = new DNode();
        a.distance = 0;
        DNode b = new DNode();
        DNode c = new DNode();
        DNode d = new DNode();
        
        // add distances
        a.neighbours.put(b, 14);
        a.neighbours.put(c, 3);
        
        b.neighbours.put(d, 2);
        c.neighbours.put(d, 4);
        
        obj.dijikstras(a, d);
        
        System.out.println(d.distance);
        // can check if all nodes are visited to see if msg broadcast was done -> https://leetcode.com/problems/network-delay-time/description/
    }

}
