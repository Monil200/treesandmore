package nontrees;
// failsed google question...shyaa
public class PrintMissingRange {
    
    public void getRanges(int a[]) {
        int missingLower = 0;
        
        for(int i=0;i<a.length;i++) {
            if (a[i] == missingLower) {
                missingLower++;
            } else if (a[i] > missingLower) {
                if (a[i] - missingLower > 1) {
                    System.out.println(", " + missingLower + "-" + (a[i]-1));
                } else {
                    System.out.println(", " + missingLower);
                }
                missingLower = a[i]+1;
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1, 3 ,9, 10,11,45,51};
        PrintMissingRange obj = new PrintMissingRange();
        obj.getRanges(a);
    }

}
