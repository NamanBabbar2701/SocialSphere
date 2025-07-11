package com.comment.model;

import com.post.model.Post;
import com.user.model.User;

import java.util.Date;

public class Comment {
    private int commentId;
    private String comment;
    private User user;
    private Post post;
    private Date timeStamp;


    public Comment() {
    }

    public Comment(int commentId, String comment, User user, Post post, Date timeStamp) {
        this.commentId = commentId;
        this.comment = comment;
        this.user = user;
        this.post = post;
        this.timeStamp = timeStamp;
    }

    public Comment(Post post, User user, String comment) {
        this.post = post;
        this.user = user;
        this.comment = comment;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
