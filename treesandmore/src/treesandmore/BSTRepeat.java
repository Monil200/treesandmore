package treesandmore;

import java.util.*;
//class Node {
//    int data;
//    Node left;
//    Node right;
//    public Node(int val) {
//        this.data = val;
//        this.left=null;
//        this.right = null;
//    }
//}

public class BSTRepeat {
    
    public static Node root;
    public BSTRepeat(){
        root = null;
    }
    
    public void insert(int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            while(true) {
                if (newNode.data > current.data) {
                    if (current.right != null) {
                        current = current.right;
                        continue;
                    } else {
                        current.right = newNode;
                        return;
                    }
                } else {
                    if (current.left != null) {
                        current= current.left;
                        continue;
                    } else {
                        current.left = newNode;
                        return;
                    }
                }
            }
        }
    }
    
    public int height(Node root) {
        if (root != null) {
            int ldepth = height(root.left);
            int rdepth = height(root.right);
            if (ldepth >= rdepth) {
                System.out.println(root.data + "------" + " | ldepth" + (ldepth+1) + '\n');
                return ldepth + 1;
            } else {
                System.out.println(root.data + "------" + " | ldepth" + (rdepth+1) + '\n');
                return rdepth + 1;
            }
        } else {
            return 0;
        }
    }
    
    public Node find(Node root,int val){
        if (root==null) {
            return null;
        } else {
            if (root.data == val) {
                return root;
            } else if (root.data > val) {
                find(root.left, val);
            } else {
                find(root.right, val);
            }
            return null;
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
    
    public void levelOrderTraversal(Node root) {
        if (root==null) {
            return;
        } else {
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);
            while(!q.isEmpty()) {
                Node temp = q.poll();
                System.out.println(temp.data);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }
    
    public void iterativeInorder(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.println("--------Iterative InOrder-----");
            Stack<Node> s = new Stack<Node>();
            Node current = root;
            while(!s.isEmpty() || current!= null) {
                if (current!=null){
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
            System.out.println("\n--------Iterative PreOrder-----");
            Stack<Node> s = new Stack<Node>();
            Node current = root;
            s.push(current);
            while(!s.isEmpty()) {
                current = s.pop();
                System.out.print(current.data + ",");
                if (current.right!=null) {
                    s.push(current.right);
                }
                if (current.left!=null) {
                    s.push(current.left);
                }
            }
        }
    }
    
    public void iterativePostorder(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.println("\n--------Iterative PostOrder-----");
            Stack<Node> s = new Stack<Node>();
            Stack<Node> storeReversePostOrder = new Stack<Node>();
            Node current = root;
            s.push(current);
            while(!s.isEmpty()) {
                current = s.pop();
                storeReversePostOrder.push(current);
                if (current.left!=null) {
                    s.push(current.left);
                }
                if (current.right!=null) {
                    s.push(current.right);
                }
            }
            while(!storeReversePostOrder.isEmpty()){
                current = storeReversePostOrder.pop();
                System.out.print(current.data + ",");
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BSTRepeat bst = new BSTRepeat();
        bst.insert(4);
        bst.insert(2);
        bst.insert(6);
//        bst.inorderTraversal(root);
        System.out.println("Height is : " + bst.height(root));
        System.out.println("Finding Node... : " + bst.find(root, 4).data);
        bst.levelOrderTraversal(root);
        bst.iterativeInorder(root);
        bst.iterativePreorder(root);
        bst.iterativePostorder(root);
    }

}
