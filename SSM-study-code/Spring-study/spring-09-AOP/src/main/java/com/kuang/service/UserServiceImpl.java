package com.kuang.service;

public class UserServiceImpl implements UserService{

    @Override
    public void add() {
        System.out.println("则增加数据");
    }

    @Override
    public void delete() {
        System.out.println("则删除数据");
    }

    @Override
    public void update() {
        System.out.println("修改数据");
    }

    @Override
    public void select() {
        System.out.println("则查询数据");
    }
}
