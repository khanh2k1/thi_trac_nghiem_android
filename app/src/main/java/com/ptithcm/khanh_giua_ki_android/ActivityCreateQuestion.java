package com.ptithcm.khanh_giua_ki_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ptithcm.khanh_giua_ki_android.model.Question;

import java.util.ArrayList;
import java.util.List;

public class ActivityCreateQuestion extends AppCompatActivity {

    private LinearLayout layoutList;
    private Button buttonAddOption;
    private Button btnLuu;
    private ViewPager viewPager;
    private CreateQuestionPagerAdapter createQuestionsViewPagerAdapter;
    private RecyclerView createQuestionRecyclerView;
    private CreateQuestionRecylerViewAdapter createQuestionsRecyclerViewAdapter;
    private List<Question> questions = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_question);


        setControl();
        setEvent();

        createQuestionsViewPagerAdapter = new CreateQuestionPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, questions);

        viewPager.setAdapter(createQuestionsViewPagerAdapter);
        viewPager.setOffscreenPageLimit(createQuestionsViewPagerAdapter.getCount());

    }

    private void addOption() {

        final View optionView = getLayoutInflater().inflate(R.layout.row_create_option,null,false);

        EditText editText = (EditText)optionView.findViewById(R.id.edtCreateOption);
        ImageButton imgBtnDeleteOption = optionView.findViewById(R.id.imgBtnDeleteOption);
        layoutList = findViewById(R.id.layout_create_option);
//        RadioGroup rbgCreateOptions = layoutList.findViewById(R.id.rbgOptions);

        imgBtnDeleteOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeOption(optionView);
            }
        });

        layoutList.addView(optionView);

    }

    private void removeOption(View view){

        layoutList.removeView(view);

    }

    public void setControl() {
        buttonAddOption = findViewById(R.id.btnAddOption);
        viewPager = findViewById(R.id.view_pagerCreateQuestion);
    }

    public void setEvent(){
        buttonAddOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOption();
            }
        });
    }

    public void chuyenTrang(){

    }
}