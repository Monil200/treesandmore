package treessandtrees;

class NodeC {
    int data;
    double capacity;
    NodeC left,right;
    NodeC(int val) {
        data = val;
        capacity = 0;
    }
}
public class BinaryTreeGlassFill {
    public NodeC root;
    int timeConsumed;
    int levelAtRefill = 0;
    BinaryTreeGlassFill() {
        root = null;
        timeConsumed = 1;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new NodeC(val);
        } else {
            NodeC current = root;
            while(true) {
                if (current.data >= val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new NodeC(val);
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new NodeC(val);
                        break;
                    }
                }
            }
        }
    }
    
    public void inorder(NodeC root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.data + " - capacity " + root.capacity);
        inorder(root.right);
    }
    
    public void fillNodes(NodeC root, double inFlow) {
        if (root == null || inFlow == 0) {
            return;
        } else {
            if (inFlow <= 1) {
                root.capacity = inFlow;
                return;
            } else {
                root.capacity = 1;
                inFlow -= 1;
                if(root.left != null && root.right!= null) {
                    fillNodes(root.left, inFlow/2);
                    fillNodes(root.right, inFlow/2);
                } else if (root.left != null) {
                    fillNodes(root.left, inFlow);
                } else if (root.right != null) {
                    fillNodes(root.right, inFlow);
                }
            }
        }
    }
    
    // all nodes have cap limit of 1 unit of water
    // we will have faucet with N units of water/sec i.e rate = X units/sec,
    // find total time to fill all nodes
    public void fillNodesTimeCalculate(NodeC root, int rate, double unitsOfWater, int level) {
        if (root == null) {
            return;
        } else {
            System.out.print("data->" + root.data + "| level" + level);
            if(unitsOfWater >=1 ) {
                root.capacity = 1;
                unitsOfWater -=1;
                System.out.print(" | capacity->" + root.capacity);
            } else {
                root.capacity = unitsOfWater;
                System.out.print(" | capacity else->" + root.capacity);
                unitsOfWater = rate;
                if (this.levelAtRefill < level) {
                    ++timeConsumed;
                }
                levelAtRefill = level;
                System.out.print(" | levelAtRefill->" + levelAtRefill + " | timeConsumed" + timeConsumed);
                fillNodesTimeCalculate(root, rate, unitsOfWater, level);
            }
            System.out.println();
            ++level;
            fillNodesTimeCalculate(root.left, rate, unitsOfWater/2, level); 
            fillNodesTimeCalculate(root.right, rate, unitsOfWater/2, level);
        }
    }

    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinaryTreeGlassFill obj = new BinaryTreeGlassFill();
        obj.insert(4);
        obj.insert(2);
        obj.insert(3);
        obj.insert(1);
        obj.insert(6);
        obj.insert(7);
        obj.insert(5);
        obj.fillNodes(obj.root, 6);
        System.out.println("---------Inorder--------");
        obj.inorder(obj.root);
        obj.fillNodesTimeCalculate(obj.root, 4, 4, 0); // initially unitsOfWater == rate
        System.out.println("---------time consumed--------?" + obj.timeConsumed);
    }

}

