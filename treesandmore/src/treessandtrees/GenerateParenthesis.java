package treessandtrees;

public class GenerateParenthesis {
    public void generateParenthesis(String s, int limit, int currentOpen, int currentClose) {
        if (s.length() == limit*2) {
            System.out.println(s);
            return;
        }
        if (s.length() > limit*2) {
            return;
        }
        if (currentOpen > limit) {
            return;
        }
        if (currentOpen < limit) {
            s += "(";
            generateParenthesis(s, limit, ++currentOpen, currentClose);
            s = s.substring(0, s.length()-1);
            --currentOpen;
        }
        if (currentClose < limit) {
            s+=")";
            generateParenthesis(s, limit, currentOpen, ++currentClose);
            s = s.substring(0, s.length()-1);
            --currentClose;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GenerateParenthesis obj = new GenerateParenthesis();
        obj.generateParenthesis("", 3, 0, 0);
    }

}
