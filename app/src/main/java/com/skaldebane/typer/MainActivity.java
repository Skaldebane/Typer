package com.skaldebane.typer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

@SuppressWarnings("RedundantCast")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener((v) -> {
            Intent i = new Intent(Intent.ACTION_VIEW).setClass(this, TypingActivity.class);
            startActivity(i);
        });
    }

}