package com.ptithcm.khanh_giua_ki_android;


import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.load.engine.Resource;
import com.ptithcm.khanh_giua_ki_android.model.AnswerUser;
import com.ptithcm.khanh_giua_ki_android.model.Question;

import java.util.ArrayList;
import java.util.List;


public class FragmentQuestion extends Fragment {
    private Question question;
    private View mView;
    int luu = -1;
    public FragmentQuestion() {

    }

    public FragmentQuestion(Question question, View mView) {
        this.question = question;
        this.mView = mView;
    }

    public FragmentQuestion(int contentLayoutId, Question question, View mView) {
        super(contentLayoutId);
        this.question = question;
        this.mView = mView;
    }


    // trả về 1 viewgroup cho fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        mView = inflater.inflate(R.layout.fragment_question, container, false);



        TextView tvQuestion = mView.findViewById((R.id.tv_question));
        ListView listViewOptions = mView.findViewById(R.id.listView_options);

        Bundle bundleReceive = getArguments();

        if (bundleReceive != null) {
            question = (Question) bundleReceive.get("question_object");
            if (question != null) {

                Resources res = getResources();

                tvQuestion.setText(question.getContent());
                OptionAdapter optionAdapter = new OptionAdapter(this, question.getOptions());
                listViewOptions.setAdapter(optionAdapter);

                listViewOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @SuppressLint({"ResourceAsColor", "UseCompatLoadingForDrawables"})
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        for (int x = 0; x < listViewOptions.getCount(); x++) {
                            View mView = listViewOptions.getChildAt(x);

                            TextView tvOption = (TextView) mView.findViewById(R.id.tv_option);
                            @SuppressLint("UseCompatLoadingForDrawables") Drawable drawable = res.getDrawable(R.drawable.round_textview_background);
                            tvOption.setBackground(drawable);
//                            question.getOptions().get(i).setChecked(false);
                        }

                        TextView tvOption = view.findViewById(R.id.tv_option);
                        Drawable drawable = null;


                        // nếu check rồi thì bỏ
                        if(question.getOptions().get(i).isChecked()) {

                            drawable = res.getDrawable(R.drawable.round_textview_background);
                            question.getOptions().get(i).setChecked(false);

                        }
                        else {

                            question.getOptions().get(i).setChecked(true);
                            drawable = res.getDrawable(R.drawable.round_textview_background_2);
                            if (luu!= -1)
                                question.getOptions().get(luu).setChecked(false);


                            luu =i;
                        }

                        System.out.println(question.getOptions().get(i).isChecked());
                        tvOption.setBackground(drawable);




                        for(int j=0;j<MainActivity.questions.size();j++) {
                            if(question.getId_question()==MainActivity.questions.get(j).getId_question()){
                                MainActivity.questions.set(j,question);
                            }
                        }

                    }
                });
            }
        }

        return mView;
    }



}
