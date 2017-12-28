package treessandtrees;
//https://www.programcreek.com/2014/08/leetcode-nested-list-weight-sum-ii-java/
import java.util.*;
class NestedList {
    
    List<NestedList> node;
    List<Integer> val;
    NestedList(){
        val = new ArrayList<Integer>();
        node = new ArrayList<NestedList>();
    }
}
public class NestedListWeightSum {
    HashMap<Integer, List<Integer>> depthNote;
    int depth;
    NestedListWeightSum() {
        depth = 1;
        depthNote = new HashMap<Integer, List<Integer>>();
    }
    public void flattenInStack(NestedList a) {
        Iterator<Integer> k = a.val.iterator();
        
        //part 1 - insert List
        while(k.hasNext()) {
            if (depthNote.containsKey(depth)) {
                List<Integer> existing = depthNote.get(depth);
                // merge 2 arrayLists
                existing.add(k.next());
                depthNote.put(depth, existing);
            } else {
                List<Integer> newInsert = new ArrayList<Integer>();
                newInsert.add(k.next());
                depthNote.put(depth, newInsert);
            }
        }
        
        // part 2 - recursive call
        if (a.node != null && a.node.size() > 0) {
            Iterator<NestedList> i = a.node.iterator();
            while(i.hasNext()) {
                NestedList temp = i.next();
                ++depth;
                flattenInStack(temp);
            }
        }
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NestedList objMain = new NestedList();
        NestedList obj1 = new NestedList();
        obj1.val.add(2);
        obj1.val.add(3);
        NestedList obj2 = new NestedList();
        obj1.val.add(4);
        obj1.val.add(5);
        
        NestedList obj11 = new NestedList();
        obj11.val.add(11);
        obj1.node.add(obj11);
        
        objMain.val.add(1);
        objMain.node.add(obj1);
        objMain.node.add(obj2);
        NestedListWeightSum instance = new NestedListWeightSum();
        instance.flattenInStack(objMain);
        System.out.println("depth " + instance.depth);
        instance.depth--;
        Set<Map.Entry<Integer, List<Integer>>> i = instance.depthNote.entrySet();
        int result = 0;
        
        for(Map.Entry<Integer, List<Integer>> j : i) {
            System.out.print(j.getKey() + "\t");
            List<Integer> temp = j.getValue();
            Iterator<Integer> it = temp.iterator();
            while(it.hasNext()) {
                int val = it.next();
                result += val*instance.depth;
                System.out.print(val + "(" + instance.depth + "), ");
            }
            instance.depth--;
            System.out.println();
        }
        System.out.println("Final result " + result);
    }
    
    

}
