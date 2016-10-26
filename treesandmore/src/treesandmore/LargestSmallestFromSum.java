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
        int s= 18, d =5;
        String digit = "";
        while(s > 0 && d > 0) {
            if (s>9) {
                digit+="9";
                s-=9;
                d--;
            } else {
                break;
            }
        }
        if(d>1) {
            digit+=(Integer.toString(s-1));
            d--;
            while(d>1) {
                digit+="0";
                d--;
            }
        }
        digit+="1";
        System.out.println("Smallest number formed is (in reverse)" + digit);
    }

}
