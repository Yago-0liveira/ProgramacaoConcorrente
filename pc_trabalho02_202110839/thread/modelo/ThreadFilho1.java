/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 20/03/2023
* Ultima alteracao.: 23/03/2023
* Nome.............: ThreadFilho1.java
* Funcao...........: Eh responsavel por executar os comandos relacionados ao primeiro filho
*******************************************************************/
package modelo;

import controle.PrincipalController;
import javafx.application.Platform;

public class ThreadFilho1 extends Thread {
  ThreadNeto1 n1 = new ThreadNeto1(); // Instanciando o neto1 na classe filho1
  PrincipalController pc; // Instanciando a classe controle na classe filho1
  public static int novaIdade; // Criando uma variavel estatica

  public void run() {
    pc.filho1(1); // Funcao que altera a imagem do filho1
    System.out.println("O primeiro filho nasceu");
    try {
      for (int idade = 0; idade <= 61; idade++) {

        if (idade == 5) {
          pc.filho1(2); // Funcao que altera a imagem do filho1
        }
        if (idade == 16) {
          pc.filho1(3); // Funcao que altera a imagem do filho1
          n1.start(); // Iniciando a thread neto1
        }
        if (idade == 22) {
          pc.filho1(4); // Funcao que altera a imagem do filho1
        }
        if (idade == 50) {
          pc.filho1(5); // Funcao que altera a imagem do filho1
        }
        novaIdade = idade;
        Platform.runLater(() -> pc.idadeFilho1(novaIdade)); // Passa o tempo para o metodo idadeFilho1
        sleep(1000); // Hiberna a thread por 1 segundo a cada ciclo do for
      }
      pc.filho1(6); // Funcao que altera a imagem do filho1
      pc.deadF1(1); // Funcao que adiciona uma "caveira" ao lado do contador do filho1 apos sua
                    // morte
      System.out.println("O primeiro filho morreu aos 61 anos");
    } catch (InterruptedException e) { // pegando o erro do tipo InterruptedException - se der esse erro
      e.printStackTrace(); // Imprime o erro no terminal
    }
  }

  public void setWindow(PrincipalController window) { // A classe passa o controlador para as classes filhas
    pc = window;
    n1.setWindow(window);
  }

}