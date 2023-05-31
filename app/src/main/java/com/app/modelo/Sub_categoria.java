package com.app.modelo;

import java.io.Serializable;

public class Sub_categoria implements Serializable {
    int id;
    String name;
    public Sub_categoria(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Sub_categoria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
