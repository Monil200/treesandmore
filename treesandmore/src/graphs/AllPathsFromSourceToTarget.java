package graphs;
import java.util.*;
public class AllPathsFromSourceToTarget {
    int V;
    LinkedList<Integer> adj[];
    
    public AllPathsFromSourceToTarget(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int v, int u) {
        adj[v].add(u);
    }
    
    public void allPathsUtil(int start, int end, int visited[], LinkedList<Integer> path) {
        if (visited[start] == 0) {
            path.add(start);
            if (start == end) {
                for(Integer j: path) {
                    System.out.print(j + ",");
                }
                System.out.println();
            } else {
                visited[start] = 1;
            }
            Iterator<Integer> adjs = adj[start].iterator();
            while(adjs.hasNext()) {
                int temp = adjs.next();
                if (visited[temp] != 1) {
                    allPathsUtil(temp, end, visited, new LinkedList<Integer>(path));
                }
            }
        } else {
            //path.remove(start);
        }
    }
    
    public void DFSToTraverseAllPaths(int start, int target){
        int visited[] = new int[V];
        LinkedList<Integer> path = new LinkedList<Integer>();
        allPathsUtil(start, target, visited, path);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AllPathsFromSourceToTarget obj = new AllPathsFromSourceToTarget(4);
        
        obj.addEdge(2,0);
        obj.addEdge(2,3);
        obj.addEdge(0,2);
        obj.addEdge(0,1);
        obj.addEdge(1,2);
        obj.addEdge(3,1);
        obj.DFSToTraverseAllPaths(2,1);
    }

}
