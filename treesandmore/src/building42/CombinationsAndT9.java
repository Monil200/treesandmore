package building42;

import java.util.*;

public class CombinationsAndT9 {
    
    static void combinationsOfAString(String a, int start) {
        if (start == a.length()) {
            System.out.println(a);
        } else {
            char t[];
            char temp;
            for(int i=start;i<a.length();i++) {
                t = a.toCharArray();
                temp = t[i];
                t[i] = t[start];
                t[start] = temp;
                String send = String.valueOf(t);
                combinationsOfAString(send, start+1);
            }
        }
    }
    
    public static List<ArrayList<String>> listOfStrings = new ArrayList<ArrayList<String>>();
    public static ArrayList<String> list1 = new ArrayList<String>();
    public static ArrayList<String> list2 = new ArrayList<String>();
    public static ArrayList<String> list3 = new ArrayList<String>();
    
    static void arrayCombinations(List<ArrayList<String>> a, int start, String[] output) {
        if (start == a.size()) {
            System.out.println(Arrays.toString(output));
        } else {
            for(int i=0;i<a.get(start).size();i++) {
                output[start] = a.get(start).get(i);
                arrayCombinations(a, start+1, output);
            }
        }
    }
    
    static void arrayCombinationsArray(String[][] a, int start, String[] output) {
        if (start == a.length) {
            System.out.println(Arrays.toString(output));
        } else {
            for(int i=start;i<a.length;i++) {
                for(int j=0;j<a[i].length;j++) {
                    output[start] = a[i][j];
                    arrayCombinationsArray(a, start+1, output);
                    output[start] = "";
                }
            }
        }
    }
    
    public static void t9dictionary(int[] keypad, String[] output, int start, HashMap<Integer, String> dict) {
        if (start == keypad.length) {
            System.out.println(Arrays.toString(output));
        } else {
            for(int j=0;j<dict.get(keypad[start]).length();j++) {
                output[start] = dict.get(keypad[start]).charAt(j) + "";
                t9dictionary(keypad, output, start+1, dict);
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        combinationsOfAString("abc", 0);
       
        
        list1.clear();list2.clear();list3.clear();listOfStrings.clear();
        list1.add("http");list1.add("https");
        list2.add(".facebook");list2.add(".google");
        list3.add(".com");list3.add(".co.in");
        listOfStrings.add(list1);listOfStrings.add(list2);listOfStrings.add(list3);
        String output[] = new String[listOfStrings.size()];
        arrayCombinations(listOfStrings, 0, output);
        
        String x[][] = {
                {"http","https"},
                {".facebook",".google"},
                {".com",".co.in"}
        };
        System.out.println("=====================");
        String output1[] = new String[x.length];
        arrayCombinationsArray(x, 0, output1);
        
        System.out.println("=====================");
        HashMap<Integer, String> dict = new HashMap<Integer, String>();
        dict.put(2, "abc");
        dict.put(3, "def");
        dict.put(4, "ghi");
        dict.put(5, "jkl");
        dict.put(6, "mno");
        dict.put(7, "pqrs");
        dict.put(8, "tuv");
        dict.put(9, "wxyz");
        
        int keypad[] = {2,3,4};
        String x2[]= new String[keypad.length];
        t9dictionary(keypad, x2, 0, dict);
        
    }

}
