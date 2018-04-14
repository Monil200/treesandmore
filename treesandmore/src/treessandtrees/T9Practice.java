package treessandtrees;
import java.util.*;
public class T9Practice {
     
    public void t9(int keyStrokes[], int index, HashMap<Integer, ArrayList<Character>> map, char output[]) {
        if (index == keyStrokes.length) {
            System.out.println(Arrays.toString(output));
            return;
        }
        
        for(int i=0;i<map.get(keyStrokes[index]).size();i++) {
            output[index] = map.get(keyStrokes[index]).get(i);
            t9(keyStrokes, index+1, map, output);
        }
    }
    
    public void generateURLs(ArrayList<String> a[], int index, String output[]) {
        if (index == a.length) {
            System.out.println(Arrays.toString(output));
            return;
        }
        
        for(int i=0;i<a[index].size();i++) {
            output[index] = a[index].get(i);
            generateURLs(a, 1+index,output);
        }
    }
    
    //https://leetcode.com/problems/combination-sum/description/
    public void getToTargetWithArrayGivenNoRepeatElement(int a[], int target, int index, int currSum, ArrayList<Integer> currNums) {
        if (currSum == target) {
            System.out.println(currNums + " currSum:" + currSum);
            return;
        }
        if (index>=a.length) {
            return;
        }
        if (currSum > target) {
            return;
        }
        
        for(int i=index;i<a.length;i++) {
            if (a[i] + currSum <= target) {
                currNums.add(a[i]);
                currSum += a[i];
                getToTargetWithArrayGivenNoRepeatElement(a,target,i+1, currSum, currNums);
                currSum -= a[i];
                currNums.remove(currNums.size()-1);
            }
        }
    }
    HashSet<ArrayList<Integer>> res;
    T9Practice() {
        res = new HashSet<ArrayList<Integer>>();
    }
  //https://leetcode.com/problems/combination-sum/description/
    public void getToTargetWithArrayGivenYesRepeatElement(int a[], int target, int index, int currSum, ArrayList<Integer> currNums) {
        if (currSum == target) {
            Collections.sort(currNums);
            
            if (res.add(currNums)) {
                System.out.println(currNums);
            }
            return;
        }
        if (index>=a.length || currSum > target)
            return;
        
        for(int i=0;i<a.length;i++) {
            if (a[i] + currSum <= target) {
                currNums.add(a[i]);
                currSum += a[i];
                getToTargetWithArrayGivenYesRepeatElement(a,target,0, currSum, currNums);
                currSum -= a[i];
                currNums.remove(currNums.size()-1);
            }
        }
    }
    
    
    public void getUniqueCombinationsOfKNumbersSumingToTarget(int target, int index, ArrayList<Integer> resList, int k, int currSum) {
        if (resList.size() == k && currSum == target) {
            Collections.sort(resList);
            if (res.add(resList)) {
                System.out.println(resList);
            }
        }
        if (currSum >= target || index > 9 || resList.size() >= k) {
            return;
        }
        for(int i=index;i<9;i++) {
            if (currSum + i <= target) {
                currSum+= i;
                resList.add(i);
                getUniqueCombinationsOfKNumbersSumingToTarget(target, i+1, resList, k, currSum);
                currSum-= i;
                resList.remove(resList.size()-1);
            }
        }
    }
    
    //25525511135
    public void restoreIpAddress(String a, int index, String curr[], int currIndex) {
        if (index >= a.length() && currIndex >= 3) {
            System.out.println(Arrays.toString(curr));
            return;
        }
        if (currIndex >= 4) {
            return;
        }
        
        for(int i=index;i<a.length();i++) {
            if (!curr[currIndex].equals("") && Integer.parseInt(curr[currIndex]) == -1) {
                curr[currIndex] = "";
            }
            if (Integer.parseInt(curr[currIndex] + a.charAt(i)) <= 255) {
                curr[currIndex] += a.charAt(i) + "";
//                System.out.println(Arrays.toString(curr) + "---" + " currIndex:" + currIndex + " i:" + i);
                restoreIpAddress(a, i+1, curr, currIndex+1);
            } else {
                curr[currIndex] = "-1";
                return;
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashMap<Integer, ArrayList<Character>> map = new HashMap<Integer, ArrayList<Character>>();
        map.put(2, new ArrayList(Arrays.asList('a', 'b', 'c')));
        map.put(3, new ArrayList(Arrays.asList('d', 'e', 'f')));
        map.put(4, new ArrayList(Arrays.asList('g', 'h', 'i')));
        map.put(5, new ArrayList(Arrays.asList('j', 'k', 'l')));
        map.put(6, new ArrayList(Arrays.asList('m', 'n', 'o')));
        map.put(7, new ArrayList(Arrays.asList('p', 'q', 'r', 's')));
        map.put(8, new ArrayList(Arrays.asList('t', 'u', 'v')));
        map.put(9, new ArrayList(Arrays.asList('w', 'x', 'y', 'z')));
        
        T9Practice obj = new T9Practice();
        int keyStrokes[] = {2,3,4};
        char output[] = new char[keyStrokes.length];
        obj.t9(keyStrokes, 0, map, output);
        
        ArrayList<String> urls[] = new ArrayList[3];
        ArrayList<String> protocol = new ArrayList<String>() {{
            add("http");
            add("https");
        }};
        ArrayList<String> host = new ArrayList<String>() {{
            add("yahoo");
            add("google");
        }};
        ArrayList<String> org = new ArrayList<String>() {{
            add("com");
            add("co.in");
        }};
        String arr[] = {"protocol", "host", "org"};
        for(int i=0;i<urls.length;i++) {
            urls[i] = new ArrayList<String>();
        }
        urls[0].addAll(protocol);
        urls[1].addAll(host);
        urls[2].addAll(org);
        String outputUrls[] = new String[urls.length];
        obj.generateURLs(urls, 0, outputUrls);
        
        
        // combination sum, give out combinations from input set array which sums to target, no repeated element used
        int inputArr[] = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        ArrayList<Integer> currNums= new ArrayList<Integer>();
        
        obj.getToTargetWithArrayGivenNoRepeatElement(inputArr, target, 0, 0, currNums);
        
        // combination sum, give out combinations from input set array which sums to target, no repeated element used
        System.out.println("Find target sum with elements repeated:------");
        int inputArr1[] = {2, 3, 6, 7};
        Arrays.sort(inputArr1);
        currNums.clear();
        obj.getToTargetWithArrayGivenYesRepeatElement(inputArr1, 7, 0, 0, currNums);
        
        obj.res.clear();
        
        // combination of k nums (1-9) summing to target
        System.out.println("Find target sum with elements repeated:------combination of k nums (1-9) summing to target");
        obj.getUniqueCombinationsOfKNumbersSumingToTarget(7, 1, new ArrayList<Integer>(), 3, 0);
        
        // restore ip address
        String currIp[] = {"", "", "", ""};
        obj.restoreIpAddress("25525511135", 0, currIp, 0);
        
    }

}
