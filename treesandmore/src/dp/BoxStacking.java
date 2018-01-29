package dp;
import java.util.*;
class Box {
    int base, height, width, length;
    Box(int h, int w, int l) {
        height = h;
        width = w;
        length = l;
        base = width*length;
    }
}
public class BoxStacking {
    public void getMaxHeight(ArrayList<Box> input) {
        int opt[] = new int[input.size()];
        
        opt[0] = input.get(0).height;
        
        for(int i=1;i<input.size();i++) {
            int currMax = 0;
            Box candidate = input.get(i);
            for(int j=0;j<i;j++) {
                Box toExtend = input.get(j);
                if (candidate.width <= toExtend.width && candidate.length <= toExtend.length) {
                    if (opt[j] > currMax) {
                        currMax = opt[j];
                    }
                }
            } // we would have stack that needs to be extended
            
            opt[i] = Math.max(input.get(i).height + currMax, opt[i-1]);
        }
        
        // traverse to get maxStack
        int maxHeight = Integer.MIN_VALUE;
        for(int i=0;i<opt.length;i++) {
            if (opt[i] > maxHeight ) {
                maxHeight = opt[i];
            }
        }
        System.out.println(Arrays.toString(opt));
        System.out.println("Max height:" + maxHeight);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Comparator<Box> special = new Comparator<Box>() {
            public int compare(Box b1, Box b2) {
                return b2.base - b1.base;
            }
        };
        
        ArrayList<Box> input = new ArrayList<Box>();
        
        input.add(new Box(4, 3,3));
        input.add(new Box(3,4,3));
        input.add(new Box(3,3,4));
        
        
        input.add(new Box(8, 2,3));
        input.add(new Box(2,3,8));
        input.add(new Box(3,2,8));
        
        Collections.sort(input, special);
        Iterator<Box> it = input.iterator();
        while(it.hasNext()) {
            Box temp = it.next();
            System.out.println("Height:" + temp.height + " length:" + temp.length + " width:" + temp.width);
        }
        BoxStacking obj = new BoxStacking();
        obj.getMaxHeight(input);
        
    }
    
    

}
