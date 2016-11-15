package graphs;
import java.util.*;
public class ConnectedComponents {
    int V;
    LinkedList<Integer> adj[];
    LinkedList<Integer> path;
    
    public ConnectedComponents(int v) {
        V = v;
        adj = new LinkedList[v];
        path = new LinkedList<Integer>();
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    void addEdge(int v, int u) {
        adj[v].add(u);
    }
    
    boolean isCyclic(int start, LinkedList<Integer> path, int[] visited, int[] callStack) {
        if (visited[start] == 0) {
            visited[start] =1;
            callStack[start] =1;
            path.add(start);
            this.path = path;
            Iterator<Integer> i = adj[start].iterator();
            while(i.hasNext()) {
                int temp = i.next();
                if (visited[temp] == 0 && isCyclic(temp, new LinkedList<Integer>(path), visited, callStack)) {
//                    this.path = path;
                    return true;
                } else if (callStack[temp] == 1) {
//                    this.path = path;
                    return true;
                }
            } 
        }
        callStack[start] = 0;
        return false;
    }
    
    void findConnectedComponent() {
        int visited[] = new int[V];
        int callStack[] = new int[V];
        boolean nodesInLoop[] = new boolean[V];
        LinkedList<Integer> nodesInLoopList = new LinkedList<Integer>();
        boolean isCyclicPath = false;
        for(int i=0;i<V;i++) {
            if (!nodesInLoop[i]) {
                for(int k=0;k<V;k++) {
                    visited[k] = 0;
                    callStack[k] = 0;
                }
                isCyclicPath = isCyclic(i, new LinkedList<Integer>(), visited, callStack);
                if (isCyclicPath) {
//                    System.out.println("Connected components  are: " + Arrays.toString(this.path.toArray()));
                    System.out.println("Connected components  are: ");
                    
                    nodesInLoopList = this.path;
                    for(Integer j : nodesInLoopList) {
                        System.out.print(j + ",");
                        nodesInLoop[j] = true;
                    }
                    System.out.println();
                }
            }
        }
        for(int i=0;i<V;i++) { // rest of the other components are connected individually
            if (!nodesInLoop[i]) {
                System.out.println(i);
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ConnectedComponents obj = new ConnectedComponents(5);
        obj.addEdge(1,0);
        obj.addEdge(0,2);
        obj.addEdge(2,1);
        obj.addEdge(0,3);
        obj.addEdge(3,4);
        obj.findConnectedComponent();
    }

}
