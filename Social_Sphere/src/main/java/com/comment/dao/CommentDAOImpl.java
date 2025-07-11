package com.comment.dao;

import com.comment.model.Comment;
import com.post.model.Post;
import com.user.model.User;
import com.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO{

    @Override
    public int insert(Comment comment) {
        try{
            String sql = "insert into comments (comment , userid , postid) values (?,?,?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,comment.getComment());
            preparedStatement.setInt(2,comment.getUser().getUserID());
            preparedStatement.setInt(3,comment.getPost().getPostID());
            int result = preparedStatement.executeUpdate();
            if(result > 0)
                return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Comment> view() {
        List<Comment> comments = new ArrayList<>();
        try{
            Statement statement = DBUtil.getConnection().createStatement();
            String sql = "Select c.* , u.username " +
                    "From Comments c " +
                    "Join Users u on c.userid = u.userid " +
                    "Order by c.timestamp DESC";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Comment comment = new Comment();
                comment.setCommentId(resultSet.getInt("commentid"));
                comment.setComment(resultSet.getString("comment"));

                comment.setTimeStamp(resultSet.getTimestamp("timestamp"));

                User user =  new User();
                user.setUserID(resultSet.getInt("userid"));
                user.setUsername(resultSet.getString("username"));

                Post post = new Post();
                post.setPostID(resultSet.getInt("postid"));

                comment.setUser(user);
                comment.setPost(post);

                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    @Override
    public int countCommentmadeByUserId(int userid) {
        int count = 0;
        try{
            String sql = "SELECT Count(*) from Comments where userid = ?";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,userid);
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







