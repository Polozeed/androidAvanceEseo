package com.bezkoder.spring.datajpa.model;


import org.aspectj.weaver.patterns.IToken;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_client;

    @Column(name = "login")
    private String login;

    @Column(name = "mdp")
    private String mdp;

    @Column(name = "token")
    private String token;

    public Client() {
    }

    public Client(String login, String mdp, String token) {
        this.login = login;
        this.mdp = mdp;
        this.token = token;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client='" + id_client + '\'' +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public long getId_client() {
        return id_client;
    }

    public void setId_client(long id_client) {
        this.id_client = id_client;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

