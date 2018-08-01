package treesandmore;
import java.util.*;
public class PlatterInABudget {
    
    
    public void getPlatter(HashMap<String, Integer> map, int budget, ArrayList<String> items, int start) {
        if (budget == 0) {
            System.out.println(items);
        }
        if (budget<= 0) {
            return;
        }
        if (map.size() == 0) {
            return;
        }
        
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for(Map.Entry<String, Integer> i : set) {
            if (i.getValue() <= budget) {
                items.add(i.getKey());
                budget -= i.getValue();
                getPlatter(map,budget,items,0);
                budget += i.getValue();
                items.remove(i.getKey());
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("roti", 2);
        map.put("sweet", 3);
        map.put("fruits", 2);
        PlatterInABudget obj = new PlatterInABudget();
        obj.getPlatter(map, 5, new ArrayList<String>(), 0);
        
    }

}
