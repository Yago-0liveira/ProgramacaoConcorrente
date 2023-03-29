/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 20/03/2023
* Ultima alteracao.: 23/03/2023
* Nome.............: ThreadNeto1.java
* Funcao...........: Eh responsavel por executar os comandos relacionados ao primeiro neto
*******************************************************************/
package modelo;

import controle.PrincipalController;
import javafx.application.Platform;

public class ThreadNeto1 extends Thread {
  ThreadBisneto b1 = new ThreadBisneto();  //Instanciando o bisneto na classe neto1
  PrincipalController pc; //Instanciando a classe controle na classe neto1
  public static int novaIdade; //Criando uma variavel estatica

  public void run() {
    pc.neto1(1); //Funcao que altera a imagem do neto
    System.out.println("O primeiro neto nasceu");
    try {

      for (int idade = 0; idade <= 35; idade++) {
        if (idade == 5){
          pc.neto1(2); //Funcao que altera a imagem do neto
        }
        if (idade == 15){
          pc.neto1(3); //Funcao que altera a imagem do neto
        }
        if (idade == 22){
          pc.neto1(4); //Funcao que altera a imagem do neto
        }
        if (idade == 30) {
          b1.start(); //Iniciando a thread bisneto
        } 
        novaIdade = idade;
        Platform.runLater(() -> pc.idadeNeto1(novaIdade)); //Passa o tempo para o metodo idadeNeto1
        Thread.sleep(1000); //Hiberna a thread por 1 segundo a cada ciclo do for 
      } 
      
      pc.neto1(5); //Funcao que altera a imagem do neto
      pc.deadN1(1); //Funcao que adiciona uma "caveira" ao lado do contador do neto apos sua morte
      System.out.println("O primeiro neto morreu aos 35 anos");
    } catch (InterruptedException e) { //Pegando o erro do tipo InterruptedException - se der esse erro
      e.printStackTrace(); //Imprime o erro no terminal
    } 
  }

  public void setWindow(PrincipalController window) { //A classe passa o controlador para as classes filhas
    pc = window;
    b1.setWindow(window);
  }
}
