package treessandtrees;

import java.util.Stack;

class NodeLL {
    NodeLL next,prev, left,right;
    int data;
    NodeLL(int val) {
        next=prev=right=left = null;
        data = val;
    }
}

public class TreeToAllLinkLists {
    public NodeLL root;
    TreeToAllLinkLists() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new NodeLL(val);
        } else {
            NodeLL current = root;
            while(true) {
                if (current.data >= val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new NodeLL(val);
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new NodeLL(val);
                        break;
                    }
                }
            }
        }
    }
    
    public void inorder(NodeLL root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + ", ");
        inorder(root.right);
    }
    
    public void toSinglyLL(NodeLL root) {
        if (root == null)
            return;
        else {
            NodeLL current = root;
            Stack<NodeLL> s = new Stack<NodeLL>();
            NodeLL prev = null;
            NodeLL head = null;
            while(!s.isEmpty() || current!=null) {
                if (current!= null) {
                    s.push(current);
                    current= current.left;
                } else {
                    current = s.pop();
                    System.out.println(current.data + ", ");
                    if (prev == null) {
                        head = current;
                    } else {
                        prev.next = current;
                    }
                    prev = current;
                    current = current.right;
                }
            }
            prev.next = null;
            System.out.println("---------LL traversal--------");
            NodeLL temp = head;
            while(temp!= null) {
                System.out.print(temp.data + ", ");
                temp = temp.next;
            }
         }
    }
    
    public void toDoublyLL(NodeLL root) {
        if (root == null)
            return;
        else {
            NodeLL current = root;
            Stack<NodeLL> s = new Stack<NodeLL>();
            NodeLL prev = null;
            NodeLL head = null;
            while(!s.isEmpty() || current!=null) {
                if (current!= null) {
                    s.push(current);
                    current= current.left;
                } else {
                    current = s.pop();
                    System.out.println(current.data + ", ");
                    if (prev == null) {
                        head = current;
                        head.prev = null;
                    } else {
                        prev.next = current;
                        current.prev = prev;
                    }
                    prev = current;
                    current = current.right;
                }
            }
            prev.next = null;
            System.out.println("---------Doubly LL traversal--------");
            NodeLL temp = head;
            NodeLL last = null;
            while(temp!= null) {
                System.out.print(temp.data + ", ");
                last = temp;
                temp = temp.next;
            }
            System.out.println("---------Doubly LL traversal using prev ie reverse--------");
            while(last!= null) {
                System.out.print(last.data + ", ");
                last = last.prev;
            }
         }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeToAllLinkLists obj = new TreeToAllLinkLists();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        System.out.println("---------Inorder--------");
        obj.inorder(obj.root);
        System.out.println("---------Inorder Iterative--------");
        obj.toSinglyLL(obj.root);
        System.out.println("--------DOubly--------");
        obj.toDoublyLL(obj.root);
    }

}
