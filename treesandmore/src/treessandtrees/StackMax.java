package treessandtrees;
import java.util.*;
class StackNode {
    StackNode next, prev;
    int data;
    StackNode(int val) {
        data = val;
    }
}
public class StackMax {
    StackNode head,top;
    HashMap<Integer, ArrayList<StackNode>> maxMap;
    ArrayList<StackNode> maxLink;
    int maxVal;
    StackMax() {
        maxVal = Integer.MIN_VALUE;
        maxLink = new ArrayList<StackNode>(); 
        maxMap= new HashMap<Integer, ArrayList<StackNode>>();
        head = top = null;
    }
    public void insert(int val) {
        StackNode newNode = new StackNode(val);
        if (head == null) {
            head = new StackNode(val);
            top = head;
        } else {
            top.next = newNode;
            newNode.prev = top;
            top = newNode;
        }
        if (maxVal < newNode.data) {
            maxVal = newNode.data;
            if (!maxMap.containsKey(maxVal)) {
                maxMap.put(maxVal, new ArrayList<StackNode>(Arrays.asList(newNode)));
            } else {
                ArrayList<StackNode> temp = maxMap.get(maxVal);
                temp.add(newNode);
                maxMap.put(maxVal, new ArrayList<StackNode>(temp));
            }
            maxLink.add(newNode);
        } else {
            StackNode temp= maxLink.get(maxLink.size() -1);
            maxLink.add(temp); // create max copy;
        }
    }
    
    public void pop() {
        if (head == null) {
            return;
        } else {
            if (head == top) {
                System.out.println("Popped from Stack:" + top.data);
                maxMap.clear();
                maxLink.clear();
                head = top = null;
                maxVal = Integer.MIN_VALUE;
            } else {
                System.out.println("Popped from Stack" + top.data);
                updateMax(top.data);
            }
        }
    }
    
    public void updateMax(int top) { // after normal pop and after popMax
//        System.out.println("------top:" + top + " maxVal:" + maxVal);
        if (top == maxVal) {
            // 1. Get from maxLink
            StackNode xTop = maxLink.get(maxLink.size() - 1);
//            System.out.println("-------Removed:" + maxLink.remove(maxLink.size()-1).data);
            maxLink.remove(maxLink.size()-1); // remove from max link

            // 2. Adjust maxMap
            
            ArrayList<StackNode> temp = maxMap.get(maxVal);
            if (temp.size() > 1) {
                temp.remove(temp.size() -1);
                maxMap.put(maxVal, new ArrayList<StackNode>(temp)); // reduced list by 1
            } else {
                maxMap.remove(maxVal);
            }
            
            // 3. adjust linklist
            if (head == xTop) {
                head = head.next;
            } else if (this.top == xTop) {
                this.top = this.top.prev;
            } else { // its middle element
                StackNode prev = xTop.prev;
                StackNode next = xTop.next;
                prev.next = next;
                next.prev = prev;
                
                
            }
            
            //4
            if (maxLink.size() > 0)
                maxVal = maxLink.get(maxLink.size()-1).data;
        } else {
            if (maxLink.size() > 0) {
                maxVal = maxLink.get(maxLink.size()-1).data;
                maxLink.remove(maxLink.size()-1);
            }
            this.top = this.top.prev;
        }
    }
    public void getTop() {
        if (head == null) {
            return;
        } else {
            System.out.println("Peek Stack Top is:" + top.data);
        }
    }
    
    public void getMaxStack() {
        if (head == null) {
            return;
        } else {
            System.out.println("Peek Stack top:" + maxVal);
        }
    }
    
    public void popMaxStack() {
        if (head == null) {
            return;
        } else {
            System.out.println("Pop Stack top:" + maxLink.get(maxLink.size()-1).data);
            updateMax(maxLink.get(maxLink.size()-1).data);
        }
    }
    
    public void populateMaxLink() {
        if (maxLink.size() == 0) {
            return;
        }
        Iterator<StackNode> it = maxLink.iterator();
        while(it.hasNext()) {
            System.out.print(it.next().data + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StackMax obj = new StackMax();
        obj.insert(2);
        obj.insert(3);
        obj.insert(1);
        obj.insert(4);
        obj.getMaxStack();
        obj.pop();
        obj.getMaxStack();
        obj.popMaxStack();
        
        obj.populateMaxLink();
        obj.getTop();
        
        
    }

}
