package treessandtrees;
import java.util.*;
class Integers {
    int val, row, col;
    Integers(int v, int r, int c) {
        val = v;
        row = r;
        col = c;
    }
}

public class MergeKSortedArrays {
    ArrayList<Integer> res;
    MergeKSortedArrays() {
        res = new ArrayList<Integer>();
    }
    public void merge(int a[][]) {
        
        int counterLimit = a.length*a[0].length;
        int counter = 0;
        PriorityQueue<Integers> pq = new PriorityQueue<Integers>(
                new Comparator<Integers>() {
                        public int compare(Integers a , Integers b) {
                            return a.val - b.val;
                        }
                }
        );
        for(int i=0;i<a.length;i++) {
            pq.add(new Integers(a[i][0], i, 0)); // add all first elements
        }
        int kth[] = new int[a.length];
        while(counter <= counterLimit) {
            Integers temp = pq.poll();
            res.add(temp.row);
//            System.out.print(temp.val + "( col:"+kth[temp.row]+" row:" + temp.row + ")");
            kth[temp.row]++; // for temp.row, increment col
            int col = kth[temp.row];
            if (col < a[temp.row].length) {// considering all rows have same length
                pq.add(new Integers(a[temp.row][col], temp.row, col));
//                System.out.print(" -- adding to Q:" + a[temp.row][col]);
            }
//            System.out.println();
            counter++;
        }
    }
    
    public void smallestRange(ArrayList<Integer> res, int a[][]) {
        if (res.size() == 0)
            return;
        else {
            Queue<Integer> q = new LinkedList<Integer>();
            HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
            int minLength = Integer.MAX_VALUE;
            int start = 0, end = 0;
            int startIndex = 0, endIndex =0;
            Iterator<Integer> it = res.iterator();
            while(it.hasNext()) {
                int temp = it.next();
                if (count.size() < a.length) {
                    end = ++endIndex; // every dequeued is end
                    count.put(temp, count.getOrDefault(temp, 0) +1);
                    q.add(temp);
                    System.out.println("Added to queue: " + count.size() + " -> temp:" + temp);
                } else { // when count size becomes k ie a.length
                    // read from front of queue till count < k and while doing it check for min length/calculate min length
                    start = startIndex;
                    if (end -start < minLength) {
                        minLength = end - start;
                    }
                    // dequeue while hashMap.size() < k;
                    while(!q.isEmpty() && count.size() > a.length) {
                        startIndex++;
                        int deQueued = q.poll();
                        if (count.get(deQueued) > 1) {
                            count.put(deQueued, count.get(deQueued) -1);
                        } else {
                            count.remove(deQueued);
                        }
                    }
                }
            }
            System.out.println("Min length range comprising all k arrays is :" + minLength);
        }
    }
    public static void main(String args[]) {
        MergeKSortedArrays obj= new MergeKSortedArrays();
        int a[][] = {
                {4,5,7,8,10},
                {1,3,6,9,11},
                {11,22,23,66,88},
                {100, 101, 102,109, 1111},
                {31,56,89,112,778, 999},
        };
        obj.merge(a);
//        System.out.println(obj.res.size());
        
        System.out.println("Min range size where all elements form k arrays lies in the sorted merged array");
        System.out.println(Arrays.toString(obj.res.toArray()));
        obj.smallestRange(obj.res, a);
        
        
    }
    
}
