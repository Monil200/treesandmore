package graphs;
import java.util.*;

public class DisjointSets {
    int V;
    LinkedList<Integer> adj[];
    
    DisjointSets(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }
    
    public void visitConnectedNeighbours(int start, boolean visited[]) {
        if (visited[start]) {
            return;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        while(!q.isEmpty()) {
            int current = q.remove();
            System.out.println("current:" + current);
            Iterator<Integer> it = adj[current].iterator();
            visited[current] = true;
            while(it.hasNext()) {
                int neighbour = it.next();
                if (!visited[neighbour]) {
//                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DisjointSets obj = new DisjointSets(6);
        obj.addEdge(0, 1);
        obj.addEdge(1, 2);
        obj.addEdge(2, 3);
        
        obj.addEdge(5, 4);
        
        boolean visited[] = new boolean[obj.V];
        int sets = 0;
        for(int i=0;i<obj.V;i++) {
            if (!visited[i]) {
                sets++;
                obj.visitConnectedNeighbours(i, visited);
            }
        }
        
        System.out.println("Total disjoint sets are:" + sets);
    }

}
