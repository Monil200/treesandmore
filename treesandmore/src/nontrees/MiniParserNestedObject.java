package nontrees;
class NestedObject {
    String val;
    NestedObject nest;
    public NestedObject() {}
    public NestedObject(String v) {
        val = v;
        nest = null;
    }
}
public class MiniParserNestedObject {
    
    public static void createNestedObject(NestedObject root, String s, int nestCount, int index) {
        if (index >= s.length() - 1 - nestCount)
            return;
        String num="";
        while( (int) s.charAt(index) > 47 && (int) s.charAt(index) < 58) {
            num += s.charAt(index);
            index++;
        }
        if (num.length() != 0) {
            nestCount++;
            root.val = num;
            root.nest = new NestedObject("");
            createNestedObject(root.nest, s, nestCount, index);
        } else {
            index++;
            createNestedObject(root, s, nestCount, index);
        }
    }
    
    public static void printNestedObj(NestedObject obj) {
        if (obj == null)
            return;
        System.out.println(obj.val);
        printNestedObj(obj.nest);
    }
    public static void main(String args[]) {
        NestedObject root = new NestedObject("");
        String s = "[123,[456,[789]]]";
        createNestedObject(root, s, 0, 0);
        printNestedObj(root);
    }
    
}
