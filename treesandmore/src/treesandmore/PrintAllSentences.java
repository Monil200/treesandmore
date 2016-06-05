package treesandmore;
// still WIP
public class PrintAllSentences {
    static String a[]  = {"you", "we"};
    static String b[]  = {"have", "are"};
    static String c[]  = {"sleep", "eat", "drink"};
    public void printSentence(int length1, int length2, int length3) {
        if (length1 == -1 || length2 == -1 || length3 == -1) {
            return;
        } else {
            System.out.println(a[length1] + " " + b[length2] + " " + c[length3]);
            printSentence(length1, length2, length3-1);
            printSentence(length1, length2-1, length3);
            printSentence(length1-1, length2, length3);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PrintAllSentences obj = new PrintAllSentences();
        obj.printSentence(a.length-1, b.length-1, c.length-1);

    }

}
