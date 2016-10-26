package treesandmore;
import java.util.*;
public class PreorderValidOrNo {
    public static Node root;
    
    public PreorderValidOrNo() {
        root = null;
    }
    
    public void inorderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.print(root.data + ",");
            inorderTraversal(root.right);
        }
    }
    
    public void createTreeFromPreorder(Node root, int a[]) {
        if (a.length == 0 || a == null) {
            return;
        } else {
            Stack<Node> rootTop = new Stack<Node>();
            root = new Node(a[0]);
            Node rootCopy = root;
            rootTop.push(rootCopy);
            for(int i=1;i<a.length;i++) {
                if (a[i] < rootCopy.data) {
                    rootCopy.left = new Node(a[i]);
                    rootTop.push(rootCopy.left);
                    rootCopy = rootCopy.left;
                } else {
                    while(rootTop.peek().data < a[i]) {
                        rootCopy = rootTop.pop();
                        if (rootTop.isEmpty()) {
                            break;
                        }
                    }
                    rootCopy.right = new Node(a[i]);
                    rootTop.push(rootCopy.right);
                    rootCopy = rootCopy.right;
                }
            }
            inorderTraversal(root);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int a[] = {40, 30, 35, 80, 100};
        int a[] = {40, 30, 35, 20, 80, 100};
        PreorderValidOrNo obj = new PreorderValidOrNo();
        
        obj.createTreeFromPreorder(root, a);
        
    }

}
