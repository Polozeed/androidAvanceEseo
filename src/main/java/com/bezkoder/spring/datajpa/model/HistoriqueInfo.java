package com.bezkoder.spring.datajpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historique_info")
public class HistoriqueInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_hist_info;

    @OneToOne
    @JoinColumn(name = "id_client")
    private Client id_client;

    @Column(name = "dateheure")
    private Date dateheure;

    @OneToOne
    @JoinColumn(name = "id_info")
    private Information id_info;


    public HistoriqueInfo() {
    }

    public HistoriqueInfo(Client id_client, Date dateheure, Information id_info) {
        this.id_client = id_client;
        this.dateheure = dateheure;
        this.id_info = id_info;
    }

    @Override
    public String toString() {
        return "HistoriqueInfo{" +
                "id_hist_info=" + id_hist_info +
                ", id_client=" + id_client +
                ", dateheure=" + dateheure +
                ", id_info=" + id_info +
                '}';
    }

    public long getId_hist_info() {
        return id_hist_info;
    }

    public void setId_hist_info(long id_hist_info) {
        this.id_hist_info = id_hist_info;
    }

    public Client getId_client() {
        return id_client;
    }

    public void setId_client(Client id_client) {
        this.id_client = id_client;
    }

    public Date getDateheure() {
        return dateheure;
    }

    public void setDateheure(Date dateheure) {
        this.dateheure = dateheure;
    }

    public Information getId_info() {
        return id_info;
    }

    public void setId_info(Information id_info) {
        this.id_info = id_info;
    }
}