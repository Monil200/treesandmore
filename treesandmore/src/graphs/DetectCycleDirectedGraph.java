package graphs;
import java.util.*;
public class DetectCycleDirectedGraph {
    int V;
    LinkedList<Integer> adj[];
    
    public DetectCycleDirectedGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int v, int u) {
        adj[v].add(u);
    }
    public boolean detectCycleUtil(int start, int[] visited, boolean[] callStack) {
        if (visited[start] == 0) {
            visited[start] = 1;
            callStack[start] = true;
            Iterator<Integer> i = adj[start].iterator();
            while(i.hasNext()) {
                int temp = i.next();
                if (visited[temp] == 0 && detectCycleUtil(temp, visited, callStack)) {
                    return true;
                } else if (callStack[temp]) {
                    return true;
                }
            }
        }
        callStack[start] = false;
        return false;
    }
    public void DFSToDetechCycle(int start) {
        int visited[] = new int[V];
        boolean callStack[] = new boolean[V];
        System.out.println("Does cycle exist: " + detectCycleUtil(start, visited,callStack));
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DetectCycleDirectedGraph obj = new DetectCycleDirectedGraph(4);
        obj.addEdge(2,0);
        obj.addEdge(2,3);
        obj.addEdge(0,2);
        obj.addEdge(0,1);
        obj.addEdge(1,2);
        obj.addEdge(3,3);
        obj.DFSToDetechCycle(2);
    }

}
