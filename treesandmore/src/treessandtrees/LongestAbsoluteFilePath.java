package treessandtrees;
import java.util.*;
class Directory {
    Directory parent;
    String name;
    int length;
    Directory(String a) {
        name = a;
        length = name.length();
    }
}
public class LongestAbsoluteFilePath {
    int maxLength = Integer.MIN_VALUE;
    public void getLongestAbsolutePath(String s) {
        ArrayList<Directory> holder[] = new ArrayList[10];
        for(int i=0;i<10;i++) {
            holder[i] = new ArrayList<Directory>();
        }
        String name = "";
        int tabCounter =0, depthCount = 0;
        for(int i=0;i<s.length();i++) {
            name += s.charAt(i) + "";
            if (s.charAt(i) == '\n') {
                depthCount++;
                name = name.substring(0, name.length()-1);
                helper(depthCount, tabCounter, holder, name);
                name = "";
                tabCounter = 0;
            } else if (s.charAt(i) == '\t') {
                tabCounter++;
                name = name.substring(0, name.length()-1);
                name = "";
            }
        }
        System.out.println(name);
        helper(depthCount, tabCounter, holder, name);
        // do it for last string;
        
        
        for(int i=0;i<10;i++) {
            Iterator<Directory> it = holder[i].iterator();
            while(it.hasNext()) {
                Directory temp = it.next();
                String parent = (temp.parent!=null) ? (temp.parent.name) : " no parent";
                System.out.println("name:" + temp.name + " parent?" + parent + " <- level:" + i + " length:" + temp.length);
            }
        }
        System.out.println("Max length absolute path is:" + maxLength);
    }
        
        
    public void helper(int depthCount, int tabCounter, ArrayList<Directory> holder[], String name) {
        if (!name.equals("")) {
            if (depthCount > 1) {
                Directory newDirectory = new Directory(name);
                newDirectory.parent = holder[tabCounter-1].get(holder[tabCounter-1].size()-1);
                holder[tabCounter].add(newDirectory);
                newDirectory.length += newDirectory.parent.length;
                if (newDirectory.length + tabCounter > maxLength) {
                    maxLength = newDirectory.length + tabCounter;
                }
            } else {
                Directory newDirectory = new Directory(name);
                holder[0].add(newDirectory);
                if (newDirectory.length + tabCounter > maxLength) {
                    maxLength = newDirectory.length + tabCounter;
                }
            }
        }
    }
        
        
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LongestAbsoluteFilePath obj = new LongestAbsoluteFilePath();
        obj.getLongestAbsolutePath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
    }

}
