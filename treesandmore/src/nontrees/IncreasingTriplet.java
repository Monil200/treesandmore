package nontrees;

public class IncreasingTriplet {
    
    public static boolean increasingTripletOnePass(int a[]) {
        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        
        
        for(int i=0;i<a.length;i++) {
            if (a[i] < x) {
                x = a[i];
            } else if (a[i] < y) {
                y = a[i];
            } else {
                return true;
            }
        }
        
        return false;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {12,11,10,5,6,2,30};
        // smaller greater approach with 3 passes can be used to find total number of triplet subsequences in array 
        int smaller[] = new int[a.length];
        int greater[] = new int[a.length];
        
        for(int i=0;i<a.length;i++) {
            smaller[i] = greater[i] = -1;
        }
        // smaller fill up
        int min = a[0];
        for(int i=1;i<a.length;i++) {
            if (a[i] > min) {
                smaller[i] = 1;
            } else if ( a[i] < min) {
                min = a[i];
            }
        }
        
        int max = a[a.length-1];
        for(int i=a.length-2;i>=0;i--) {
            if (a[i] < max) {
                greater[i] = 1;
            } else if ( a[i] > max) {
                max = a[i];
            }
        }
        
        for(int i=1;i<a.length-1;i++) {
            if (smaller[i] == greater[i] && greater[i] == 1) {
                System.out.println("Triplet found, mid is at -> " + i + " : " + a[i]);
            }
        }
        System.out.println("Do we have increasing triplet ?? " + increasingTripletOnePass(a));
    }

}
