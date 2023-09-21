
package com.mycompany.processo;

public class SimulacaoSO {
   public static void main(String[] args) {
        Processo[] processos = new Processo[10];

        // Inicialização dos processos com tempos de processamento aleatórios
        for (int i = 0; i < 10; i++) {
            processos[i] = new Processo(i, (int) (Math.random() * 8001 + 2000)); // Tempo de processamento aleatório entre 2000 e 10000 ciclos
        }

        // Loop principal da simulação
        while (!todosTerminaram(processos)) {
            for (Processo processo : processos) {
                if (processo.getEp().equals("PRONTO")) {
                    System.out.println("Processo " + processo.getPid() + ": PRONTO >>> EXECUTANDO");
                    processo.executar();
                }
            }
        }
    }

    public static boolean todosTerminaram(Processo[] processos) {
        // Verifica se todos os processos terminaram a execução
        for (Processo processo : processos) {
            if (!processo.getEp().equals("TERMINADO")) {
                return false;
            }
        }
        return true;
    }
}
