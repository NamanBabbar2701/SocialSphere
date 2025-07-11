package com.user.dao;

import com.user.model.User;

public interface UserDAO {
    int insert(User user);
    User authenticate(String username , String password);
//    int getUserIdByUsername(String username);
}
