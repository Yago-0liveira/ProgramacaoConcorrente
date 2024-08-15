/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 07/05/2023
* Ultima alteracao.: 13/05/2023
* Nome.............: VariaveisGlobais.java
* Funcao...........: Eh responsavel pelas variaveis do semaforo
*******************************************************************/
package modelo;

import java.util.concurrent.Semaphore;

public class VariaveisGlobais {
  static int espacoDisponivel = 4; // quantidade de pratos que cabem na mesa (buffer)
  static Semaphore mutex = new Semaphore(1); // controla a regiao critica, se o mutex for 1 = regiao critica vazia
  static Semaphore vazio = new Semaphore(espacoDisponivel); // conta os espacos vazios disponiveis na mesa
  static Semaphore cheio = new Semaphore(0); // conta os espacos ocupados na mesa

  public static void setMutex(int valor) { // define a variavel Mutex
    mutex = new Semaphore(valor);
  }

  public static void setVazio(int espacoDisponivel) { // define a variavel Vazio
    vazio = new Semaphore(espacoDisponivel);
  }

  public static void setCheio(int i) { // define a variavel Cheio
    cheio = new Semaphore(i);
  }
}
