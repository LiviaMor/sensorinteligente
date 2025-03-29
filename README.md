# Sensor Inteligente

Projeto Integrador V-B apresentado a disciplina PUC-GO.
Este projeto realiza o monitoramento em tempo real de sensores de temperatura, umidade e luminosidade usando hardware
Arduino UNO e comunicação serial. Os dados são coletados, processados no mySql.

## Funcionalidades

* Leitura de dados de sensores por meio de uma porta serial.
* Processamento dos dados de temperatura, humidade e luminosidade no MySQL.

## Tecnologias Utilizadas

Protótipo - Figma;
Backend - Java (SpringBoot),integração com Arduino via , e Gson para manipulação de JSON;
Arduino IDE;
Hardware - Arduino UNO, sensor de temperatura e umidade (DHT11), luminosidade (LDR);
Banco de Dados: MySQL para armazenamento de dados.

## Estrutura do Projeto

* `SensorintelligenteAplication.java`: Ponto de entrada da aplicação Spring Boot
* `IniciarSerialCommunication`.java: Classe utilizada para iniciar e configurar a comunicação serial com o Arduino.
* `SensorReader.java`:  Classe principal que gerencia a comunicação e o processamento dos dados recebidos via porta
  serial.
* `SerialCommunication.java`: Classe dedicada a lidar diretamente com a comunicação serial.
* `SensorController.java`: Classe controladora que expõe endpoints REST para permitir interação com os dados dos
  sensores(PARA UM PROJETO FUTURO)
* `SensorService.java`: Classe que implementa a lógica
* `SensorDTO.java`: Classe utilizado para transportar os dados.
* `Sensor.java`: Classe que representa o modelo de dados dos sensores.

## Pré-requisitos

* Java Development Kit (JDK) instalado. (Usei o 17)
* Maven: Configurado no ambiente.
* Arduino IDE: Para enviar o firmware aos sensores.
* Biblioteca jSerialComm adicionada ao projeto.
* Biblioteca GSON
* Banco de dados: MySQL
* IDE da sua preferência (eu utilizei IntelliJ).

## Problemas Conhecidos

A conexão serial pode falhar se a porta já estiver ocupada por outro processo. Certifique-se de que a porta está livre
antes de iniciar o programa

## Colaboradores

[Igor Anjos](https://github.com/IgorcAnjos)

[Livia Mor]( https://github.com/LiviaMor)

## Como Usar

1. Clone este repositório;
   ``` git
   git clone <link-do-repositorio>
   ``` 
2. Conecte o Arduino via USB;
3. Abra o código do Arduino na Arduino IDE, atualize as bibliotecas necessárias e faça o upload para o Arduino;
4. Abra o projeto na sua IDE Java de sua preferencia;
5. Adicione as dependencias do projeto
    * Biblioteca jSerialComm
    * Biblioteca Gson
    * Biblioteca MySQL
6. Configure o banco de dados MySQL;
    * Atualize as credencias de usuário e senha no arquivo `application.properties`.
7. Execute o banco de dados MySQL;
8. Inicie o projeto executando a classe 'SensorIntelligenteAplication.java`;

## Protótipo Figma

(<iframe style="border: 1px solid rgba(0, 0, 0, 0.1);" width="800" height="450" src="https://embed.figma.com/design/XxyYvZyptC2WBfPxRKlLbJ/Untitled?node-id=0-1&embed-host=share" allowfullscreen></iframe>)