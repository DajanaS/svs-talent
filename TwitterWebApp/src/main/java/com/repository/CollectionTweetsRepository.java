package com.repository;

import com.tweet.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
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