package LinkedLists;

import java.util.*;

public class MaxSumLL {
    
    public Node push(Node head,int  val) {
        if (head == null) {
            return new Node(val);
        } else {
            Node current = new Node(val);
            current.next = head;
            head = current;
            return head;
        }
    }
    
    public void traversal(Node head) {
        if (head == null) {
            return;
        } else {
            Node temp = head;
            while(temp!=null) {
                System.out.print(temp.data+ ",");
                temp = temp.next;
            }
        }
    }
    
    public void mergeLL(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return;
        } else {
            int sum1 = 0;
            int sum2 = 0;
            Node current1 = head1;
            Node current2 = head2;
            Node resultNode = null;
            List<Integer> l1 = new ArrayList<Integer>();
            List<Integer> l2 = new ArrayList<Integer>();
            List<Integer> tempList = new ArrayList<Integer>();
            while(true) {
                if (current1!=null && current2== null) {
                    while(current1!=null) {
                        resultNode = push(resultNode, current1.data);
                        current1 = current1.next;
                    }
                    System.out.println("\n Result node till now");
                    traversal(resultNode);
                    break;
                }
                if (current2!=null && current1== null) {
                    while(current2!=null) {
                        resultNode = push(resultNode, current2.data);
                        current2 = current2.next;
                    }
                    System.out.println("\n Result node till now");
                    traversal(resultNode);
                    break;
                }
                while(current1!=null && current2!=null && current1.data < current2.data) {
                    sum1 += current1.data;
                    l1.add(current1.data);
                    current1= current1.next;
                }
                while(current2!=null && current1!=null && current2.data < current1.data) {
                    sum2 += current2.data;
                    l2.add(current2.data);
                    current2= current2.next;
                }
                if (current1!=null && current2!=null && current1.data == current2.data) {
                    if (sum1 >= sum2) {
                        tempList = l1;
                    } else {
                        tempList = l2;
                    }
                    Iterator<Integer> i = tempList.iterator();
                    while(i.hasNext()) {
                        resultNode = push(resultNode, i.next());
                    }
                    resultNode = push(resultNode,current1.data); // push common node;
                    // clear stuff;
                    sum1 = 0;
                    sum2 = 0;
                    current1 = current1.next;
                    current2 = current2.next;
                    l1.clear();
                    l2.clear();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node head1 = null;
        MaxSumLL l = new MaxSumLL();
        head1 = l.push(head1,511);
        head1 = l.push(head1,240);
        head1 = l.push(head1,120);
        head1 = l.push(head1,90);
        head1 = l.push(head1,30);
        head1 = l.push(head1,3);
        head1 = l.push(head1,1);
        System.out.println("Traverse a LL1");
        l.traversal(head1);
        
        Node head2 = null;
        head2 = l.push(head2,249);
        head2 = l.push(head2,240);
        head2 = l.push(head2,125);
        head2 = l.push(head2,90);
        head2 = l.push(head2,32);
        head2 = l.push(head2,12);
        head2 = l.push(head2,3);
        head2 = l.push(head2,0);
        System.out.println("\nTraverse a LL2");
        l.traversal(head2);
        l.mergeLL(head1, head2);
    }

}
