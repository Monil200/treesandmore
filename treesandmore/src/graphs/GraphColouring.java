package graphs;
import java.util.*;

public class GraphColouring {
    int V;
    LinkedList<Integer> adj[];
    
    public GraphColouring(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    void addEdge(Integer v, Integer u) {
       adj[v].add(u);
       adj[u].add(v);
    }
    
    void colorTheGraph() {
        boolean color[] = new boolean[V];
        int results[] = new int[V];// if nodes are assigned color or no
        results[0] =1;
        color[0] = true;
        
        for(int i=1;i<V;i++) {
            if (results[i] == 0)  { // if this node is not assigned color
                Iterator<Integer> nodes = adj[i].iterator();
                while(nodes.hasNext()) {
                    int temp = nodes.next();
                    if (results[temp] == 1) {
                        color[temp] = true; // make the colors of its nodes as unavailable, ie unavailable == true
                    }
                }
                
                for(int j=0;j<V;j++) {
                    if (color[j] == false) {
                        results[i] = 1;
                        System.out.println("Color assigned to node " + i +" is:" + j);
                        break;
                    }
                }// assign first available color
                for(int j=0;j<V;j++) {
                    color[j] = false; // make all color available again;
                }
            }
        }
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GraphColouring obj = new GraphColouring(4);
        obj.addEdge(0,1);
        obj.addEdge(1,2);
        obj.addEdge(2,3);
        obj.addEdge(3,0);
        obj.colorTheGraph();
    }

}
