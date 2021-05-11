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
    private long luminosite;

    @Column(name = "proximite")
    private long proximite;

    @Column(name = "gravite")
    private long gravite;

    @Column(name = "acceleration")
    private long acceleration;

    @Column(name = "latitude")
    private long latitude;

    @Column(name = "longitude")
    private long longitude;


    public Information() {
    }

    public Information(long luminosite, long proximite, long gravite, long acceleration, long latitude, long longitude) {
        this.luminosite = luminosite;
        this.proximite = proximite;
        this.gravite = gravite;
        this.acceleration = acceleration;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId_info() {
        return id_info;
    }

    public void setId_info(long id_info) {
        this.id_info = id_info;
    }

    public long getLuminosite() {
        return luminosite;
    }

    public void setLuminosite(long luminosite) {
        this.luminosite = luminosite;
    }

    public long getProximite() {
        return proximite;
    }

    public void setProximite(long proximite) {
        this.proximite = proximite;
    }

    public long getGravite() {
        return gravite;
    }

    public void setGravite(long gravite) {
        this.gravite = gravite;
    }

    public long getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(long acceleration) {
        this.acceleration = acceleration;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }
}
