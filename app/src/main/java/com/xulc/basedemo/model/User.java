package com.xulc.basedemo.model;

import net.tsz.afinal.annotation.sqlite.Id;

/**
 * Created by xuliangchun on 2016/7/8.
 * 必须有一个主键。默认列名为id，并自增。使用注解@Id(column="id")
 实际bean中没有id属性，使用@id(column="name") 使name成主键 ，非integer等整数类型，不会自增
 */

public class User {
    @Id(column = "userId")
    private int userId;
    private String name;
    private String email;
    private String age;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
