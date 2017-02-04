package post16;

import java.util.*;

class Node {
    Node left,right;
    Node next,prev;
    int data,height,size;
    Node(int val) {
        data = val;
        height = 0;
        size= 0;
    }
}

public class ReTreeBasics {
    Node root;
    Node head;
    
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
    
    public void inorderTraversal(Node root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.data + "," );
        inorderTraversal(root.right);
    }
    
    public int size(Node root) {
        if (root == null)
            return 0;
        else {
            return 1 + size(root.left) + size(root.right);
        }
    }
    
    public int height(Node root) {
        if (root == null)
            return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);
            if (lheight >= rheight)
                return 1+lheight;
            else 
                return 1+rheight;
        }
    }
    
    public boolean isBST(Node root) {
        if (root == null) {
            return true;
        } else {
            boolean isBst = true;
            if (root.left != null) {
                isBst = (root.data < root.left.data) ? false : true;
            }
            if (root.right != null) {
                isBst = (root.data > root.right.data) ? false : true;
            }
            
            return (isBst && isBST(root.left) && isBST(root.right)); 
        }
    }
    
    public void levelOrder(Node root) {
        if (root == null) {
            return;
        } else {
            Queue<Node> q = new LinkedList<Node>();
            Node current = root;
            q.add(current);
            while(!q.isEmpty()) {
                Node temp = q.remove();
                System.out.print(temp.data + ",");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }
    public void levelOrderZigZag(Node root) {
        if (root == null) {
            return;
        } else {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            Node current = root;
            s1.add(current);
            int i = 0;
            while(!s1.isEmpty() || !s2.isEmpty()) {
                while(!s1.isEmpty()) {
                    Node temp = s1.pop();
                    System.out.print(temp.data + ",");
                    if (temp.left!= null) {
                        s2.push(temp.left);
                    }
                    if (temp.right!= null) {
                        s2.push(temp.right);
                    }
                }
                System.out.println();
                while(!s2.isEmpty()) {
                    Node temp = s2.pop();
                    System.out.print(temp.data + ",");
                    if (temp.right!= null) {
                        s1.push(temp.right);
                    }
                    if (temp.left!= null) {
                        s1.push(temp.left);
                    }
                }
                System.out.println();
            }
        }
    }
    
    public void rootToLeafPath(Node root, List<Node> l, int sum) {
        if (root == null) {
            return;
        } else {
            sum += root.data;
            l.add(root);
            if (root.left == null && root.right == null) {
                for(Node i : l) {
                    System.out.print(i.data + ",");
                }
                System.out.println("sum: " + sum);
            }
            rootToLeafPath(root.left, new ArrayList<Node>(l),sum);
            rootToLeafPath(root.right, new ArrayList<Node>(l),sum);
        }
    }
    
    public void inorderIterative(Node root) {
        if (root == null) {
            return;
        } else {
            Stack<Node> s = new Stack<Node>();
            Node current = root;
            while(!s.isEmpty() || current!= null) {
                if (current!=null) {
                    s.push(current);
                    current = current.left;
                } else {
                    Node temp = s.pop();
                    System.out.print(temp.data + ",");
                    current = temp.right;
                }
            }
        }
    }
    
    public void BTtoSinglyLL(Node root) {
        if (root == null) {
            return;
        } else {
            Stack<Node> s = new Stack<Node>();
            boolean isHeadAssigned = false;
            Node current = root;
            Node prev = null;
            while(!s.isEmpty() || current!= null) {
                if (current!=null) {
                    s.push(current);
                    current = current.left;
                } else {
                    Node temp = s.pop();
                    if (!isHeadAssigned) {
                        isHeadAssigned = true;
                        head = temp;
                    } else {
                        prev.next = temp;
                    }
                    prev = temp;
                    current = temp.right;
                }
            }
            prev.next = null;
            System.out.println("\n Displaying Singly LL");
            Node ll = head;
            
            while(ll!=null) {
                System.out.print(ll.data + ",");
                ll = ll.next;
            }
        }
    }
    
    public void BTtoDoublyLL(Node root) {
        if (root == null) {
            return;
        } else {
            Stack<Node> s = new Stack<Node>();
            boolean isHeadAssigned = false;
            Node current = root;
            Node prev = null;
            while(!s.isEmpty() || current!= null) {
                if (current!=null) {
                    s.push(current);
                    current = current.left;
                } else {
                    Node temp = s.pop();
                    if (!isHeadAssigned) {
                        isHeadAssigned = true;
                        head = temp;
                    } else {
                        prev.next = temp;
                        temp.prev = prev;
                    }
                    prev = temp;
                    current = temp.right;
                }
            }
            prev.next = null;
            System.out.println("\n Displaying Double LL form head");
            Node ll = head;
            
            while(ll!=null) {
                System.out.print(ll.data + ",");
                ll = ll.next;
            }
            System.out.println("\n Displaying Double LL form tail");
            ll = prev;
            while(ll!=null) {
                System.out.print(ll.data + ",");
                ll = ll.prev;
            }
        }
    }
    
    public void iterativePreorder(Node root) {
        if (root == null)
            return;
        else {
            Stack<Node> s = new Stack<Node>();
            Node current = root;
            s.push(current);
            while(!s.isEmpty()) {
                Node temp = s.pop();
                System.out.print(temp.data + ",");
                if (temp.right != null)
                    s.add(temp.right);
                if (temp.left != null)
                    s.add(temp.left);
            }
            
        }
    }
    
    public int memoizedHeight(Node root) { // can be used to get diameter
        if (root == null) {
            return 0;
        } else {
            int lheight = memoizedHeight(root.left)+1;
            int rheight = memoizedHeight(root.right)+1;
            
            if (lheight >= rheight)
                root.height = lheight;
            else
                root.height = rheight;
            return root.height;
        }
    }
    
    public void memoizedHeightDisplay(Node root) {
        if (root == null)
            return;
        memoizedHeightDisplay(root.left);
        System.out.print(root.height + "," );
        memoizedHeightDisplay(root.right);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReTreeBasics obj = new ReTreeBasics();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(8);
        obj.inorderTraversal(obj.root);
        System.out.println("Size");
        System.out.println(obj.size(obj.root));
        System.out.println("Height");
        System.out.println(obj.height(obj.root));
        System.out.println("isBST?");
        System.out.println(obj.isBST(obj.root));
        System.out.println("levelOrder");
        obj.levelOrder(obj.root);
        System.out.println("\nlevelOrderZigZag");
        obj.levelOrderZigZag(obj.root);
        System.out.println("\n Root to leaf paths");
        obj.rootToLeafPath(obj.root, new ArrayList<Node>(),0);
        System.out.println("\n Inorder iterative");
        obj.inorderIterative(obj.root);
        System.out.println("\n BT to single LL");
        obj.BTtoSinglyLL(obj.root);
        System.out.println("\n BT to Doubly LL");
        obj.BTtoDoublyLL(obj.root);
        System.out.println("\n Iterative Preorder");
        obj.iterativePreorder(obj.root);
        System.out.println("\n memoised heights");
        obj.memoizedHeight(obj.root);
        obj.memoizedHeightDisplay(obj.root);
    }

}
