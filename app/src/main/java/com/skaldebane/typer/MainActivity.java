package com.skaldebane.typer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

@SuppressWarnings({"RedundantCast", "ConstantConditions"})
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.appbar_layout);
    }

}
