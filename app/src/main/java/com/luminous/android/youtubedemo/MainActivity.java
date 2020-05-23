package com.luminous.android.youtubedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] titles = getResources().getStringArray(R.array.lip_sync_battle_title);
        String[] links = getResources().getStringArray(R.array.lip_sync_battle_links);
    }
}
