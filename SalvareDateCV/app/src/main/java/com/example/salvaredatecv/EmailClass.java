package com.example.salvaredatecv;

/**
 * Created by Mada on 09.12.2016.
 */

public class EmailClass {
    private int id;
    private String email;

    public EmailClass(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
