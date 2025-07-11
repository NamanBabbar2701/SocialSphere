package com.post.dao;

import com.post.model.Post;
import com.user.model.User;
import com.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostDAOImpl implements PostDAO{

    @Override
    public int insert(Post post){
        try{
            String sql = "insert into POSTS(TITLE , CONTENT , USERID) values (? , ? , ?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getContent());
            preparedStatement.setInt(3, post.getUser().getUserID());

            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public List<Post> view() {
       List<Post> posts = new ArrayList<>();
       try{
           Statement statement = DBUtil.getConnection().createStatement();
           String sql = "Select p.*, u.username FROM POSTS p JOIN USERS u on p.userid = u.userid ORDER By p.timestamp DESC";
           ResultSet resultSet = statement.executeQuery(sql);

           while(resultSet.next()){
               Post post = new Post();
               post.setPostID(resultSet.getInt("postid"));
               post.setTitle(resultSet.getString("title"));
               post.setContent(resultSet.getString("content"));
               post.setTimestamp(resultSet.getTimestamp("timestamp"));

               User user = new User();
               user.setUserID(resultSet.getInt("userid"));
               user.setUsername(resultSet.getString("username"));

               post.setUser(user);

               posts.add(post);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return posts;
    }

    @Override
    public int countPostByUserId(int userid) {
        int count = 0;
        try{
            String sql = "SELECT COUNT(*) FROM POSTS WHERE USERID = ?";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, userid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
