package com.example.erronkauno2_swipe.Login;

public class User {
    int ID;
    String login, password;


    public User(int iD, String login, String password) {
        super();
        ID = iD;
        this.login = login;
        this.password = password;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}