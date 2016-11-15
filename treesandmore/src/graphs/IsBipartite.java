package graphs;
import java.util.*;
public class IsBipartite {

    int V;
    LinkedList<Integer> adj[];
    
    public IsBipartite(int v) {
        V = v;
        adj = new LinkedList[V];
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int v, int u) {
        adj[v].add(u);
    }
    
    public boolean isBipartite(int start, int[] color) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        color[start] = 1;
        while(!q.isEmpty()) {
            System.out.println(Arrays.toString(color));
            int node = q.poll();
            Iterator<Integer> i = adj[node].iterator();
            while(i.hasNext()) {
                int temp = i.next();
                if (color[temp] != 0) { // if color not defined
                    if (color[temp] == color[node]) {
                        return false;
                    }
                }
                color[temp] = color[node]*-1;
                q.add(temp);
            }
        }
        return true;
    }
    
    public void DFS(int start) {
        int color[] = new int[V];
        System.out.println("Is Bipartite? " + isBipartite(start, color));
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        IsBipartite obj = new IsBipartite(5);
        obj.addEdge(0, 1);
        obj.addEdge(0, 2);
        obj.addEdge(1, 4);
        obj.addEdge(2, 3);
        obj.addEdge(3, 4);
//        obj.addEdge(4, 5);
        
        obj.DFS(0);
    }

}
