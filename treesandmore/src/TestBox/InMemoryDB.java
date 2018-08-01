package TestBox;
import java.util.*;

class Feature {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
}

class Transaction {
    Feature f;
    Transaction() {
        f = new Feature();
    }
}

public class InMemoryDB {
    
    public Transaction commited;
    public ArrayList<Transaction> uncommited = new ArrayList<Transaction>();
    InMemoryDB() {
        commited = new Transaction();
    }
    
    public void setValAndCount(Transaction x, String key, int val) {
        x.f.map.put(key, val);
        if (x.f.count.containsKey(val)) {
            x.f.count.put(val, x.f.count.get(val) +1);
        } else {
            x.f.count.put(val, 1);
        }
    }
    
    
    public void plainCommitSet(boolean isOutOfBlock, String key, int val) {
        if (isOutOfBlock) {
            // put
            setValAndCount(commited, key, val);
        } else {
            if (uncommited.size() > 0 ) {
                int candidateTransactionIndex = uncommited.size()-1; 
                setValAndCount(uncommited.get(candidateTransactionIndex), key, val);
            }
        }
    }
    
    public void beginBlock() {
        Transaction newTransaction = new Transaction();
        uncommited.add(newTransaction);
    }
    
    public void commitTransaction() {
        // read all trasaction and update
        if (uncommited.size() == 0) {
            System.out.println("Nothing to commit, ty!");
            return;
        }
        Iterator<Transaction> it = uncommited.iterator();
        
        while(it.hasNext()) {
            Transaction current = it.next();
            Set<Map.Entry<String, Integer>> set = current.f.map.entrySet();
            for(Map.Entry<String, Integer> i : set) {
                commited.f.map.put(i.getKey(), i.getValue());
                // reused bloack of code
                if (commited.f.count.containsKey(i.getValue())) {
                    commited.f.count.put(i.getValue(), commited.f.count.get(i.getValue()) +1);
                } else {
                    commited.f.count.put(i.getValue(), 1);
                }
                // reuse ended
            }
        }
        uncommited.clear(); // no more transactions
    }
    
    public void getValue(String key) {
        if (uncommited.size() > 0) {
            Transaction top = uncommited.get(uncommited.size() - 1);
            if (top.f.map.containsKey(key)) {
                System.out.println("Uncommited Value of Key: " + key +" is " +  top.f.map.get(key));
            } else {
                System.out.println("NULL - no such key in this transaction block."); // if this doenst exist , i should check commited
            }
        } else {
            // get data from master commited
            if (commited.f.map.containsKey(key)) {
                System.out.println("Commited Value of Key: " + key +" is " +  commited.f.map.get(key));
            } else {
                System.out.println("NULL - no such key in commited state/block."); 
            }
        }
    }
    
    public void getCount(int c) {
        if (uncommited.size() > 0) {
            Transaction top = uncommited.get(uncommited.size() - 1);
            if (top.f.count.containsKey(c)) {
                System.out.println("Uncommited Count Value of c: " + c +" is " +  top.f.count.get(c));
            } else {
                System.out.println("NULL - no such count value in this transaction block.");
            }
        } else {
            // get data from master commited
            if (commited.f.count.containsKey(c)) {
                System.out.println("Commited Count Value of c: " + c +" is " +  commited.f.count.get(c));
            } else {
                System.out.println("NULL - no such count value in commited state."); 
            }
        }
    }
    
    public void delete(String key) {
        if (uncommited.size() > 0) {
            Transaction top = uncommited.get(uncommited.size() - 1);
            if (top.f.map.containsKey(key)) {
                int valuesCount = top.f.map.get(key);
                
                // removed key
                top.f.map.remove(key);
                // remove or reduce count
                if (top.f.count.containsKey(valuesCount) && top.f.count.get(valuesCount) == 1) {
                    top.f.count.remove(valuesCount);
                } else if (top.f.count.containsKey(valuesCount) && top.f.count.get(valuesCount) > 1) {
                    top.f.count.put(valuesCount, top.f.count.get(valuesCount) -1);
                }
                System.out.println("Deleted key from latest transaction block:" + key);
            } else {
                System.out.println("NULL - no such count value in this transaction block.");
            }
        } else { // delete from in commited
            if (commited.f.map.containsKey(key)) {
                int valuesCount = commited.f.map.get(key);
                
                // removed key
                commited.f.map.remove(key);
                // remove or reduce count
                if (commited.f.count.containsKey(valuesCount) && commited.f.count.get(valuesCount) == 1) {
                    commited.f.count.remove(valuesCount);
                } else if (commited.f.count.containsKey(valuesCount) && commited.f.count.get(valuesCount) > 1) {
                    commited.f.count.put(valuesCount, commited.f.count.get(valuesCount) -1);
                }
                System.out.println("Deleted key from commited block/space: " + key);
            } else {
                System.out.println("NULL - no such count value in commited block/space");
            }
        }
    }
    
    public void rollBack() {
        if (uncommited.size() == 0) {
            System.out.println("NO TRANSACTION");
            return;
        }
        int candidateTransactionIndex = uncommited.size()-1;
        uncommited.remove(candidateTransactionIndex); // removed latest transaction
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InMemoryDB obj = new InMemoryDB();
        
//        obj.beginBlock();
//        obj.plainCommitSet(false, "A",10);
//        obj.getCount(10);
//        obj.commitTransaction();
//        obj.getValue("A");
//        obj.getCount(10);
//        obj.delete("A");
//        obj.delete("A");
//        obj.getCount(10);
//        obj.commitTransaction();
//        
//        System.out.println("----------------------------------------------");
        obj.beginBlock();
        obj.plainCommitSet(false, "A", 11);
        obj.plainCommitSet(false, "B", 11);
        obj.getCount(11);
        obj.getValue("B");
        obj.beginBlock();
        obj.plainCommitSet(false, "B", 21);
        obj.getValue("B");
        obj.delete("B");
        obj.getValue("B");
        obj.commitTransaction();
        obj.getValue("B");
        obj.getCount(11);
        
        
        System.out.println("----------------------------------------------");
//        obj.plainCommitSet(true, "A", 11);
//        obj.plainCommitSet(true, "B", 11);
//        obj.getValue("A");
//        obj.getCount(11);
//        obj.beginBlock();
//        obj.getValue("A"); //
//        obj.rollBack();
//        obj.getValue("A");
        
        
        
        
        
    }

}
