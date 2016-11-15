package graphs;
// determine if graph is connected or no. A graph is said to be connected if we can reach any other node from a random node.
import java.util.*;
public class ConnectedGraph {
    int V;
    LinkedList<Integer> adj[];
    
    public ConnectedGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int v, int u) {
        adj[v].add(u);
    }
    
    public void DFSUtilToCheckAllVisited(int start, int[] visited) {
        if (visited[start] == 0) {
            visited[start] =1;
            Iterator<Integer> list = this.adj[start].iterator();
            System.out.println(adj[start].size() + "<-");
            while(list.hasNext()) {
                int temp = list.next();
                if (visited[temp] == 0) {
                    DFSUtilToCheckAllVisited(temp, visited);
                }
            }
        }
    }
    public void DFS(int start, ConnectedGraph graphTranspose) {
        int visited[] = new int[V];
        DFSUtilToCheckAllVisited(start, visited);
        boolean allVisited = allVisited(visited);
        if (allVisited) {
            for(int i=0;i<V;i++) {
                visited[i] = 0;
            }
            // use reverse edge graph to see if it can be reached from same start node
            graphTranspose.DFSUtilToCheckAllVisited(start, visited);
            allVisited = allVisited(visited);
            if (allVisited) {
                System.out.println("Graph IS strongly connected");
            } else {
                System.out.println("Graph IS NOT strongly connected");
            }
        } else {
            System.out.println("Graph is not strongly connected");
        }
    }
    
    public boolean allVisited(int[] visited) {
        boolean allVisited = true;
        for(int i=0;i<V;i++) {
            if (visited[i] == 0) {
                allVisited = false;
                break;
            }
        }
        return allVisited;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ConnectedGraph obj = new ConnectedGraph(3);
        obj.addEdge(0, 1);
        obj.addEdge(1, 2);
        obj.addEdge(2, 0);
        
        ConnectedGraph objTranspose = new ConnectedGraph(3);
        objTranspose.addEdge(1, 0);
        objTranspose.addEdge(2, 1);
        objTranspose.addEdge(0, 2);
        
        obj.DFS(1, objTranspose);
    }

}
