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
        int a[] = {3, 6,9,7};
        int one = Integer.MAX_VALUE;
        int three=-1, two = -1;
        
        for(int i=0;i<a.length;i++) {
            if (a[i] < one) {
                one = a[i];
            } else if (a[i] > three) {
                three = a[i];
            } else if (a[i] > one && a[i] < three) {
                two = a[i];
                break;
            }
        }
        
        System.out.println(one + "" + three + "" + two);
        if (two == -1) {
            System.out.println("No 132");
        } else {
            System.out.println("Success");
        }
        
        
        // dp problem
        System.out.println(findSubstringInWraproundString("abcdbcd"));
    }

}
