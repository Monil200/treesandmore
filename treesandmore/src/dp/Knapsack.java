package dp;

public class Knapsack {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // given dimensions below, can we have a knapsack of capacity 5;
        int w[] = {1,2,9,3};
        int knapsack = 5;
        int opt[][] = new int[w.length+1][knapsack+1];
        
        for(int i=0;i<opt.length;i++) {
            opt[i][0] = 1;
        }
        for(int i=1;i<opt[0].length;i++) {
            opt[0][i] = 0;
        }
        boolean a = false;
        boolean b = false;
        for(int i=1;i<opt.length;i++) {
            for(int j = 1;j<opt[0].length;j++) {
                a = opt[i-1][j] == 1 ? true : false;
                try {
                    b = opt[i-1][j - w[i-1]] == 1 ? true: false;
                } catch (Exception e) {
                    b = false;
                }
                opt[i][j] = (a || b) ? 1 : 0;
            }
            a = false;
            b = false;
        }
        
        for(int i=0;i<opt.length;i++) {
            for(int j = 0;j<opt[0].length;j++) {
                System.out.print(opt[i][j] + ",");
            }
            System.out.println();
        }
        
        System.out.println(opt[w.length][knapsack]);
        
        int x = (int) Math.pow(2, 4);
    }

}
