package graphs;
import java.util.*;
public class CyclesInGraphVariations {
    int V;
    LinkedList<Integer> adj[];
    CyclesInGraphVariations(int v) {
        V = v;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int u , int v) {
        adj[u].add(v);
        adj[v].add(u);
    }
    
    public void addEdgeDirected(int u , int v) {
        adj[u].add(v);
    }
    
    public void DFSContainsCycleUndirectedGraph(int start, int parent, boolean visited[], boolean callstack[]) {
        if (!visited[start]) {
            callstack[start] = true;
            visited[start] = true;
            System.out.println("Node:" + start);
            Iterator<Integer> it = adj[start].iterator();
            while(it.hasNext()) {
                int neighbour = it.next();
                if (parent != -1 && neighbour != parent) {
                    if (callstack[neighbour]) {
                        System.out.println("Cycle detected in undirected graph at node" + neighbour);
                    }
                }
                if (!visited[neighbour]) {
                    DFSContainsCycleUndirectedGraph(neighbour, start, visited, callstack);
                }
            }
        }
        callstack[start] = false;
        
    }
    
    public void DFSTopologicalDirected(int start, boolean visited[], ArrayList<Integer> a) {
        if (!visited[start]) {
            visited[start] = true;
//            System.out.println("Node:" + start);
            Iterator<Integer> it = this.adj[start].iterator();
            while(it.hasNext()) {
                int neighbour = it.next();
                if (!visited[neighbour]) {
                    DFSTopologicalDirected(neighbour, visited, a);
                }
            }
        }
        System.out.println("Node order:" + start);
        a.add(start);
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CyclesInGraphVariations obj = new CyclesInGraphVariations(6);
        obj.addEdge(0,1);
        obj.addEdge(1,2);
        obj.addEdge(2,3);
        obj.addEdge(3,4);
        obj.addEdge(4,1); // this is making cycle
//        obj.addEdge(4,5); // this is making cycle
        obj.addEdge(0,5);
        
        boolean visited[] = new boolean[obj.V];
        boolean callstack[] = new boolean[obj.V];
        obj.DFSContainsCycleUndirectedGraph(0, -1, visited, callstack);
        
        // topological sort
        System.out.println("Topological order:");
        CyclesInGraphVariations obj1 = new CyclesInGraphVariations(4);
        obj1.addEdgeDirected(1, 0);
        obj1.addEdgeDirected(2, 0);
        obj1.addEdgeDirected(3, 0);
        obj1.addEdgeDirected(1, 3);
        Arrays.fill(visited, false);
        ArrayList<Integer> topologicalOrder = new ArrayList<Integer>();
        for(int i=obj1.V-1;i>=0;i--) {
            if (!visited[i])
                obj1.DFSTopologicalDirected(i, visited, topologicalOrder);
        }
        System.out.println(topologicalOrder);
    }

}
