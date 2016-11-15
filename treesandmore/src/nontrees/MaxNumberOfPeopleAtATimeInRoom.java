package nontrees;

public class MaxNumberOfPeopleAtATimeInRoom {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[][] = {{10,14},{12,13},{12,16},{13,15},{16,18}}; // sorted based on start times, if no then sort it
        int currentCount = 1;
        int maxCount=0;
        for(int i=0;i<a.length;i++) {
            currentCount = 1;
            for(int j=i+1;j<a.length;j++) {
                if (a[j][0] > a[i][1]) {
                    break;
                }
                if (i==j) {
                    continue;
                } else {
                    if (a[j][0] < a[i][1]) {
                        currentCount++;
                    }
                    if (currentCount > maxCount) {
                        maxCount = currentCount;
                    }
                }
            }
        }
        System.out.println("Max ppl at a time in a room:" + maxCount);
    }

}
