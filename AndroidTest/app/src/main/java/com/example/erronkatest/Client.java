package com.example.erronkatest;

public class Client {
    int ID;
    String name;
    Boolean active;
    public Client(int iD, String name, boolean active) {
        super();
        ID = iD;
        this.name = name;
        this.active = active;


    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getActive() {
        return active;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }
}
