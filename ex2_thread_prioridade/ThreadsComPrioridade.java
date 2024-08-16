/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ex2_thread_prioridade;

/**
 *
 * @author Andre
 */
public class ThreadsComPrioridade {

    public static void main(String[] args) {
        
        // Cria a primeira thread com prioridade alta
        Thread threadAltaPrioridade = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread de Alta Prioridade - Mensagem " + i);
                try {
                    Thread.sleep(500); // Pequena pausa para simular trabalho
                } catch (InterruptedException e) {
                    System.out.println("Thread de Alta Prioridade foi interrompida.");
                }
            }
        });

        // Cria a segunda thread com prioridade baixa
        Thread threadBaixaPrioridade = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread de Baixa Prioridade - Mensagem " + i);
                try {
                    Thread.sleep(800); // Pequena pausa para simular trabalho
                } catch (InterruptedException e) {
                    System.out.println("Thread de Baixa Prioridade foi interrompida.");
                }
            }
        });

        // Define as prioridades das threads
        threadAltaPrioridade.setPriority(Thread.MAX_PRIORITY); // Prioridade máxima (10)
        threadBaixaPrioridade.setPriority(Thread.MIN_PRIORITY); // Prioridade mínima (1)

        // Inicia as threads
        threadAltaPrioridade.start();
        threadBaixaPrioridade.start();
    }
}

