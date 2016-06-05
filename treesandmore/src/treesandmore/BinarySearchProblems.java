package treesandmore;

public class BinarySearchProblems {
    public static int[] a = {1, 3, 5 ,7, 9 ,11,13, 15 ,17 ,19};
    public static int[] b = {1,1,1,1,1, 3, 5 ,7, 9 ,9,9,9,11,13, 15 ,17 ,19};
    public void PredessorSuccessor(int low, int high, int key) {
        int currentPredessor = a[low];
        int currentSuccessor = a[high];
        int mid;
        while (high >= low) {
            mid = (high + low) /2;
            if (a[mid] == key) {
                System.out.println("No successor , predessor ." + a[mid] + " is the key found");
            }
            if (a[mid] > key) {
                currentSuccessor = a[mid];
                high = mid - 1;
            } else {
                currentPredessor = a[mid];
                low = mid + 1;
            }
        }
        System.out.println("Predessor: " + currentPredessor + " Successor: " + currentSuccessor);
        
    }
    
    public void firstOccurance(int low, int high, int key) {
        while(high >= low) {
            int mid = (low + high) /2;
            if ((mid==0 ||  b[mid-1] < key) && b[mid] == key) {
                System.out.println("First occourance is : " + mid);
                return;
            }
            if (b[mid] > key) {
                high = mid-1;
            } else if (b[mid] == key) {
                high = mid-1;
            } else {
                low = mid +1;
            }
        }
    }
    
    public void lastOccurance(int low, int high, int key) {
        while(high >= low) {
            int mid = (low + high) /2;
            if ((mid==b.length-1 ||  b[mid+1] > key) && b[mid] == key) {
                System.out.println("Last occourance is : " + mid);
                return;
            }
            if (b[mid] > key) {
                high = mid-1;
            } else if (b[mid] == key) {
                low = mid+1;
            } else {
                low = mid +1;
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinarySearchProblems obj = new BinarySearchProblems();
        obj.PredessorSuccessor(0, a.length -1, 6);
        obj.firstOccurance(0, b.length-1, 1);
        obj.lastOccurance(0, b.length-1, 9);
    }

}
