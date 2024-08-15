/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 07/05/2023
* Ultima alteracao.: 13/05/2023
* Nome.............: Produtor.java
* Funcao...........: Eh responsavel por executar os comandos relacionados ao chef (Produtor)
esses comandos estao mellhor descritos abaixo
*******************************************************************/
package modelo;

import controle.PrincipalController;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Produtor extends Thread {
  private PrincipalController controle;
  // instanciando as posicoes do chef
  private ImageView cozinheiroC;
  private ImageView cozinheiroF;
  // instanciando baloes de frases
  private ImageView balaoC;
  private ImageView balaoE;
  // intanciando os pratos de comida
  private ImageView prato;
  private ImageView prato2;
  private ImageView prato3;
  private ImageView prato4;

  private int velocidade; // velocidade em que o produtor cozinha/entrega

  public Produtor(PrincipalController controle) { // construtor do produtor
    this.controle = controle;
    this.cozinheiroC = controle.getCozinheiroCostas();
    this.cozinheiroF = controle.getCozinheirofrente();
    this.balaoC = controle.getBalaoCozinhando();
    this.balaoE = controle.getBalaoEntregando();
    this.prato = controle.getComida();
    this.prato2 = controle.getComida2();
    this.prato3 = controle.getComida3();
    this.prato4 = controle.getComida4();
  }

  public void run() { // metodo onde ocorre tudo que ha na thread

    while (true) { // const = 1

      try {

        cozinhaPrato(); // gera algo para colocar no espaco dispo
        // System.out.println("produzindo algo");

        VariaveisGlobais.vazio.acquire(); // decrementa o contador de espacos vazios
        VariaveisGlobais.mutex.acquire(); // entra na regiao critica

        entregaPrato(); // coloca um novo item no espaco dispo
        // System.out.println("entrou na regiao critica produtor");

        VariaveisGlobais.mutex.release(); // sai da regiao critica
        VariaveisGlobais.cheio.release(); // incrementa o contador de espacos ocupados

      } catch (InterruptedException e) {
      }
    }
  }

  public void cozinhaPrato() { // metodo para realizar operacoes visuais anes da regiao critica
    try {
      Thread.sleep(alteraVelocidade(controle.getSliderChefAux()) * 500); // settando velocidade da thread
    } catch (InterruptedException e) {
    }
    Platform.runLater(() -> balaoE.setVisible(false)); // deixa o balao entregando invisivel
    Platform.runLater(() -> cozinheiroF.setVisible(false)); // deixa o cozinheiro (frente) invisivel
    Platform.runLater(() -> cozinheiroC.setVisible(true)); // deixa o cozinheiro de costas visivel
    Platform.runLater(() -> balaoC.setVisible(true)); // deixa o balao cozinhando visivel

  }

  public void entregaPrato() { // metodo para realizar operacoes visuais dentro da regiao critica
    try {
      Thread.sleep(alteraVelocidade(controle.getSliderChefAux()) * 500); // settando velocidade da thread
      Platform.runLater(() -> cozinheiroC.setVisible(false)); // deixa o imageview chefCostas invisivel
      Platform.runLater(() -> balaoC.setVisible(false)); // deixa o balao cozinhando invisivel
      Platform.runLater(() -> cozinheiroF.setVisible(true)); // deixa o imageview chefFrente visivel
      Platform.runLater(() -> balaoE.setVisible(true)); // deixa o imageview balao entregando visivel
      // setando a visibilidade dos pratos
      if (!prato.isVisible())
        prato.setVisible(true);
      else if (!prato2.isVisible())
        prato2.setVisible(true);
      else if (!prato3.isVisible())
        prato3.setVisible(true);
      else if (!prato4.isVisible())
        prato4.setVisible(true);
    } catch (InterruptedException e) {
    }

  }

  public int alteraVelocidade(int velocidadeAtualizada) { // metodo para alterar a velocidade do produtor
    velocidade = velocidadeAtualizada;
    if (velocidade == 0)
      velocidade = 4;
    else if (velocidade == 1)
      velocidade = 3;
    else if (velocidade == 2)
      velocidade = 2;
    else if (velocidade == 3)
      velocidade = 1;
    return velocidade;
  }
}
