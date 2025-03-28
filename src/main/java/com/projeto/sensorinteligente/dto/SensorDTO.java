package com.projeto.sensorinteligente.dto;


public class SensorDTO {
    private int luminosidade;
    private float temperatura;
    private float umidade;

    public SensorDTO() {}

    public SensorDTO(int luminosidade, float temperatura, float umidade) {
        this.luminosidade = luminosidade;
        this.temperatura = temperatura;
        this.umidade = umidade;
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
