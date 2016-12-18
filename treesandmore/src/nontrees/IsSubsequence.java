package nontrees;

public class IsSubsequence {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String container = "ahbgd";
        String contains = "abc";
        
        int containerIndex = 0;
        
        for(int i=0;i<container.length();i++) {
            if (container.charAt(i) == contains.charAt(containerIndex)) {
                System.out.println(contains.charAt(containerIndex) + "--");
                containerIndex++;
            }
        }
        
        if (containerIndex >= contains.length())
            System.out.println("TRUE");
        else
            System.out.println("FALSE");
    }

}
