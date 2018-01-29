package treessandtrees;
// check quetion before trying to think
// https://www.geeksforgeeks.org/longest-consecutive-sequence-binary-tree/
class NodeLength extends Node {
    int length;
    NodeLength left,right;
    NodeLength(int val) {
        super(val);
        length=0;
    }
}
public class BTLongestConsequitiveSequence {
    NodeLength root;
    int maxLength;
    BTLongestConsequitiveSequence() {
        root = null;
        maxLength = Integer.MIN_VALUE;
    }
    public void insert(int val) {
        if (root == null) {
            root = new NodeLength(val);
        } else {
            NodeLength newNode = new NodeLength(val);
            NodeLength current = root;
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
    
    public void inorder(NodeLength root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " (" + root.length + ") ");
        inorder(root.right);
    }
    
    public void longestConsequitiveSequence(NodeLength root, int currLength, int exp) {
        if (root == null) {
            return;
        } else {
            if (root.data == exp) {
                currLength++;
            } else {
                currLength = 1;
            }
            maxLength = Math.max(maxLength, currLength);
            longestConsequitiveSequence(root.left, currLength, root.data + 1);
            longestConsequitiveSequence(root.right, currLength, root.data + 1);
            
            
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BTLongestConsequitiveSequence obj = new BTLongestConsequitiveSequence();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        obj.longestConsequitiveSequence(obj.root, 0, 0);
//        obj.inorder(obj.root);
        System.out.print(obj.maxLength);
    }

}
