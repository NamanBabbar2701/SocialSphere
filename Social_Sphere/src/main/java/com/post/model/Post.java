package com.post.model;

import com.user.model.User;

import java.util.Date;

public class Post {

    private int postID;
    private String title;
    private String content;

    public Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    private Date timestamp;
    private User user;

    public Post() {
    }

    public Post(int postID, String title, String content, User user) {
        this.postID = postID;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.user = user;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

