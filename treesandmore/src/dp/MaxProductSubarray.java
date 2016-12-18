package dp;

public class MaxProductSubarray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {-2, -3, 0, -2, -40};
        int maxProd = 1;
        int prodSoFar = 1;
        
        for(int i=0;i<a.length;i++) {
            if (a[i] != 0) {
                prodSoFar *= a[i];
                maxProd = Math.max(maxProd, prodSoFar);
            } else {
                prodSoFar = 1;
            }
        }
        System.out.println(maxProd);
    }

}
