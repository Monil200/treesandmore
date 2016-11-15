package graphs;
import java.util.*;
public class PrimsMinimumSpanningTree {
    int V;
    LinkedList<Integer> adj[];
    LinkedList<Integer> w[];
    LinkedList<Integer> wOutput[];
    
    public PrimsMinimumSpanningTree(int v) {
        V = v;
        adj = new LinkedList[v];
        w = new LinkedList[v];
        wOutput = new LinkedList[v];
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<Integer>();
            w[i] = new LinkedList<Integer>();
            wOutput[i] = new LinkedList<Integer>();
        }
    }
    
    void addEdge(int v, int u, int weight) {
        adj[v].add(u);
        adj[u].add(v);
        
        // weights
        w[v].add(weight);
        w[u].add(weight);
        
    }
    
    public void DFS(int start, int[] visited) {
        if (visited[start] == 0) {
            System.out.print(start + ",");
            visited[start] =1;
            Iterator<Integer> nodes = adj[start].iterator();
            while(nodes.hasNext()) {
                int temp = nodes.next();
                DFS(temp, visited);
            }
        }
    }
    
    public void primsMST(int start, int[] mstSet) {
        if(!checkMSTComplete(mstSet)) {
            wOutput[start].add(returnMinEdge(w[start], adj[start], mstSet));
            mstSet[start] =1;
            Iterator<Integer> nodes = adj[start].iterator();
            while(nodes.hasNext()) {
                int temp = nodes.next();
                if (mstSet[temp] == 0) {
                    primsMST(temp, mstSet);
                }
            }
        }
    }
    
    int returnMinEdge(LinkedList<Integer> w, LinkedList<Integer> neighbours, int mstSet[]) {
        int minSoFar = Integer.MAX_VALUE;
        for(int i=0;i<w.size();i++) {
            if (minSoFar > w.get(i) && mstSet[neighbours.get(i)] == 0) {
                minSoFar = w.get(i);
            }
        }
        if (minSoFar == Integer.MAX_VALUE)
            return -1;
        return minSoFar;
        
    }
    
    boolean checkMSTComplete(int mstSet[]) {
        for(int i=0;i<V;i++) {
            if (mstSet[i] == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PrimsMinimumSpanningTree obj = new PrimsMinimumSpanningTree(4);
        int visited[] = new int[obj.V];
        obj.addEdge(0, 1, 2);
        obj.addEdge(1, 2, 1);
        obj.addEdge(0, 2, 1);
        obj.addEdge(2, 3, 3);
        obj.DFS(0, visited);
        int mstSet[] = new int[obj.V];
        obj.primsMST(0, mstSet);
        System.out.println(Arrays.toString(mstSet)); // array to check if all are visited;
        // print each nodes edge that is part of MST
        for(int i=0;i<obj.V;i++) {
            System.out.print(i + ":");
            for(Integer j : obj.wOutput[i]) {
                System.out.print(j + ",");
            }
            System.out.println();
        }
    }

}
