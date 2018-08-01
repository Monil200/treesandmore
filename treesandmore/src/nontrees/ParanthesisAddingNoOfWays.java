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

    public void numberOfWaysToFormBalancedParanthesis(String s, int open, int close, int target) {
//        System.out.println("open:" + (open) + " str:" + s + " closed:" + (close));
        if (s.length() == target && open == close && open == target/2) {
            System.out.println(s);
            return;
        }
        if (open > target/2 || close > target/2) {
            return;
        }
        numberOfWaysToFormBalancedParanthesis(s+"(",open+1, close, target);
        numberOfWaysToFormBalancedParanthesis(s+")",open, close+1, target);
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ParanthesisAddingNoOfWays obj = new ParanthesisAddingNoOfWays();
        StringBuilder s = new StringBuilder();
        obj.numberOfWaysToFormBalancedParanthesis("", 0, 0, 4);
        
    }

}
