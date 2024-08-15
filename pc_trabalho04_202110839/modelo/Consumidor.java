/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 07/05/2023
* Ultima alteracao.: 13/05/2023
* Nome.............: Consumidor.java
* Funcao...........: Eh responsavel por executar os comandos relacionados ao cliente (consumidor)
esses comandos estao melhor descritos abaixo
*******************************************************************/

package modelo;

import controle.PrincipalController;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class Consumidor extends Thread {
  private PrincipalController controle;
  // instanciando baloes de frases
  private ImageView balaoE;
  private ImageView balaoC;
  // instanciando pratos de comida
  private ImageView prato;
  private ImageView prato2;
  private ImageView prato3;
  private ImageView prato4;
  private int velocidade; // velocidade de consumo do cliente

  public Consumidor(PrincipalController controle) { // consrutor da classe consumidor
    this.controle = controle;
    this.balaoE = controle.getBalaoEsperando();
    this.balaoC = controle.getBalaoComendo();
    this.prato = controle.getComida();
    this.prato2 = controle.getComida2();
    this.prato3 = controle.getComida3();
    this.prato4 = controle.getComida4();

  }

  public void run() { // metodo onde ocorre tudo que ha na thread
    while (true) { // loop do semaforo
      try {
        VariaveisGlobais.cheio.acquire(); // decrementa o contador de espacos ocupados
        VariaveisGlobais.mutex.acquire();// entra na regiao critica

        consome();// retira um item do espaco
        // System.out.println("entrou na regiao critica");
        VariaveisGlobais.mutex.release(); // deixa a regiao critica
        VariaveisGlobais.vazio.release(); // incrementa o contador de espacos vazios
        esperando();// realiza operacoes com o item
        // System.out.println("fazendo algo com o item");

      } catch (InterruptedException e) {
      }

    }

  }

  public void consome() { // metodo para realizar operacoes visuais dentro da regiao critica
    try {
      Thread.sleep(alteraVelocidade(controle.getSliderClienteAux()) * 700); // settando velocidade da thread
      Platform.runLater(() -> balaoE.setVisible(false)); // deixa o balao esperando invisivel
      Platform.runLater(() -> balaoC.setVisible(true)); // deixa o balao comendo visivel
      // setando a visibilidade dos pratos
      if (prato4.isVisible())
        prato4.setVisible(false);
      else if (prato3.isVisible())
        prato3.setVisible(false);
      else if (prato2.isVisible())
        prato2.setVisible(false);
      else if (prato.isVisible())
        prato.setVisible(false);
    } catch (InterruptedException e) {
    }

  }

  public void esperando() { // metodo para realizar operacoes visuais fora da regiao critica
    try {
      Thread.sleep(alteraVelocidade(controle.getSliderClienteAux()) * 700); // settando velocidade da thread
    } catch (InterruptedException e) {
    }
    Platform.runLater(() -> balaoC.setVisible(false)); // deixa o balao comendo invisivel
    Platform.runLater(() -> balaoE.setVisible(true)); // deixa o balao esperando visivel
  }

  public int alteraVelocidade(int velocidadeAtualizada) { // metodo para alterar a velocidade do produtor
    velocidade = velocidadeAtualizada;
    if (velocidade == 0) {
      velocidade = 4;
    } else if (velocidade == 1)
      velocidade = 3;
    else if (velocidade == 2)
      velocidade = 2;
    else if (velocidade == 3)
      velocidade = 1;
    return velocidade;
  }
}
