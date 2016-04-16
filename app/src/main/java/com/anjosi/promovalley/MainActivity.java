package com.anjosi.promovalley;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.anjosi.promovalley.openhelper.DatabaseProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        DatabaseProvider provider = new DatabaseProvider(this);

    }
}
