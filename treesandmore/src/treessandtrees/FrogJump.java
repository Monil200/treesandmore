package treessandtrees;
import java.util.*;
public class FrogJump {
    
    public void canFrogReachEnd(int a[]) {
        if (a.length == 0)
            return;
        
        HashMap<Integer, HashSet<Integer>> steps= new HashMap<Integer, HashSet<Integer>>();
        steps.put(0, new HashSet<Integer>(Arrays.asList(1)));
        
        
        for(int i=1;i<a.length;i++) {
            steps.put(a[i], new HashSet<Integer>());
        }
        
        
        
        for(int i=0;i<a.length-1;i++) { // what steps can be taken 
            HashSet<Integer> temp = steps.get(a[i]);
            if (temp!= null && temp.size() > 0) {
                for(Integer j : temp) {
                    int toGo = a[i] + j;
                    if (toGo == a[a.length-1]) {
                        System.out.println("We reached end");
//                        return;
                    }
                    if (steps.containsKey(toGo)) {
                        HashSet<Integer> toGoStepsList = steps.get(toGo);
                        if (j-1 > 0) {
                            toGoStepsList.add(j-1);
                        }
                        toGoStepsList.add(j);
                        toGoStepsList.add(j+1);
                    }
                }
            }
        }
        
        
        for(Integer i : steps.keySet()) {
            System.out.println("Key:" + i + " val->" + steps.get(i));
        }
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {0,1,3,4,6,8};
        FrogJump obj = new FrogJump();
        obj.canFrogReachEnd(a);
        
    }

}
