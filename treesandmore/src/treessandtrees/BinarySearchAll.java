package treessandtrees;

public class BinarySearchAll {
    
    
    public static int binarySearch(int a[], int low, int high, int target) {
        int mid = (low+high)/2;
        while(low < high) {
            mid = (low+high)/2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                high = mid-1;
            } else if (a[mid] < target) {
                low = mid+1;
            }
        }
        return mid;
    }
    
    public static int binarySearchGetFirst(int a[], int low, int high, int target) {
        int mid = (low+high)/2;
        while(low < high) {
            mid = (low+high)/2;
            if (a[mid] == target) {
                while(mid>0 && a[mid -1] == a[mid]) {
                    --mid;
                }
                return mid;
            } else if (a[mid] > target) {
                high = mid-1;
            } else if (a[mid] < target) {
                low = mid+1;
            }
        }
        return mid;
    }
    public static int binarySearchGetLast(int a[], int low, int high, int target) {
        int mid = (low+high)/2;
        while(low < high) {
            mid = (low+high)/2;
            if (a[mid] == target) {
                while(mid < a.length && a[mid + 1] == a[mid]) {
                    ++mid;
                }
                return mid;
            } else if (a[mid] > target) {
                high = mid-1;
            } else if (a[mid] < target) {
                low = mid+1;
            }
        }
        return mid;
    }
    /*
     * Check which half of the array is sorted and within that half make decision.
     * if 1st half is sorted, check if target is between low and mid and then decide
     * if second half is sorted, check if target is between mid and end and then decide.
     */
    public static int rotatedSortedArray(int a[], int low, int high, int target) {
        int mid = low+high/2;
        while(low < high) {
            mid = (low+high)/2;
            System.out.println("low - " + low + " Mid - " + mid + "high - " + high);
            if (a[mid] == target) {
                return mid;
            } else if (a[low] < a[mid]) {
                if (a[low] <= target && target <= a[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
                //int b[] = {7,8,9,10,11,12,13,14,2,3,4,5};
            } else {
                if (a[mid] <= target && target <= a[high]) {
                    low = mid+1; 
                } else {
                    high = mid-1;
                }
            }
        }
        return mid;
    }
    
    public static int rotatedSortedArrayStart(int a[], int low, int high) { // find the minimum is rotated sorted array
        int mid = low+high/2;
        while(low <= high) {
            mid = (low+high)/2;
            System.out.println("low - " + low + " Mid - " + mid + "high - " + high);
            if (Math.abs(low - high) <=2 ) {
                return Math.min(a[low], a[high]);
            }
            if (a[mid] < a[mid+1] && a[mid] < a[mid-1]) {
                return a[mid];
            } else if (a[low] < a[mid]) {
                if (a[mid] > a[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
                //int b[] = {7,8,9,10,11,3,4,5};
            } else {
                if (a[mid] > a[low]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return mid;
    }
    
    public static int sortedArrayInsertPosition(int a[], int low, int high, int target) {
        int mid = (low+high)/2;
        while(low < high) {
            mid = (low+high)/2;
            System.out.println("**--low - " + low + " Mid - " + mid + "high - " + high);
            if (a[mid] == target) {
                return mid;
                //int[] c = {6,80,90,100, 120};
            } else if (mid-1 >0 && a[mid] > target && a[mid-1] < target) { // can be separately handled
                return mid-1;
            } else if (mid +1 <= a.length && a[mid] < target && a[mid+1] > target) { // can be separately handled
               return mid+1;
            } else if(a[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return mid;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1,2,2,3,4,5,5,5,6,7,8,9,10};
        int target = 14;
        System.out.println("Target " + target + " found at pos: " + binarySearch(a, 0, a.length, target));
        System.out.println("Target " + target + " first occourance at pos:" + binarySearchGetFirst(a, 0, a.length, target));
        System.out.println("Target " + target + " last occourance at pos:" + binarySearchGetLast(a, 0, a.length, target));
        
        // rotated array.
        int target1 = 7;
        int b[] = {6,7,8,9,10,5};
//        System.out.println("Target " + target1 + " in rotated array at pos:" + rotatedSortedArray(b, 0, b.length-1, target1));
        System.out.println("Pivot of rotated array : " + rotatedSortedArrayStart(b, 0, b.length-1));
        
        int[] c = {6,80,90,100, 120};
        int target3 = 1;
        // if target < lowest || target > largest then handle separately
        System.out.println("position to insert new number in sorted array : " + sortedArrayInsertPosition(c, 0, c.length, target3));
    }

}
