package treessandtrees;

import java.util.*;

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
    
    public void nextCLosesTimeV2(String time) {
        if (time == null || time.length() == 0) {
            return;
        }
        
        String arr[] = time.split(":");
        int hh = Integer.parseInt(arr[0]);
        int mm = Integer.parseInt(arr[1]);
        
        
        int rotatedHH = hh, rotatedMM = mm;
        int diff = Integer.MAX_VALUE;
        int currDiff = 0;
        boolean run = true;
        System.out.println("Out Loop HH:" + rotatedHH + " MM:" + rotatedMM);
        int count = 0;
        while(count < 1439) {
            rotatedMM++;
            count++;
            if (rotatedMM == 60) {
                rotatedMM = 0;
                rotatedHH++;
                if (rotatedHH == 24) {
                    rotatedHH = 0;
                }
            }
            System.out.println("Loop HH:" + rotatedHH + " MM:" + rotatedMM + " HH og:" + hh + " mm og:" + mm);
            if (isSameDigitsInTime(rotatedHH, rotatedMM, time)) {
                if (rotatedHH > hh) {
                    currDiff += 60*(rotatedHH - hh);
                } else if (rotatedHH < hh) {
                    currDiff += 60*(24 - hh) + 60*rotatedHH;
                }
                if (rotatedMM > mm) {
                    currDiff += rotatedMM - mm;
                } else if (rotatedMM < mm) {
                    currDiff -= (mm - rotatedMM);  
                }
                if (currDiff < diff) {
                    diff = currDiff;
                    System.out.println("Candidate HH:" + rotatedHH + " MM:" + rotatedMM);
                }
            }
        }
        
        System.out.println("SMallest diff:" + diff);
    }
    
    public boolean isSameDigitsInTime(int hh, int mm, String time) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<time.length();i++) {
            if (time.charAt(i) != ':') {
                map.put(time.charAt(i)+"", map.getOrDefault(map.get(time.charAt(i)),1));
            }
        }
        String hhString = String.valueOf(hh);
        String mmString = String.valueOf(mm);
        
        for(int i=0;i<hhString.length();i++) {
            String t = hhString.charAt(i) + "";
            if (!map.containsKey(t)) {
                return false;
            }
        }
        for(int i=0;i<mmString.length();i++) {
            String t = mmString.charAt(i) + "";
            if (!map.containsKey(t)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NextClosestTime obj = new NextClosestTime();
        String time = "19:34";
//        String timeNumsStr[] = time.split(":");
//        int timeNums[] = new int[4];
//        int res[] = new int[4];
//        timeNums[0] = Integer.parseInt(timeNumsStr[0])/10;
//        timeNums[1] = Integer.parseInt(timeNumsStr[0])%10;
//        
//        timeNums[2] = Integer.parseInt(timeNumsStr[1])/10;
//        timeNums[3] = Integer.parseInt(timeNumsStr[1])%10;
//        
//        System.out.println(Arrays.toString(timeNums));
//        
//        obj.getTimeCombinations(timeNums, res, 0);
//        System.out.println("Smallest diff is:" + obj.minDiff + " time is: " + Arrays.toString(obj.closestTime));
        
        obj.nextCLosesTimeV2(time);
    }

}
