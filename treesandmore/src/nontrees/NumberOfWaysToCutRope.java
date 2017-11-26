package nontrees;

public class NumberOfWaysToCutRope {
    static int count = 0;
    public static void waysToCut(int currLength, int maxLength, int cuts, int maxCuts) {
        if (cuts == maxCuts) {
            System.out.println(currLength + "," + (maxLength - currLength));
            count++;
            return;
        }
        for(int i=1;i<maxLength;i++) {
            waysToCut(i,maxLength,++cuts,maxCuts);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        waysToCut(0, 5, 0, 1);
        System.out.println("No of ways : " + count);
    }

}
