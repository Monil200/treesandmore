package treessandtrees;
import java.util.*;
public class TextJustificationRH {
    public void breakWord(String a[], int limit) {
        int currLimit = limit;
        StringBuilder sentence = new StringBuilder();
        String spaceBar = " ";
        ArrayList<String> output = new ArrayList<String>();
        for(int i=0;i<a.length;i++) {
            if (a[i].length() > limit) {
                System.out.println("Bad input");
                return;
            }
            if (currLimit == limit) {
                sentence.append(a[i]);
                currLimit -= a[i].length();
            } else if (currLimit > 0 && currLimit < limit && (currLimit - a[i].length() - 1) >= 0) {
                sentence.append(spaceBar);
                sentence.append(a[i]);
                currLimit = currLimit - a[i].length() -1;
            } else {
                if (sentence.length() > 0) {
                    output.add(sentence.toString());
                }
                sentence.setLength(0);
                currLimit = limit;
                sentence.append(a[i]);
                currLimit -= a[i].length();
            }
            if (currLimit == 0) {
                output.add(sentence.toString());
                currLimit = limit;
                sentence.setLength(0);
            }
        }

        // after for
        if (sentence.length() > 0)
            output.add(sentence.toString());
        
        System.out.println(output);


    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TextJustificationRH obj = new TextJustificationRH();
        String a[] = {"thisaasd", "is", "a", "english","as" , "asd", "qsd", "sentence", "i"};
        int limit = 8;
        obj.breakWord(a, limit);
    }

}
