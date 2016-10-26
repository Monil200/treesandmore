package treesandmore;
import java.util.*;
class NodeModified {
    int data;
    NodeModified left;
    NodeModified right;
    NodeModified prev;
    NodeModified next;
    public NodeModified(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
        this.prev = null;
        this.next = null;
    }
}
public class TreeToAllLL {
    
    public static NodeModified root;
    public static NodeModified head;
    
    public TreeToAllLL() {
        root = null;
        head = null;
    }
    
    public void llTraversal(NodeModified head) {
        if (head == null) {
            return;
        } else {
            while(head !=null) {
                System.out.print(head.data + ",");
                head = head.next;
            }
        }
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new NodeModified(val);
            return;
        } else {
            NodeModified current = root;
            while (true) {
                if (current.data > val) {
                    if (current.left !=null) {
                        current = current.left;
                        continue;
                    } else {
                        current.left = new NodeModified(val);
                        return;
                    }
                }
                if (current.data < val) {
                    if (current.right !=null) {
                        current = current.right;
                        continue;
                    } else {
                        current.right = new NodeModified(val);
                        return;
                    }
                }
            }
        }
    }
    public void inorder(NodeModified root) {
        if (root == null) {
            return;
        } else {
            inorder(root.left);
            System.out.print(root.data +  ",");
            inorder(root.right);
        }
    }
    
    public void BTtoSinglyLL(NodeModified root) {
        if (root == null) {
            return;
        } else {
            Stack<NodeModified> s = new Stack<NodeModified>();
            boolean isRootAssigned = false;
            NodeModified current = root;
            NodeModified prev = null;
            NodeModified ll = null;
            while(!s.isEmpty() || current!=null) {
                if (current!=null) {
                    s.push(current);
                    current = current.left;
                } else {
                    current = s.pop();
                    if (!isRootAssigned) {
                        head = current;
                        prev = head;
                        isRootAssigned = true;
                    } else {
                        ll = current;
                        prev.next = ll;
                        prev = ll;
                    }
                    current = current.right;
                }
            }
        }
    }
    
    public void BTtoDoublyLL(NodeModified root) {
        if (root == null) {
            return;
        } else {
            Stack<NodeModified> s = new Stack<NodeModified>();
            boolean isRootAssigned = false;
            NodeModified current = root;
            NodeModified prev = null;
            NodeModified ll = null;
            while(!s.isEmpty() || current!=null) {
                if (current!=null) {
                    s.push(current);
                    current = current.left;
                } else {
                    current = s.pop();
                    if (!isRootAssigned) {
                        head = current;
                        prev = head;
                        head.prev = null;
                        isRootAssigned = true;
                    } else {
                        ll = current;
                        prev.next = ll;
                        ll.prev = prev;
                        prev = ll;
                    }
                    current = current.right;
                }
            }
            System.out.println("\n Print Singly LL in reverse using Prev ppinter to check Double LL");
            while(ll!=null) {
                System.out.print(ll.data + ",");
                ll = ll.prev;
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeToAllLL obj = new TreeToAllLL();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(6);
        obj.insert(8);
        System.out.println("\n Inorder of tree");
        obj.inorder(root);
        System.out.println("\n Convert Tree to Singly LL inline");
        obj.BTtoSinglyLL(root);
        System.out.println("\n Print Singly LL");
        obj.llTraversal(head);
        
        System.out.println("\n Convert Tree to Singly Doubly LL inline");
        obj.BTtoDoublyLL(root);
        
        
    }

}
