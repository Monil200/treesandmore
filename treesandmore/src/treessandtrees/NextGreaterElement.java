package treessandtrees;
import java.util.*;


public class NextGreaterElement {
    
    
    public void getNextGreaterElement(int a[]) {
        Stack<Integer> s = new Stack<Integer>();
        int res[] = new int[a.length];
        
        res[a.length-1] = -1; // base case;
        s.push(a[a.length-1]);
        
        for(int i=a.length-2;i>=0;i--) {
            if (s.peek() > a[i]) {
                res[i] = s.peek();
                s.push(a[i]);
            } else {
                while(s.size() > 0 && a[i] >= s.peek()) {
                    s.pop();
                }
                if (s.size() == 0) {
                    res[i] = -1;
                } else {
                    res[i] = s.peek();
                }
                s.push(a[i]);
            }
        }
        System.out.println(Arrays.toString(res));
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NextGreaterElement obj = new NextGreaterElement();
        int a[] = {1,5, 7, 9,12};
        obj.getNextGreaterElement(a);
    }

}
