package treessandtrees;

import java.util.Arrays;

import javax.xml.soap.Text;

public class BoldTagInString {
    
    public void addBoldTags(String a, String dict[], boolean bold[]) {
        if (a == null || a.length() == 0 || dict.length == 0)
            return;
        
        for(int i=0;i<dict.length;i++) {
            for(int j=dict[i].length() - 1;j<a.length();j++) {
                if (dict[i].equals(a.substring(j - dict[i].length() + 1, j+1))) {
                    System.out.println("yes for term:" + dict[i] + " starting" + (j - dict[i].length() + 1) + " ending:" + (j+1));
                    for(int k = (j - dict[i].length() + 1); k<(j+1); k++) {
                        bold[k] = true;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(bold));
        
        String boldOpen = "<b>";
        String boldClose = "</b>";
        StringBuilder output = new StringBuilder();
        for(int i=0;i<bold.length;i++) {
            if (bold[i]) {
                int j = i;
                output.append(boldOpen);
                while(j < bold.length && bold[j]) {
                    output.append(a.charAt(j) + "");
                    j++;
                }
                output.append(boldClose);
                --j;
                i = j;
            } else {
                output.append(a.charAt(i) + "");
            }
        }
        System.out.println(output.toString());
    }
    
    public static void main(String args[]) {
        String dict[] = {"aaa", "aab", "bc", "xy"};
        String text = "aaabxybbc";
        BoldTagInString obj = new BoldTagInString();
        boolean bold[] = new boolean[text.length()];
        obj.addBoldTags(text, dict, bold);
    }
}
