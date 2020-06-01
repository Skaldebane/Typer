package com.skaldebane.typer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings({"RedundantCast", "ConstantConditions"})
public class TextActivity extends AppCompatActivity {

    private EditText textType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_close);
        actionBar.setHomeActionContentDescription("Cancel");

        textType = (EditText) findViewById(R.id.textType);
        textType.setText(getIntent().getStringExtra("text"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.text_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                setResult(RESULT_CANCELED);
                finish();
                break;
            case R.id.clearAction:
                textType.setText("");
                break;
            case R.id.doneAction:
                Intent data = new Intent().putExtra("text", textType.getText().toString());
                setResult(RESULT_OK, data);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
