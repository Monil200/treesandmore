package treessandtrees;
/*
 * These will be 2 programs which demonstrates use of PQ in a greedy fashion
 * 1. Longest chain a-b c-d where c > b and for all pairs a-b -> a < b
 * 2. if dm, dt pairs represent dm days needed to complete course and course has to be completed by dt day, find max courses that can be taken.
 * 3. Same as max jobs that can be completed given start-end times
 */
import java.util.*;
public class MaxLengthChain {
    
    public void getMaxChain(Integer a[][]) { // each a[i] is of length 2;
        
        Comparator<Integer[]> special = new Comparator<Integer[]>() {
                public int compare(Integer a[], Integer b[]) {
                    return a[1] - b[1];
                }
        };
        
        Arrays.sort(a, special);
        
        int maxSoFar = a[0][1];
        int length = 1;
        for(int i=1;i<a.length;i++) {
            if (a[i][0] >= maxSoFar) {
                length+=1;
                maxSoFar = a[i][1];
            }
        }
        System.out.println("Max length is :" + length);
    }
    
    public void getMaxCoursesEnrolled(Integer a[][]) {
        if (a.length == 0)
            return;
        
        Comparator<Integer[]> special = new Comparator<Integer[]>() {
            public int compare(Integer a[], Integer b[]) {
                return a[1] - b[1];
            }
        };
        
        Arrays.sort(a, special);
        
        int time = a[0][0];
        int coursesTaken = 1;
        
        for(int i=1;i<a.length;i++) {
            if (a[i][1] > (time + a[i][0])) {
                coursesTaken++;
                time+=a[i][0];
            } else {
                time-=a[i-1][0];
                time+=a[i][0];
            }
        }
        System.out.println("Max courses that you can enroll is: " + coursesTaken);
         
    }
    
    public void getMaxMeetingRooms(Integer a[][]) {
        if (a == null || a.length == 0)
            return;
        
        Comparator<Integer[]> special = new Comparator<Integer[]>() {
            public int compare(Integer a[], Integer b[]) {
                return a[1] - b[1];
            }
        };
        
        Arrays.sort(a, special);
        
        PriorityQueue<Integer[]> specialPq = new PriorityQueue<Integer[]>(
                new Comparator<Integer[]>() {
                    public int compare(Integer a[], Integer b[]) {
                        return a[1] - b[1];
                    }
                }
        );
        
        specialPq.add(a[0]);
        int roomCount = 1;
        for(int i=1;i<a.length;i++) {
            Integer temp[] = specialPq.peek();
            if (a[i][0] < temp[1]) {
                roomCount++;
            } else {
                while(specialPq.size() > 0 && a[i][0] >= specialPq.peek()[1]) {
                    specialPq.poll();
                }
            }
            specialPq.add(a[i]);
            // 9-10 10-13 10-11 11-12
        }
        System.out.println("Max meeting that you will need is: " + roomCount);
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MaxLengthChain obj = new MaxLengthChain();
        Integer a[][] = {{1,3}, {2,4}, {3,5}, {4,6}, {4,7}};
        obj.getMaxChain(a);
        
        // timings  to course enrollment
        Integer times[][] = {{100,200}, {200,1300}, {1000,1250}, {2000,3200}};
        obj.getMaxCoursesEnrolled(times);
        
        // number of meeting rooms
        Integer roomTimes[][] = {{8,9}, {8,10}, {9,11}, {10,13}, {10,15}};
        obj.getMaxMeetingRooms(roomTimes);
    }

}
