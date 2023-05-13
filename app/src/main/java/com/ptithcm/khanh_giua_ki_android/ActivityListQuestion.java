package com.ptithcm.khanh_giua_ki_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.ptithcm.khanh_giua_ki_android.model.Question;

import java.util.ArrayList;
import java.util.List;

public class ActivityListQuestion extends AppCompatActivity {

    private List<Question> questions = new ArrayList<>();
    private RecyclerView recyclerView;
    private QuestionsRecyclerViewAdapter questionsRecyclerViewAdapter;
    private Intent intent;
    private Button btnBack;


    public ActivityListQuestion() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_question);

        setControl();
        getQuestions();
        setAdapter();
        setEvent();

    }


    public void setAdapter(){
        questionsRecyclerViewAdapter = new QuestionsRecyclerViewAdapter(questions, this);
        recyclerView.setAdapter(questionsRecyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));

    }

    public void setControl(){
        recyclerView = findViewById(R.id.rcvListQuestion);
        btnBack = findViewById(R.id.btnBack);
    }

    public void setEvent() {

    }

    public void getQuestions(){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("questions");
        questions = (List<Question>) bundle.get("questions");
        System.out.println(questions.size());
    }

}