package nontrees;
import java.util.*;
public class RestoreIpAddress {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String ip = "22525511135";
        
        int a[] = new int[4];
        int put = 0;
        for(int i=0;i<4;i++) {
            if (i < 3) {
                a[i] = Integer.parseInt(ip.charAt(i) + "");
            } else {
                a[i] = Integer.parseInt(ip.substring(i, ip.length()));
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(isValidIp(a,3));
        System.out.println(Arrays.toString(a));
    }
    
    public static boolean isValidIp(int[] a, int top) {
        if (a.length == 0) {
            return false;
        } else {
            if (top == -1) {
                return true;
            }
            int topVal = a[top];
            if (topVal > 255) {
                if (top >= 1) {
                    int secondToTop = a[top-1];
                    int rippleValue = Integer.parseInt(String.valueOf(topVal).charAt(0) + "");
                    secondToTop = Integer.parseInt(String.valueOf(secondToTop) + String.valueOf(rippleValue));
                    a[top-1] = secondToTop;
                    String topValStr = String.valueOf(topVal);
                    topValStr = topValStr.substring(1, topValStr.length());
                    topVal = Integer.parseInt(topValStr);
                    a[top] = topVal;
                    if (a[top] > 255) {
                        return isValidIp(a, top);
                    } else {
                        return isValidIp(a, top-1);
                    }
                } else {
                    return false;
                }
            } else {
                return isValidIp(a, top-1);
            }
        }
    }
    

}
