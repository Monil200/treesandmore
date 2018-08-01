package toD;

public class BinarySearchAll {
    
    public void normalBS(int a[], int start, int end, int target) {
        if (a.length == 0) return;
        
        int mid = (end + start)/2;
        
        while(end > start) {
            mid = (end + start)/2;
            if (a[mid] == target) {
                System.out.println("Target found at location:" + mid);
                break;
            } else if (a[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
    }
    
    public void getFirstInstance(int a[], int start, int end, int target) {
        if (a.length == 0) return;
        
        int mid = (end + start)/2;
//        int a1[] = {1,2,2,3,3,4,4};
        while(end >= start) {
            mid = (end + start)/2;
            //System.out.println("start:" + start + " mid:" + mid + " end:" + end + " a[mid-1]:" + a[mid-1] + " a[mid]:" + a[mid] + " target:" + target);
            
            if ((a[mid] == target && mid == 0) || (mid > 0 && a[mid] == target && a[mid-1] < a[mid])) {
                System.out.println("Target's first instance found at location:" + mid);
                break;
            } else if (target > a[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
    }
    
    public void getLastInstance(int a[], int start, int end, int target) {
        if (a.length == 0) return;
        
        int mid = (end + start)/2;
        
        while(end >= start) {
            mid = (end + start)/2;
//            System.out.println("start:" + start + " mid:" + mid + " end:" + end + " a[mid+1]:" + a[mid+1] + " a[mid]:" + a[mid] + " target:" + target);
            if ((a[mid] == target && mid == a.length-1) || (mid <= a.length-2 && a[mid] == target && a[mid+1] > a[mid])) {
                System.out.println("Target's Last instance found at location:" + mid);
                break;
            } else if (target >=a[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinarySearchAll obj = new BinarySearchAll();
        int a[] = {1,2,3,4,5,6};
        obj.normalBS(a, 0, a.length, 4);
        
        int a1[] = {1,2,2,3,3,4,4};
        obj.getFirstInstance(a1, 0, a1.length, 3);
        
        int a2[] = {1,2,3,3,4,4,5};
        obj.getLastInstance(a2, 0, a2.length, 4);
        
    }

}
