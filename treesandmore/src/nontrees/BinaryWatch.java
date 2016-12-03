package nontrees;
import java.util.*;
public class BinaryWatch {
    public static void getAllTimes(int bitsSet, int start, String output[]) {
        if (start == bitsSet) {
            System.out.println(Arrays.toString(output));
        } else {
            for(int i=start;i<output.length;i++) {
                output[i] = "1";
                getAllTimes(bitsSet, start+1, output);
                output[i] = "0";
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int bitsSet = 1;
        String output[] = new String[10]; // 1,2,4,8 for hours 1,2,4,8,16,32 for minutes;
        for(int i=0;i<output.length;i++)
            output[i] = "0";
        getAllTimes(bitsSet, 0, output);
    }

}
