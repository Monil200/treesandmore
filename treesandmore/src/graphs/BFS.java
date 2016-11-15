package graphs;

import java.util.*;
public class BFS {
    int V;
    LinkedList<Integer> adj[];
    
    public BFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    void addEdge(int v , int u) {
        adj[v].add(u);
    }
    
    public void BFSUtil(int start, int[] visited) {
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        while(!q.isEmpty()) {
            int node = q.poll();
            visited[node] = 1;
            System.out.print(node + ",");
            Iterator<Integer> nodeList = adj[node].iterator();
            while(nodeList.hasNext()) {
                int temp = nodeList.next();
                if (visited[temp] == 0) {
                    q.add(temp);
                }
            }
        }
    }
    
    public void BFSTraversal(int start) {
        int visited[] = new int[V];
        BFSUtil(start, visited);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BFS obj = new BFS(4);
        
        obj.addEdge(2,0);
        obj.addEdge(2,3);
        obj.addEdge(0,2);
        obj.addEdge(0,1);
        obj.addEdge(1,2);
        obj.addEdge(3,3);
        obj.BFSTraversal(2);

    }

}
