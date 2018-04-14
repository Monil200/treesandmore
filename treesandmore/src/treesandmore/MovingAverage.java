package treesandmore;
import java.util.*;
public class MovingAverage {
    
    public void getAverage(int a[], int w) { // window of with w
        if (a.length < w) {
            return;
        }
        int window[] = new int[w];
        int windowPointer = 0, runningSum = 0;
        for(int i=0;i<w;i++) {
            runningSum += a[i];
            window[i] = a[i];
        }
        for(int i=w;i<a.length;i++) {
            System.out.println("Average for window ending:" + i + " - " + runningSum/w);
            runningSum -= window[windowPointer];
            window[windowPointer++] = a[i];
            runningSum += a[i];
            if (windowPointer >= 3) {
                windowPointer = 0;
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MovingAverage obj = new MovingAverage();
        int a[] = {5,7,2,1,4,6,4,7};
        obj.getAverage(a, 3);
    }

}
