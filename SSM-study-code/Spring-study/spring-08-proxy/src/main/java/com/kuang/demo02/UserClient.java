package com.kuang.demo02;

public class UserClient {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        UserServiceProxy userProxy = new UserServiceProxy();

        userProxy.setUserService(userService);

        userProxy.delete();

    }



}
