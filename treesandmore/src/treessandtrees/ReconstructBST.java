package treessandtrees;
import java.util.*;
public class ReconstructBST {
    Node first,current,last, root;
    ReconstructBST() {
        first= current= last = null;
    }
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node current = root;
            Node newNode = new Node(val);
            while(true) {
                if (current.data >= val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = newNode;
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = newNode;
                        break;
                    }
                }
            }
        }
        
    }
    
    public void reconstruct(Node root) {
        if (root == null) {
            return;
        } else {
            Stack<Node> st = new Stack<Node>();
            Node current = root;
            Node prev = null;
            ArrayList<Node> list = new ArrayList<Node>(); 
            while(!st.isEmpty() || current!= null) {
                if (current!=null) {
                    st.push(current);
                    current = current.left;
                } else {
                    current = st.pop();
                    if (prev!=null && prev.data > current.data) {
                        list.add(prev);
                        list.add(current);
                    } // it will have max size 4
                    prev = current;
                    current = current.right;
                }
            }
            
            // 
            if (list.size() == 2) {
                int temp = list.get(0).data;
                list.get(0).data = list.get(1).data;
                list.get(1).data = temp;
            } else if (list.size() == 4) {
                int temp = list.get(0).data;
                list.get(0).data = list.get(3).data;
                list.get(3).data = temp;
            } else {
                System.out.print("No reconstruction needed!");
            }
        }
    }
    
    public void inorder(Node root) {
        if (root == null)
            return;
        else {
            inorder(root.left);
            System.out.print(root.data + ",");
            inorder(root.right);
        }
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReconstructBST obj = new ReconstructBST();
        obj.insert(15);
        obj.root.left = new Node(1);
        obj.root.left.left = new Node(2);
        obj.root.left.right = new Node(8);
        obj.root.right = new Node(20);
        obj.inorder(obj.root);
        
        obj.reconstruct(obj.root);
        System.out.println("\n Tree reconstructed......");
        obj.inorder(obj.root);
        
    }

}
