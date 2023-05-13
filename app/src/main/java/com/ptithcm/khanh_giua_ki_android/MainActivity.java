package com.ptithcm.khanh_giua_ki_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.ptithcm.khanh_giua_ki_android.model.Option;
import com.ptithcm.khanh_giua_ki_android.model.Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";

    private TextView tvCurrentQuestion,
            tvTotalQuestion,
            tvContentQuestion,
            tvCountTime;
    private Button btnNopBai;
    private ImageButton imgDropUpDown;
    private ViewPager viewPager;
    private QuestionViewPagerAdapter questionsViewPagerAdapter;
    private QuestionsRecyclerViewAdapter questionsRecyclerViewAdapter;
    private RecyclerView questionRecyclerView;
    private Intent intentQuestions;
    public static List<Question> questions = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thi);

        setControl();
        if(questions.isEmpty()) {
            createListQuestion();
        }
        setAdapter();
        setEvent();
    }

    private Option createOption(int id_question, int id_option) {
        Option option = new Option();

        option.setId_question(id_question);
        option.setChecked(false);
        option.setContent("Tui tên là Lê Đăng Khánh");
        option.setId_option(id_option);

        return option;
    }

    private Question createQuestion(int id_question) {
        List<Option> options = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            Option option = createOption(1, i);
            options.add(option);
        }

        Question question = new Question();

        question.setOptions(options);
        question.setId_question(id_question);
        question.setContent("What your is name ?");
        question.setId_correct_option(1);

        return question;
    }

    private void createListQuestion() {

        for (int i = 0; i < 5; i++) {
            questions.add(createQuestion(i + 1));
        }
    }

    public void setControl() {
        tvCurrentQuestion = findViewById(R.id.tv_current_question);
        tvTotalQuestion = findViewById(R.id.tv_total_question);
        tvContentQuestion = findViewById(R.id.tv_question);
        viewPager = findViewById(R.id.view_pager);
        btnNopBai = findViewById(R.id.btnNopBai);
        imgDropUpDown = findViewById(R.id.imgDropUpDown);
    }

    public void setAdapter(){
        questionsViewPagerAdapter = new QuestionViewPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, questions);

        viewPager.setAdapter(questionsViewPagerAdapter);
        viewPager.setOffscreenPageLimit(questionsViewPagerAdapter.getCount());
    }

    private void chuyenViTriCauHoi() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                tvCurrentQuestion.setText(String.valueOf(position + 1));

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setEvent() {
        chuyenViTriCauHoi();
        tvTotalQuestion.setText(String.valueOf(questionsViewPagerAdapter.getCount()));

        btnNopBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        imgDropUpDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable drop_down = ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_baseline_arrow_drop_down_24);
                Drawable drop_up = ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_baseline_arrow_drop_up_24);
                // Mở lên
                if(imgDropUpDown.getDrawable().getConstantState().equals(drop_down.getConstantState())) {
                    System.out.println("Mo len");
                    imgDropUpDown.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24);
                    intentQuestions = new Intent(MainActivity.this, ActivityListQuestion.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("questions", (Serializable) questions);
                    intentQuestions.putExtra("questions", bundle);
                    startActivity(intentQuestions);
                }
                // Đóng lại
                else {
                    System.out.println("Dong lai");
                    imgDropUpDown.setImageResource(R.drawable.ic_baseline_arrow_drop_down_24);
                }
            }
        });
    }



}