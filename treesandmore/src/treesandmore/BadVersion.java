package treesandmore;

public class BadVersion {
    public static int apiCalledCount = 0;
    public static boolean isBadVersion(int n) {
        apiCalledCount++;
        if (n >= 90) { // 26th is the version from where the bug got introduced.
            return true;
        }
        return false;
    }
    
    // min is the first version of the product,
    // high is the latest product version;
    public static void findBadVersion(int n, int min, int max) { // given a version n, find the version from which the product became bad
        Boolean currentVersion;
        int high = max;
        int low = min;
        int ncopy = 0;
        while(ncopy != n) {
            currentVersion = isBadVersion(n);
            if (currentVersion) {
                high = n;
            }
            if (!currentVersion) {
                low = n;
            }
            ncopy = n;
            n = (low+high)/2;
            System.out.println(n);
        }
        System.out.println("The version from which the product became bad is " + n + " , it resulted in " + apiCalledCount + " api calls to find it out.");
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        findBadVersion(50, 0 ,100);
    }

}
