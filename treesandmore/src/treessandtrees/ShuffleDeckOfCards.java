package treessandtrees;
import java.util.*;
class Cards {
    int val;
    char type;
    Cards(char c, int v) {
        type = c;
        val = v;
    }
}
public class ShuffleDeckOfCards {
    public static void shuffle(List<Cards> a) {
        List<Cards> shuffledDeck = new ArrayList<Cards>();
        
        for(int i=0;i<52;i++) {
            int random = (int) (Math.random()*(52-i));
            shuffledDeck.add(a.get(random));
            a.remove(random); // instead swap it with last card
        }
        
        Iterator<Cards> it = shuffledDeck.iterator();
        System.out.println("-----------After shuffle---------");
        while(it.hasNext()) {
            Cards temp = it.next();
            System.out.println(temp.type + " - " + temp.val);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        char type[] = {'c', 's', 'h', 'd'};
        
        List<Cards> initial = new ArrayList<Cards>();
        for(int i=0;i<type.length;i++) {
            for(int j=0;j<a.length;j++) {
                initial.add(new Cards(type[i], a[j]));
            }
        }
        
        Iterator<Cards> it = initial.iterator();
        while(it.hasNext()) {
            Cards temp = it.next();
            System.out.println(temp.type + " - " + temp.val);
        }
        shuffle(initial);
        
        ArrayList<String> xyz = new ArrayList<String>();
        xyz.add(null);
        System.out.println(xyz.get(0) == null);
    }

}
