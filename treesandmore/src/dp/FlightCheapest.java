package dp;
import java.util.*;
public class FlightCheapest {
    
    public void generateCheapestFlightTable(int a[][]) {
        int opt[][] = new int[3][3];
        int cost[][] = new int[3][3];
        
        for(int i=0;i<a.length;i++) {
            cost[i][i] = 0;
            opt[i][i] = 0;
        }
        for(int i=0;i<a.length;i++) {
            cost[a[i][0]][a[i][1]] = a[i][2];
        }
        for(int i=1;i<a[0].length;i++) {
            opt[0][i] = cost[0][i];
        }
        
        int cols = 1;
        for(int i=1;i<a.length;i++) { // rows
            cols++;
            for(int j=cols;j<a[0].length;j++) {
                int withoutNew = opt[i-1][j];
                int withNew = cost[i][j] + opt[i-1][cols-1];
                opt[i][j] = Math.min(withoutNew, withNew);
            }
        }
        
        
        for(int i=0;i<a.length;i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
        
        
     }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[][] = {{0,1, 100},{1,2,100}, {0,2,500}};
        FlightCheapest obj= new FlightCheapest();
        obj.generateCheapestFlightTable(a);
    }

}
