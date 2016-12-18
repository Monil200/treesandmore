package nontrees;
import java.util.Stack;
public class MaxHistogramArea {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1,2,2,1};
        Stack<Integer> s = new Stack<Integer>();
        int top = -1;
        int currentArea = 0;
        int maxArea = 0;
        s.push(0);
        top++;
        for(int i=1;i<a.length;i++) {
            if (a[i] >= a[s.peek()]) {
                s.push(i);
                top++;
            } else {
                while(a[s.peek()] > a[i] && s.size() > 0) {
                    currentArea = a[s.peek()]*(i-top);
                    s.pop();
                    top--;
                    if (currentArea > maxArea) {
                        maxArea = currentArea;
                    }
                    currentArea = 0;
                }
                s.push(i);
            }
        }
        
        // at this point, stack can be non empty. So empty it
        int i = a.length;
        while(s.size() > 0) {
            currentArea = a[s.peek()]*(s.peek() + 1);
            s.pop();
            System.out.println(currentArea + "-");
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }
            currentArea = 0;
        }
        
        System.out.println(maxArea);
    }

}
