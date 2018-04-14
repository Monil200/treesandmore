package graphs;
import java.util.*;
class PrimNode {
    HashMap<PrimNode, Integer> neighbours;
    int distance;
    boolean visited;
    String name;
    PrimNode(String n) {
        name = n;
        distance = Integer.MAX_VALUE;
        neighbours = new HashMap<PrimNode, Integer>(); 
    }
}
public class PrimsMinimumSpanningTree {
    int V;
    LinkedList<Integer> adj[];
    LinkedList<Integer> w[];
    LinkedList<Integer> wOutput[];
    
    // v2 vars
    HashMap<PrimNode, HashMap<PrimNode, Integer>> outputNetwork;
    
    
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
        outputNetwork = new HashMap<PrimNode, HashMap<PrimNode, Integer>>();
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
    
    
    
    public void primsMST(PrimNode start, PrimNode to, int distance) {
        if (!start.visited) {
            start.visited = true;
            HashMap<PrimNode, Integer> neighboursOutputNetwork;
            if (!outputNetwork.containsKey(start)) {
                neighboursOutputNetwork = new HashMap<PrimNode, Integer>();
            } else {
                neighboursOutputNetwork = outputNetwork.get(start);
            }
            neighboursOutputNetwork.put(to, Math.min(distance, neighboursOutputNetwork.getOrDefault(to, Integer.MAX_VALUE)));
            outputNetwork.put(start, neighboursOutputNetwork);

            PriorityQueue<PrimNode> pq = new PriorityQueue<PrimNode>(
                    new Comparator<PrimNode>() {
                        public int compare(PrimNode a, PrimNode b) {
                            return a.distance - b.distance;
                        }
                    }
            );
            
            Set<Map.Entry<PrimNode, Integer>> set = start.neighbours.entrySet();
            for(Map.Entry<PrimNode, Integer> i : set) {
                if (start.distance + start.neighbours.get(i.getKey()) < i.getKey().distance) {
                    i.getKey().distance = start.distance + start.neighbours.get(i.getKey()); 
                }
                pq.add(i.getKey());
            }
            
            while(pq.size() > 0) {
                PrimNode thisNeighbour = pq.poll();
                System.out.println("calling for:" + thisNeighbour.name + " distance:" + start.neighbours.get(thisNeighbour));
                primsMST(thisNeighbour, start, start.neighbours.get(thisNeighbour));
            }
        }
        
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
        
        
        // v2 on prims based on PQ - so complexity is O(VlogV) + O(e)
        PrimNode a = new PrimNode("a");
        a.distance = 0;
        PrimNode b = new PrimNode("b");
        PrimNode c = new PrimNode("c");
        PrimNode d = new PrimNode("d");

        // add distances
        a.neighbours.put(b, 14);
        a.neighbours.put(c, 3);

        b.neighbours.put(d, 2);
        c.neighbours.put(d, 4);

        obj.primsMST(a, a, 0);
        
        Set<Map.Entry<PrimNode, HashMap<PrimNode, Integer>>> set = obj.outputNetwork.entrySet();
        for(Map.Entry<PrimNode, HashMap<PrimNode, Integer>> i : set) {
            System.out.print("Node: " + i.getKey().name);
            Set<Map.Entry<PrimNode, Integer>> j = i.getValue().entrySet();
            for(Map.Entry<PrimNode, Integer> k : j) {
                System.out.print(" - neighbour:" + k.getKey().name + " distance:" + k.getValue());
            }
            System.out.println();
        }
        
    }

}
