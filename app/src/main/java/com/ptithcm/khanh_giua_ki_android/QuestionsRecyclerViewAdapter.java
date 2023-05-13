package com.ptithcm.khanh_giua_ki_android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ptithcm.khanh_giua_ki_android.model.Option;
import com.ptithcm.khanh_giua_ki_android.model.Question;

import java.util.List;

public class QuestionsRecyclerViewAdapter extends
        RecyclerView.Adapter<QuestionsRecyclerViewAdapter.QuestionViewHolder> implements View.OnClickListener {

    private List<Question> questions;
    private Context context;


    public QuestionsRecyclerViewAdapter(List<Question> questions, Context context) {
        this.questions = questions;
        this.context = context;
    }


    @NonNull
    @Override
    public QuestionsRecyclerViewAdapter.QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View questionView = layoutInflater.inflate(R.layout.fragment_question_item, parent, false);
        return new QuestionViewHolder(questionView);
    }

    @SuppressLint({"ResourceAsColor", "UseCompatLoadingForDrawables"})
    @Override
    public void onBindViewHolder(@NonNull QuestionsRecyclerViewAdapter.QuestionViewHolder holder, int position) {
        Question question = questions.get(position);

        if(question==null) {
            return;
        }
        else {
            holder.tvQuestion.setText(String.valueOf(position+1));

            List<Option> options = question.getOptions();
            System.out.println("id question = " + question.getId_question());
            int length = options.size();

            for(int i = 0; i< length;i++) {
                if(options.get(i).isChecked()) {
                    System.out.println("checked");
                    holder.tvQuestion.setBackgroundResource(R.drawable.radius_blue_10);

//                    drawable = FragmentQuestion.res.getDrawable(R.drawable.round_textview_background_2);
                }
                else {

                }
            }

        }
    }


    @Override
    public int getItemCount() {
        if(!questions.isEmpty()) return questions.size();
        return 0;
    }

    @Override
    public void onClick(View view) {

    }


    public class QuestionViewHolder extends RecyclerView.ViewHolder {

        private TextView tvQuestion;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuestion = itemView.findViewById(R.id.tvQuestion);
        }
    }
}
