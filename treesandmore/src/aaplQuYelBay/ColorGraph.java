package aaplQuYelBay;
import java.util.*;
public class ColorGraph {
    int V;
    LinkedList adj[];
    ColorGraph(int v) {
        V = v;
        adj = new LinkedList[4];
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    void addEdge(int u, int v) { //u->v, u is depended on v 
        adj[u].add(v);
//        adj[v].add(u); undirected
    }
    
    void DFS(int start, int visited[]) {
        if (visited[start] != 1) {
            System.out.print(start + ",");
            visited[start] =1;
            Iterator<Integer> it = adj[start].iterator();
            while(it.hasNext()) {
                int temp = it.next();
                if (visited[temp] != 1) {
                    DFS(temp, visited);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ColorGraph obj = new ColorGraph(4);
        obj.addEdge(3, 2);
        obj.addEdge(3, 1);
        obj.addEdge(1, 0);
        obj.addEdge(2, 0);
        int visited[] = new int[obj.V];
        obj.DFS(3, visited);
    }

}
