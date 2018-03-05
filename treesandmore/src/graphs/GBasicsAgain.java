package graphs;
import java.util.*;
public class GBasicsAgain {
    int V;
    LinkedList<Integer> adj[];
    GBasicsAgain(int v){
        V=v;
        adj = new LinkedList[V];
        for(int i=0;i<V;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }
    
    public void BFS(int start, int visited[]) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        while(!q.isEmpty()) {
            int node = q.poll();
            if (visited[node] == 0)
                System.out.print(node + ", ");
            visited[node] = 1;
            Iterator<Integer> it = adj[node].iterator();
            while(it.hasNext()) {
                int neighbour = it.next();
                if (visited[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }
    }
    public void DFS(int start, int visited[]) {
        if (visited[start] == 0) {
            System.out.print(start + ", ");
            visited[start] = 1;
            Iterator<Integer> it = adj[start].iterator();
            while(it.hasNext()) {
                int neighbour = it.next();
                if (visited[neighbour] == 0) {
                    DFS(neighbour, visited);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GBasicsAgain obj = new GBasicsAgain(4);
        obj.addEdge(0, 1);
        obj.addEdge(1, 3);
        obj.addEdge(0, 2);
        obj.addEdge(2, 3);
        int visited[] = new int[obj.V];
        int visited1[] = new int[obj.V];
        obj.BFS(0, visited);
        System.out.println();
        obj.DFS(0, visited1);
    }

}
