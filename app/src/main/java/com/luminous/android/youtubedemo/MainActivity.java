package com.luminous.android.youtubedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] titles = getResources().getStringArray(R.array.lip_sync_battle_title);
        List<String> titleList = Arrays.asList(titles);

        String[] links = getResources().getStringArray(R.array.lip_sync_battle_links);
        List<String> linkList = 

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        final LinearLayoutManager listLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(listLayoutManager);

        final VideoRecyclerAdapter videoRecyclerAdapter = new VideoRecyclerAdapter(this, titleList, links);
    }
}
