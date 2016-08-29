package treesandmore;
import java.util.*;


public class SpiralTraversal {
    
    public static Node root;
    public SpiralTraversal() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node newNode = new Node(val);
            Node current = root;
            while(true) {
                if (newNode.data < current.data) {
                    if (current.left !=null) {
                        current = current.left;
                        continue;
                    } else {
                        current.left = newNode;
                        return;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
//                        continue;
                    } else {
                        current.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    
    public void inorderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.println(root.data + ",");
            inorderTraversal(root.right);
        }
    }
    
    // using  2 stacks
    public void spiralTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.add(root);
            Node temp;
            while(!s1.isEmpty()) {
                temp = s1.pop();
                System.out.print(temp.data+ ",");
                if (temp.left!=null) {
                    s2.add(temp.left);
                }
                if (temp.right!=null) {
                    s2.add(temp.right);
                }
                if (s1.isEmpty()) {
                    while(!s2.isEmpty()) {
                        temp = s2.pop();
                        System.out.print(temp.data+ ",");
                        if (temp.right!=null) {
                            s1.add(temp.right);
                        }
                        if (temp.left!=null) {
                            s1.add(temp.left);
                        }
                    }
                }
            }
        }
    }
    
    // using  2 stacks
    public void printExtremeLevelNodesAlternate(Node root) {
        if (root == null) {
            return;
        } else {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.add(root);
            Node temp;
            Boolean shouldPrintLeftMost = true;
            Boolean shouldPrintRightMost = true;
            while(!s1.isEmpty()) {
                shouldPrintRightMost = true;
                temp = s1.pop();
                if (shouldPrintLeftMost) {
                    System.out.print(temp.data+ ",");
                    shouldPrintLeftMost = false; 
                }
                if (temp.left!=null) {
                    s2.add(temp.left);
                }
                if (temp.right!=null) {
                    s2.add(temp.right);
                }
                if (s1.isEmpty()) {
                    shouldPrintLeftMost = true;
                    while(!s2.isEmpty()) {
                        temp = s2.pop();
                        if (shouldPrintRightMost) {
                            System.out.print(temp.data+ ",");
                            shouldPrintRightMost = false;
                        }
                        if (temp.right!=null) {
                            s1.add(temp.right);
                        }
                        if (temp.left!=null) {
                            s1.add(temp.left);
                        }
                    }
                }
            }
        }
    }
    
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpiralTraversal b = new SpiralTraversal();
        b.insert(4);
        b.insert(2);
        b.insert(1);
        b.insert(3);
        b.insert(8);
        b.insert(6);
        b.insert(9);
        b.insert(0);
        b.insert(10);
        b.inorderTraversal(root);
        System.out.println("\n Spiral with 2 queues");
        b.spiralTraversal(root);
        System.out.println("\n printExtremeLevelNodesAlternate");
        b.printExtremeLevelNodesAlternate(root);
        }

}
