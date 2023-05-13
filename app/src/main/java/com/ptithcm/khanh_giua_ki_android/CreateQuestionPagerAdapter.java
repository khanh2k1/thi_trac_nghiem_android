package com.ptithcm.khanh_giua_ki_android;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.ptithcm.khanh_giua_ki_android.model.Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CreateQuestionPagerAdapter extends FragmentStatePagerAdapter {

    List<Question> questions = new ArrayList<>();

    public CreateQuestionPagerAdapter(@NonNull FragmentManager fm, int behavior,
                                      List<Question> questions) {
        super(fm, behavior);
        this.questions = questions;
    }


    @NonNull
    @Override
    public FragmentCreateQuestion getItem(int position) {
        if (questions.isEmpty()) return null;

        else {
            Question question = questions.get(position);
            FragmentCreateQuestion fragmentCreateQuestion = new FragmentCreateQuestion();
            Bundle bundle = new Bundle();
            bundle.putSerializable("createQuestion_object", (Serializable) question);
            fragmentCreateQuestion.setArguments(bundle);

            return fragmentCreateQuestion;
        }
    }

    @Override
    public int getCount() {
        if (!questions.isEmpty()) return questions.size();
        return 0;
    }

}
