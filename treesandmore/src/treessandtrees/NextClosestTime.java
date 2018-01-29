package treessandtrees;

import java.util.Arrays;

public class NextClosestTime {
    int currDiff, minDiff;
    int closestTime[];
    NextClosestTime() {
        currDiff = 0;
        minDiff= Integer.MAX_VALUE;
        closestTime = new int[4];
    }
    public void getTimeCombinations(int time[], int combTime[], int start) {
        if (start == 4) {
            System.out.print(Arrays.toString(combTime));
            getdiff(time, combTime);
        }
        if (start >= time.length)
            return;
        for(int i=start;i<time.length;i++) {
            for(int j=0;j<time.length;j++) {
                combTime[i] = time[j];
                getTimeCombinations(time,combTime, i+1);
            }
        }
    }
    
    public void getdiff(int time[], int timeComb[]) {
        if (time[0] == timeComb[0] && time[1] == timeComb[1] && time[2] == timeComb[2] && time[3] == timeComb[3]) {
            System.out.println("Same time");
            return;
        }
        if ((timeComb[0]*10 + timeComb[1]) > 23 || (timeComb[2]*10 + timeComb[3]) > 59) {
            System.out.println("Not a valid combination");
            return;
        }
        int fromMinutes = time[0]*10*60 + time[1]*60 + time[2]*10 + time[3];
        int toMinutes = timeComb[0]*10*60 + timeComb[1]*60 + timeComb[2]*10 + timeComb[3];
        boolean maxReached = false;
        System.out.print("fromMinutes: " + fromMinutes + " toMinutes:" + toMinutes);
        for(int i=fromMinutes;i<toMinutes || i<24*60; i++) {
            currDiff++;
            if (i == toMinutes) {
                break;
            }
            if (i == (24*60 -1)) {
                maxReached = true;
            }
        }
        if (maxReached) {
            for(int i=0;i<toMinutes;i++) {
                currDiff++;
            }
        }
        
        System.out.println(" Minutes in diff: " + currDiff);
        if (currDiff < minDiff) {
            System.out.println("**********************" + currDiff);
            minDiff = currDiff;
            for(int i=0;i<4;i++) {
                closestTime[i] = timeComb[i];
            }
        }
        currDiff = 0;
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NextClosestTime obj = new NextClosestTime();
        String time = "23:59";
        String timeNumsStr[] = time.split(":");
        int timeNums[] = new int[4];
        int res[] = new int[4];
        timeNums[0] = Integer.parseInt(timeNumsStr[0])/10;
        timeNums[1] = Integer.parseInt(timeNumsStr[0])%10;
        
        timeNums[2] = Integer.parseInt(timeNumsStr[1])/10;
        timeNums[3] = Integer.parseInt(timeNumsStr[1])%10;
        
        System.out.println(Arrays.toString(timeNums));
        
        obj.getTimeCombinations(timeNums, res, 0);
        System.out.println("Smallest diff is:" + obj.minDiff + " time is: " + Arrays.toString(obj.closestTime));
    }

}
