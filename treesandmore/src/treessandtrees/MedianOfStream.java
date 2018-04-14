package treessandtrees;
import java.util.*;
public class MedianOfStream {
    
    public void getMedian(int a[]) {
        
        PriorityQueue<Integer> right = new PriorityQueue<Integer>(); // min-heap
        PriorityQueue<Integer> left = new PriorityQueue<Integer>(
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return b- a;
                    }
                }
        ); // max-heap
        right.add(a[0]);
        for(int i=1;i<a.length;i++) {
            right.add(a[i]);
            if (Math.abs(right.size() - left.size()) > 1) {
                left.add(right.poll());
            }
            
            if ((right.size() + left.size()) % 2 ==0) {
                double res = (left.peek() + right.peek()) / 2f;
                System.out.println("Median ending data point " + i + " is:" + res);
            } else {
                System.out.println("Median ending data point " + i + " is:" + right.peek());
            }
        }
    }
    
    public void getMedianFromStreamInWindow(int a[], int w) {
        int window[] = new int[w];
        int windowPointer = 0;
        PriorityQueue<Integer> right = new PriorityQueue<Integer>(); // min-heap
        PriorityQueue<Integer> left = new PriorityQueue<Integer>(
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return b- a;
                    }
                }
        ); // max-heap
        
        for(int i=0;i<a.length;i++) {
            window[windowPointer++] = a[i];
            right.add(a[i]);
            if (Math.abs(right.size() - left.size()) > 1) {
                left.add(right.poll());
            }
            if (right.size() > left.size()) {
                left.add(right.poll());
                right.add(left.poll());
            }
            if (windowPointer >= w) {
                windowPointer = 0;
            }
            if ((i+1) >= w) {
                // printing result
                if ((right.size() + left.size()) % 2 ==0) {
                    double res = (left.peek() + right.peek()) / 2f;
                    System.out.println("Median ending data point width our window size " + i + " is:" + res);
                } else {
                    System.out.println("Median ending data point width our window size " + i + " is:" + right.peek());
                }
                
                // realign window
                if (right.contains(window[windowPointer])) {
                    right.remove(window[windowPointer]);
                } else if (left.contains(window[windowPointer])) {
                    left.remove(window[windowPointer]);
                }
            }
        }
        
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MedianOfStream obj = new MedianOfStream();
        int a[] = {5,6,7};
        obj.getMedian(a);
        
        // sliding window median
        int b[] = {1,3,-1,-3,5,3,6,7};
        obj.getMedianFromStreamInWindow(b, 3);
    }

}
