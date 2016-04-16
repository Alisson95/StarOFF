package com.anjosi.promovalley.openhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anjosi on 16/04/2016.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_COMP = "LISTA_COMPRAS";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME_COMP = "name";
    public static final String COLUMN_LOCA_COMP = "location";
    public static final String COLUMN_POSI_COMP = "position";
    public static final String COLUMN_PRIC_COMP = "price";

    public DataBaseHelper(Context context) {
        super(context, "meubanco.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        CreateTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        CreateTable(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        CreateTable(db);
    }

    private void CreateTable(SQLiteDatabase db){
        StringBuilder bd = new StringBuilder();
        bd.append("CREATE TABLE ");
        bd.append(TABLE_COMP);
        bd.append("(");
        bd.append(COLUMN_ID);
        bd.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        bd.append(COLUMN_NAME_COMP);
        bd.append(" VARCHAR(60), ");
        bd.append(COLUMN_LOCA_COMP);
        bd.append(" TEXT, ");
        bd.append(COLUMN_POSI_COMP);
        bd.append(" TEXT ");
        bd.append(");");

        db.execSQL(bd.toString());
    }
}
