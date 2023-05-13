package com.ptithcm.khanh_giua_ki_android.model;

import java.io.Serializable;
import java.util.List;

public class Option implements Serializable {

    // cần được biết là có được chọn hay không
    private boolean isChecked;
    // nội dung của câu hỏi
    private String content;
    // id của option
    private int id_option;
    // id của câu hỏi
    private int id_question;

    public Option() {
        this.isChecked=false;
    }

    public Option(int id_option, boolean isChecked, String content, int id_question ) {
        this.id_option = id_option;
        this.isChecked = isChecked;
        this.content = content;
        this.id_question = id_question;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public int getId_option() {
        return id_option;
    }

    public void setId_option(int id_option) {
        this.id_option = id_option;
    }
}
