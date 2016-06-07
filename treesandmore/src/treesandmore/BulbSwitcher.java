package treesandmore;
/*
 * There are n bulbs that are initially off. You first turn on all the bulbs. 
 * Then, you turn off every second bulb. On the third round, 
 * you toggle every third bulb (turning on if it's off or turning off if it's on). 
 * For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. 
 * Find how many bulbs are on after n rounds.
 */
public class BulbSwitcher {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int bulbs[] = {-1,-1,-1,-1,-1};
        int rounds = 3;
        switchBulbs(bulbs, rounds, 1);
        for(int i=0;i<bulbs.length;i++) {
            System.out.print(bulbs[i] + " , ");
        }
        /*
         * -1,-1,-1,-1,-1 - initial
         * 1, 1, 1, ,1 ,1 - round 1
         * 1 ,-1, 1, -1, 1 - round 2
         * 1, -1, -1, -1, 1 - round 3
         */

    }
    
    public static void switchBulbs(int bulbs[], int rounds, int everyNthSwitch) {
        if (rounds == 0 ) {
            return;
        } else {
            int i=0;
            while(i<bulbs.length) {
                if (everyNthSwitch > 1) {
                    i+=everyNthSwitch;
                    if (i-1 < bulbs.length)
                        bulbs[i-1] *=-1;
                } else {
                    bulbs[i] *=-1;
                    i++;
                }
            }
            switchBulbs(bulbs, --rounds, ++everyNthSwitch);
        }
    }

}
