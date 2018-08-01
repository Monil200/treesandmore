package treesandmore;

public class FreedomTrail {
    
    public int minSteps(String main, String key, int start) {
        System.out.println("main:" + main + " start:" + start);
        if (key == null || key.length() == 0 || start >= key.length()) {
            return 0;
        }
        
        int clock = 0, antiClock = 0;
        String newClockString = main, newAntiClockString = main;
        for(int j=0;j<main.length();j++) {
            if(main.charAt(j) == key.charAt(start)) {
                if (j!=0) {
                    newClockString = main.substring(j, main.length()) + main.substring(0, j); 
                }
                break;
            }
            clock++;
        }
        clock++;
        for(int j=main.length()-1;j>=0;j--) {
            if(main.charAt(j) == key.charAt(start)) {
                if (j!=main.length()-1) {
                    newAntiClockString = "";
                    for(int k = j;k>=0;k--) {
                        newAntiClockString += main.charAt(k);
                    }
                    for(int k = main.length()-1;k>j;k--) {
                        newAntiClockString += main.charAt(k);
                    }
                }
                break;
            }
            antiClock++;
        }
        antiClock++;
        
        return Math.min(clock + minSteps(newClockString, key, start+1), antiClock + minSteps(newAntiClockString, key, start+1));
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FreedomTrail obj = new FreedomTrail();
        System.out.println(obj.minSteps("godding", "gd", 0));
    }

}
