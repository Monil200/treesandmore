package nontrees;
import java.util.Stack;
public class MaxHistogramArea {
    
    public void getMaxAreaOfHistgram(int a[]) {
        int maxArea = Integer.MIN_VALUE;
        int currArea = 0;
        int top;
        Stack<Integer> s = new Stack<Integer>();
        
        s.push(0); // put index 0 by default.
        for(int i=1;i<a.length;i++) { // do something
            System.out.println(s.toString());
            if ((s.size() > 0 && a[i] >= a[s.peek()]) || (s.size() == 0)) {
                s.push(i);
            } else {
                while(s.size() > 0 && a[i] < a[s.peek()]) {
                    top = s.pop();
                    if (s.size() > 0) {
                        currArea = a[top]*(i - s.peek() - 1);
                    } else {
                        currArea = a[top]*i;
                    }
                    System.out.println("\t currArea:" + currArea + " max:" + maxArea);
                    if (currArea > maxArea) {
                        maxArea = currArea;
                    }
                }
                s.push(i);
            }
        }
        
        while (s.size() > 0) {
            top = s.pop();
            if (s.size() > 0) {
                currArea = a[top]*(a.length+1 - s.peek() - 1);
            } else {
                currArea = a[top]*a.length+1;
            }
            if (currArea > maxArea) {
                maxArea = currArea;
            }
        }
        
        System.out.println("Max histogram area is:" + maxArea);
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {6,2,5,4,5,1,6};
        MaxHistogramArea obj = new MaxHistogramArea();
        obj.getMaxAreaOfHistgram(a);
    }

}
