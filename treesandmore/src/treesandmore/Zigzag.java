package treesandmore;

public class Zigzag {
    
    public void zigzagNumberOrdering() {
        int[] a = {4, 3, 7, 8, 6, 2, 1, 10, 11, 34, 12, 33, 19};
        int current,next, temp;
        for (int i =0; i<a.length -1; i++) {
            current = a[i];
            next = a[i+1];
            if (i % 2 == 0){
                if (current < next) {
                    System.out.print(a[i] + " , ");
                    continue;
                }
            } else {
                if (current > next) {
                    System.out.print(a[i] + " , ");
                    continue;
                }
            }
            temp = current;
            current = next;
            next = temp;
            a[i] = current;
            a[i+1] = next;
            System.out.print(a[i] + " , ");
        }
        System.out.print(a[a.length-1]);
        
    }
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
        Zigzag a = new Zigzag();
        a.zigzagNumberOrdering();
    }

}
