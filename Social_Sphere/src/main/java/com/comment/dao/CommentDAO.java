package com.comment.dao;

import com.comment.model.Comment;

import java.util.List;

public interface CommentDAO {
    int insert(Comment comment);
    List<Comment> view();
    int countCommentmadeByUserId(int userid);
}
