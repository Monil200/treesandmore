package nontrees;

public class BinaryWithoutConsequitiveOnes {
    static int result = 0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        countBinaryWithNoConsequitiveOnes("0", 5);
        countBinaryWithNoConsequitiveOnes("1", 5);
        System.out.println("Binary Patters without consequitive ones:" + result);
    }
    
    public static void countBinaryWithNoConsequitiveOnes(String s, int limit) {
        if (s.length() >= 2 && s.charAt(s.length()-1) == '1' && s.charAt(s.length()-2) == '1') {
            return;
        } else if (s.length() >= limit) {
            System.out.println("i m in else : -> " + s);
            result++;
            return;
        }
        countBinaryWithNoConsequitiveOnes(s+="0", limit);
        s = s.substring(0, s.length() -1);
        countBinaryWithNoConsequitiveOnes(s+="1", limit);
    }

}
