package treessandtrees;

import java.util.*;

/*
 * In LeetCode Store, there are some kinds of items to sell. Each item has a price.

However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.

You are given the each item's price, a set of special offers, and the number we need to buy for each item. The job is to output the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers.

Each special offer is represented in the form of an array, the last number represents the price you need to pay for this special offer, other numbers represents how many specific items you could get if you buy this offer.

You could use any of special offers as many times as you want.
Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
Output: 14
Explanation: 
There are two kinds of items, A and B. Their prices are $2 and $5 respectively. 
In special offer 1, you can pay $5 for 3A and 0B
In special offer 2, you can pay $10 for 1A and 2B. 
You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
 */
public class ShoppingOffers {
    int cost;
    ShoppingOffers() {
        cost = Integer.MAX_VALUE;
    }
    public int getCheapestOffers(List<Integer> prices, ArrayList<ArrayList<Integer>> offers, List<Integer> needs) {
        
        for(int i=0;i<offers.size();i++) {
            boolean isInValidOffer = false;
            int remains = 0;
            ArrayList<Integer> offer = offers.get(i);
            for(int j=0;j<needs.size();j++) {
                remains = needs.get(j) - offer.get(j);
                if (remains < 0) {
                    isInValidOffer = true;
                    break;
                }
                remains = 0;
            }
            
            if (!isInValidOffer) {
                for(int j=0;j<needs.size();j++) {
                    System.out.println("offers:" + Arrays.asList(offer) + " j:" + j);
                    needs.set(j , needs.get(j) - offer.get(j));
                    System.out.println("needs:" + Arrays.asList(needs) + " j:" + j);
                }
                cost = Math.min(cost, getCheapestOffers(prices, offers, needs) + offer.get(offer.size() -1));
                // backtrack
                for(int j=0;j<needs.size();j++) {
                    needs.set(j , needs.get(j) + offer.get(j));
                }
            }
            
        }
        
        // org price
        int nonOfferPrice = 0;
        for(int i =0;i<prices.size();i++) {
            nonOfferPrice += prices.get(i)*needs.get(i); 
        }
        
        return Math.min(nonOfferPrice, cost);
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> prices = new ArrayList<Integer>(Arrays.asList(2,2));
        List<Integer> needs = new ArrayList<Integer>(Arrays.asList(3,2));
        ArrayList<ArrayList<Integer>> offers = new ArrayList<ArrayList<Integer>>();
        offers.add(new ArrayList<Integer>(Arrays.asList(0,2,2)));
        offers.add(new ArrayList<Integer>(Arrays.asList(1,2,10)));
        offers.add(new ArrayList<Integer>(Arrays.asList(2,0,5)));
        ShoppingOffers obj = new ShoppingOffers();
        System.out.println(obj.getCheapestOffers(prices, offers, needs));
    }

}
