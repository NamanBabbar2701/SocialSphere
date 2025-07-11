package com.post.dao;

import com.post.model.Post;

import java.util.List;

public interface PostDAO {
    int insert(Post post);
    List<Post> view();
    int countPostByUserId(int userid);
}
