package treessandtrees;

public class OneThreeTwoCheck {
    public static int findSubstringInWraproundString(String p) {
        // count[i] is the maximum unique substring end with ith letter.
        // 0 - 'a', 1 - 'b', ..., 25 - 'z'.
        int[] count = new int[26];
        
        // store longest contiguous substring ends at current position.
        int maxLengthCur = 0; 

        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) {
                maxLengthCur++;
            }
            else {
                maxLengthCur = 1;
            }
            
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLengthCur);
        }
        
        // Sum to get result
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1,3,3, 9};
        
        int min = Integer.MAX_VALUE;
        int max = a[0];
        int mid = -1;
        
        for(int i=0;i<a.length;i++) {
            if (a[i] < min) {
                min = a[i];
            } else if (a[i] >= max) {
                max = a[i]; 
            } else {
                mid = a[i];
                break;
            }
        }
        if (mid == -1) {
            System.out.println("no 132"); 
        } else {
            System.out.println("132 success");
        }
        // dp problem
        System.out.println(findSubstringInWraproundString("abcdbcd"));
    }

}
