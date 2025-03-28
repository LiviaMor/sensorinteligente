package com.projeto.sensorinteligente.arduino;

import com.fazecast.jSerialComm.SerialPort;
import com.google.gson.Gson;
import com.projeto.sensorinteligente.dto.SensorDTO;
import com.projeto.sensorinteligente.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SerialCommunication implements Runnable {

    private SerialPort port;
    private final SensorService sensorService;
    private final Gson gson = new Gson();

    @Autowired
    public SerialCommunication(SensorService sensorService) {
        this.sensorService = sensorService;
        // Configure a porta serial conforme necessário
        port = SerialPort.getCommPort("COM3"); // Substitua pela porta correta
        port.setComPortParameters(9600, 8, 1, 0);
    }

    public void iniciar() {
        if (port.openPort()) {
            System.out.println("Conexão serial estabelecida.");
            // Inicia a thread para leitura contínua
            Thread threadLeitura = new Thread(this);
            threadLeitura.start();
        } else {
            System.out.println("Erro ao abrir a porta serial.");
        }
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            while (true) {
                int bytesRead = port.readBytes(buffer, buffer.length);
                if (bytesRead > 0) {
                    String data = new String(buffer, 0, bytesRead).trim();
                    System.out.println("Dados recebidos: " + data);
                    processarDados(data);
                }
                Thread.sleep(2000); // Aguarda 2 segundos antes de nova leitura
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            port.closePort();
        }
    }

    private void processarDados(String data) {
        try {
            // Converter o JSON em SensorDTO
            SensorDTO sensorDTO = gson.fromJson(data, SensorDTO.class);
            // Chama o serviço para salvar os dados
            sensorService.salvarSensor(sensorDTO);
            System.out.println("Dados enviados para o serviço com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao processar os dados recebidos: " + e.getMessage());
        }
    }
}
