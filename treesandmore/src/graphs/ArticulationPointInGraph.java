package graphs;
// find bridge in undirected graph. Bridge is defined as an edge which when removed from graph, makes graph disconnected.
// similarly a node which when removed from graph makes graph disconnected is called articulation point.
import java.util.*;
public class ArticulationPointInGraph {
    int V;
    LinkedList<Integer> adj[];
    
    public ArticulationPointInGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i] = new LinkedList<Integer>();
    }
    
    void addEdge(int v, int u) {
        adj[v].add(u);
        adj[u].add(v);
    }
    
    public boolean allVisited(int[] visited) {
        for(int i=0;i<V;i++) {
            if (visited[i] == 0)
                return false;
        }
        return true;
    }
    
    public void findAPDFSUtil(int start, int[] visited) {
        if (visited[start] == 0) {
            visited[start] = 1;
            Iterator<Integer> i = adj[start].iterator();
            while(i.hasNext()) {
                int temp = i.next();
                if (visited[temp] == 0) {
                    findAPDFSUtil(temp, visited);
                }
            }
        }
    }
    
    public void DFS() {
        int visited[] = new int[V];
        boolean APFound = false;
        for(int i=0;i<V;i++) {
            removeNode(i);
            findAPDFSUtil(i+1, visited);
            APFound = allVisited(visited);
            if (APFound)
                System.out.println("AP is : " + i);
            cleanVisited(visited);
            addNodeBack();
        }
    }
    
    void cleanVisited(int[] visited) {
        for(int i=0;i<V;i++) {
            visited[i] = 0;
        }
    }
    
    void removeNode(int n) {
        for(int i=0;i<V;i++) {
            for(Integer j: adj[i]) {
                if (j == n) {
                    adj[i].remove(j);
                }
            }
        }
        adj[n].clear();
    }
    
    void addNodeBack() {
        // remove everything
//        for(int i=0;i<V;i++) {
//            for(Integer j: adj[i]) {
//                adj[i].remove(j);
//            }
//        }
        this.addEdge(1, 2);
        this.addEdge(1, 0);
        this.addEdge(2, 0);
        this.addEdge(0, 3);
        this.addEdge(3, 4);
    }
            
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArticulationPointInGraph obj = new ArticulationPointInGraph(5);
        obj.addEdge(1, 2);
        obj.addEdge(1, 0);
        obj.addEdge(2, 0);
        obj.addEdge(0, 3);
        obj.addEdge(3, 4);
        
        obj.DFS();
    }

}
