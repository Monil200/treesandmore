package treesandmore;

public class IntegerToEnglishWords {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";
        
        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) +THOUSANDS[i] + " " + words;
                System.out.println("\t" + words.trim());
            }
            num /= 1000;
            System.out.println("\t" + num);
            i++;
        }
        
        System.out.println(words.trim());
        return words.trim();
    }

    private String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
    
    
    public String intToString(int num) {
        String word = "";
        int i = 0;
        while(num > 0) {
            word =  Helper(num%1000) + " " + THOUSANDS[i++] + " " + word + " ";
            num = num/1000;
        }
        return word.trim();
    }
    
    public String Helper(int num) {
        System.out.println(num);
        if (num ==0) {
            return "";
        } else if(num < 20) {
            return LESS_THAN_20[num];
        } else if (num < 100) {
            return TENS[(int) num/10] + " " + Helper((int) num%10); 
        } else { // >100
            return LESS_THAN_20[(int) num/100] + " Hundred " + Helper(num%100);
        }
    }
     public static void main(String[] args) {
        // TODO Auto-generated method stub
        IntegerToEnglishWords obj = new IntegerToEnglishWords();
        obj.numberToWords(1000);
//        System.out.println(obj.helper(100));
        System.out.println(obj.intToString(1000));
    }

}
