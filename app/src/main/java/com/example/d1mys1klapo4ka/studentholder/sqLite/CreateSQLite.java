package com.example.d1mys1klapo4ka.studentholder.sqLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.d1mys1klapo4ka.studentholder.model.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by d1mys1klapo4ka on 27.06.2017.
 */

public class CreateSQLite extends SQLiteOpenHelper implements DataBaseHandler {

    private static final String NAME_TABLE = "WORK";
    private static final String ID = "_ID";
    private static final String NAME_USER = "NAME";
    private static final String SECOND_NAME_USER = "SECOND_NAME";
    private static final String B_DAY_USER = "B_DAY";

    private static final int DATABASE_VERSION = 1;

    public CreateSQLite(Context context) {
        super(context, NAME_TABLE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

      String CREATE_DATA_BASE = "CREATE TABLE " + NAME_TABLE + "(" +
	ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
	NAME_USER +	" TEXT NOT NULL," +
	SECOND_NAME_USER +	" TEXT NOT NULL," +
	B_DAY_USER + " TEXT NOT NULL" + ")";

        db.execSQL(CREATE_DATA_BASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + NAME_TABLE);
                onCreate(db);
    }


    @Override
    public void addModels(Models models) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_USER, models.getName());
        values.put(SECOND_NAME_USER, models.getSecondName());
        values.put(B_DAY_USER, models.getBirhday());

        db.insert(NAME_TABLE, null, values);
        db.close();
    }

    @Override
    public Models getModels(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(NAME_TABLE, new String[] { ID,
                        NAME_USER, SECOND_NAME_USER, B_DAY_USER }, ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        Models models = new Models(Integer.parseInt(cursor.getString(0)),cursor.getString(1),
                cursor.getString(2), cursor.getString(3));

        return models;
    }

    @Override
    public List<Models> getAllModels() {
        List<Models> contactList = new ArrayList<Models>();
        String selectQuery = "SELECT  * FROM " + NAME_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Models models = new Models();
                models.setId(Integer.parseInt(cursor.getString(0)));
                models.setName(cursor.getString(1));
                models.setSecondName(cursor.getString(2));
                models.setBirhday(cursor.getString(3));

                contactList.add(models);
            } while (cursor.moveToNext());
        }

        return contactList;
    }

}
