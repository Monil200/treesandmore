package treesandmore;
import java.util.*;
class SubscribedUser {
    List<String> thisSubscriptions = new ArrayList<String>();
    static int userId = 0;
    int uid;
    public SubscribedUser() {
        this.uid = ++userId;
        this.thisSubscriptions = thisSubscriptions;
    }
    
    public void subscribeToSubscription(Subscription s) {
        List<String> thisSubscription = this.thisSubscriptions;
        List<SubscribedUser> users = s.users;
        if (s != null) {
            if (thisSubscription.indexOf(s.name) >= 0) {
                thisSubscription.add(s.name);
            }
        }
        if (users.indexOf(this) == -1 ){
            users.add(this);
            s.users = users;
        }
    }
    
    public void unsubscribeToSubscription(Subscription s) {
        List<String> thisSubscription = this.thisSubscriptions;
        List<SubscribedUser> users = s.users;
        if (s != null) {
            if (thisSubscription.indexOf(s.name) >= 0) {
                thisSubscription.remove(thisSubscription.indexOf(s.name));
            }
        }
        if (users.indexOf(this) >= 0 ){
            users.remove(users.indexOf(this));
            s.users = users;
        }
    }
}
class Subscription {
    List<SubscribedUser> users = new ArrayList<SubscribedUser>();
    String name;
    public Subscription(String name) {
        this.name = name;
    }
    
    public void sendNotification(String message) {
        List<SubscribedUser> users = new ArrayList<SubscribedUser>();
        users = this.users;
        Iterator<SubscribedUser> userIterator = users.iterator();
        while(userIterator.hasNext()) {
            SubscribedUser u = userIterator.next();
            System.out.println(" Send notification to user:" + u.uid + " Message:" + message);
        }
    }
    
    
}
public class SubscriptionModel {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SubscribedUser u1 = new SubscribedUser();
        SubscribedUser u2 = new SubscribedUser();
        
        Subscription s1 = new Subscription("Daily Mail");
        Subscription s2 = new Subscription("Daily Scores");
        
        u1.subscribeToSubscription(s1);
        u2.subscribeToSubscription(s2);
        u2.subscribeToSubscription(s1);
        
        s1.sendNotification("You have 4 mails in your inbox");
        s2.sendNotification("Ind vs Aus - Aus won!!");
        
        u1.unsubscribeToSubscription(s1);
        s1.sendNotification("Hello we have update our spam filter");
        
        
        
        
    }

}
