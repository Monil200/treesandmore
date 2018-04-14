package graphs;
import java.util.*;


public class GraphsBasicsAgain {
    int V;
    LinkedList<Integer> adj[]; 
    HashSet<Integer> callStack;
    GraphsBasicsAgain(int v) {
        V = v;
        adj = new LinkedList[V];
        callStack = new HashSet<Integer>();
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u); // bidirectional
    }
    
    public void DFS(int start, boolean visited[]) {
        if (!visited[start]) {
            visited[start] = true;
            System.out.print(start + ", ");
            Iterator<Integer> itr = adj[start].iterator();
            while(itr.hasNext()) {
                int neighbour = itr.next();
                if (!visited[neighbour]) {
                    DFS(neighbour, visited);
                }
            }
        }
    }
    
    public void BFS(int start, boolean visited[]) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int current = q.remove();
            System.out.print(current + ", ");
            Iterator<Integer> itr = adj[current].iterator();
            while(itr.hasNext()) {
                int neighbour = itr.next();
                if (!visited[neighbour]) {
                    q.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
    
    public void allPaths(int start, int end, ArrayList<Integer> paths, boolean visited[]) {
        if (!visited[start]) {
            if (start == end) {
                System.out.println(paths);
                return;
            }
            visited[start] = true;
            Iterator<Integer> itr = adj[start].iterator();
            while(itr.hasNext()) {
                int neighbour = itr.next();
                System.out.println("neighbour:" + neighbour);
                if (!visited[neighbour]) {
                    System.out.println("in if:" + neighbour);
                    paths.add(neighbour);
                    allPaths(neighbour, end, new ArrayList<Integer>(paths), visited);
                    paths.remove(paths.size()-1);
                }
            }
        }
    }
    
    
    public void detectCycleInUndirectedGraph(int start,boolean visited[], int parent) {
        visited[start] = true;
        Iterator<Integer> itr = adj[start].iterator();
        callStack.add(start);
        while(itr.hasNext()) {
            int neighbour = itr.next();
            if (neighbour != start && callStack.contains(neighbour)) {
                System.out.println("Cycle exists");
                return;
            }
            if (!visited[neighbour]) {
                detectCycleInUndirectedGraph(neighbour, visited, start);
            }
        }
        callStack.remove(start); // s will be popped
        
    }
    
    public void detectCycleInUndirectedGraphUtil() {
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++) {
            if (!visited[i]) {
                detectCycleInUndirectedGraph(i, visited, -1);
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GraphsBasicsAgain obj = new GraphsBasicsAgain(4);
        obj.addEdge(0,1);
        obj.addEdge(1,3);
        obj.addEdge(0,2);
        obj.addEdge(2,3);
        
        boolean visited[] = new boolean[obj.V];
        System.out.println("DFS----");
        obj.DFS(0, visited);
        
        // BFS
        System.out.println("\n BFS----");
        Arrays.fill(visited, false);
        obj.BFS(0, visited);
        
        // all paths
        System.out.println("\n All paths----");
        Arrays.fill(visited, false);
        obj.allPaths(0, 3, new ArrayList<Integer>(), visited);
        
        
        // cycle in undirected graph
        GraphsBasicsAgain cycleTestUndirected = new GraphsBasicsAgain(4);
        cycleTestUndirected.addEdge(0, 1);
        cycleTestUndirected.addEdge(1, 2);
//        cycleTestUndirected.addEdge(2, 0);
        cycleTestUndirected.addEdge(3, 1);
        cycleTestUndirected.addEdge(3,0);
        
        cycleTestUndirected.detectCycleInUndirectedGraphUtil();
        
    }

}
