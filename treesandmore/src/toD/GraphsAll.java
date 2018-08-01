package toD;
import java.util.*;
class GNode {
    int data;
    ArrayList<GNode> neighbours;
    GNode(int v) {
        data = v;
        neighbours = new ArrayList<GNode>();
    }
}

public class GraphsAll {
    
    
    public void addEdge(GNode u, GNode v) { // undirected edge
        u.neighbours.add(v);
        v.neighbours.add(u);
    }
    
    public void addEdgeDirected(GNode u, GNode v) { // directed edge
        u.neighbours.add(v);
    }
    
    public void DFS(GNode start, HashSet<GNode> visited) {
        if (!visited.contains(start)) {
            visited.add(start);
            System.out.println("data:" + start.data );
            Iterator<GNode> n = start.neighbours.iterator();
            while(n.hasNext()) {
                GNode current = n.next();
                if (!visited.contains(current)) {
                    DFS(current, visited);
                }
            }
        }
    }
    
    public void BFS(GNode start) {
        HashSet<GNode> visited = new HashSet<GNode>();
        Queue<GNode> q = new LinkedList<GNode>();
        q.add(start);
        visited.add(start);
        while(!q.isEmpty()) {
            GNode current = q.remove();
            Iterator<GNode> n = current.neighbours.iterator();
            System.out.println("data:" + current.data );

            while(n.hasNext()) {
                GNode temp = n.next();
                if (!visited.contains(temp)) {
                    visited.add(temp);
                    q.add(temp);
                }
            }
        }
    }
    
    HashSet<GNode> stack = new HashSet<GNode>(); 
    public boolean containsCycle(GNode start) {
        if (!stack.contains(start)) {
            stack.add(start);
            Iterator<GNode> it = start.neighbours.iterator();
            while(it.hasNext()) {
                GNode current = it.next();
                if (stack.contains(current)) {
                    return true;
                } else {
                    return containsCycle(current); 
                }
            }
            stack.remove(start);
        }
        return false;
    }
    
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GraphsAll obj = new GraphsAll();
        GNode a = new GNode(1);
        GNode b = new GNode(2);
        GNode c = new GNode(3);
        GNode d = new GNode(4);
        
        obj.addEdge(a, b);
        obj.addEdge(a, c);
        obj.addEdge(b, d);
        obj.addEdge(c, d);
        
        obj.DFS(a, new HashSet<GNode>());
        System.out.println();
        obj.BFS(a);
        
        // cycle graph
        GNode x = new GNode(11);
        GNode y = new GNode(12);
        GNode z = new GNode(13);
        GNode w = new GNode(14);
        
        obj.addEdgeDirected(x, y);
        obj.addEdgeDirected(y, z);
        obj.addEdgeDirected(z, w);
        obj.addEdgeDirected(w, x);
        
        System.out.println("contains cycle:" + obj.containsCycle(x));
    }

}
