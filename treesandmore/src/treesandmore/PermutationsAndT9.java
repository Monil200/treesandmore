package treesandmore;
import java.util.*;
public class PermutationsAndT9 {
    
    public static void permutationsOfAString(String str, int s, int e) {
        if (s == e) {
            System.out.println(str);
        } else {
            for(int i=s;i<str.length();i++) {
                char strarr[] = str.toCharArray();
                char temp = strarr[i];
                strarr[i] =strarr[s];
                strarr[s] = temp;
                str = String.valueOf(strarr);
                permutationsOfAString(str, s+1, e);
            }
        }
    }
    
    public static List<ArrayList<String>> listOfStrings = new ArrayList<ArrayList<String>>();
    public static ArrayList<String> list1 = new ArrayList<String>();
    public static ArrayList<String> list2 = new ArrayList<String>();
    public static ArrayList<String> list3 = new ArrayList<String>();
    
    public static void permuteArrayElements(int s, int e, ArrayList<String> str) {
        if (s == e) {
            String[] temp = new String[str.size()];
            temp = str.toArray(temp);
            System.out.println(Arrays.toString(temp)); 
        } else {
            for(int i=s;i<str.size();i++) {
                String tempStr = str.get(s);
                str.set(s,str.get(i));
                str.set(i, tempStr);
                permuteArrayElements(s+1, str.size(), new ArrayList<String>(str));
            }
        }
    }
    
    public static HashMap<Integer, String> map = new HashMap<Integer, String>();
    
    public static void generateT9Combinations(int k[], String output[], int start) {
        if (start == k.length) { // output.length == k.length will not work as output has length 3 as defined.
            System.out.println(Arrays.toString(output));
        } else {
            for(int i=0;i<map.get(k[start]).length();i++) {
                output[start] = map.get(k[start]).charAt(i) + "";
                generateT9Combinations(k, output, start+1);
            }
        }
    }
    
    
    public static void generateUrlCombinations(String[] output, int start) {
        if (start == listOfStrings.size()) {
            System.out.println(Arrays.toString(output));
        } else {
            for(int i=0;i<listOfStrings.get(start).size();i++) {
                output[start] = listOfStrings.get(start).get(i);
                generateUrlCombinations(output, start+1);
            }
        }
    }
    
    public static void main(String[] args) {
        // permutations of a string n!
        permutationsOfAString("abc", 0, "abc".length());
        
        //permute strings in arrays -> n!
        list1.add("eat");list1.add("sleep");
        list2.add("study");list2.add("revise");
        list3.add("run");list3.add("repeat");
        listOfStrings.add(list1);listOfStrings.add(list2);listOfStrings.add(list3);
        ArrayList<String> result = new ArrayList<String>();
        for(ArrayList<String> i : listOfStrings) {
            for(String j :i) {
                result.add(j);
            }
        }
        for(String j :result) {
            System.out.print(j + ",");
        }
        permuteArrayElements(0, result.size(), result);
        
        //t9
        int keyStrokes[] = {2,3,4};
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        String comb[] = new String[keyStrokes.length];
        generateT9Combinations(keyStrokes, comb, 0);
        
        //uber urls
        System.out.println("Uber urls");
        list1.clear();list2.clear();list3.clear();listOfStrings.clear();
        list1.add("http");list1.add("https");
        list2.add("facebook");list2.add("google");
        list3.add("com");list3.add("co.in");
        listOfStrings.add(list1);listOfStrings.add(list2);listOfStrings.add(list3);
        String urls[] = new String[listOfStrings.size()];
        generateUrlCombinations(urls, 0);
    }

}
