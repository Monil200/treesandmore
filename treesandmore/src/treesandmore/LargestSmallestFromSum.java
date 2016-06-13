package treesandmore;
/*
 * Find smallest number with given number of digits and sum of digits
Input  : s = 9, d = 2
Output : 18
There are many other possible numbers 
like 45, 54, 90, etc with sum of digits
as 9 and number of digits as 2. The 
smallest of them is 18.
 */
public class LargestSmallestFromSum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int s= 45, d =5;
        String digit = "";
        digit += "1";
        s -=1;
        d -=1;
        int remainder;
        while(s > 0 && d > 0) {
            if (s>9) {
                s -= 9;
                d--;
                digit += "9";
            } else {
                digit += (Integer.toString(s));
                s -= s;
                d--;
            }
        }
        if (s > 0 && d == 0) {
            remainder = s +1;
            if (remainder >= 10) {
                System.out.println("Number cannot be formed with given constraints");
            } else {
                System.out.println("Smallest number is : " + remainder + digit.substring(1));
            }
        } else {
            System.out.println("Smallest number is : " + digit);
        }
    }

}
