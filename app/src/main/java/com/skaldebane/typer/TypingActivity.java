package com.skaldebane.typer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings({"RedundantCast"})
@SuppressLint("SetTextI18n")
public class TypingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typing);

        final TextView typeView = (TextView) findViewById(R.id.typeView);

        String text = getIntent().getStringExtra("n");


    }

}
