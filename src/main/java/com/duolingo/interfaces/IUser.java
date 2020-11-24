package com.duolingo.interfaces;

import com.duolingo.model.User;

import java.util.List;

public interface IUser {

    public List<User> getAllUsers();

    public User insertUser(User user);

}
