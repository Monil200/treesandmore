package treessandtrees;

import java.util.Arrays;

// select k random nodes from pool of N nodes/nums
public class ReservoirSampling {
    public void reservoirSample(int a[], int k) {
        // make sure k < a.length
        int kRandom[] = new int[k];
        
        // add first k nums to kRand
        for(int i=0;i<k;i++) {
            kRandom[i] = a[i];
        }
        
        for(int i=k;i<a.length;i++) {
            int rand = (int) (Math.random()*i);
            System.out.println(rand);
            if (rand < k) {
                kRandom[rand] = a[i];
            }
        }
        
        System.out.println(Arrays.toString(kRandom));
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int rand = (int )(Math.random() * 50 + 1);
        System.out.println(rand);
        int a[] = {1,2,3,4,5,6,7,8,9,10};
        ReservoirSampling obj = new ReservoirSampling();
        obj.reservoirSample(a, 3);
    }

}
