package com.ptithcm.khanh_giua_ki_android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ptithcm.khanh_giua_ki_android.model.Option;
import com.ptithcm.khanh_giua_ki_android.model.Question;

import java.util.List;

public class CreateQuestionRecylerViewAdapter extends
        RecyclerView.Adapter<CreateQuestionRecylerViewAdapter.CreateQuestionViewHolder>{
    private List<Question> questions;
    private LayoutInflater layoutInflater;


    public CreateQuestionRecylerViewAdapter(List<Question> questions, Context ctx) {
        this.questions = questions;
        this.layoutInflater = layoutInflater.from(ctx);
    }


    @NonNull
    @Override
    public CreateQuestionRecylerViewAdapter.CreateQuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View questionView = layoutInflater.from(parent.getContext()).inflate(R.layout.fragment_question_item, parent, false);
        CreateQuestionRecylerViewAdapter.CreateQuestionViewHolder questionViewHolder = new CreateQuestionRecylerViewAdapter.CreateQuestionViewHolder(questionView);
        return new CreateQuestionRecylerViewAdapter.CreateQuestionViewHolder(questionView);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull CreateQuestionRecylerViewAdapter.CreateQuestionViewHolder holder, int position) {
        Question question = questions.get(position);

        if(question==null) {
            return;
        }
        else {
            holder.tvQuestion.setText(String.valueOf(position+1));

            List<Option> options = question.getOptions();
            int length = options.size();
            for(int i = 0; i< length;i++) {
                if(options.get(i).isChecked()) {
                    holder.tvQuestion.setBackgroundColor(R.color.yellow);
                }
                else {
                    holder.tvQuestion.setBackgroundColor(R.color.white);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        if(!questions.isEmpty()) return questions.size();
        return 0;
    }

    public class CreateQuestionViewHolder extends RecyclerView.ViewHolder {

        private TextView tvQuestion;

        public CreateQuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuestion = itemView.findViewById(R.id.tv_create_content_question);
        }
    }
}
