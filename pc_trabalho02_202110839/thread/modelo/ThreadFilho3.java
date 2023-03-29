/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 20/03/2023
* Ultima alteracao.: 23/03/2023
* Nome.............: ThreadFilho3.java
* Funcao...........: Eh responsavel por executar os comandos relacionados ao terceiro filho
*******************************************************************/
package modelo;

import controle.PrincipalController;
import javafx.application.Platform;

public class ThreadFilho3 extends Thread {
  PrincipalController pc; // Instanciando a classe controle na classe filho3
  public static int novaIdade; // Criando uma variavel estatica

  public void run() {
    pc.filho3(1); // Funcao que altera a imagem do filho3
    try {
      System.out.println("O terceiro filho nasceu");
      for (int idade = 0; idade <= 55; idade++) {
        if (idade == 5) {
          pc.filho3(2); // Funcao que altera a imagem do filho3
        }
        if (idade == 15) {
          pc.filho3(3); // Funcao que altera a imagem do filho3
        }
        if (idade == 22) {
          pc.filho3(4); // Funcao que altera a imagem do filho3
        }
        if (idade == 50) {
          pc.filho3(5); // Funcao que altera a imagem do filho3
        }
        novaIdade = idade;
        Platform.runLater(() -> pc.idadeFilho3(novaIdade)); // Passa o tempo para o metodo idadeFilho3
        Thread.sleep(1000); // Hiberna a thread por 1 segundo a cada ciclo do for
      }
      pc.filho3(6); // Funcao que altera a imagem do filho3
      pc.deadF3(1); // Funcao que adiciona uma "caveira" ao lado do contador do filho3 apos sua
                    // morte
      System.out.println("O terceiro filho morreu aos 55 anos");

    } catch (InterruptedException e) { // Pegando o erro do tipo InterruptedException - se der esse erro
      e.printStackTrace(); // Imprime o erro no terminal
    }
  }

  public void setWindow(PrincipalController window) {
    pc = window; // A variavel pc recebe a classe controle principal
  }
}
