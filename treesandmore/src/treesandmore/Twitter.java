package treesandmore;
import java.util.*;
/*
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.

getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.

follow(followerId, followeeId): Follower follows a followee.

unfollow(followerId, followeeId): Follower unfollows a followee.
 */
class User {
    static int userId = 0;
    int uid;
    List<User> followersList = new ArrayList<User>();
    List<User> followingList = new ArrayList<User>();
    List<String> tweetsList = new ArrayList<String>();
    
    public User() {
        this.uid = ++userId;
    }
    
    public void follow(User u) {
        List<User> getThisFollowing = this.followingList;
        Iterator<User> temp = null;
        
        if (u != null) {
            getThisFollowing.add(u);
//            temp = getThisFollowing.iterator();
//            while(temp.hasNext()) {
//                System.out.print(temp.next().uid + ",");
//            }
        } else {
            System.out.println("User does not exist");
        }
        
    }
    
    public void unfollow(User u) {
        List<User> getThisFollowers = this.followingList;
        int unfollowUid = getThisFollowers.indexOf(u);
        if (unfollowUid >= 0 ) {
            getThisFollowers.remove(unfollowUid);
            this.followingList = getThisFollowers;
        }
        Iterator<User> temp = getThisFollowers.iterator();
        // new list of following after unfollowing someone;
//        while(temp.hasNext()) {
//            System.out.println(temp.next() + ",");
//        }
    }
    
    public void postTweet(String tweet) {
        List<String> getThisTweets = this.tweetsList;
        getThisTweets.add(tweet);
        this.tweetsList = getThisTweets;
        Iterator<String> temp = getThisTweets.iterator();
        // list of tweets;
//        while(temp.hasNext()) {
//            System.out.println(temp.next() + ",");
//        }
    }
    
    public void getNewsFeed() {
        List<User> getThisFollowing = this.followingList;
        Iterator<User> thisFollowingList= getThisFollowing.iterator();
        while(thisFollowingList.hasNext()) {
            User thisFollowing = thisFollowingList.next();
            List<String> thisUserTweetsList = thisFollowing.tweetsList;
            Iterator<String> thisUserTweetsListIterator = thisUserTweetsList.iterator();
            while(thisUserTweetsListIterator.hasNext()) {
                System.out.println(thisUserTweetsListIterator.next());
            }
        }
        
    }
}
public class Twitter {
    public static void main(String[] args) {
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        User u31 = null;
        u1.follow(u3);
        u1.follow(u2);
        u1.follow(u31); //User does not exist 
        u2.follow(u1);
        u1.postTweet("Hi there");
        u1.postTweet("Hi Facebook, i am coming");
        u2.postTweet("Roger federer");
        u2.postTweet("Novak djokovic");
        u3.postTweet("rafael Nadal");
        u3.postTweet("STan wawrinka");
        System.out.println("News feed of user 2");
        u2.getNewsFeed();
        System.out.println("News feed of user 1");
        u1.getNewsFeed();
        u1.unfollow(u3);
        System.out.println("News feed of user 1 after unfollowing u3");
        u1.getNewsFeed();
    }
}
