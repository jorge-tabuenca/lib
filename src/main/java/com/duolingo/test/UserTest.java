package com.duolingo.test;

import com.duolingo.interfaces.IUser;
import com.duolingo.interfaces.impl.UserImpl;

public class UserTest {

    public static void main(String[] args) {

        IUser userManager = new UserImpl();

        System.out.println(userManager.getAllUsers());

    }
}
