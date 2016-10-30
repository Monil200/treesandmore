package nontrees;

public class BinarySearchVariations {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1,2,2,3,4,5,5,5,6,7,8,9,10};
        int mid = a.length/2;
        int start = 0;
        int end = a.length;
        int target = 10;
        while(start <= end) {
            mid = (start + end)/2;
            if (a[mid] == target) {
                System.out.println("Data found at location: " + mid);
                break;
            } else if (a[mid] > target) {
                end = mid-1;
            } else if (a[mid] < target) {
                start = mid+1;
            }
        }
        getFirstOccourance(a, 5);
        getLastOccourance(a, 5);
    }
    
    public static void getFirstOccourance(int a[], int target) {
        int end = a.length;
        int start = 0;
        int mid = (start + end) /2;
        
        while(start <= end) {
            if (a[mid] == target && a[mid] > a[mid-1]) {
                System.out.println("First occourence found at location: " + mid);
                break;
            } else if (a[mid] == target && a[mid] == a[mid-1]) {
                mid -=1;
            } else if (a[mid] > target) {
                end = mid-1;
                mid = (start + end) /2;
            } else if(a[mid] < target) {
                start = mid+1;
                mid = (start + end) /2;
            }
        }
        
    }
    
    public static void getLastOccourance(int a[], int target) {
        int end = a.length;
        int start = 0;
        int mid = (start + end) /2;
        
        while(start <= end) {
            if (a[mid] == target && a[mid] < a[mid+1]) {
                System.out.println("Last occourence found at location: " + mid);
                break;
            } else if (a[mid] == target && a[mid] == a[mid+1]) {
                mid +=1;
            } else if (a[mid] > target) {
                end = mid-1;
                mid = (start + end) /2;
            } else if(a[mid] < target) {
                start = mid+1;
                mid = (start + end) /2;
            }
        }
        
    }

}
