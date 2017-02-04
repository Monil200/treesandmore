package nontrees;
/*
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]
 */
public class ParanthesisAddingNoOfWays {

    public static void addParanthesis(String input, int i, String curr, int maxOpenings, int open, int close) {
        if (open == maxOpenings && i == input.length()) {
            System.out.println(curr);
        } else {
            System.out.println(curr+ " : i" + i);
//            boolean toOpenClose = false;
//            int temp = (int) input.charAt(i);
//            if (temp >=47 && temp<= 57) {
//                toOpenClose = true;
//            }
            if (open > close && close < maxOpenings && i > 0 && curr.charAt(curr.length()-1) != ')') {
                curr+=  input.charAt(i) + "";
                curr+=  input.charAt(i+1) + "";
                curr+= ")";
                addParanthesis(input, i+1, curr, maxOpenings, open, close+1);
            }
            if (open < maxOpenings) {
                curr+= "(";
                addParanthesis(input, i, curr, maxOpenings, open+1, close);
                curr+=  input.charAt(i) + "";
                curr+=  input.charAt(i+1) + ""; // sign, can do intelligently until we see operator, temp now...
                addParanthesis(input, i+2, curr, maxOpenings, open, close);
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String input = "2-1-1";
        int maxOpenings = 0;
        for(int i=0;i<input.length();i++) {
            int temp = (int) input.charAt(i);
            if (temp >=47 && temp<= 57) {
                maxOpenings++;
            }
        }
        maxOpenings--;
        System.out.println(maxOpenings);
        addParanthesis(input, 0, "", maxOpenings, 0, 0);
        
    }

}
