package postbuilding42;
import java.util.*;
class Node {
    int data;
    Node left;
    Node right;
    public Node(int val) {
        data = val;
    }
}
public class TreesBasics {
    Node root;
    public TreesBasics() {
        
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node newNode = new Node(val);
            Node current = root;
            while(true) {
                if (current.data > val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = newNode;
                        return;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    
    public int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            return size(root.left) + size(root.right)  +1;
        }
    }
    
    public int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int ldepth = height(root.left);
            int rdepth = height(root.right);
            if (ldepth >= rdepth)
                return ldepth +1;
            else {
                return rdepth +1;
            }
        }
    }
    
    public void inorderTraversal(Node root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.data + "," );
        inorderTraversal(root.right);
    }
    
    
    public void doubleAtree(Node root) {
        if (root == null)
            return;
        else {
            doubleAtree(root.left);
            Node temp = root.left;
            root.left = new Node(root.data);
            root.left.left = temp;
            doubleAtree(root.right);
        }
    }
    
    public boolean isMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        else {
            return (root1.data == root2.data && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left));
        }
    }
    
    public boolean isBSTV1(Node root) {
        if (root == null) {
            return true;
        } else {
            boolean leftOk = true;
            boolean rightOk = true;
            if (root.left != null) {
                leftOk = (root.data >= root.left.data) ? true : false;
            }
            if (root.right != null) {
                rightOk = (root.data < root.right.data) ? true : false;
            }
            return (leftOk && rightOk && isBSTV1(root.left) && isBSTV1(root.right));
        }
    }
    
    public void rootToLeafPaths(Node root, ArrayList<Node> al) {
        if (root == null) {
            return;
        } else {
            al.add(root);
            if (root.left == null & root.right== null) {
                for(Node i: al) {
                    System.out.print(i.data + ",");
                }
                System.out.println();
            }
            rootToLeafPaths(root.left, new ArrayList<Node>(al));
            rootToLeafPaths(root.right, new ArrayList<Node>(al));
        }
    }
    
    
    public void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);
            int count = q.size();
            while(!q.isEmpty()) {
                while(count > 0) {
                    Node temp = q.remove();
                    count--;
                    System.out.print(temp.data + ",");
                    if (temp.left!=null)
                        q.add(temp.left);
                    if (temp.right!=null)
                        q.add(temp.right);
                }
                count = q.size();
                System.out.println();
            }
        }
    }
    
    public void spiralTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.add(root);
            while(!s1.isEmpty() || !s2.isEmpty()) {
                while(!s1.isEmpty()){
                    Node temp = s1.pop();
                    System.out.print(temp.data+",");
                    if (temp.left != null)
                        s2.add(temp.left);
                    if (temp.right != null)
                        s2.add(temp.right);
                }
                System.out.println();
                while(!s2.isEmpty()){
                    Node temp = s2.pop();
                    System.out.print(temp.data+",");
                    if (temp.right != null)
                        s1.add(temp.right);
                    if (temp.left != null)
                        s1.add(temp.left);
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreesBasics obj = new TreesBasics();
        obj.insert(4);
        obj.insert(2);
        obj.insert(6);
        obj.insert(3);
        obj.insert(1);
        System.out.println("\n The inorder traversal is");
        obj.inorderTraversal(obj.root);
        System.out.println("\n The size is: " + obj.size(obj.root));
        System.out.println("\n The height is: " + obj.height(obj.root));
        
        // mirror
        System.out.println("\n The Mirror section");
        TreesBasics obj1 = new TreesBasics();
        obj1.insert(4);
        obj1.root.left = new Node(6);
        obj1.root.right = new Node(2);
        obj1.root.right.left = new Node(3);
        obj1.root.right.right = new Node(1);
        System.out.println("\n The inorder traversal is");
        obj.inorderTraversal(obj.root);
        System.out.println("\n The inorder traversal is");
        obj.inorderTraversal(obj1.root);
        System.out.println("\n Are these trees mirror: " + obj.isMirror(obj.root, obj1.root)); 
        
        
        obj.doubleAtree(obj.root);
        System.out.println("\n The inorder traversal after doubling is");
        obj.inorderTraversal(obj.root);
        
        System.out.println("\n Is BST V1 ? " + obj.isBSTV1(obj.root));
        System.out.println("\n Is BST V1 ? " + obj1.isBSTV1(obj1.root));
        
        System.out.println("\n Root to leaf paths are: ");
        obj1.rootToLeafPaths(obj1.root, new ArrayList<Node>());
        
        System.out.println("\n level order traversal: ");
        obj1.levelOrderTraversal(obj1.root);
        
        System.out.println("\n The inorder traversal is");
        obj1.inorderTraversal(obj1.root);
        System.out.println("\n Spiral order traversal: ");
        obj1.spiralTraversal(obj1.root);
        
        
    }

}
