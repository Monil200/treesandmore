package treessandtrees;
import java.util.*;
/*
 * LeetCode 582. Kill Process

Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.

We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.

Example 1:

Input: 
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation: 
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.
 */
public class KillProcess {
    
    public void killTheseProcesses(int pid[], int ppid[], ArrayList<Integer> res, int target) {
        if (pid.length == 0 || ppid.length == 0 || ppid.length != pid.length) {
            return;
        }
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>(); // parent is key, child is list
        for(int i=0;i<pid.length;i++) {
            if (map.containsKey(ppid[i])) {
                ArrayList<Integer> temp = map.get(ppid[i]);
                temp.add(pid[i]);
                map.put(ppid[i], temp);
            } else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(pid[i]);
                map.put(ppid[i], temp);
            }
        }
        
        res.add(target);
        if (map.containsKey(target)) {
            Queue<Integer> hold = new LinkedList<Integer>();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp = map.get(target);
            Iterator<Integer> it = temp.iterator();
            while(it.hasNext()) {
                hold.add(it.next());
            } // initial added to queue
            while(!hold.isEmpty()) {
                target = hold.poll();
                res.add(target);
                temp = map.get(target);
                if (temp != null) {
                    it = temp.iterator();
                    while(it.hasNext()) {
                        hold.add(it.next());
                    }
                }
            }
            it = res.iterator();
            while(it.hasNext()) {
                System.out.println("Process to be killed - " + it.next());
            }
        } else {
            System.out.println("Child(leaf) process to be killed");
        }
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        KillProcess obj = new KillProcess();
        int pid[] = {1, 3, 10, 5, 7, 8};
        int ppid[] = {3, 0, 5, 3, 10, 10};
        obj.killTheseProcesses(pid, ppid, new ArrayList<Integer>(), 5);
    }

}
