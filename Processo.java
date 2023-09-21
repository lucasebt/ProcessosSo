
package com.mycompany.processo;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
public class Processo {

    public static void main(String[] args) {
    private int pid;
    private int tp;
    private int cp;
    private String ep;
    private int nes;
    private int n_cpu;

    public Processo(int pid, int tp) {
        this.pid = pid;
        this.tp = tp;
        this.cp = 0;
        this.ep = "PRONTO";
        this.nes = 0;
        this.n_cpu = 0;
    }

    public void executar() {
        this.ep = "EXECUTANDO";
        int quantum = 1000;
        Random rand = new Random();

        while (cp < tp) {
            if (rand.nextDouble() < 0.05) {
                nes++;
                ep = "BLOQUEADO";
                break;
            }

            n_cpu++;
            cp++;

            if (cp % quantum == 0) {
                System.out.println("Processo " + pid + ": EXECUTANDO >>> PRONTO");
                ep = "PRONTO";
                return;
            }
        }

        ep = "TERMINADO";
        System.out.println("Processo " + pid + ": TERMINADO");
        System.out.println("PID: " + pid + ", TP: " + tp + ", CP: " + cp + ", EP: " + ep + ", NES: " + nes + ", N_CPU: " + n_cpu);
        escreverDadosProcesso();
    }

    public void escreverDadosProcesso() {
        try {
            FileWriter arquivo = new FileWriter("dados_processo.txt", true);
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            gravarArquivo.println("PID: " + pid + ", TP: " + tp + ", CP: " + cp + ", EP: " + ep + ", NES: " + nes + ", N_CPU: " + n_cpu);
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters para acessar os atributos privados do processo
    public int getPid() {
        return pid;
    }

    public String getEp() {
        return ep;
    }
}