/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 20/03/2023
* Ultima alteracao.: 23/03/2023
* Nome.............: ThreadBisneto.java
* Funcao...........: Eh responsavel por executar os comandos relacionados ao bisneto
*******************************************************************/
package modelo;

import controle.PrincipalController;
import javafx.application.Platform;

public class ThreadBisneto extends Thread {
  PrincipalController pc; // Instanciando a classe controle na classe bisneto
  public static int novaIdade; // Criando uma variavel estatica

  public void run() {
    pc.bisneto(1); // Funcao que altera a imagem do bisneto
    System.out.println("O bisneto nasceu");
    try {
      for (int idade = 0; idade <= 12; idade++) {
        if (idade == 5) {
          pc.bisneto(2); // Funcao que altera a imagem do bisneto
        }
        novaIdade = idade;
        Platform.runLater(() -> pc.idadeBisneto(novaIdade)); // Passa o tempo para o metodo idadeBisneto
        Thread.sleep(1000); // Hiberna a thread por 1 segundo a cada ciclo do for
      }
      pc.bisneto(3); // Funcao que altera a imagem do bisneto
      pc.deadB(1); // Funcao que adiciona uma "caveira" ao lado do contador do bisneto apos sua
                   // morte
      System.out.println("O bisneto morreu aos 12 anos");
    } catch (InterruptedException e) { // Pegando o erro do tipo InterruptedException - se der esse erro
      e.printStackTrace(); // Imprime o erro no terminal
    }
  }

  public void setWindow(PrincipalController window) {
    pc = window; // A variavel pc recebe a classe controle principal
  }
}
