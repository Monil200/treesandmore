package aaplQuYelBay;
import java.util.*;
class NodeAll {
    int data, size,height, sum;
    NodeAll left,right;
    NodeAll(int val) {
        data = val;
    }
}
public class TreeAll {
    NodeAll root;
    TreeAll() {
        root = null;
    }
     public void insert(int val) {
        if (root == null) {
            root = new NodeAll(val);
        } else {
            NodeAll current = root;
            while(true) {
                if (current.data >= val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new NodeAll(val);
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new NodeAll(val);
                        break;
                    }
                }
            }
        }
    }
     
    public void inorder(NodeAll root) {
         if (root == null)
             return;
         inorder(root.left);
         System.out.print(root.data + " (size: " + root.size + ", Height:" + root.height + "), ");
         inorder(root.right);
    }
    
    public boolean isBST(NodeAll root) {
        if (root == null) {
            return true;
        } else {
            boolean isLeftOk = (root.left != null) ? root.data >= root.left.data : true;
            boolean isRightOk = (root.right != null) ? root.data < root.right.data : true;
            
            return isLeftOk && isRightOk && isBST(root.left) && isBST(root.right);
        }
    }
    
    public boolean isHeightBalanced(NodeAll root) {
        if (root == null) {
            return true;
        } else {
            int leftSize = (root.left != null) ? root.left.height : 0;
            int rightSize = (root.right != null) ? root.right.height : 0;
            
            return (Math.abs(leftSize - rightSize) <= 1 && isHeightBalanced(root.left) && isHeightBalanced(root.right));
        }
    }
    
    public int setSize(NodeAll root) {
        if (root == null) {
            return 0 ;
        } else {
            root.size = 1 + setSize(root.left) + setSize(root.right);
            return root.size;
        }
    }
    public int setHeight(NodeAll root) { // we would set the max height 
        if (root == null) {
            return 0 ;
        } else {
            int left = setHeight(root.left);
            int right = setHeight(root.right);
            root.height =  1 + Math.max(left, right);
            return root.height;
        }
    }
    
    // all tasks
    // diameter
    public void getDiameter(NodeAll root, int res[]) {
        if (root == null) {
            return;
        } else {
            int leftHeight = (root.left != null) ? root.left.height : 0;
            int rightHeight = (root.right != null) ? root.right.height : 0;
            
            if (res[0] < (leftHeight + rightHeight + 1)) {
                res[0] = (leftHeight + rightHeight + 1);
            }
            getDiameter(root.left, res);
            getDiameter(root.right, res);
        }
    }
    
    // traversals
    public void levelOrder(NodeAll root) {
        if (root == null)
            return;
        Queue<NodeAll> q = new LinkedList<NodeAll>();
        NodeAll current = root;
        q.add(current);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                current = q.remove();
                size--;
                System.out.print(current.data + ",");
                if (current.left!=null) {
                    q.add(current.left);
                }
                if (current.right!=null) {
                    q.add(current.right);
                }
            }
            System.out.println();
        }
    }
    
    public int sumTree(NodeAll root) {
        if (root == null)
            return 0;
        root.sum = root.data + sumTree(root.left) + sumTree(root.right);
        return root.sum;
    }
    public void inorderSum(NodeAll root) {
        if (root == null)
            return;
        inorderSum(root.left);
        System.out.print(root.data + " (sum: " + root.sum + "), ");
        inorderSum(root.right);
    }
    
    public void iterativeInorder(NodeAll root) {
        if (root == null)
            return;
        Stack<NodeAll> s = new Stack<NodeAll>();
        NodeAll current = root;
        while(!s.isEmpty() || current!=null) {
            if (current!=null) {
                s.push(current);
                current = current.left;
            } else {
                current = s.pop();
                System.out.print(current.data + ",");
                current = current.right;
            }
        }
    }
    
    public void iterativePreorder(NodeAll root) {
        if (root == null)
            return;
        Stack<NodeAll> s = new Stack<NodeAll>();
        NodeAll current = root;
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
    
    NodeAll predecessor;
    public void predecessor(NodeAll root, int i, NodeAll parent) { // find greatest value smaller than i 
        if (root == null) {
            return;
        } else {
            if (root.data >= i) {
                predecessor(root.left, i, parent);
            } else if (root.data < i) {
                predecessor = root;
                predecessor(root.right, i, root);
            } 
        }
    }
    
    //unique BSTs
    HashSet<String> uniqueBST = new HashSet<String>();
    public String findUniqueBSTs(NodeAll root) {
        if (root == null) {
            return "#";
        } else {
            String ret = root.data + "," + findUniqueBSTs(root.left) + "," + findUniqueBSTs(root.right);
            uniqueBST.add(ret);
            return ret;
        }
    }
    
    // deserialize now
    public NodeAll deserializeHelper(NodeAll root, int a[], String s[]) {
        if (s[a[0]].equals("#")) {
            return null;
        } else {
            root = new NodeAll(Integer.parseInt(s[a[0]]));
            a[0]++;
            root.left =  deserializeHelper(root, a, s);
            a[0]++;
            root.right =  deserializeHelper(root, a, s);
            return root;
        }
    }
    
    public NodeAll getLCA(NodeAll root, int a, int b) {
        if (root == null) {
            return null;
        } else {
            if (root.data == a || root.data == b) {
                return root;
            }
            NodeAll left = getLCA(root.left, a, b);
            NodeAll right = getLCA(root.right, a, b);
            
            if (left != null && right != null) {
                return root;
            }
            return (left!= null) ? left : right;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeAll obj = new TreeAll();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        System.out.println("\n Is the tree BST?->"  + obj.isBST(obj.root));
        System.out.println("\n Is the tree Height Balanced? -> "  + obj.isHeightBalanced(obj.root));
        obj.setSize(obj.root);
        obj.setHeight(obj.root);
        obj.inorder(obj.root);
        
        
        // get diameter
        int a[] = {Integer.MIN_VALUE};
        obj.getDiameter(obj.root, a);
        System.out.println("\n Diamater?->"  + a[0]);
        
        System.out.println("\n Level order traversal");
        obj.levelOrder(obj.root);
        
        System.out.println("\n Traversal after sum tree");
        obj.sumTree(obj.root);
        obj.inorderSum(obj.root);
        
        System.out.println("\n Inorder Traversal iterative");
        obj.iterativeInorder(obj.root);
        
        System.out.println("\n Preorder Traversal iterative");
        obj.iterativePreorder(obj.root);
        
        System.out.println("\n Predecessor of a node");
        obj.predecessor(obj.root, 2, null);
        System.out.println("\n Predecessor of a node is with root:" + obj.predecessor.data); // need to find the rightmost element of subtree rooted with predecessor
        
        System.out.println("\n unique BSTs node");
        String serializehelper = obj.findUniqueBSTs(obj.root);
        System.out.println(obj.uniqueBST);
        
        System.out.println("\n Serialize Deserialize node, we got final root,left,right combo from above method");
        NodeAll newRoot = null;
        int counter[] = {0};
        newRoot = obj.deserializeHelper(newRoot, counter, serializehelper.split(","));
        obj.iterativeInorder(newRoot);
        
        System.out.println("\n LCA recursive..");
        NodeAll LCANode = null;
        LCANode = obj.getLCA(obj.root, 1, 4);
        System.out.println("\n LCA is.." + LCANode.data);
    }

}
