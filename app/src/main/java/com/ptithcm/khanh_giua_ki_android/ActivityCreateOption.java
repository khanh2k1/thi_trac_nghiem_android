package com.ptithcm.khanh_giua_ki_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ptithcm.khanh_giua_ki_android.model.Option;

import java.util.ArrayList;

public class ActivityCreateOption extends AppCompatActivity {


    RecyclerView recyclerOptions;
    ArrayList<Option> options = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_option);

//        recyclerOptions = findViewById(R.id.recycler_options);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerOptions.setLayoutManager(layoutManager);

        options = (ArrayList<Option>) getIntent().getExtras().getSerializable("listCreateOptions");

        recyclerOptions.setAdapter(new CreateOptionAdapter(options));
    }
}