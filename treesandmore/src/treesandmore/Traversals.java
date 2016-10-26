package treesandmore;

import java.util.*;

public class Traversals {
    public static Node root;
    
    public Traversals() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node current = root;
            Node newNode = new Node(val);
            while(true) {
                if (current.data > val) {
                    if (current.left !=null) {
                        current = current.left;
                    } else {
                        current.left = newNode;
                        break;
                    }
                } else {
                    if (current.right!=null) {
                        current = current.right;
                    } else {
                        current.right = newNode;
                        break;
                    }
                }
            }
        }
    }
    
    public void inorderTraversal(Node root){
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.print(root.data + ",");
            inorderTraversal(root.right);
        }
    }
    
    public void levelorderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            Queue<Node> s = new LinkedList<Node>();
            Node current = root;
            s.add(current);
            while(!s.isEmpty()) {
                current = s.remove();
                System.out.print(current.data + ",");
                if (current.left != null) {
                    s.add(current.left);
                }
                if (current.right != null) {
                    s.add(current.right);
                }
            }
        }
    }
    
    public void spiralTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            
            Node current = root;
            s1.push(current);
            while(!s1.isEmpty() || !s2.isEmpty()) {
                
                while(!s1.isEmpty()) {
                    current = s1.pop();
                    System.out.print(current.data + ",");
                    if (current.left != null) {
                        s2.push(current.left);
                    }
                    if (current.right != null) {
                        s2.push(current.right);
                    }
                }
                
                while(!s2.isEmpty()) {
                    current = s2.pop();
                    System.out.print(current.data + ",");
                    if (current.right != null) {
                        s1.push(current.right);
                    }
                    if (current.left != null) {
                        s1.push(current.left);
                    }
                }
            }
        }
    }
    
    public void iterativeInorder(Node root) {
        if (root == null) {
            return;
        } else {
            Stack<Node> s = new Stack<Node>();
            Node current = root;
            while(!s.isEmpty() || current != null) {
                if (current != null) {
                    s.push(current);
                    current = current.left;
                } else {
                    current = s.pop();
                    System.out.print(current.data + ",");
                    current = current.right;
                }
            }
        }
    }
    
    public void iterativePreorder(Node root) {
        if (root == null) {
            return;
        } else {
            Stack<Node> s = new Stack<Node>();
            Node current = root;
            s.push(current);
            while(!s.isEmpty()) {
                current = s.pop();
                System.out.print(current.data + ",");
                if (current.right != null) {
                    s.push(current.right);
                }
                if (current.left != null) {
                    s.push(current.left);
                }
            }
        }
    }
    
    // do flipped post order ie root right left and store everything in stack
    public void iterativePostorder(Node root) {
        if (root == null) {
            return;
        } else {
            Stack<Node> s = new Stack<Node>();
            Stack<Node> reversePostorder = new Stack<Node>();
            Node current = root;
            s.push(current);
            while(!s.isEmpty()) {
                current = s.pop();
                reversePostorder.push(current);
//                System.out.print(current.data + ",");
                if (current.left != null) {
                    s.push(current.left);
                }
                if (current.right != null) {
                    s.push(current.right);
                }
            }
            
            while(!reversePostorder.isEmpty()) {
                System.out.print(reversePostorder.pop().data + ",");
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Traversals obj = new Traversals();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(7);
        obj.insert(6);
        obj.insert(8);
        obj.inorderTraversal(root);
        System.out.println("\nLevel order traversal using 1 Queue is:\n");
        obj.levelorderTraversal(root);
        
        System.out.println("\n Spiral order traversal using 2 stack is:\n");
        obj.spiralTraversal(root);
        
        System.out.println("\n Iterative inorder traversal using 1 stack is:\n");
        obj.iterativeInorder(root);
        
        System.out.println("\n Iterative preorder traversal using 1 stack is:\n");
        obj.iterativePreorder(root);
        
        System.out.println("\n Iterative postorder traversal using 1 stack is:\n");
        obj.iterativePostorder(root);
        
    }

}
