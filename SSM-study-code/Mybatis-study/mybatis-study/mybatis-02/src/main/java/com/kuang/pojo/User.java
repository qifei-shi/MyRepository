package com.kuang.pojo;

import org.apache.ibatis.type.Alias;

/**
 *
 * alt+insert 快速构造方法快捷键
* */
//实体类
@Alias("user")
public class User {
    private int id;
    private String name;
    private String pwd;

    public User() {

    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}