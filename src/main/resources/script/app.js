// Função para simular dados dos sensores
function atualizarSensores() {
    // Simulação de leitura dos sensores
    const luminosidade = (Math.random() * 900 + 100).toFixed(0); // Luminosidade em lux
    const temperatura = (Math.random() * 20 + 15).toFixed(1); // Temperatura em °C
    const umidade = (Math.random() * 40 + 30).toFixed(0); // Umidade em %

    // Atualiza os valores no HTML
    document.getElementById('luminosidade').textContent = luminosidade + " lux";
    document.getElementById('temperatura').textContent = temperatura + " °C";
    document.getElementById('umidade').textContent = umidade + " %";
}

// Atualiza os dados a cada 10 segundos
setInterval(atualizarSensores, 10000);
// Atualização inicial
atualizarSensores();
