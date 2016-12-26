package graphs;
import java.util.*;
public class TopologicalSort {
    int V;
    int assignment;
    LinkedList adj[];
    int tnum[];
    
    TopologicalSort(int v) {
        V = v;
        adj = new LinkedList[4];
        tnum = new int[V];
        assignment = V-1;
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<Integer>();
            tnum[i] = -1;
        }
    }
    
    public void addedge(int u,int v) { // edge from v to u, meaning v has dependency on u
        adj[v].add(u);
    }
    
    public void DFS(int start, boolean visited[]) {
        if (visited[start]) {
            return;
        } else {
            visited[start] = true;
            System.out.println("\n node: " + start + ", topological number: " + tnum[start]);
            Iterator<Integer> it = adj[start].iterator();
            while(it.hasNext()) {
                int temp = it.next();
                if (!visited[temp]) {
                    DFS(temp, visited);
                }
            }
        }
    }
    
    public void topologicalNumbers(int start, boolean visited[]) {
        if (visited[start]) {
            return;
        } else {
            visited[start] = true;
            System.out.print(start + ",");
            Iterator<Integer> it = adj[start].iterator();
            while(it.hasNext()) {
                int temp = it.next();
                if (!visited[temp]) {
                    topologicalNumbers(temp, visited);
                }
            }
            tnum[start] = assignment--;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TopologicalSort obj = new TopologicalSort(4);
        
        obj.addedge(1, 0);
        obj.addedge(2, 0);
        obj.addedge(3, 1);
        obj.addedge(3, 2);
        boolean visited[] = new boolean[obj.V];
        obj.topologicalNumbers(0, visited);
        boolean visited1[] = new boolean[obj.V];
        obj.DFS(0, visited1);
    }

}
