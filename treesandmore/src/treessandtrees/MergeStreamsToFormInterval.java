package treessandtrees;
class Interval {
    int start, end;
    Interval left, right;
    boolean isValid;
    Interval(int s, int e) {
        start = s;
        end = e;
        isValid = true;
    }
}
public class MergeStreamsToFormInterval {
    Interval root;
    MergeStreamsToFormInterval() {
        root =null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Interval(val, val);
        } else {
            Interval current = root;
            while(true) {
                System.out.println("I m here for:"+ val);
                if (current.start == val+1) {
                    Interval temp = getleftMaxInterval(current);
                    if (temp != null && temp.end == val-1) {
                        current.start = temp.start;
                        temp.isValid = false;
                        break;
                    } else {
                        current.start = val;
                        break;
                    }
                } else if (current.end == val-1) {
                    Interval temp = getRightMinInterval(current);
                    if (temp != null && temp.start == val+1) {
                        current.end = temp.end;
                        temp.isValid = false;
                        break;
                    } else {
                        current.end = val;
                        break;
                    }
                } else if (current.start > val) {
                    if (current.left!= null) {
                        current = current.left;
                    } else {
                        current.left = new Interval(val,val);
                        break;
                    }
                } else if (current.end < val) {
                    if (current.right!= null) {
                        current = current.right;
                    } else {
                        current.right = new Interval(val,val);
                        break;
                    }
                }
            }
            
        }
    }
    
    public Interval getRightMinInterval(Interval root) {
        if (root.right == null)
            return null;
        Interval current = root;
        while(current.right != null) {
            current = current.right;
        }
        if (current == root)
            return null;
        return current;
    }
    
    public Interval getleftMaxInterval(Interval root) {
        if (root.left == null)
            return null;
        Interval current = root;
        while(current.left != null) {
            current = current.left;
        }
        if (current == root)
            return null;
        return current;
    }
    
    public void inorder(Interval root) {
        if (root == null)
            return;
        System.out.println("I m here");
        inorder(root.left);
        if (root.isValid)
            System.out.println("[" + root.start + ", " + root.end + "], ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MergeStreamsToFormInterval obj = new MergeStreamsToFormInterval();
        obj.insert(3);
        obj.insert(1);
        obj.insert(8);
        obj.insert(7);
        obj.insert(2);
        obj.insert(4);
        obj.insert(10);
        obj.insert(11);
        obj.inorder(obj.root);
    }

}
