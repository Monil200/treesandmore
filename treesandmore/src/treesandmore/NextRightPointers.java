package treesandmore;

import java.util.*;
class NodeRight {
    int data;
    NodeRight left, right,next;
    NodeRight(int val) {
        data = val;
    }
}
public class NextRightPointers {
    NodeRight root;
    public NextRightPointers() {
        root = null;
    }

    public void insert(int val) {
        if (root == null) {
            root = new NodeRight(val);
            return;
        } else {
            NodeRight current = root;
            while (true) {
                if (current.data > val) {
                    if (current.left !=null) {
                        current = current.left;
                        continue;
                    } else {
                        current.left = new NodeRight(val);
                        return;
                    }
                }
                if (current.data < val) {
                    if (current.right !=null) {
                        current = current.right;
                        continue;
                    } else {
                        current.right = new NodeRight(val);
                        return;
                    }
                }
            }
        }
    }
    public void inorderTraversal(NodeRight root) {
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.print(root.data +  " , ");
            inorderTraversal(root.right);
        }
    }
    
    public void levelOrder(NodeRight root) {
        if (root == null)
            return;
        Queue<NodeRight> q = new LinkedList<NodeRight>();
        q.add(root);
        NodeRight temp = null;
        NodeRight next = null;
        boolean isTail = true;
        int qcount = q.size();
        while(!q.isEmpty()) {
            while(qcount > 0) {
                next = temp;
                temp = q.remove();
                qcount--;
                if (isTail) {
                    temp.next = null;
                } else {
                    temp.next = next;
                }
                if (temp.right!=null) {
                    q.add(temp.right);
                }
                if (temp.left!=null) {
                    q.add(temp.left);
                }
                isTail = false;
            }
            qcount = q.size();
            isTail = true;
        }
    }
    
    public void displayUsingRightNextPointers(NodeRight root) { // store only first element of every level
        if (root == null)
            return;
        Queue<NodeRight> q = new LinkedList<NodeRight>();
        q.add(root);
        NodeRight current = null;
        boolean isFirstWhile = true;
        int qcount = q.size();
        while(!q.isEmpty()) {
            isFirstWhile = true;
            while(qcount > 0) {
                current = q.remove();
                qcount--;
                if (current.left!=null) {
                    q.add(current.left);
                }
                if (current.right!=null) {
                    q.add(current.right);
                }
                if (isFirstWhile) {
                    NodeRight temp = current;
                    while(temp!=null) {
                        System.out.print(temp.data + ",");
                        temp = temp.next;
                    }
                    System.out.println();
                }
                isFirstWhile = false;
            }
            isFirstWhile = true;
            qcount  = q.size();
        }
    }
     
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NextRightPointers obj = new NextRightPointers();
        obj.insert(4);
        obj.insert(2);
        obj.insert(6);
        obj.insert(1);
        obj.insert(3);
        obj.inorderTraversal(obj.root);
        
        obj.levelOrder(obj.root);
        System.out.println("\n Display tree using next right pointers");
        obj.displayUsingRightNextPointers(obj.root);
    }

}
