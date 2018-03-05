package treessandtrees;
/*
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 */
import java.util.*;
public class AccountsMerge {
    
    public void mergeAccounts(ArrayList<String> a[]) {
        if (a.length == 0 || a == null)
            return;
        
        Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
        
        for(int i=0;i<a.length;i++) {
            ArrayList<String> input = a[i];
            HashSet<String> emails = new HashSet<String>();
            boolean isExistingUser = false;
            String matchedName = "";
            System.out.println(input);
            for(int j=0;j<input.size();j++) {
                if (j == 0){
                    if (map.containsKey(input.get(j))) {
                        isExistingUser = true;
                        matchedName = input.get(j); // can be get(0)
                    } else {
                        isExistingUser = false;
                    }
                } else {
                    emails.add(input.get(j));
                }
            }
            if (isExistingUser) {
                isExistingUser = false;
                Iterator<String> it = emails.iterator();
                HashSet<String> candidateEmails = map.get(matchedName); 
                while(it.hasNext()) {
                    String email = it.next();
                    if (candidateEmails.contains(email)) {
                        isExistingUser = true;
                        break;
                    }
                }
                if (isExistingUser) {
                    for(String s : emails) {
                        candidateEmails.add(s);
                    }
                    map.put(matchedName, new HashSet<String>(candidateEmails));
                }
            } else {
                map.put(input.get(0), emails);
            }
        }
        
        System.out.println(map);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AccountsMerge obj = new AccountsMerge();
        ArrayList<String> input[] = new ArrayList[4];
        input[0] = new ArrayList<String>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        input[1] = new ArrayList<String>(Arrays.asList("John", "johnnybravo@mail.com"));
        input[2] = new ArrayList<String>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        input[3] = new ArrayList<String>(Arrays.asList("Mary", "mary@mail.com"));
        
        obj.mergeAccounts(input);
    }

}
