package treessandtrees;
import java.util.*;
public class OpenLock {
    
    public Integer getMinStepsToReachLockTarget(String s, String t, String[] deadends) {
        if (s == null || s.length()< 4 || t == null || t.length()< 4) {
            return null;
        }
        if (s.equals(t)) {
            return 0;
        }
        HashSet<String> dead = new HashSet<String>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        q.add(s);
        visited.add(s);
        int steps = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                String bfs = q.remove();
                size--;
                if (dead.contains(bfs)) {
                    continue;
                }
                if (t.equals(bfs)) {
                    System.out.println("Min steps to reach target is:" + steps);
                    return steps; // this was the important statement i missed, as a result i was getting incorrect answer.
                }
                for(int i=0;i<4;i++) {
                    // for every character in s, do its bfs
                    char temp[] = bfs.toCharArray();
                    int tempInt = (int) temp[i];
                    // forward
                    temp[i] = (tempInt == 57) ? '0' : (char) (tempInt+1);
                    String forward = String.valueOf(temp);
                    // backwards
                    temp[i] = (tempInt == 48) ? '9' : (char) (tempInt-1);
                    String backward = String.valueOf(temp);
                    System.out.println("Adding forward:" + forward + " backward:" + backward);
                    if (!dead.contains(forward) && !visited.contains(forward)) {
                        q.add(forward);
                        visited.add(forward);
                    }
                    if (!dead.contains(backward) && !visited.contains(backward)) {
                        q.add(backward);
                        visited.add(backward);
                    }
                }
            }
            steps++;
        }
        return -1;
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        OpenLock obj = new OpenLock();
        String dead[] = {"0201","0101","0102","1212","2002"};
        System.out.println(obj.getMinStepsToReachLockTarget("0000", "0202", dead));
    }

}
