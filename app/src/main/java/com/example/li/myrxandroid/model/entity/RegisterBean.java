package com.example.li.myrxandroid.model.entity;

public class RegisterBean {
    private String name;
    private String passwd;
    private String nikeName;

    public RegisterBean(String name, String passwd, String nikeName) {
        this.name = name;
        this.passwd = passwd;
        this.nikeName = nikeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }
}
