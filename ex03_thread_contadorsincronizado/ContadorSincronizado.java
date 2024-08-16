/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ex03_thread_contadorsincronizado;

/**
 *
 * @author Andre
 */
public class ContadorSincronizado {

    private int contador = 0;

    // Método sincronizado para incrementar o contador
    public synchronized void incrementar() {
        contador++;
    }

    // Método para obter o valor final do contador
    public int getContador() {
        return contador;
    }

    public static void main(String[] args) {
        ContadorSincronizado contadorSincronizado = new ContadorSincronizado();

        // Criação da primeira thread que incrementa o contador 100 vezes
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                //System.out.println("Thread1 contando: "+i);
                contadorSincronizado.incrementar();
            }
        });

        // Criação da segunda thread que incrementa o contador 100 vezes
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                //System.out.println("Thread2 contando: "+i);
                contadorSincronizado.incrementar();
            }
        });

        // Inicia as threads
        thread1.start();
        thread2.start();

        // Aguarda ambas as threads terminarem
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Uma thread foi interrompida.");
        }

        // Imprime o valor final do contador
        System.out.println("Valor final do contador: " + contadorSincronizado.getContador());
    }
}

