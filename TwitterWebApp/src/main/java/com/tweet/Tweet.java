package com.tweet;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Tweet implements Comparable<Tweet> {
    private String content;
    private Date time;

    public Tweet() {
        content = "";
        time = new Date();
    }

    public Tweet(String content) {
        this.content = content;
        time = new Date();
    }

    public Tweet(String content, Date time) {
        this.content = content;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public Date getTime() {
        return time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Anonymous\n" + time.toString() + "\n" + content + "\n";
    }

    @Override
    public int compareTo(Tweet o) {
        if (time.compareTo(o.getTime()) < 0) return -1;
        if (time.compareTo(o.getTime()) > 0) return 1;
        return 0;
    }
}