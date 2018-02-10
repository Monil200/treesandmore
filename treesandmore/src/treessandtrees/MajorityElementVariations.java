package treessandtrees;

public class MajorityElementVariations {
    public void getMajority(int a[]) { // voting algorithm
        int count = 1;
        int element = 0;
        
        for(int i=0;i<a.length;i++) {
            if (a[i] != element) {
                count--;
                if (count < 1) {
                    element = a[i];
                    count=1;
                }
            } else {
                count++;
            }
        }
        
        if (count > 1) {
            System.out.println("We have a majority element");
        } else {
            System.out.println("We DO NOT have a majority element");
        }
    }
    
    public void getMajorityElementOneThird(int a[]) { // majority greater than n/3
        int count1=1,count2 = 0;
        int element1=a[0],element2 = a[0];// cancel each other
        
        for(int i=0;i<a.length;i++) {
            if (a[i] == element1) {
                count1++;
            } else if (a[i] == element2) {
                count2++;
            } else if (count1 == 0) {
                element1 = a[i];
                count1++;
            } else if (count2 == 0) {
                element2 = a[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2=0;
        for(int i=0;i<a.length;i++) {
            if (a[i] == element1) count1++;
            if (a[i] == element2) count2++;
        }
        
        if (count1>a.length/3) {
            System.out.println("We have a majority element - majority by n/3: " + element1 );
        }
        if (count2>a.length/3) {
            System.out.println("We have a majority element - majority by n/3:" + element2 );
        }
    
        
    }
    
    
    
    public static void main(String[] args) {
        MajorityElementVariations obj = new MajorityElementVariations();
        int a[] = {2,1,3};
        obj.getMajority(a);
        
        int b[] = {1,2,3,1};
        obj.getMajorityElementOneThird(b);
    }
}
