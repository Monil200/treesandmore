package treesandmore;
//Find the Largest number with given number of digits and sum of digits
//How to find the largest number with given digit sum s and number of digits d?
public class LargetNumberWithNDigits {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int s = 20, d = 4;
        int sCopy = 20;
        String finalN="";
        int currentSum = 0;
        for (int i=0;i<d;i++) {
            for(int j=9;j>=0;j--) {
                if (s>=j) {
                    finalN += j+"";
                    s -= j;
                    currentSum +=j;
                    break;
                }
            }
        }
        if (currentSum < sCopy) {
            System.out.println("Digit cannot be formed with given sum : " + s);
        } else {
            System.out.println(finalN); // digit formed ..yeah!!
        }
    }

}
