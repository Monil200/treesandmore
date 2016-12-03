package nontrees;
//https://leetcode.com/contest/leetcode-weekly-contest-10/problems/can-i-win/
//In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.
//
//What if we change the game so that players cannot re-use integers?
//
//For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.
//
//Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.
//
//You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.
public class CanIWin {
    public static boolean canP1Win(int runningTotal,boolean isP1, int desiredTotal, int minava, int maxava) {
        System.out.println("Running total" + runningTotal + " is P1?" + isP1);
        if (isP1 && runningTotal >= desiredTotal) {
            return true;
        }
        if (!isP1 && runningTotal >= desiredTotal) {
            return false;
        }
        
        if (runningTotal + maxava >= desiredTotal) {
            return canP1Win(runningTotal + maxava, !isP1, desiredTotal, minava, maxava-1);
        } else {
            if (runningTotal + (maxava -1) + maxava <= desiredTotal)
                return canP1Win(runningTotal + maxava, !isP1, desiredTotal, minava, maxava-1);
            else 
                return canP1Win(runningTotal + minava, !isP1, desiredTotal, minava+1, maxava);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Can p1 win: " + !canP1Win(0,true, 12, 1, 10));
    }

}
