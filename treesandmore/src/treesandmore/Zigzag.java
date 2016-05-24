package treesandmore;

public class Zigzag {

    public static void main(String[] args) {
        String string = "geeksforgeeks";
        int charCount = 0;
        int strlen = string.length();
        int i=0;
        int iterationCount=0;
        int n= 3;
        while(charCount<strlen) {
            while(i<strlen) {
                System.out.print(string.charAt(i));
                charCount++;
                if (iterationCount % 2 ==0) {
                    i += (n+1);
                } else {
                    i += (n-1);
                }
            }
            iterationCount++;
            i = iterationCount;
        }
    }

}
