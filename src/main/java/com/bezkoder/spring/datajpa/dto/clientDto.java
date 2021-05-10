package com.bezkoder.spring.datajpa.dto;

import java.io.Serializable;



public class clientDto implements Serializable {

    private long id;
    private String login;
    private String mdp;

    public clientDto() {
    }

    public clientDto(int id, String login, String mdp) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
