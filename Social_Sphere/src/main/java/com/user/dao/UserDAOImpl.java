package com.user.dao;

import com.user.model.User;
import com.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    @Override
    public int insert(User user) {
        try {
            String sql = "Insert into Users(username , email , password) values (?, ?, ?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            int result = preparedStatement.executeUpdate();
            if (result > 0)
                return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public User authenticate(String username, String password) {
        try {
            String sql = "Select * from Users where Username = ? and Password = ?";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("userid"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
