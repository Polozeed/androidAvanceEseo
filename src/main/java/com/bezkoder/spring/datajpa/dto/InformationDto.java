package com.bezkoder.spring.datajpa.dto;

import java.io.Serializable;

public class InformationDto  implements Serializable {

    private long id;
    private long luminosite;
    private long proximite;
    private long gravite;
    private long acceleration;


    public InformationDto() {
    }

    public InformationDto(long id, long luminosite, long proximite, long gravite, long acceleration) {
        this.id = id;
        this.luminosite = luminosite;
        this.proximite = proximite;
        this.gravite = gravite;
        this.acceleration = acceleration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}


