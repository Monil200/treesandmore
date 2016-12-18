package postbuilding42;
import java.util.*;
class NaryNode {
    String name;
    String desig;
    List<NaryNode> reportees;
    public NaryNode(String n, String d) {
        name = n;
        desig = d;
        reportees = new ArrayList<NaryNode>();
    }
}

public class NaryTree {
    NaryNode root;
    NaryTree() {
    }
    
    
    public void insert(NaryNode manager, NaryNode e) {
        if (root == null) {
            root = new NaryNode(e.name, e.desig);
            return; // please have ur ceo
        } else {
            Stack<NaryNode> s = new Stack<NaryNode>();
            s.push(root);
            
            while(!s.isEmpty()) {
                NaryNode temp = s.pop();
                List<NaryNode> list = temp.reportees;
                for(NaryNode i : list) {
                    if (manager == i) {
                        i.reportees.add(e);
                        System.out.println("added");
                    } else {
                        List<NaryNode> j = i.reportees;
                        for(NaryNode k : j) {
                            s.push(k);
                        }
                    }
                }
            }
        }
        
    }
    
    public void traverse(NaryNode root) {
        if (root == null) {
            return;
        } else {
            List<NaryNode> l = root.reportees;
            System.out.println(root.name + "- " + root.desig);
            for(NaryNode i : l) {
                traverse(i);
            }
        }
    }
    
    public static void main(String args[]) {
        NaryNode e = new NaryNode("Monil", "CEO");
        NaryTree obj = new NaryTree();
        
        NaryNode e1 = new NaryNode("e1", "d1");
        NaryNode e2 = new NaryNode("e2", "d2");
        NaryNode e3 = new NaryNode("e3", "d1");
        
        
        NaryNode e4 = new NaryNode("e4", "d3");
        NaryNode e5 = new NaryNode("e5", "d5");
        NaryNode e6 = new NaryNode("e6", "d1");
        
        
        
        obj.insert(null, e); // ceo with no manager
        obj.root.reportees.add(e1);
        obj.root.reportees.add(e2);
        obj.root.reportees.add(e3);
//        obj.insert(e, e1);
//        obj.insert(e, e2);
//        obj.insert(e, e3);
        
        obj.insert(e2, e4);
        obj.insert(e2, e5);
        obj.insert(e1, e6);
        
        obj.traverse(obj.root);
        
        
        
    }
    
    
}
