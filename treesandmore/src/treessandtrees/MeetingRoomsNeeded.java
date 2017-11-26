package treessandtrees;

public class MeetingRoomsNeeded {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] times = {{1,2}, {1,4}, {6,9}, {2,4}, {3,5}, {4,5}, {4,8}, {5,6}};
        int[] clock = new int[24];
        
        int maxRooms = 0;
        int j, hour = -1;
        for(int i=0;i<times.length;i++) {
            j = times[i][0];
            while(j<=times[i][1]) {
                clock[j++] +=1;
            }
        }
        
        for(int i=0;i<clock.length;i++) {
            if(maxRooms < clock[i]) {
                maxRooms = clock[i];
                hour = i;
            }
        }
        
        System.out.println("Max number of rooms needed is " + maxRooms + " at hour " + hour);
    }

}
