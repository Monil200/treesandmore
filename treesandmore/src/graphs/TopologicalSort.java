package graphs;
import java.util.*;
public class TopologicalSort {
    int V;
    LinkedList adj[];
    Stack<Integer> s; 
    TopologicalSort(int v) {
        V = v;
        s = new Stack<Integer>();
        adj = new LinkedList[V];
         for(int i=0;i<V;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int u, int v) {
        adj[u].add(v);
    }
    
    public void topologicalSortUtil(int visited[], int start) { // this is only because there is no cycle in graph
        visited[start] =1;
        Iterator<Integer> it = adj[start].iterator();
        while(it.hasNext()) {
            int temp = it.next();
            if (visited[temp] != 1) {
                topologicalSortUtil(visited, temp);
            }
        }
        s.push(start);
    }
    public void topologicalSort(int[] visited) {
        for(int i=0;i<V;i++) {
            if (visited[i] != 1)
                topologicalSortUtil(visited, i);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TopologicalSort obj = new TopologicalSort(4);
        
        obj.addEdge(0,1);
        obj.addEdge(0,3);
        obj.addEdge(0,2);
        int[] visited = new int[obj.V];
        obj.topologicalSort(visited);
        for(Integer i : obj.s) {
            System.out.print(i + ",");
        }
    }

}
