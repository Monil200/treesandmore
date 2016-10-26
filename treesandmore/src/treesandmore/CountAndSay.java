package treesandmore;

public class CountAndSay {

    public static void countNumber(String s, int k) {
        int count = 0;
        String numberWithCount = "";
        char num;
        char pnum; //previous num
        int digit=1;
        while(count<k) {
            pnum = s.charAt(0);
            System.out.println(s + "<- s at the start");
            for(int i=1;i<s.length();i++) {
                num = s.charAt(i);
                if (pnum == num) {
                    digit++;
                } else {
                    numberWithCount += (Integer.toString(digit) + (pnum + ""));
                    digit =1;
                }
                pnum = num;
            }
          numberWithCount += (Integer.toString(digit) + (pnum + "")); // because last char might not reach the else part where string concatanation happens
          digit = 1;
          s = numberWithCount;
          count++;
          System.out.println(numberWithCount);
          numberWithCount = "";
        }
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a = "11223344";
        int k = 3;
        countNumber(a,k);
    }

}
