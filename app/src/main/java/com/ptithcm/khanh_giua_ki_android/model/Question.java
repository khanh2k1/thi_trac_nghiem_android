package com.ptithcm.khanh_giua_ki_android.model;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {

    private List<Option> options;
    private int id_question;
    private int id_correct_option;
    private String content;


    public Question() {
    }

    public Question(List<Option> options, int id_question, int id_correct_option, String content) {
        this.options = options;
        this.id_question = id_question;
        this.id_correct_option = id_correct_option;
        this.content = content;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public int getId_correct_option() {
        return id_correct_option;
    }

    public void setId_correct_option(int id_correct_option) {
        this.id_correct_option = id_correct_option;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
