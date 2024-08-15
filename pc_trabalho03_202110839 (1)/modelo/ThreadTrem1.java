/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 18/04/2023
* Ultima alteracao.: 22/04/2023
* Nome.............: ThreadTrem1.java
* Funcao...........: Eh responsavel por executar os comandos relacionados ao trem 1 (o trem vermelho)
*******************************************************************/
package modelo;

import controle.PrincipalController;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class ThreadTrem1 extends Thread {
  private PrincipalController controle;
  private int velocidade; // velocidade dos trens
  private int posiX; // posicao X
  private int posiY; // posicao Y
  private ImageView trem;

  public ThreadTrem1(PrincipalController controle) { // contrutor da classe
    this.controle = controle;
    this.trem = controle.getTrem1();
    this.velocidade = 1;
  }

  public void run() {
    while (true) { // metodo da variavel de travamento
      posiX = 0; // posicao inicial do trem no eixo x
      posiY = 0; // posicao inicial do trem no eixo y
      Platform.runLater(() -> trem.setX(posiX)); // passando a posicao do x para o image trem
      Platform.runLater(() -> trem.setY(posiY)); // passando a posicao do y para o image trem

      moveXParaDireita(88); // move o trem para direita
      // regiao critica1
      verificaPonte1(); // chama a funcao para verificar o estado da ponte 1
      controle.setPonte1(false); // define a ponte como ocupada 1
      rotacao(-90); // rota o trem
      moveYParaBaixo(40); // move o trem para baixo
      rotacao(180); // rota o trem
      moveXParaDireita(244); // move o trem para direita
      rotacao(90); // rota o trem
      moveYParaCima(0);// move o trem para cima
      rotacao(180); // rota o trem
      // fim regiao critica1
      controle.setPonte1(true); // define a ponte 1 como desocupada 
      moveXParaDireita(357); // move o trem para direita
      // regiao critica2
      verificaPonte2(); // chama a função para verificar o estado da ponte 2
      controle.setPonte2(false); // define a ponte 2 como ocupada
      rotacao(-90); // rota o trem
      moveYParaBaixo(40); // move o trem para baixo
      rotacao(180); // rota o trem
      moveXParaDireita(513); // move o trem para direita
      rotacao(90); // rota o trem
      moveYParaCima(0); // move o trem para cima
      rotacao(180); // rota o trem
      // fim2
      controle.setPonte2(true); // define a ponte 2 como livre
      moveXParaDireita(605); // move o trem para direita

    }
  }

  public void moveXParaDireita(int pararX) { // metodo que faz o rem mover para direita
    while (posiX != pararX) {
      try {
        Thread.sleep(velocidade);
      } catch (InterruptedException e) {
      }
      posiX++;
      Platform.runLater(() -> trem.setX(posiX));
    }
  }

  public void moveYParaBaixo(int pararY) { // metodo que faz o trem mover para baixo
    while (posiY != pararY) {
      try {
        Thread.sleep(velocidade);
      } catch (InterruptedException e) {
      }

      posiY++;
      Platform.runLater(() -> trem.setY(posiY));
    }
  }

  public void moveYParaCima(int pararY) { // mettodo que faz o trem mover para cima
    while (posiY != pararY) {
      try {
        Thread.sleep(velocidade);
      } catch (InterruptedException e) {
      }

      posiY--;
      Platform.runLater(() -> trem.setY(posiY));
    }
  }

  public void rotacao(int grau) { // metodo que faz o trem rotar
    Platform.runLater(() -> trem.setRotate(grau));
  }

  public void verificaPonte1() { // metodo para verificar se a ponte 1 esta ocupada
    while (controle.isPonte1() == false) {
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
      }
    }
  }
  
  public void verificaPonte2() { // metodo para verificar se a ponte 2 esta ocupada
    while (controle.isPonte2() == false) {
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
      }
    }
  }

  public void aumentaVelocidade() { // aumenta a velocidade dos trens
    if (velocidade > 5) {
      velocidade -= 5;
    }
  }

  public void diminuiVelocidade() { // diminui a velocidade dos trens
    if (velocidade <= 45) {
      velocidade += 5;
    }
  }
}
