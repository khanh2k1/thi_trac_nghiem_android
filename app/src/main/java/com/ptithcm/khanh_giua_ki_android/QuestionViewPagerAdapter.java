package com.ptithcm.khanh_giua_ki_android;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.ptithcm.khanh_giua_ki_android.model.Question;
import java.io.Serializable;
import java.util.List;

public class QuestionViewPagerAdapter extends FragmentStatePagerAdapter {


    private List<Question> questions;

    public QuestionViewPagerAdapter(@NonNull FragmentManager fm,
                                    int behavior,
                                    List<Question> questions) {
        super(fm, behavior);
        this.questions = questions;
    }

    @NonNull
    @Override
    public FragmentQuestion getItem(int position) {
        if(questions.isEmpty()) return null;
        else {
            Question question = questions.get(position);
            FragmentQuestion fragmentQuestion = new FragmentQuestion();
            Bundle bundle = new Bundle();
            bundle.putSerializable("question_object", (Serializable) question);
            fragmentQuestion.setArguments(bundle);

            return fragmentQuestion;
        }
    }

    @Override
    public int getCount() {
        if(questions.isEmpty()) {
            return 0;
        }
        return questions.size();
    }

    public Question getQuestion (int position){
        if(questions.isEmpty()) {
            return new Question();
        }else {
            Question question = questions.get(position);
            return question;
        }
    }



}
