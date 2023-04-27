package com.example.simple_mvvm;

public class User {

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String email;
    private String password;

}
