/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 20/03/2023
* Ultima alteracao.: 23/03/2023
* Nome.............: ThreadPai.java
* Funcao...........: Eh responsavel por executar os comandos relacionados ao pai 
*******************************************************************/

package modelo;

import controle.PrincipalController;
import javafx.application.Platform;

public class ThreadPai extends Thread {
  // instanciando os filhos na classe pai
  ThreadFilho1 f1 = new ThreadFilho1();
  ThreadFilho2 f2 = new ThreadFilho2();
  ThreadFilho3 f3 = new ThreadFilho3();
  PrincipalController pc; // instanciando a classe controle na classe pai
  public static int novaIdade; // criando uma variavel estatica

  public void setWindow(PrincipalController window) { // A classe passa o controlador para as classes filhas
    pc = window;
    f1.setWindow(window);
    f2.setWindow(window);
    f3.setWindow(window);

  }

  public void run() {
    pc.pai(1); // Funcao que altera a imagem do pai
    System.out.println("O pai nasceu");
    try {
      for (int idade = 0; idade <= 90; idade++) { // Contador da idade do pai
        if (idade == 5) {
          pc.pai(2); // Funcao que altera a imagem do pai
        }

        if (idade == 15) {
          pc.pai(3); // Funcao que altera a imagem do pai
        }

        if (idade == 22) {
          pc.pai(4); // Funcao que altera a imagem do pai
          f1.start(); // Iniciando a thread filho 1
        }

        if (idade == 25) {
          f2.start(); // Iniciando a thread filho 2
        }

        if (idade == 32) {
          f3.start(); // Iniciando a thread filho 3
        }

        if (idade == 50) {
          pc.pai(5); // Funcao que altera a imagem do pai
        }
        novaIdade = idade;
        Platform.runLater(() -> pc.idadePai(novaIdade)); // Passa o tempo para o metodo idadePai
        Thread.sleep(1000); // Hiberna a thread por 1 segundo a cada ciclo do for
      }
      pc.pai(6); // Funcao que altera a imagem do pai
      pc.deadP(1); // Funcao que adiciona uma "caveira" ao lado do contador do pai apos sua morte
      System.out.println("O pai morreu");

    } catch (InterruptedException e) { // Pegando o erro do tipo InterruptedException - se der esse erro
      e.printStackTrace(); // Imprime o erro no terminal
    }
  }

}
