package nontrees;

public class SmallestElementInRotatedArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int a[] = {6 ,7, 8, 9, 10, 3};
        
        int end = a.length-1;
        int start = 0;
        int mid;
        while(end >= start) {
            mid = (start + end) /2;
            System.out.println(" - " + mid + " - " +a[mid]);
            if (mid == end) {
                System.out.println(a[mid]);
                return;
            }
            if (a[mid] < a[mid-1]  && a[mid] < a[mid +1]) {
                System.out.println(a[mid]);
                return;
            } else if (a[end] < a[start]) {
                start = mid+1;
            } else if (a[end] > a[start]) {
                end = mid-1;
            }
        }
    }

}
