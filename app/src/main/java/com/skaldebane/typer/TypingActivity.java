package com.skaldebane.typer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings({"ConstantConditions", "RedundantCast"})
@SuppressLint("SetTextI18n")
public class TypingActivity extends AppCompatActivity {

    int i1, i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typing);

        final TextView typeView = (TextView) findViewById(R.id.typeView);

        String name = getIntent().getStringExtra("n");
        String line1 = "Hello, " + name + ".";
        String line2;
        if (name.toLowerCase().equals("imane")) {
            line2 = "Such a sweet visitor!";
        } else if (name.toLowerCase().equals("joseph")) {
            line2 = "Python personally!";
        } else if (name.toLowerCase().equals("hossam")) {
            line2 = "You created me!!";
        } else {
            line2 = "That was another test.";
        }

        i1 = 0;
        final Timer t1 = new Timer();
        t1.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    if (i1 < line1.length()) {
                        typeView.setText(typeView.getText().toString() + line1.charAt(i1));
                        i1++;
                    } else {
                        t1.cancel();
                        typeView.setText(typeView.getText().toString() + "\n");
                        i2 = 0;
                        final Timer t2 = new Timer();
                        t2.scheduleAtFixedRate(new TimerTask() {
                            @Override
                            public void run() {
                                runOnUiThread(() -> {
                                    if (i2 < line2.length()) {
                                        typeView.setText(typeView.getText().toString() + line2.charAt(i2));
                                        i2++;
                                    } else t2.cancel();
                                });
                            }
                        }, 75, 75);
                    }
                });
            }
        }, 75, 75);
    }

}
