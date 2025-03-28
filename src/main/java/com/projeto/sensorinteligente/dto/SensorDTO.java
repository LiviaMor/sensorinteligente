package com.projeto.sensorinteligente.dto;

public class SensorDTO {
    private int luminosidade;
    private int temperatura;
    private int umidade;

    public SensorDTO() {}

    public SensorDTO(int luminosidade, int temperatura, int umidade) {
        this.luminosidade = luminosidade;
        this.temperatura = temperatura;
        this.umidade = umidade;
    }

    // Getters and setters
    public int getLuminosidade() { return luminosidade; }
    public void setLuminosidade(int luminosidade) { this.luminosidade = luminosidade; }

    public int getTemperatura() { return temperatura; }
    public void setTemperatura(int temperatura) { this.temperatura = temperatura; }

    public int getUmidade() { return umidade; }
    public void setUmidade(int umidade) { this.umidade = umidade; }
}
