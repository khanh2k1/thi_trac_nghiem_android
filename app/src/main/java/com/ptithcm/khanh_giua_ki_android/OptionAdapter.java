package com.ptithcm.khanh_giua_ki_android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.ptithcm.khanh_giua_ki_android.R;
import com.ptithcm.khanh_giua_ki_android.model.AnswerUser;
import com.ptithcm.khanh_giua_ki_android.model.Option;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class OptionAdapter extends BaseAdapter {

    private final Fragment fragment;
    private List<Option> options = new ArrayList<>();

    public OptionAdapter(Fragment fragment, List<Option> options) {
        this.fragment = fragment;
        this.options = options;
    }

    @Override
    public int getCount() {
        if (options.isEmpty()) return 0;
        return options.size();
    }

    @Override
    public Object getItem(int i) {
        return options.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // Inflate the view if it doesn't exist
        if (view == null) {
            view = LayoutInflater.from(fragment.getContext()).inflate(R.layout.row_add_option, viewGroup, false);
        }

        // Gọi layoutInflater ra để bắt đầu ánh xạ view và data.
        LayoutInflater inflater = fragment.getLayoutInflater();

        // Đổ dữ liệu vào biến View, view này chính là những gì nằm trong item_name.xml
        view = inflater.inflate(R.layout.row_add_option, null);

        // Đặt chữ cho từng view trong danh sách.
        TextView tvOption = (TextView) view.findViewById(R.id.tv_option);
        tvOption.setText(options.get(i).getContent());

        return view;
    }

    public List<Object> getAllObject() {
        List<Object> list = new ArrayList<>();
        for(int i = 0;i< this.getCount();i++) {
            list.add(this.getItem(i));
        }
        return list;
    }









}
