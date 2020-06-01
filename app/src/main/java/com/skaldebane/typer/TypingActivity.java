package com.skaldebane.typer;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings({"RedundantCast", "FieldCanBeLocal"})
public class TypingActivity extends AppCompatActivity {

    private TextView typeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typing);

        typeView = (TextView) findViewById(R.id.typeView);

        String text = getIntent().getStringExtra("n");


    }

}
