package com.skaldebane.typer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressWarnings({"RedundantCast", "ConstantConditions"})
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.appbar_layout);

        final EditText name = (EditText) findViewById(R.id.name);
        final Button go = (Button) findViewById(R.id.go);

        go.setOnClickListener(v -> {
            if (name.length() == 0) {
                Toast.makeText(this, "Come on we're not kidding write your name.", Toast.LENGTH_LONG).show();
            } else if (name.length() < 3) {
                Toast.makeText(this, "Is this a chinese name or what???", Toast.LENGTH_LONG).show();
            } else {
                Intent i = new Intent(Intent.ACTION_VIEW).setClass(MainActivity.this, TypingActivity.class);
                i.putExtra("n", name.getText().toString());
                startActivity(i);
            }
        });
    }

}
