package graphs;
import java.util.*;

// use BFS
class NodeG {
    int name;
    LinkedList<NodeG> adj;
    public NodeG(int i) {
        name = i;
        adj = new LinkedList<NodeG>();
    }
}
public class CloneUndirectedGraph {
    int V;
    HashMap<NodeG, NodeG> cloneMap;
    public CloneUndirectedGraph(int v) {
        V = v;
        cloneMap = new HashMap<NodeG, NodeG>();
    }
    
    public void DFS(NodeG start, HashSet<NodeG> set) {
        if (!set.contains(start)) {
            System.out.print(start.name + ",");
            set.add(start);
            Iterator<NodeG> i = start.adj.iterator();
            while(i.hasNext()) {
                NodeG temp = i.next();
                if (!set.contains(temp)) {
                    DFS(temp, set);
                }
            }
        }
    }
    
    public void cloneGraph(NodeG start) {
        Queue<NodeG> q = new LinkedList<NodeG>();
        q.add(start);
        NodeG colnedPopped = null;
        while(!q.isEmpty()) {
            NodeG popped = q.poll();
            Iterator<NodeG> adjs;
            if (!cloneMap.containsKey(popped)) {
                colnedPopped = new NodeG(popped.name);
                cloneMap.put(popped, colnedPopped);
                adjs = popped.adj.iterator();
                while(adjs.hasNext()) {
                    NodeG temp = adjs.next();
                    colnedPopped.adj.add(temp);
                }
            }
            adjs = popped.adj.iterator();
            while(adjs.hasNext()) {
                NodeG temp = adjs.next();
                if (!cloneMap.containsKey(temp)) {
                    q.add(temp);
                }
            }
        }
        Set<Map.Entry<NodeG, NodeG>> x = cloneMap.entrySet();
        for(Map.Entry<NodeG, NodeG> i: x) {
            System.out.println(i.getKey().name);
        }
        DFS(cloneMap.get(start), new HashSet<NodeG>());
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CloneUndirectedGraph obj = new CloneUndirectedGraph(4);
        NodeG n1 = new NodeG(1);
        NodeG n2 = new NodeG(2);
        NodeG n3 = new NodeG(3);
        NodeG n4 = new NodeG(4);
        n1.adj.add(n2);
        n2.adj.add(n3);
        n3.adj.add(n4);
        n4.adj.add(n1);
        
        HashSet<NodeG> visited = new HashSet<NodeG>();
        
        obj.DFS(n1, visited);
        System.out.println();
        obj.cloneGraph(n1);
        
    }

}
