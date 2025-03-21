package com.projeto.sensorinteligente.arduino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fazecast.jSerialComm.SerialPort;
import com.projeto.sensorinteligente.service.SensorService;
import com.projeto.sensorinteligente.dto.SensorDTO;
import com.projeto.sensorinteligente.arduino.SerialCommunication;
@Component
public class SensorReader {

    private final SerialCommunication serialCommunication;

    @Autowired
    private SensorService sensorService;

    public SensorReader() {
        this.serialCommunication = new SerialCommunication("COM3"); // Example port
    }

    public void lerDadosSensores() {
        if (serialCommunication.initialize()) {
            try {
                String linha;
                while ((linha = serialCommunication.readData()) != null) {
                    String[] dados = linha.split(",");
                    int luminosidade = Integer.parseInt(dados[0].split(":")[1].trim());
                    int temperatura = Integer.parseInt(dados[1].split(":")[1].trim());
                    int umidade = Integer.parseInt(dados[2].split(":")[1].trim());

                    SensorDTO sensorDTO = new SensorDTO();
                    sensorDTO.setLuminosidade(luminosidade);
                    sensorDTO.setTemperatura(temperatura);
                    sensorDTO.setUmidade(umidade);


                    sensorService.salvarSensor(sensorDTO);


                }
            } catch (Exception e) {
                System.out.println("Erro ao processar dados: " + e.getMessage());
            } finally {
                serialCommunication.close();
            }
        }
    }
}

