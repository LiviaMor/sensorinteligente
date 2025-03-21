package com.projeto.sensorinteligente.dto;

public class SensorDTO {
    private int luminosidade;
    private int temperatura;
    private int umidade;

    public void setLuminosidade(int luminosidade) {
        this.luminosidade = luminosidade;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public void setUmidade(int umidade) {
        this.umidade = umidade;
    }


    public int getLuminosidade() {
        return luminosidade;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public int getUmidade() {
        return umidade;
    }
}

