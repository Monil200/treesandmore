package treesandmore;

import java.util.Arrays;

class Stack1 {
    public static int a[] = new int[10];
    public static int link[] = new int[a.length];
    public static int ava = 0;
    
    int top;
    public Stack1() {
        this.top = -1;
    }
    
    public void push(int val) { //// top represents from which array to push
        if (link[ava] == -1) {
            System.out.println("STack overflow");
            return;
        }
        a[ava] = val;
        this.top = ava;
        int tempAva = link[ava]; // current ava points to next ava 
        link[ava] = this.top; // then ava will be replaced by current stack's top where push is initiated.
        ava = tempAva;
    }
    
    public void pop() {
        if (this.top == -1) {
            System.out.println("Stack underflow");
            return;
        }
        System.out.println("Popped from stack: " + a[this.top]);
        a[this.top] = -1; // -1 means empty position is 'a' array
        int newAva = this.top;
        this.top = link[this.top];
        int tempAva = ava;
        ava = newAva;
        link[newAva] = tempAva;
    }
}
public class KStacksInArray {
    public static void main(String args[]) {
        int count=1;
        for(int i=0;i<(Stack1.a.length-1);i++) {
            Stack1.link[i] = count++; // 0th empty position points to 1
        }
        Stack1.link[Stack1.a.length-1] = -1; // last link points to overflow;
        Stack1 s1 = new Stack1();
        Stack1 s2 = new Stack1();
        System.out.println(Arrays.toString(Stack1.link));
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(3);
        s1.push(3);
        s1.push(3);
        s1.push(3);
        s1.push(3);
        s1.push(3);
        s1.push(3);
        s1.pop();
        s2.push(33);
        s2.pop();
        s2.push(33);
        
        System.out.println(Arrays.toString(Stack1.a));
        System.out.println(Arrays.toString(Stack1.link));
        System.out.println(Stack1.ava);
        System.out.println(s2.top);
    }
}
