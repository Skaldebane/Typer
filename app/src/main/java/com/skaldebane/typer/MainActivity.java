package com.skaldebane.typer;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

@SuppressWarnings("ConstantConditions")
public class MainActivity extends AppCompatActivity {

    public static String toType;
    private SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingsFragment = new SettingsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.settings, settingsFragment).commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setCustomView(R.layout.appbar_layout);
        }
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {

        Preference text;

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);

            text = findPreference("text");
            text.setOnPreferenceClickListener(preference -> {
                Intent intent = new Intent(Intent.ACTION_VIEW).setClass(getContext(), TextActivity.class).putExtra("text", toType);
                startActivityForResult(intent, 0);
                return false;
            });
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            toType = data.getStringExtra("text").trim();
            if (toType.isEmpty()) settingsFragment.text.setSummary("None. Click here to set text.");
            else settingsFragment.text.setSummary(summarize(toType));
        }
    }

    private String summarize(String summary) {
        if (summary.trim().contains("\n")) {
            return summary.trim().substring(0, summary.trim().indexOf("\n")) + "...";
        } else {
            return summary.trim();
        }
    }

}