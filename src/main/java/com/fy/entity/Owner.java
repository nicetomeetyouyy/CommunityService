package com.fy.entity;

import org.neo4j.ogm.annotation.*;

@NodeEntity(label = "owner")
public class Owner {
    @Id@GeneratedValue
    private Long id;
    private String name;
    private String sex;
    private String age;
    private String tel;
    private String identity;
    private String user_id;
    public Owner() {
    }



    public Owner(Long id, String name, String sex, String age, String tel, String identity, String user_id) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.identity = identity;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
