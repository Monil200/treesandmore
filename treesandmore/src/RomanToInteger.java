import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        Map<Character, Integer> charToValueMap = new HashMap<>();

        charToValueMap.put('M', 1000);
        charToValueMap.put('D', 500);
        charToValueMap.put('C', 100);
        charToValueMap.put('L', 50);
        charToValueMap.put('X', 10);
        charToValueMap.put('V', 5);
        charToValueMap.put('I', 1);

        String input = "LVIII";
        int finalVal = 0;
        int reduction = 0;
        for (int i=0;i<input.length()-1;i++) {
            char currentChar = input.charAt(i);
            int currentCharVal = charToValueMap.get(currentChar);
            char nextChar = input.charAt(i+1);
            int nextCharVal = charToValueMap.get(nextChar);
            if (currentCharVal >= nextCharVal) {
                finalVal += (currentCharVal - reduction);
                reduction = 0;
            } else {
                // dont add to final val because we have a higher number ahead of us and this is reduction to do a minus operations
                reduction = currentCharVal;
            }
        }
        // final char to process along with reduction from previous character.
        // Since our loop only runs till length -1, we need to separately process final character and with the reduction if any
        finalVal += (charToValueMap.get(input.charAt(input.length()-1)) - reduction);
        System.out.println("output:" + finalVal);
    }
}
