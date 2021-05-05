package com.bezkoder.spring.datajpa.model;




import org.aspectj.weaver.patterns.IToken;

import javax.persistence.*;

@Entity
@Table(name = "information")
public class Information {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_info;

    @Column(name = "luminosite")
    private int luminosite;

    @Column(name = "niv_batt")
    private int niv_batt;

    @Column(name = "pression")
    private int pression;

    @Column(name = "temperature")
    private int temperature;

    @Column(name = "latitude")
    private int latitude;

    @Column(name = "longitude")
    private int longitude;


    public Information() {
    }

    public Information(int luminosite, int niv_batt, int pression, int temperature, int latitude, int longitude) {
        this.luminosite = luminosite;
        this.niv_batt = niv_batt;
        this.pression = pression;
        this.temperature = temperature;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id_info=" + id_info +
                ", luminosite=" + luminosite +
                ", niv_batt=" + niv_batt +
                ", pression=" + pression +
                ", temperature=" + temperature +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public long getId_info() {
        return id_info;
    }

    public void setId_info(long id_info) {
        this.id_info = id_info;
    }

    public int getLuminosite() {
        return luminosite;
    }

    public void setLuminosite(int luminosite) {
        this.luminosite = luminosite;
    }

    public int getNiv_batt() {
        return niv_batt;
    }

    public void setNiv_batt(int niv_batt) {
        this.niv_batt = niv_batt;
    }

    public int getPression() {
        return pression;
    }

    public void setPression(int pression) {
        this.pression = pression;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}