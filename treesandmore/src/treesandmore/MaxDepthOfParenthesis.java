package treesandmore;
//Find maximum depth of nested parenthesis in a string
//We are given a string having parenthesis like below
//     “( ((X)) (((Y))) )”
//We need to find the maximum depth of balanced parenthesis, like 4 in above example. Since ‘Y’ is surrounded by 4 balanced parenthesis.
//
//If parenthesis are unbalanced then return -1.
public class MaxDepthOfParenthesis {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int currentOpenings = 0;
        int currentDepth = 0;
        int maxDepth = 0;
        char previousBrace = (char) '('; 
        String a = "((()())())";
        for (int i=0;i<a.length(); i++) {
            if (a.charAt(i) == (char) '(' || a.charAt(i) == (char) ')') {
                if (a.charAt(i) == (char) '(') {
                    currentOpenings++;
                    if (previousBrace == (char) ')') {
                        currentDepth = 0;
                    }
                    previousBrace = '(';
                } else {
                    currentOpenings--;
                    currentDepth++;
                    if (currentDepth > maxDepth) {
                        maxDepth = currentDepth;
                    }
                    previousBrace = ')';
                }
            }
        }
        if (currentOpenings != 0) {
            System.out.println("-1");
        } else {
            System.out.println(" max depth is : " + maxDepth );
        }

    }

}
