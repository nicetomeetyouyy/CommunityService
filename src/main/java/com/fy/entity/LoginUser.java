package com.fy.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (LoginUser)实体类
 *
 */
public class LoginUser implements Serializable {
    private static final long serialVersionUID = 894912058065772275L;

    private Integer user_id;

    private String login_name;

    private String password;

    private Date create_time;

    private Date login_time;


    public LoginUser(Integer user_id, String login_name, String passward, Date create_time, Date login_time, Integer login_tount) {
        this.user_id = user_id;
        this.login_name = login_name;
        this.password = passward;
        this.create_time = create_time;
        this.login_time = login_time;
    }

    public LoginUser() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getPassward() {
        return password;
    }

    public void setPassward(String passward) {
        this.password = passward;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }


}
