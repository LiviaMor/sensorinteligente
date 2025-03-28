package com.projeto.sensorinteligente.arduino;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fazecast.jSerialComm.SerialPort;
import com.projeto.sensorinteligente.service.SensorService;
import com.projeto.sensorinteligente.dto.SensorDTO;
import com.projeto.sensorinteligente.arduino.SerialCommunication;
import com.fazecast.jSerialComm.SerialPort;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SensorReader {

    public static void main(String[] args) {
        // Configuração do banco de dados
        String url = "jdbc:mysql://localhost:3306/sensorinteligente";
        String user = "root";
        String password = "1904";

        // Configuração da porta Serial
        SerialPort port = SerialPort.getCommPort("COM3"); // Substitua pela sua porta Arduino
        port.setComPortParameters(9600, 8, 1, 0);
        port.openPort();

        if (port.isOpen()) {
            System.out.println("Conexão serial estabelecida.");
        } else {
            System.out.println("Erro ao abrir a porta serial.");
            return;
        }

        // Leitura contínua dos dados
        try {
            byte[] buffer = new byte[1024];
            while (true) {
                int bytesRead = port.readBytes(buffer, buffer.length);
                if (bytesRead > 0) {
                    String data = new String(buffer, 0, bytesRead).trim();
                    System.out.println("Dados recebidos: " + data);

                    // Parse dos dados JSON e salvamento no banco
                    saveToDatabase(data, url, user, password);
                }
                Thread.sleep(2000); // Aguarda 2 segundos antes de continuar
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            port.closePort();
        }
    }

    // Método para salvar os dados no banco de dados
    private static void saveToDatabase(String data, String url, String user, String password) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO sensor (temperatura, umidade, luminosidade) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                // Parsing JSON usando Gson
                Gson gson = new Gson();
                SensorDTO sensor = gson.fromJson(data, SensorDTO.class);

                stmt.setFloat(1, sensor.getTemperatura());
                stmt.setFloat(2, sensor.getUmidade());
                stmt.setInt(3, sensor.getLuminosidade());
                stmt.executeUpdate();

                System.out.println("Dados inseridos no banco de dados com sucesso!");
            }
        } catch (Exception e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }
}


