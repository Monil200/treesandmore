package nontrees;

public class IncreasingTriplet {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int a[] = {5, 4, 3, 2, 1};
        int a[] = {1, 2, 3, 4, 5};
        int num = Integer.MAX_VALUE,num2 = Integer.MAX_VALUE,num3 = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++) {
            if (a[i] < num) {
                num = a[i];
            } else if(a[i] < num2) {
                num2 = a[i];
            } else if (a[i] < num3) {
                num3= a[i];
            }
        }
        
        System.out.println("3 nums are:" + num + ", " + num2 + ", " + num3);
    }

}
