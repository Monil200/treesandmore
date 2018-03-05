package graphs;
import java.util.*;

public class FindCelebrity {
    int V;
    LinkedList<Integer> adj[];
    public FindCelebrity(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int u, int v) {
        adj[u].add(v); // directed edge
    }
    
    public void celebrityFinder(int start, boolean isCelebrity[], int visited[]) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        while(!q.isEmpty()) {
            int celeb = q.poll();
            System.out.println(" candidate celeb:" + celeb + " size of its adj:" + adj[celeb].size());
            visited[celeb] = 1;
            Iterator<Integer> it = adj[celeb].iterator();
            if (adj[celeb].size() > 0) {
                isCelebrity[celeb] = false; // because this guy knows someone.
            }
            while(it.hasNext()) {
                int celebNeighbour = it.next();
                if (visited[celebNeighbour] == 0) {
                    q.add(celebNeighbour);
                }
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FindCelebrity obj = new FindCelebrity(4);
        obj.addEdge(0, 1);
        obj.addEdge(2, 1);
        obj.addEdge(3, 1);
        int visited[] = new int[obj.V];
        boolean isCelebrity[] = new boolean[obj.V];
        for(int i=0;i<obj.V;i++) 
            isCelebrity[i] = true; // make everyone a celeb
        for(int i=0;i<obj.V;i++) {
            if (visited[i] == 0)
                obj.celebrityFinder(i, isCelebrity, visited);
        }
        
        System.out.println(Arrays.toString(isCelebrity));
    }
}
