package com.projeto.sensorinteligente.arduino;

import com.fazecast.jSerialComm.SerialPort;

import java.io.InputStream;
import java.util.Scanner;

public class SerialCommunication {
    private SerialPort serialPort;

    public SerialCommunication(String portName) {
        SerialPort[] availablePorts = SerialPort.getCommPorts();

        for(SerialPort port : availablePorts) {
            if (port.getSystemPortName().equals(portName)) {
                this.serialPort = port;
                break;
            }
        }

        if (this.serialPort == null) {
            System.err.println("Porta serial '" + portName + "' não encontrada.");
        }

    }

    public boolean initialize() {
        if (this.serialPort != null) {
            if (this.serialPort.openPort()) {
                this.serialPort.setComPortParameters(9600, 8, 1, 0);
                System.out.println("Porta serial '" + this.serialPort.getSystemPortName() + "' aberta com sucesso.");
                return true;
            } else {
                System.err.println("Erro ao abrir a porta serial '" + this.serialPort.getSystemPortName() + "'.");
                return false;
            }
        } else {
            return false;
        }
    }

    public String readData() {
        if (this.serialPort != null && this.serialPort.isOpen()) {
            InputStream inputStream = this.serialPort.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            if (scanner.hasNextLine()) {
                return scanner.nextLine();
            }

            scanner.close();
        }

        return null;
    }

    public void close() {
        if (this.serialPort != null && this.serialPort.isOpen()) {
            if (this.serialPort.closePort()) {
                System.out.println("Porta serial '" + this.serialPort.getSystemPortName() + "' fechada.");
            } else {
                System.err.println("Erro ao fechar a porta serial '" + this.serialPort.getSystemPortName() + "'.");
            }
        }

    }
}
