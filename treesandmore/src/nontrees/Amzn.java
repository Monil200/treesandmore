package nontrees;
import java.util.Stack;

public class Amzn {
    
    public static int totalScore(String[] blocks, int n)
    {   
        if (blocks.length ==0 || blocks.length != n) {
            return 0;
        }
        int score = 0, temp = 0, prev= 0, prevPrev= 0, saveTemp = 0;
        boolean wasPreviousUndo = false;
        Stack<Integer> pastScores = new Stack<Integer>();
        for(int i=0;i<n;i++) {
            switch(blocks[i]) {
            case "X":
                wasPreviousUndo = false;
                temp = (!pastScores.isEmpty()) ? pastScores.peek() : 0;
                score += temp*2;
                pastScores.push(temp*2);
                temp = 0;
                break;
            case "+":
                wasPreviousUndo = false;
                prev = (!pastScores.isEmpty()) ? pastScores.peek() : 0;
                saveTemp = pastScores.pop();
                prevPrev = (!pastScores.isEmpty()) ? pastScores.peek() : 0;
                temp = prev + prevPrev;
                pastScores.push(saveTemp);
                score += temp;
                pastScores.push(temp);
                temp = 0;
                break;
            case "Z":
                temp = (!pastScores.isEmpty() && !wasPreviousUndo) ? pastScores.pop() : 0;
                score -= temp;
                break;
            default: // integer
                wasPreviousUndo = false;
                pastScores.push(Integer.parseInt(blocks[i]));
                score+= Integer.parseInt(blocks[i]);
                break;
            }
        }
        return score;
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a[] = {"5", "-2", "4", "Z", "X", "9", "+", "+"};
        System.out.println(totalScore(a, 8));
    }

}
