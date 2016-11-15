package graphs;
import  java.util.*;
public class DFS {
    
    int V;
    LinkedList adj[];
    
    public DFS( int v) {
        this.V = v;
        this.adj = new LinkedList[v];
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    
    public void addEdge(int v, int u) { //add edge from v to u
        adj[v].add(u);
    }
    
    public void DFSUtil(int start, int[] visited) {
        
        if (visited[start] == 0) {
            visited[start] = 1;
            System.out.print(start + ",");
            Iterator<Integer> i = adj[start].iterator();
            while(i.hasNext()) {
                int node = i.next();
                if (visited[node] == 0) {
                    DFSUtil(node, visited);
                }
            }
        } else {
            return;
        }
    }
    
    public void DFSTraversal(int start) {
        int visited[] = new int[this.V];
        DFSUtil(start, visited);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DFS obj = new DFS(4);
        
        obj.addEdge(2,0);
        obj.addEdge(2,3);
        obj.addEdge(0,2);
        obj.addEdge(0,1);
        obj.addEdge(1,2);
        obj.addEdge(3,3);
        obj.DFSTraversal(2);
        
    }

}
