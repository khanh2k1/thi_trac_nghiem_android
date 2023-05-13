package com.ptithcm.khanh_giua_ki_android.model;


public class AnswerUser {
    private int id_question;
    private int id_option;

    public AnswerUser() {
    }

    public AnswerUser(int id_question, int id_option) {
        this.id_question = id_question;
        this.id_option = id_option;
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



