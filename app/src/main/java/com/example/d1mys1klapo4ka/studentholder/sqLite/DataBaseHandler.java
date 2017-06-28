package com.example.d1mys1klapo4ka.studentholder.sqLite;

import com.example.d1mys1klapo4ka.studentholder.model.Models;

import java.util.List;

/**
 * Created by d1mys1klapo4ka on 27.06.2017.
 */

public interface DataBaseHandler {

    public void addModels(Models models);
    public Models getModels(int id);
    public List<Models> getAllModels();

}
