/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 26/05/2023
* Ultima alteracao.: 05/06/2023
* Nome.............: Carros.java
* Funcao...........: Eh responsavel por executar os comandos relacionados aos carros,
 como seus percursos e posicoes. esses comandos estao melhor descritos abaixo.
******************************************************************/

package modelo;

import controle.*;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class Carros extends Thread {
  private int posiX;
  private int posiY;
  int percurso = 0;
  private PrincipalController pC;
  private int velocidade[] = new int[8];
  ImageView carro;

  public Carros(PrincipalController pc, int percurso) {
    this.pC = pc;
    this.percurso = percurso;
  }

  public void rotaV() throws InterruptedException { //switchs de percurso para as threads
    switch (this.percurso) {
      case 6:
        Percurso06();
        break;
      case 3:
        Percurso03();
        break;
      case 7:
        Percurso07();
        break;
      case 12:
        Percurso12();
        break;
      case 13:
        Percurso13();
        break;
      case 14:
        Percurso14();
        break;
      case 22:
        Percurso22();
        break;
      case 23:
        Percurso23();
        break;
    }
  }

  public void Percurso06() throws InterruptedException {
    carro = pC.getCarro1Ci();
    // inicia na rua 31
    moveParaEsquerda(carro, -120, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r31 (nao critica)
    pC.s20.release();
    pC.s19_13.acquire();// p6p3
    moveParaEsquerda(carro, -165, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // passa da esquina de r31
    Platform.runLater(() -> carro.setRotate(360)); // roda o carro para cima
    moveParaCima(carro, -80, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r18
    pC.s18_6.acquire();
    pC.s13_7_1.acquire();
    moveParaCima(carro, -120, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    moveParaCima(carro, -165, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r19
    pC.s19_13.release();// p6p3
    moveParaCima(carro, -207, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // meio
    moveParaCima(carro, -250, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r20
    pC.s1_2_3.acquire();
    moveParaCima(carro, -300, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // passa da esquina de r20
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita
    pC.s13_7_1.release();
    moveParaDireita(carro, 0, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// r1
    pC.s3_4_5.acquire();
    pC.s12_6_5_4.acquire();
    moveParaDireita(carro, 170, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r2
    moveParaDireita(carro, 215, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    pC.s1_2_3.release();
    moveParaDireita(carro, 295, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r3
    moveParaDireita(carro, 340, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    moveParaDireita(carro, 465, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r4
    pC.s2_4.release();
    pC.s5_12.acquire();
    moveParaDireita(carro, 510, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    pC.s3_4_5.release();
    moveParaDireita(carro, 675, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r5
    moveParaDireita(carro, 720, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // passa da esquina de r5
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    moveParaBaixo(carro, -260, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r6
    moveParaBaixo(carro, -210, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // passa da esquina de r6
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    pC.s18_6.release();
    pC.s5_12.release();
    moveParaEsquerda(carro, 560, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// r25
    pC.s11.acquire();
    pC.s12_6_5_4.release();
    moveParaEsquerda(carro, 515, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    moveParaEsquerda(carro, 390, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// r24
    pC.s11.release();
    pC.s10.acquire();
    moveParaEsquerda(carro, 345, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    pC.s10.release();
    moveParaEsquerda(carro, 260, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r23
    pC.s9.acquire();
    moveParaEsquerda(carro, 215, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    moveParaEsquerda(carro, 95, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r22
    pC.s9.release();
    pC.s8_14.acquire();
    moveParaEsquerda(carro, 45, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // passa da esquina de r22
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    moveParaBaixo(carro, -170, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r42
    pC.s14_15_16_17_18.acquire();
    moveParaBaixo(carro, -125, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // passa da esquina de r42
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita
    pC.s8_14.release();
    moveParaDireita(carro, 170, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// r27
    pC.s15.acquire();
    moveParaDireita(carro, 215, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    pC.s15.release();
    moveParaDireita(carro, 295, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// r28
    pC.s28_18.acquire();
    pC.s32_33_34.acquire();
    pC.s16_7_18.acquire();
    pC.s16.acquire();
    moveParaDireita(carro, 340, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    pC.s16.release();
    moveParaDireita(carro, 465, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// r29
    moveParaDireita(carro, 510, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    moveParaDireita(carro, 675, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// r30
    moveParaDireita(carro, 720, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// passa da esquina de r30
    pC.s14_15_16_17_18.release();
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    moveParaBaixo(carro, -50, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r8
    pC.s16_7_18.release();
    moveParaBaixo(carro, 0, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    moveParaBaixo(carro, 40, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r9
    pC.s30_36_35_34.acquire();
    moveParaBaixo(carro, 80, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    moveParaBaixo(carro, 120, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r10
    moveParaBaixo(carro, 165, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // passa da esquina de r10
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    moveParaEsquerda(carro, 560, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// r11
    pC.s33_34_35.acquire();
    moveParaEsquerda(carro, 515, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    moveParaEsquerda(carro, 390, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// r12

    moveParaEsquerda(carro, 345, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    moveParaEsquerda(carro, 260, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r13
    pC.s30_36_35_34.release();
    pC.s28_18.release();
    pC.s33_32_31_25.acquire();
    moveParaEsquerda(carro, 215, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    pC.s33_34_35.release();
    moveParaEsquerda(carro, 95, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r14
    moveParaEsquerda(carro, 45, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    pC.s32_33_34.release();
    moveParaEsquerda(carro, -120, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r15
    moveParaEsquerda(carro, -165, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // passa da esquina de r15
    Platform.runLater(() -> carro.setRotate(360)); // roda o carro para cima
    moveParaCima(carro, 130, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r16
    moveParaCima(carro, 80, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // passa da esquina de r16
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita
    pC.s33_32_31_25.release();
    moveParaDireita(carro, 10, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// r36
    pC.s26.acquire();
    moveParaDireita(carro, 45, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    pC.s26.release();
    moveParaDireita(carro, 170, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r37
    pC.s27_28.acquire();
    pC.s27.acquire();
    moveParaDireita(carro, 215, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // meio
    pC.s27.release();
    moveParaDireita(carro, 295, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r38
    pC.s28.acquire();
    moveParaDireita(carro, 345, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // meio
    pC.s28.release();
    moveParaDireita(carro, 465, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r39
    pC.s25_23_22.acquire();
    pC.s27_28.release();
    moveParaDireita(carro, 515, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // passa da esquina de r39
    Platform.runLater(() -> carro.setRotate(360)); // roda o carro para cima
    moveParaCima(carro, 45, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r59
    moveParaCima(carro, -5, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // passa da esquina de r59
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    moveParaEsquerda(carro, 390, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// 34
    pC.s22.acquire();
    moveParaEsquerda(carro, 340, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    pC.s22.release();
    moveParaEsquerda(carro, 260, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r33
    pC.s21.acquire();
    moveParaEsquerda(carro, 215, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1()));// meio
    pC.s21.release();
    moveParaEsquerda(carro, 95, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // r32
    pC.s25_23_22.release();
    pC.s20.acquire();
    moveParaEsquerda(carro, 45, alteraVelocidade(velocidade[0], pC.getVelocidadeCar1())); // meio
    // fica de olho no s43
  }

  public void Percurso03() throws InterruptedException {
    carro = pC.getCarro2Ye();
    moveParaEsquerda(carro, -120, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r15
    moveParaEsquerda(carro, -165, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // passa da esquina de r15
    Platform.runLater(() -> carro.setRotate(360)); // roda o carro para cima
    moveParaCima(carro, -35, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r16
    moveParaCima(carro, -80, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// meio
    pC.s33_32_31_25.release();
    moveParaCima(carro, -120, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r17
    pC.s19_13.acquire();// p6p3
    moveParaCima(carro, -165, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// meio
    moveParaCima(carro, -240, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r18
    pC.s18_6.acquire();
    pC.s13_7_1.acquire();
    pC.s19_13.release();// p6p3
    moveParaCima(carro, -285, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// meio
    moveParaCima(carro, -330, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r19
    moveParaCima(carro, -375, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // meio
    moveParaCima(carro, -420, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r20
    pC.s1_2_3.acquire();
    moveParaCima(carro, -460, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // passa da esquina de r20
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita
    pC.s13_7_1.release();
    moveParaDireita(carro, 10, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// r1
    pC.s12_6_5_4.acquire();
    pC.s2_4.acquire();
    pC.s3_4_5.acquire();
    moveParaDireita(carro, 50, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// meio
    moveParaDireita(carro, 170, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r2
    moveParaDireita(carro, 220, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// meio
    pC.s1_2_3.release();
    moveParaDireita(carro, 295, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r3
    moveParaDireita(carro, 345, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// meio
    moveParaDireita(carro, 465, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r4
    pC.s2_4.release();
    pC.s5_12.acquire();
    moveParaDireita(carro, 515, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// meio
    pC.s3_4_5.release();
    moveParaDireita(carro, 675, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r5
    moveParaDireita(carro, 720, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // passa da esquina de r5
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    moveParaBaixo(carro, -420, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r6
    moveParaBaixo(carro, -375, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// meio
    pC.s5_12.release();
    moveParaBaixo(carro, -330, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r7
    pC.s16_7_18.acquire();
    moveParaBaixo(carro, -290, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // passa da esquina de r7
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    moveParaEsquerda(carro, 560, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// r30
    pC.s12_6_5_4.release();
    moveParaEsquerda(carro, 515, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// meio
    moveParaEsquerda(carro, 390, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r29
    pC.s16_22.acquire();
    moveParaEsquerda(carro, 340, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // passa da esquina de r29
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    pC.s13_16.release();
    moveParaBaixo(carro, -210, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r53
    pC.s18_6.release();
    pC.s16_7_18.release();
    pC.s25_23_22.acquire();
    moveParaBaixo(carro, -160, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // passa da esquina de r53
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita
    pC.s16_22.release();
    moveParaDireita(carro, 470, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r34
    moveParaDireita(carro, 515, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // passa da esquina de r34
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    moveParaBaixo(carro, -125, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// r59
    moveParaBaixo(carro, -80, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// passa da esquina de r59
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita
    moveParaDireita(carro, 680, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r40
    pC.s28_18.acquire();
    pC.s30_36_35_34.acquire();
    pC.s25_23_22.release();
    moveParaDireita(carro, 725, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // passsa da esquina de r40
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    moveParaBaixo(carro, -40, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r10
    pC.s32_33_34.acquire();
    moveParaBaixo(carro, 5, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // passa da esquina de r10
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    moveParaEsquerda(carro, 560, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// r11
    pC.s27_33_34_35.acquire();
    moveParaEsquerda(carro, 515, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// meio
    moveParaEsquerda(carro, 390, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// r12

    moveParaEsquerda(carro, 345, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// passa da esquina de r12
    Platform.runLater(() -> carro.setRotate(360)); // roda o carro para cima
    pC.s30_36_35_34.release();
    moveParaCima(carro, -35, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r55
    pC.s27_28.acquire();
    moveParaCima(carro, -80, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // passa da esquina de r55
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    moveParaEsquerda(carro, 260, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// r38
    pC.s28_18.release();
    pC.s27_28.release();
    moveParaEsquerda(carro, 215, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// passa esquina de r38
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    moveParaBaixo(carro, -40, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// r50
    pC.s33_32_31_25.acquire();
    moveParaBaixo(carro, 5, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2()));// passa esquina de r50
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    moveParaEsquerda(carro, 95, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // r14
    pC.s27_33_34_35.release();
    moveParaEsquerda(carro, 55, alteraVelocidade(velocidade[1], pC.getVelocidadeCar2())); // voltando para r15
    pC.s32_33_34.release();
    // ficar de olho no s13
  }

  public void Percurso07() throws InterruptedException {
    carro = pC.getCarro3Re();
    // inicia na r26
    pC.s18_6.release();
    pC.s13_16.release();
    moveParaDireita(carro, 120, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// r26
    pC.s14.acquire();
    pC.s14_15_16_17_18.acquire();
    moveParaDireita(carro, 165, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// meio
    pC.s14.release();
    moveParaDireita(carro, 290, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// r27
    pC.s13_16.acquire();
    pC.s18_6.acquire();
    pC.s15.acquire();
    moveParaDireita(carro, 335, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// meio
    pC.s15.release();
    moveParaDireita(carro, 415, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// r28
    pC.s16.acquire();
    moveParaDireita(carro, 460, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// meio
    pC.s16.release();
    moveParaDireita(carro, 585, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// r29
    pC.s17.acquire();
    moveParaDireita(carro, 630, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// meio
    pC.s17.release();
    moveParaDireita(carro, 795, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// r30
    pC.s12_6_5_4.acquire();
    moveParaDireita(carro, 840, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// passa da esquina de r30
    Platform.runLater(() -> carro.setRotate(360)); // roda o carro para cima
    pC.s14_15_16_17_18.release();
    moveParaCima(carro, -45, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3())); // r7
    moveParaCima(carro, -85, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// meio
    moveParaCima(carro, -130, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3())); // r6
    moveParaCima(carro, -170, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3())); // passa da esquina de r6
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    moveParaEsquerda(carro, 675, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3())); // r5
    pC.s3_4_5.acquire();
    moveParaEsquerda(carro, 630, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// meio
    moveParaEsquerda(carro, 505, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3())); // r4
    pC.s2_4.acquire();
    moveParaEsquerda(carro, 460, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// meio
    moveParaEsquerda(carro, 380, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3())); // r3
    pC.s12_6_5_4.release();
    moveParaEsquerda(carro, 335, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// meio
    moveParaEsquerda(carro, 210, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3())); // r2
    moveParaEsquerda(carro, 165, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// meio
    pC.s3_4_5.release();
    pC.s2_4.release();
    moveParaEsquerda(carro, -5, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3())); // r1
    moveParaEsquerda(carro, -40, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3())); // passa da esquina de r1
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    moveParaBaixo(carro, -130, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// r20
    moveParaBaixo(carro, -85, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// meio
    moveParaBaixo(carro, -45, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// r19
    moveParaBaixo(carro, 1, alteraVelocidade(velocidade[2], pC.getVelocidadeCar3()));// passa da esquina de r19
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita

  }

  public void Percurso12() throws InterruptedException {
    carro = pC.getCarro4Bl();
    // começa na rua 41
    pC.s2_4.release();
    pC.s8_14.acquire();
    moveParaBaixo(carro, 45, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4()));// meio
    moveParaBaixo(carro, 85, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // r42
    pC.s14.acquire();
    moveParaBaixo(carro, 135, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4()));// meio
    pC.s14.release();
    pC.s8_14.release();
    moveParaBaixo(carro, 210, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // r43
    pC.s20.acquire();
    moveParaBaixo(carro, 250, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4()));// meio
    pC.s20.release();
    moveParaBaixo(carro, 295, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // r44
    pC.s26.acquire();
    moveParaBaixo(carro, 335, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4()));// meio
    pC.s26.release();
    moveParaBaixo(carro, 375, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // r45
    pC.s4_34.acquire();
    pC.s32_33_34.acquire();
    moveParaBaixo(carro, 420, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // passa da esquina de r45
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita
    moveParaDireita(carro, 125, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4()));// r14
    pC.s34_33.acquire();
    moveParaDireita(carro, 170, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4()));// meio
    moveParaDireita(carro, 255, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4()));// r13

    moveParaDireita(carro, 300, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4()));// passa da esquina de r13
    Platform.runLater(() -> carro.setRotate(360)); // roda o carro para cima
    pC.s34_33.release();
    moveParaCima(carro, 380, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // r55
    pC.s28.acquire();
    pC.s32_33_34.release();
    moveParaCima(carro, 335, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // meio
    pC.s28.release();
    moveParaCima(carro, 295, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // r54
    pC.s22.acquire();
    pC.s16_22.acquire();
    moveParaCima(carro, 255, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4()));// meio
    pC.s22.release();
    moveParaCima(carro, 175, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // r53
    pC.s16.acquire();
    moveParaCima(carro, 130, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // meio
    pC.s16_22.release();
    pC.s16.release();
    moveParaCima(carro, 85, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // r52
    pC.s10.acquire();
    moveParaCima(carro, 40, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // meio
    pC.s10.release();
    moveParaCima(carro, 1, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // 51
    pC.s2_4.acquire();
    pC.s3_4_5.acquire();
    moveParaCima(carro, -40, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // passa da esquina de 51
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    moveParaEsquerda(carro, 215, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // r3
    pC.s4_34.release();
    moveParaEsquerda(carro, 170, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4()));// meio
    pC.s3_4_5.release();
    moveParaEsquerda(carro, 45, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // r2
    moveParaEsquerda(carro, 0, alteraVelocidade(velocidade[3], pC.getVelocidadeCar4())); // passa da esquina de r2
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo

  }

  public void Percurso13() throws InterruptedException {
    carro = pC.getCarro5Gr();
    // comeca na r47
    pC.s9.release();
    pC.s15.acquire();
    moveParaBaixo(carro, 45, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // meio
    pC.s15.release();
    moveParaBaixo(carro, 125, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // 48
    pC.s9.acquire();
    pC.s21.acquire();
    moveParaBaixo(carro, 170, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5()));// meio
    moveParaBaixo(carro, 210, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // r49
    pC.s21.release();
    pC.s27.acquire();
    pC.s28_18.acquire();
    pC.s27_33_34_35.acquire();
    pC.s33_34_35.acquire();
    moveParaBaixo(carro, 250, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5()));// meio
    moveParaBaixo(carro, 290, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // r50
    pC.s34_33.acquire();
    pC.s27.release();
    moveParaBaixo(carro, 330, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // passa da esquina de r50
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita
    moveParaDireita(carro, 90, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5()));// r13
    moveParaDireita(carro, 130, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5()));// meio
    pC.s34_33.release();
    moveParaDireita(carro, 260, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5()));// r12
    moveParaDireita(carro, 305, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5()));// passa da esquina de r12
    Platform.runLater(() -> carro.setRotate(360)); // roda o carro para cima
    pC.s33_34_35.release();
    moveParaCima(carro, 290, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // r60
    pC.s27_33_34_35.release();
    pC.s28_18.release();
    pC.s25_23_22.acquire();
    moveParaCima(carro, 250, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5()));// meio
    moveParaCima(carro, 210, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // r59
    moveParaCima(carro, 165, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5()));// meio
    moveParaCima(carro, 90, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // r58
    pC.s17.acquire();
    pC.s16_7_18.acquire();
    pC.s25_23_22.release();
    moveParaCima(carro, 45, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5()));// meio
    moveParaCima(carro, 0, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // r57
    pC.s11.acquire();
    pC.s17.release();
    pC.s16_7_18.release();
    moveParaCima(carro, -45, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // meio
    pC.s11.release();
    moveParaCima(carro, -90, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // r56
    pC.s12_6_5_4.acquire();
    pC.s3_4_5.acquire();

    moveParaCima(carro, -130, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // passa da esquina de r56
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    moveParaEsquerda(carro, 175, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // r4
    moveParaEsquerda(carro, 130, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5()));// meio
    moveParaEsquerda(carro, 50, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // r3
    moveParaEsquerda(carro, 0, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // passa da esquina de r3
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    moveParaBaixo(carro, -85, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // r46
    moveParaBaixo(carro, -40, alteraVelocidade(velocidade[4], pC.getVelocidadeCar5())); // voltando para r47
    pC.s12_6_5_4.release();
    pC.s3_4_5.release();

  }

  public void Percurso14() throws InterruptedException {
    carro = pC.getCarro6Wh();
    // comeca na rua 51
    pC.s10.acquire();
    moveParaBaixo(carro, 45, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6()));// meio
    pC.s10.release();
    moveParaBaixo(carro, 90, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // r52
    pC.s16.acquire();
    pC.s16_22.acquire();
    moveParaBaixo(carro, 130, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // meio
    pC.s16.release();
    moveParaBaixo(carro, 210, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // r53
    pC.s22.acquire();
    moveParaBaixo(carro, 255, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6()));// meio
    pC.s16_22.release();
    pC.s22.release();
    moveParaBaixo(carro, 300, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // r54
    pC.s28_18.acquire();
    moveParaBaixo(carro, 340, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6()));// meio
    moveParaBaixo(carro, 380, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // r55
    moveParaBaixo(carro, 420, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // passa da esquina de r55
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita
    moveParaDireita(carro, 130, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // r12
    pC.s4_34.release();
    moveParaDireita(carro, 170, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6()));// meio
    moveParaDireita(carro, 335, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // r11
    moveParaDireita(carro, 380, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // passa da esquina de r11
    Platform.runLater(() -> carro.setRotate(360)); // roda o carro para cima
    moveParaCima(carro, 380, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // r10
    moveParaCima(carro, 335, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // meio
    moveParaCima(carro, 295, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // r9
    moveParaCima(carro, 255, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6()));// meio
    moveParaCima(carro, 175, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // r8
    pC.s4_34.acquire();
    pC.s12_6_5_4.acquire();
    moveParaCima(carro, 130, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6()));// meio
    moveParaCima(carro, 85, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // r7
    pC.s28_18.release();
    moveParaCima(carro, 40, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // meio
    moveParaCima(carro, 0, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // r6
    moveParaCima(carro, -40, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // passa da esquina de r6
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    moveParaEsquerda(carro, 215, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // r5
    moveParaEsquerda(carro, 175, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6()));// meio
    moveParaEsquerda(carro, 40, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6())); // r4
    moveParaEsquerda(carro, 0, alteraVelocidade(velocidade[5], pC.getVelocidadeCar6()));// passa da esquina de r4
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    pC.s12_6_5_4.release();
  }

  public void Percurso22() {
    carro = pC.getCarro7Or();
    // comeca na r21
    moveParaDireita(carro, 120, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// r21
    moveParaDireita(carro, 165, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// meio
    moveParaDireita(carro, 290, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// r22
    moveParaDireita(carro, 335, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // passa da esquina de r22
    Platform.runLater(() -> carro.setRotate(360)); // roda o carro para cima
    moveParaCima(carro, -50, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// r46
    moveParaCima(carro, -90, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// passa da esquina de r46
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita
    moveParaDireita(carro, 415, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// r3
    moveParaDireita(carro, 460, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// passa da esquina de r3
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    moveParaBaixo(carro, -50, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // r51
    moveParaBaixo(carro, 0, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// passa da esquina de r51
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita
    moveParaDireita(carro, 590, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // r24
    moveParaDireita(carro, 630, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// meio
    moveParaDireita(carro, 795, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // r25
    moveParaDireita(carro, 840, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // passa da esquina de r25
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    moveParaBaixo(carro, 40, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // r7
    moveParaBaixo(carro, 80, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // meio
    moveParaBaixo(carro, 165, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // r8
    moveParaBaixo(carro, 205, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // meio
    moveParaBaixo(carro, 245, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // r9
    moveParaBaixo(carro, 290, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// meio
    moveParaBaixo(carro, 330, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // 10
    moveParaBaixo(carro, 370, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // passa da esquina de r10
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    moveParaEsquerda(carro, 680, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // r11
    moveParaEsquerda(carro, 630, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// meio
    moveParaEsquerda(carro, 510, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // r12
    moveParaEsquerda(carro, 460, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // passa da esquina de r12
    Platform.runLater(() -> carro.setRotate(360)); // roda o carro para cima
    moveParaCima(carro, 330, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// r55
    moveParaCima(carro, 285, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// passa da esquina dr r55
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    moveParaEsquerda(carro, 380, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// 38
    moveParaEsquerda(carro, 330, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // passa da esquina de r38
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    moveParaBaixo(carro, 330, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // r50
    moveParaBaixo(carro, 370, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // passa da esquina de r50
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    moveParaEsquerda(carro, 210, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // r14
    moveParaEsquerda(carro, 165, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// meio
    moveParaEsquerda(carro, 0, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // r15
    moveParaEsquerda(carro, -45, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // passa da esquina de 415
    Platform.runLater(() -> carro.setRotate(360)); // roda o carro para cima
    moveParaCima(carro, 330, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// r16
    moveParaCima(carro, 290, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// meio
    moveParaCima(carro, 250, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// r17
    moveParaCima(carro, 210, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// meio
    moveParaCima(carro, 130, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // r18
    moveParaCima(carro, 85, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7()));// meio
    moveParaCima(carro, 40, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // r19
    moveParaCima(carro, -5, alteraVelocidade(velocidade[6], pC.getVelocidadeCar7())); // passa da esquina de r19
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita

  }

  public void Percurso23() {
    carro = pC.getCarro8Br();
    // começa na r35
    moveParaEsquerda(carro, -120, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // r35
    moveParaEsquerda(carro, -160, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // passa da esquina de r35
    Platform.runLater(() -> carro.setRotate(360)); // roda o carro para cima
    moveParaCima(carro, -80, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// r68
    moveParaCima(carro, -125, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// passa da esquina de r68
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    moveParaEsquerda(carro, -290, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// r29
    moveParaEsquerda(carro, -335, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// passa da esquina de r29
    Platform.runLater(() -> carro.setRotate(360)); // roda o carro para cima
    moveParaCima(carro, -170, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// r52
    moveParaCima(carro, -215, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// passa da esquina de r52
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    moveParaEsquerda(carro, -415, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// r23
    moveParaEsquerda(carro, -460, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// passa da esquina de r23
    Platform.runLater(() -> carro.setRotate(360)); // roda o carro para cima
    moveParaCima(carro, -255, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // 46
    moveParaCima(carro, -300, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// passa da esquina r46
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda
    moveParaEsquerda(carro, -580, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// r2
    moveParaEsquerda(carro, -625, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// meio
    moveParaEsquerda(carro, -800, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// r1
    moveParaEsquerda(carro, -840, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// passa da esquina de r1
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    moveParaBaixo(carro, -255, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // r20
    moveParaBaixo(carro, -210, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// meio
    moveParaBaixo(carro, -170, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // r19
    moveParaBaixo(carro, -125, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // passa na esquina de r19
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita
    moveParaDireita(carro, -675, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // r26
    moveParaDireita(carro, -630, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // passa da esquina do r26
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    moveParaBaixo(carro, -50, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // r43
    moveParaBaixo(carro, 0, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// passa da esquin de r43
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita
    moveParaDireita(carro, -505, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// r32
    moveParaDireita(carro, -460, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// passa da esquina de r32
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    moveParaBaixo(carro, 40, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // r49
    moveParaBaixo(carro, 80, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // passa da esquina de r49
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita
    moveParaDireita(carro, -380, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // r38
    moveParaDireita(carro, -330, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // passa da esquina de r38
    Platform.runLater(() -> carro.setRotate(180)); // roda o carro para baixo
    moveParaBaixo(carro, 120, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // r55
    moveParaBaixo(carro, 170, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// passa da esquina de r55
    Platform.runLater(() -> carro.setRotate(90)); // roda o carro para direita
    moveParaDireita(carro, -210, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// r12
    moveParaDireita(carro, -160, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// meio
    moveParaDireita(carro, 0, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // r11
    moveParaDireita(carro, 50, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// passa da esquina de r11
    Platform.runLater(() -> carro.setRotate(360)); // roda o carro para cima
    moveParaCima(carro, 125, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // r10
    moveParaCima(carro, 80, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8()));// meio
    moveParaCima(carro, 40, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // r9
    moveParaCima(carro, 0, alteraVelocidade(velocidade[7], pC.getVelocidadeCar8())); // passa da esquina de r9
    Platform.runLater(() -> carro.setRotate(-90)); // roda o carro esquerda

  }

  public void run() {
    while (true) {
      try {
        rotaV();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void moveParaDireita(ImageView img, int parar, int velocidade) {
    while (posiX <= parar) {
      try {
        Platform.runLater(() -> img.setX(posiX));
        posiX++;
        sleep(velocidade);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void moveParaEsquerda(ImageView img, int parar, int velocidade) {

    while (posiX >= parar) {
      try {
        Platform.runLater(() -> img.setX(posiX));
        posiX--;
        sleep(velocidade);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void moveParaCima(ImageView img, int parar, int velocidade) {
    while (posiY >= parar) {
      try {
        Platform.runLater(() -> img.setY(posiY));
        posiY--;
        sleep(velocidade);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void moveParaBaixo(ImageView img, int parar, int velocidade) {

    while (posiY <= parar) {
      try {
        Platform.runLater(() -> img.setY(posiY));
        posiY++;
        sleep(velocidade);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public int alteraVelocidade(int velocidade, int VelocidadeAtualizada) {
    velocidade = VelocidadeAtualizada;

    switch (velocidade) {
      case 0:
        velocidade = 10;
        break;
      case 1:
        velocidade = 5;
        break;
      case 2:
        velocidade = 2;
        break;
      default:
        System.out.println("");
        break;
    }
    return velocidade;
  }

}
