package nontrees;
/*http://buttercola.blogspot.com/2016/01/leetcode-generalized-abbreviation.html
 * word ->
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * */
public class GeneralizedAbbreviations {
    
    public static void generateAbbr(String s, int currentIndex, String output, int index) {
//        System.out.println(output + " **");
        if (output.length() == s.length()) {
            System.out.println(output);
            output = "";
        }
//        if (isPreviousNumber) {
//            return;
//        }
        for(int i=currentIndex;i<s.length();i++) {
            System.out.print("  i: " + i + " ");
            if ((i - 0) > 0) {
                output += s.substring(0, i);
            }
            output += String.valueOf(index);
            if (i+1 < s.length()) {
                output += s.substring(i+1, s.length());
            }
            generateAbbr(s, ++currentIndex, output, index);
            output = "";
//            --index;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "word";
        generateAbbr(s, 0, "", 1);
    }

}
