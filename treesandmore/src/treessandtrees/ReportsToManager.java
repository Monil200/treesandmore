package treessandtrees;
import java.util.*;
public class ReportsToManager {
    
    public void getAllReports(String emp, HashMap<String, HashSet<String>> pmap) {
        if (emp == null || emp.equals(""))
            return;
        
        // base.
        if (!pmap.containsKey(emp)) {
            System.out.println(emp + ":" + 0);
            return;
        }
        
        Queue<String> hold = new LinkedList<String>();
        HashSet<String> unique = new HashSet<String>();
        hold.add(emp);
        int count = 0;
        while(!hold.isEmpty()) {
            // read pmap
            String s = hold.remove();
//            System.out.println("i m here" + s);
            if (pmap.containsKey(s)) {
                HashSet<String> sub = pmap.get(s);
                count += sub.size();
                Iterator<String> it = sub.iterator();
                while(it.hasNext()) {
                    String reports = it.next(); 
                    if (!unique.contains(reports)) {
                        hold.add(reports);
                        unique.add(reports);
                    }
                }
            }
        }
        
        System.out.println(emp + ":" + count);
        
        
    }
    
    public HashMap<String, HashSet<String>> processInput(Map<String, String> map) {
        if (map == null || map.size() == 0)
            return null;
        HashMap<String, HashSet<String>> pmap = new HashMap<String, HashSet<String>>();
        
        Set<Map.Entry<String, String>> set = map.entrySet();
        
        for(Map.Entry<String, String> s : set) {
            if (!s.getKey().equals(s.getValue())) {
                if (!pmap.containsKey(s.getValue())) {
                    pmap.put(s.getValue(), new HashSet<String>(Arrays.asList(s.getKey())));
                } else {
                    HashSet<String> temp = pmap.get(s.getValue());
                    temp.add(s.getKey());
                    pmap.put(s.getValue(), temp); // add new emloyee
                }
            }
        }
        
        return pmap;
        
    }
    
    
    
    public static void main(String[] args) {
        ReportsToManager obj = new ReportsToManager();
        Map<String, String> input = new HashMap<String, String>();
        input.put("A0", "A1");
        input.put("B0", "B1");
        input.put("C0", "B1");
        input.put("A1", "A2");
        input.put("B1", "A2");
        input.put("C1", "B2");
        input.put("A2", "A3");
        input.put("B2", "A3");
        input.put("A3", "A3");
        
        HashMap<String, HashSet<String>> pmap = new HashMap<String, HashSet<String>>();
        pmap = obj.processInput(input); // manager - sub map
        
        
        System.out.println(pmap);
        System.out.println(input.size());
        
        
//        Set<Map.Entry<String, String>> set = input.entrySet();
        Iterator<String> it = input.keySet().iterator();
        while(it.hasNext()) {
            obj.getAllReports(it.next().toString(), pmap); // for all emp get count
        } // for
        
    }// main
        
        
        
}// class