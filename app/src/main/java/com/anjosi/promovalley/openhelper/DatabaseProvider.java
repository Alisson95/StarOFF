package com.anjosi.promovalley.openhelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

/**
 * Created by Anjosi on 16/04/2016.
 */
public class DatabaseProvider {

    private DataBaseHelper helper;
    private SQLiteDatabase db;

    public DatabaseProvider(){
        db = helper.getWritableDatabase();
    }

    private int insert(){
        ContentValues cv = new ContentValues();

        cv.put(DataBaseHelper.COLUMN_NAME_COMP, "");
        cv.put(DataBaseHelper.COLUMN_LOCA_COMP, "");
        cv.put(DataBaseHelper.COLUMN_POSI_COMP, "");


        long id = db.insert(DataBaseHelper.TABLE_COMP, null, cv);

        return  Integer.parseInt(String.valueOf(id));
    }

    class insertion extends AsyncTask<Object, Object, Object>{

        @Override
        protected Object doInBackground(Object... params) {
            return null;
        }


    }

}
