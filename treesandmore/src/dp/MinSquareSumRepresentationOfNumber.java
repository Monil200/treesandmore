package dp;

import java.util.Arrays;

public class MinSquareSumRepresentationOfNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int num = 16;
        int opt[] = new int[num+1];
        opt[0] = 1;
        opt[1] = 1;
        opt[2] = 2;
        opt[3] = 3;
        int maxSquareNumSoFar = 1;
        for(int i=4;i<= num ;i++) {
            if (Math.sqrt(i) % 1 == 0) {
                maxSquareNumSoFar = i;
                opt[i] = 1;
            } else {
                opt[i] = opt[maxSquareNumSoFar] + opt[i - maxSquareNumSoFar];
            }
        }
        System.out.println(Arrays.toString(opt));
        System.out.println("Min numbers to represent num: " + num + " with min numbers such that square of those num == num: " + opt[num]);
    }
}
