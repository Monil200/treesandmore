package treessandtrees;
import java.util.*;
public class UniqueIncreasingSubsequences {
    
    public void getUniqueSubsequences(List<Integer> holder, Set<List<Integer>> res, int nums[], int index) {
//        System.out.println("index:" + index);
        if (holder.size() >= 2) {
//            System.out.println("my size is greater than 2:");
//            Iterator<Integer> i = holder.iterator();
//            while(i.hasNext()) {
//                System.out.print(i.next() + ", ");
//            }
//            System.out.println();
            res.add(new ArrayList(holder));
        }
        if (index >= nums.length) {
            return;
        }
        for(int i=index;i<nums.length;i++) {
            System.out.println("i:" + i);
            if (holder.size() == 0 || holder.get(holder.size() -1 ) <= nums[i]) {
//                System.out.println("adding index:" + i);
                holder.add(nums[i]);
                getUniqueSubsequences(holder, res, nums, 1+i);
                holder.remove(holder.size() -1);
//                --index;
            }
        }
    }
    
    public void test(int index, int tabCount) {
        if (index>=4 ) {
            return;
        }
        for(int i=index;i<4;i++) {
            for(int j=0;j<tabCount;j++) {
                System.out.print("\t");
            }
            System.out.println(" " + i);
            test(1+i, 1 + tabCount);
            //--index;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        UniqueIncreasingSubsequences obj = new UniqueIncreasingSubsequences();
        List<Integer> holder = new ArrayList<Integer>();
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        int nums[] = {5,6,7,7};
        obj.getUniqueSubsequences(holder, res, nums, 0);
        System.out.println(res.size());
        Iterator<List<Integer>> it = res.iterator();
        while(it.hasNext()) {
            List<Integer> temp = it.next();
//            System.out.println("i m here" + temp.size());
            Iterator<Integer> i = temp.iterator();
            while(i.hasNext()) {
                System.out.print(i.next() + ", ");
            }
            System.out.println();
        }
        System.out.println("----------------TEST OF KNOWLEDGE----------------");
        obj.test(0, 0);
    }

}
