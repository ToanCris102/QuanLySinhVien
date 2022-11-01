/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author OverLord
 */
public class ModelAdmin {
    private int admin_id;
    private String userName;
    private String passWord;
    private String fullName;

    public ModelAdmin() {
        admin_id = 0;
        userName = "";
        passWord = "";
        fullName = "";
    }

    
    
    public ModelAdmin(int id, String userName, String passWord, String fullName) {
        this.admin_id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
    }

    public ModelAdmin(String userName, String passWord, String fullName) {
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int id) {
        this.admin_id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
}
