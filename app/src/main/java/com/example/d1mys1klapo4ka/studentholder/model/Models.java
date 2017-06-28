package com.example.d1mys1klapo4ka.studentholder.model;

import java.io.Serializable;

/**
 * Created by d1mys1klapo4ka on 15.05.2017.
 */

public class Models implements Serializable {

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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getBirhday() {
        return birhday;
    }

    public void setBirhday(String birhday) {
        this.birhday = birhday;
    }

    private int id;

    private String name;
    private String secondName;
    private String birhday;

    public Models(int id, String name, String secondName, String birhday) {

        this.name = name;
        this.secondName = secondName;
        this.birhday = birhday;
        this.id = id;
    }

    public Models(){}

}
