package com.projeto.sensorinteligente;

import com.projeto.sensorinteligente.arduino.SerialCommunication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class IniciarSerialCommunication implements CommandLineRunner {

    @Autowired
    private SerialCommunication serialCommunication;

    @Override
    public void run(String... args) throws Exception {
        // Inicia a comunicação com o Arduino
        serialCommunication.iniciar();
    }
}
