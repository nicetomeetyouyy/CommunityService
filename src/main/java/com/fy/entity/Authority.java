package com.fy.entity;

public class Authority {
    private int authority_id;
    private String authority_name;
    private String description;
    private String uri;

    public Authority() {
    }

    public Authority(int authority_id, String authority_name, String description, String uri) {
        this.authority_id = authority_id;
        this.authority_name = authority_name;
        this.description = description;
        this.uri = uri;
    }

    public int getAuthority_id() {
        return authority_id;
    }

    public void setAuthority_id(int authority_id) {
        this.authority_id = authority_id;
    }

    public String getAuthority_name() {
        return authority_name;
    }

    public void setAuthority_name(String authority_name) {
        this.authority_name = authority_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
