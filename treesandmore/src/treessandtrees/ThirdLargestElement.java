package treessandtrees;

public class ThirdLargestElement {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {9 ,8 ,2 ,5 ,10};
        
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
        
        for(int i=0;i<a.length;i++) {
            if(a[i] > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = a[i];
            } else if(a[i] > secondMax) {
                thirdMax = secondMax;
                secondMax = a[i];
            } else if (a[i] > thirdMax) {
                thirdMax = a[i];
            }
            System.out.println("max:" + max + " secondMax:" + secondMax + " thirdMax:" + thirdMax);
        }
        System.out.println("3rd max element is:" + thirdMax);
    }

}
