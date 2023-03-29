/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 20/03/2023
* Ultima alteracao.: 23/03/2023
* Nome.............: ThreadNeto2.java
* Funcao...........: Eh responsavel por executar os comandos relacionados ao segundo neto
*******************************************************************/
package modelo;

import controle.PrincipalController;
import javafx.application.Platform;

public class ThreadNeto2 extends Thread {
  PrincipalController pc; // Instanciando a classe controle na classe neto2
  public static int novaIdade; // Criando uma variavel estatica

  public void run() {
    pc.neto2(1); // Funcao que altera a imagem do neto2
    System.out.println("O segundo neto nasceu");
    try {
      for (int idade = 0; idade <= 33; idade++) {
        if (idade == 5) {
          pc.neto2(2); // Funcao que altera a imagem do neto2
        }
        if (idade == 15) {
          pc.neto2(3); // Funcao que altera a imagem do neto2
        }
        if (idade == 22) {
          pc.neto2(4); // Funcao que altera a imagem do neto2
        }
        novaIdade = idade;
        Platform.runLater(() -> pc.idadeNeto2(novaIdade)); // Passa o tempo para o metodo idadeNeto2
        sleep(1000); // Hiberna a thread por 1 segundo a cada ciclo do for
      }
      pc.neto2(5); // Funcao que altera a imagem do neto2
      pc.deadN2(1); // Funcao que adiciona uma "caveira" ao lado do contador do neto2 apos sua morte
      System.out.println("O segundo neto morreu aos 33 anos");
    } catch (InterruptedException e) { // Pegando o erro do tipo InterruptedException - se der esse erro
      e.printStackTrace(); // Imprime o erro no terminal
    }
  }

  public void setWindow(PrincipalController window) {
    pc = window; // A variavel pc recebe a classe controle principal
  }
}
