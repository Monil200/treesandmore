package treesandmore;
import java.util.*;

public class Node {
    int data;
    Node left;
    Node right;
    public Node(int val){
       this.data = val;
       this.left = null;
       this.right = null;
    }
}

class BinarySearchTree{
    public static Node root;
    public BinarySearchTree() {
        this.root = null;
    }
    
    public void insert(int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
            return;
        } else {
            Node current = root;
            while(true) {
                if (current.data > newNode.data) {
                    if (current.left != null) {
                        current = current.left;
                        continue;
                    } else {
                        current.left = newNode;
                        return;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                        continue;
                    } else {
                        current.right = newNode;
                        return;
                    }
                }
            }
        }
    }
   
    
    public int height(Node root) {
        if (root != null) {
            int lDepth = height(root.left);
            int rDepth = height(root.right);
            if (lDepth >= rDepth) {
                System.out.println(root.data + "------" + " | ldepth" + (lDepth+1) + '\n');
                return lDepth+1;
            } else {
                System.out.println(root.data + "------" + " | rdepth" + (rDepth+1) + '\n');
                return rDepth+1;
            }
        } else {
            return 0;
        }
    }
    
    public void delete(Node root, int val) {
        if (root == null) {
            return;
        } else {
            Node parent = root;
            Node current = root;
            Boolean isLeft = false;
            // find location of parent and current target to be deleted.
            while(current.data != val && current!=null) {
                parent = current;
                current = (parent.data > val) ? parent.left : parent.right;
                if (parent.data > val) {
                    isLeft = true;
                } else {
                    isLeft = false;
                }
            }
            if (current == null) {
                return; // no node found.
            }
            // case 1 - node to be deleted is leaf node
            if (current.left == null && current.right == null) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (current.left == null && current.right != null) {
                if (isLeft) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            } else if (current.left != null && current.right == null) {
                if (isLeft) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            } else {
                // find smallest element in the tree where current is root
            }
        }
    }
    
    public Node find(Node root, int val) {
        Node current = root;
        while(current!=null) {
            if (current.data == val) {
                return current;
            } else if (current.data > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }
    
    public void preorderTraversal(Node root) {
        if (root!=null) {
            preorderTraversal(root.left);
            System.out.print(root.data + " | ");
            preorderTraversal(root.right);
        }
    }
    
    public void inorderTraversal(Node root) {
        if (root!=null) {
            System.out.print(root.data + " | ");
            inorderTraversal(root.left);
            inorderTraversal(root.right);
        }
    }
    
    public void inorderTraversalNoRecursion(Node root) {
        if (root == null) {
            return;
        } else {
            Node temp = root;
            Deque<Node> q = new LinkedList<Node>();
            while(!q.isEmpty() || temp != null) {
                if (temp != null) {
                   q.push(temp);
                   temp = temp.left;
                } else {
                    temp = q.pop();
                    System.out.print(temp.data + " , ");
                    temp = temp.right;
                }
            }
        }
    }
    
    public void postorderTraversal(Node root) {
        if (root!=null) {
            postorderTraversal(root.right);
            postorderTraversal(root.left);
            System.out.print(root.data + " | ");
        }
    }
    
    public void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            Queue<Node> q = new LinkedList<Node>();
            Node temp;
            q.add(root);
            while(!q.isEmpty()){
                temp = q.poll();
                System.out.print(temp.data + " , ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }
    
    public void spiralOrderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            Queue<Node> q = new LinkedList<Node>();
            int counter = 0;
            Node temp;
            q.add(root);
            while(!q.isEmpty()){
                temp = q.poll();
                System.out.print(temp.data + " , ");
                if (counter % 2 == 0 ) {
                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                } else {
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                }
                counter++;
            }
        }
    }
    
    public static void main(String args[]) {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(2);
        b.insert(1);
        b.insert(4);
        b.insert(5);
        System.out.println("\n----------Preorder Traversal------------");
        b.preorderTraversal(root);
        System.out.println("\n----------InOrder Traversal-------------");
        b.inorderTraversal(root);
        System.out.println("\n----------Postorder Traversal-------------");
        b.postorderTraversal(root);
        Node findNode = b.find(root, 100);
        if (findNode!= null)
            System.out.println("\n----------Find a node-------------" + findNode.data);
        else
            System.out.println("\n----------Find a node - No Result found-------------");
       b.delete(root, 4);
       System.out.println("\n----------Preorder Traversal after deletion-------------");
       b.preorderTraversal(root);
       System.out.println("\n----------Height of BST-------------");
       System.out.println(b.height(root));
       b.insert(4);
       b.insert(3);
       System.out.println("\n----------LevelOrder traversal of BST-------------");
       b.levelOrderTraversal(root);
       System.out.println("\n----------Spiral traversal of BST-------------");
       b.spiralOrderTraversal(root);
       System.out.println("\n----------InOrder Traversal-------------");
       b.inorderTraversal(root);
       System.out.println("\n----------InOrder Traversal No recurrsion-------------");
       b.inorderTraversalNoRecursion(root);
    }
}