package aaplQuYelBay;
import java.util.*;
class Employee implements Comparable<Employee>{
    int id;
    String name;
    Employee(int i, String n) {
        id = i;
        name = n;
    }
    
    public int compareTo(Employee e1) {
        if (e1 == null) {
            return -1;
        }
        return e1.id - this.id; // descending
    }
 }
public class SortObjVariations {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Employee e1 = new Employee(1, "Monil");
        Employee e2 = new Employee(2, "Arm");
        Employee e3 = new Employee(100, "Zico");
        
        ArrayList<Employee> list = new ArrayList<Employee>();
        list.add(e1);list.add(e2);list.add(e3);
        
        Collections.sort(list);
        
        for(Employee e: list) {
            System.out.println("id:" + e.id + " name:" + e.name);
        }
        
        // own comparator
        
        Comparator<Employee> c2d = new Comparator<Employee>() {
            public int compare(Employee a, Employee b) {
//                return b.id - a.id;
                return a.id - b.id;
            }
        };
        
        Collections.sort(list, c2d);
        
        for(Employee e: list) {
            System.out.println("id:" + e.id + " name:" + e.name);
        }
    }

}
