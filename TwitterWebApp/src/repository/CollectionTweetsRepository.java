package repository;

import tweet.Tweet;

import java.util.*;

public class CollectionTweetsRepository implements TweetsRepository {
    private ArrayList<Tweet> tweets;

    public CollectionTweetsRepository() {
        tweets = new ArrayList<>();
    }

    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    @Override
    public String toString() {
        Collections.sort(tweets, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (Tweet tweet : tweets) {
            sb.append(tweet.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}