/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 20/03/2023
* Ultima alteracao.: 23/03/2023
* Nome.............: ThreadFilho2.java
* Funcao...........: Eh responsavel por executar os comandos relacionados ao segundo filho
*******************************************************************/
package modelo;

import controle.PrincipalController;
import javafx.application.Platform;

public class ThreadFilho2 extends Thread {
  ThreadNeto2 n2 = new ThreadNeto2(); // Instanciando o neto2 na classe filho2
  PrincipalController pc; // Instanciando a classe controle na classe filho2
  public static int novaIdade; // Criando uma variavel estatica

  public void run() {
    pc.filha2(1); // Funcao que altera a imagem do filho2
    System.out.println("O segundo filho nasceu");
    try {
      for (int idade = 0; idade <= 55; idade++) {
        if (idade == 5) {
          pc.filha2(2); // Funcao que altera a imagem do filho2
        }
        if (idade == 15) {
          pc.filha2(3); // Funcao que altera a imagem do filho2
        }
        if (idade == 20) {
          n2.start(); // Iniciando a thread neto2
        }
        if (idade == 22) {
          pc.filha2(4); // Funcao que altera a imagem do filho2
        }
        if (idade == 50) {
          pc.filha2(5); // Funcao que altera a imagem do filho2
        }
        novaIdade = idade;
        Platform.runLater(() -> pc.idadeFilho2(novaIdade)); // Passa o tempo para o metodo idadeFilho2
        sleep(1000); // Hiberna a thread por 1 segundo a cada ciclo do for
      }
      pc.filha2(6); // Funcao que altera a imagem do filho2
      pc.deadF2(1); // Funcao que adiciona uma "caveira" ao lado do contador do filho2 apos sua
                    // morte
      System.out.println("O segundo filho morreu aos 55 anos");

    } catch (InterruptedException e) { // Pegando o erro do tipo InterruptedException - se der esse erro
      e.printStackTrace(); // Imprime o erro no terminal
    }
  }

  public void setWindow(PrincipalController window) { // A classe passa o controlador para as classes filhas
    pc = window;
    n2.setWindow(window);
  }
}
