package com.fy.entity;

public class Advice {
    private int id;
    private int user_id;
    private String tel;
    private String contact;
    private String email;
    private String description;
    private int state;
    private String answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Advice() {
    }

    public Advice(int id, int user_id, String tel, String contact, String email, String description, int state, String answer) {
        this.id = id;
        this.user_id = user_id;
        this.tel = tel;
        this.contact = contact;
        this.email = email;
        this.description = description;
        this.state = state;
        this.answer = answer;
    }
}
