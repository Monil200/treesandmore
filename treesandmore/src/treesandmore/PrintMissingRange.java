package treesandmore;

public class PrintMissingRange {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1, 3 ,9, 10,11,45,51};
        Integer available[] = new Integer[100];
        for(int i=0;i<available.length;i++) {
            available[i] = -1;
        }
        for(int i=0;i<a.length;i++) {
            available[a[i]] = 1;
        }
        int currentDiff = 0;
        int minSoFar = 0;
        int maxSoFar = 0;
        for(int i=0;i<available.length;i++) {
            if (available[i] == -1) {
                currentDiff++;
                if (minSoFar == 0) { // this means min not yer set;
                    minSoFar = i;
                }
                maxSoFar = i;
            } else {
                if (currentDiff == 1) {
                    System.out.print((i -1) + " , ");
                } else if (currentDiff >1) {
                    System.out.print(minSoFar + " - " + maxSoFar + " , ");
                }
                currentDiff = 0;
                minSoFar = 0;
                maxSoFar = 0;
            }
            if ( i == available.length-1) {
                if (currentDiff == 1) {
                    System.out.print((i -1) + " , ");
                } else if (currentDiff >1) {
                    System.out.print(minSoFar + " - " + maxSoFar + " , ");
                }
            }
        }
    }

}
