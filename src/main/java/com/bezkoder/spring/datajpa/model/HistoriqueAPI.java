package com.bezkoder.spring.datajpa.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historique_api")
public class HistoriqueAPI {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_hist_api;


    @OneToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "id_client",
            joinColumns = @JoinColumn(name = "id_client"),
            inverseJoinColumns = @JoinColumn(name = "id_client"))
    private Client id_client;

    @Column(name = "dateheure")
    private Date dateheure;

    @Column(name = "id_info")
    private long id_info;

    @Column(name = "type_comm")
    private String type_comm;

    public HistoriqueAPI() {
    }

    @Override
    public String toString() {
        return "HistoriqueAPI{" +
                "id_hist_api=" + id_hist_api +
                ", id_client=" + id_client +
                ", dateheure=" + dateheure +
                ", id_info=" + id_info +
                ", type_comm='" + type_comm + '\'' +
                '}';
    }

    public HistoriqueAPI(Client id_client, Date dateheure, long id_info, String type_comm) {
        this.id_client = id_client;
        this.dateheure = dateheure;
        this.id_info = id_info;
        this.type_comm = type_comm;
    }

    public long getId_hist_api() {
        return id_hist_api;
    }

    public void setId_hist_api(long id_hist_api) {
        this.id_hist_api = id_hist_api;
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

    public long getId_info() {
        return id_info;
    }

    public void setId_info(long id_info) {
        this.id_info = id_info;
    }

    public String getType_comm() {
        return type_comm;
    }

    public void setType_comm(String type_comm) {
        this.type_comm = type_comm;
    }
}