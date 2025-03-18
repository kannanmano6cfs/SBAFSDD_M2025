package com.learning.ex_productservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Userdata {

    @Id
    @GeneratedValue
    private int user_id;
    private String user_name;

    public Userdata() {
    }

    public Userdata(int user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
