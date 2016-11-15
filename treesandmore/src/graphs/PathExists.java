package graphs;
import java.util.*;

// check if path exist between 2 nodes in a directed graph
public class PathExists {
    int V;
    LinkedList<Integer> adj[];
    boolean targetFound = false;
    
    public PathExists(int v) {
        V = v;
        adj = new LinkedList[4];
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int v, int u) {
        adj[v].add(u);
    }
    
    public void isReachable(int start, int target, int[] visited) {
        
        if (visited[start] == 0) {
            visited[start] = 1;
            Iterator<Integer> i = adj[start].iterator();
            while(i.hasNext()) {
                int temp = i.next();
                if (temp == target) {
                    targetFound = true;
                    return;
                } else {
                    if (visited[temp] == 0) {
                        isReachable(temp, target, visited);
                    }
                }
            }
        }
    }
    public void DFS(int start, int target) {
        int visited[] = new int[V];
        isReachable(start, target, visited);
    }
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PathExists obj = new PathExists(4);
        
        obj.addEdge(2,0);
        obj.addEdge(2,3);
        obj.addEdge(0,2);
        obj.addEdge(0,1);
        obj.addEdge(1,2);
        obj.addEdge(3,3);
        obj.DFS(1, 3);
        System.out.println("Path exists?: " + obj.targetFound);
    }

}
