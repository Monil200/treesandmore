package dp;
import java.util.*;
public class NumberOfPallindromes {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a[][] = {
                    {"a", "a", "a", "b"},
                    {"b", "a", "a", "a"},
                    {"a", "b", "b", "a"}
                };
        
        List<String> result[][] = new ArrayList[a.length][a[0].length];
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[0].length;j++) {
                result[i][j] = new ArrayList<String>();
            }
        } // initialize result with arraylists references
        String temp = "";
        for(int i=0;i<a.length;i++) {
            temp += a[i][0]; // 1st columns
            result[i][0].add(temp);
        }
        temp = "";
        for(int i=0;i<a.length;i++) {
            temp += a[0][i]; // 1st columns
            result[0][i].add(temp);
        }
        for(int i=1;i<a.length;i++) {
            for(int j=1;j<a[0].length;j++) {
                Iterator<String> listTop = result[i-1][j].iterator();
                while(listTop.hasNext()) {
                    temp = listTop.next() + a[i][j];
                    result[i][j].add(temp);
                }
                listTop = result[i][j-1].iterator();
                while(listTop.hasNext()) {
                    temp = listTop.next() + a[i][j];
                    result[i][j].add(temp);
                }
            }
        }
        Iterator<String> i = result[a.length-1][a[0].length-1].iterator();
        while(i.hasNext()) {
            System.out.println(i.next()); // call isPallindeome function for each of these strings
        }
    }

}
