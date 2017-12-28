package treessandtrees;
import java.util.*;
//https://leetcode.com/problems/ipo/description/
class ProjectPairs {
    int profit,capital;
    ProjectPairs(int a, int b) {
        profit = a;
        capital = b;
    }
}
public class IPOBudget {
    
    public void getMaxProfile(int profit[], int capital[], int toSpend, int k) {
        if (profit.length != capital.length || k<=0)
            return;
        PriorityQueue<ProjectPairs> pqCap = new PriorityQueue<ProjectPairs>(
                new Comparator<ProjectPairs>() {
                    public int compare(ProjectPairs a, ProjectPairs b) {
                        return a.capital - b.capital;
                    }
                }
        );
        
        PriorityQueue<ProjectPairs> pqPro = new PriorityQueue<ProjectPairs>(
                new Comparator<ProjectPairs>() {
                    public int compare(ProjectPairs a, ProjectPairs b) {
                        return b.profit - a.profit;
                    }
                }
        );
        
        PriorityQueue<ProjectPairs> res = new PriorityQueue<ProjectPairs>();
        
        
        for(int i=0;i<profit.length;i++) {
            pqCap.add(new ProjectPairs(profit[i], capital[i]));
        }
        //
//        while(pqCap.size() > 0) {
//            ProjectPairs temp = pqCap.poll();
//            System.out.println("in cap Q -> project with capital:" + temp.capital + " profit:" + temp.profit);
//        }
        //
        while(k > 0) { // num of prjs to pick
            while(pqCap.size() > 0 && pqCap.peek().capital <= toSpend) {
                ProjectPairs temp = pqCap.peek(); // remove everything from top of pqCap which is within spend
                pqPro.add(temp);
                pqCap.poll(); // now remove i from pqCap
            } // we got all possible candidates which we can pick for max profit

            if (pqPro.size() > 0) { // all are candidates
                ProjectPairs temp = pqPro.poll();
                --k;
                toSpend += temp.profit;
                toSpend -= temp.capital;
                System.out.println("project with capital:" + temp.capital + " profit:" + temp.profit);
//                res.add(temp);
            } else {
                break;
            }
        }
        
        if (k == 0) {
            System.out.println("We maxed it out, below are projects");
            Iterator<ProjectPairs> it = res.iterator();
            while(it.hasNext()) {
                ProjectPairs temp = it.next();
                System.out.println("project with capital:" + temp.capital + " profit:" + temp.profit);
            }
        } else {
            System.out.println("We couldnt pick k projects with given budget");
        }
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        IPOBudget obj = new IPOBudget();
        int profit[]={1,2,3};
        int capital[]={0,1,1};
        int k = 3;
        int toSpend = 0;
        obj.getMaxProfile(profit, capital, toSpend, k);
    }

}
