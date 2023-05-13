package com.ptithcm.khanh_giua_ki_android;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ptithcm.khanh_giua_ki_android.model.Question;

import java.util.ArrayList;
import java.util.List;

public class FragmentCreateQuestion extends Fragment {

    private Question question;
    private View mView;

    public FragmentCreateQuestion() {
    }

    public FragmentCreateQuestion(Question question, View mView) {
        this.question = question;
        this.mView = mView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }
    // trả về 1 viewgroup cho fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_create_question, container, false);

        TextView tvQuestion = mView.findViewById((R.id.tv_question));
        ListView listViewOptions = mView.findViewById(R.id.recycler_create_options);

        Bundle bundleReceive = getArguments();

        if (bundleReceive != null) {
            question = (Question) bundleReceive.get("createQuestion_object");
            if (question != null) {
                tvQuestion.setText(question.getContent());
                OptionAdapter optionAdapter = new OptionAdapter(this, question.getOptions());
                listViewOptions.setAdapter(optionAdapter);
//                listViewOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @SuppressLint({"ResourceAsColor", "UseCompatLoadingForDrawables"})
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                        Resources res = getResources();
//                        for (int x = 0; x < listViewOptions.getCount(); x++) {
//                            View mView = listViewOptions.getChildAt(x);
//
//                            TextView tvOption = (TextView) mView.findViewById(R.id.tv_option);
//                            @SuppressLint("UseCompatLoadingForDrawables") Drawable drawable = res.getDrawable(R.drawable.round_textview_background);
//                            tvOption.setBackground(drawable);
////                            question.getOptions().get(i).setChecked(false);
//                        }
//
//                        TextView tvOption = view.findViewById(R.id.tv_option);
//                        Drawable drawable = null;
//
//                        System.out.println(question.getOptions().get(i).isChecked());
//
//                        // nếu check rồi thì bỏ
//                        if(question.getOptions().get(i).isChecked()) {
//                            drawable = res.getDrawable(R.drawable.round_textview_background);
//                            question.getOptions().get(i).setChecked(false);
//                        }
//                        else {
//                            question.getOptions().get(i).setChecked(true);
//                            drawable = res.getDrawable(R.drawable.round_textview_background_2);
//                        }
//
//                        System.out.println(question.getOptions().get(i).isChecked());
//                        tvOption.setBackground(drawable);
//
////                        question.getOptions().get(i).setChecked(true);
//
//
//                    }
//                });
            }
        }
        return inflater.inflate(R.layout.fragment_create_question, container, false);
    }
}