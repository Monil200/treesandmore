package nontrees;
/*http://buttercola.blogspot.com/2016/01/leetcode-generalized-abbreviation.html
 * word ->
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * */
public class GeneralizedAbbreviations {
    
    public static void generateAbbr(String s, String prefix, String integer, int currIndex, boolean isPreviousNumber, boolean isCurrentNumber) {
        if (currIndex == s.length()) {
            return;
        }
//        if (isPreviousNumber == isCurrentNumber) {
//            return;
//        }
        System.out.println(prefix + integer + s.substring(prefix.length()+1, s.length()));
        
        for(int i=currIndex;i<s.length();i++) {
            for(int j=i;j<s.length();j++) {
                System.out.println("currIndex: " + currIndex + " j:" + j);
                prefix = s.substring(currIndex, j);
                integer = Integer.toString(j+1);
                generateAbbr(s,prefix,integer,++currIndex, true, false);
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "word";
        generateAbbr(s, "", "w", 0, false, false);
    }

}
