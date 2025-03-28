package com.projeto.sensorinteligente.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sensor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private int luminosidade;
    private float temperatura;
    private float umidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLuminosidade() {
        return luminosidade;
    }

    public void setLuminosidade(int luminosidade) {
        this.luminosidade = luminosidade;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getUmidade() {
        return umidade;
    }

    public void setUmidade(float umidade) {
        this.umidade = umidade;
    }
}
