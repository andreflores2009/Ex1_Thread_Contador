/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ex1_thread_contador;

/**
 *
 * @author Andre
 */
public class Contador extends Thread {

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            try {
                // Atraso de 1 segundo (1000 milissegundos)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Em caso de interrupção da thread
                System.out.println("Thread foi interrompida");
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        // Cria e inicia a thread do contador
        Contador contador = new Contador();
        contador.start();
    }
}
