package com.ptithcm.khanh_giua_ki_android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ptithcm.khanh_giua_ki_android.model.Option;

import java.util.ArrayList;
import java.util.List;

public class CreateOptionAdapter extends RecyclerView.Adapter<CreateOptionAdapter.CreateOptionView> {


    private List<Option> options = new ArrayList<>();

    public CreateOptionAdapter(List<Option> options) {
        this.options = options;
    }

    @NonNull
    @Override
    public CreateOptionAdapter.CreateOptionView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.row_create_option,parent,false);
        return new CreateOptionView(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CreateOptionAdapter.CreateOptionView holder, int position) {
        Option option = options.get(position);
        holder.edtCreateOption.setText(option.getContent());
        holder.rbCorrect_option.setChecked(option.isChecked());
    }

    @Override
    public int getItemCount() {
        if(!options.isEmpty()) return options.size();
        return 0;
    }

    public static class CreateOptionView extends RecyclerView.ViewHolder{

        RadioButton rbCorrect_option;
        EditText edtCreateOption;
        public CreateOptionView(@NonNull View itemView) {
            super(itemView);
            edtCreateOption = itemView.findViewById(R.id.edtCreateOption);

        }
    }
}
