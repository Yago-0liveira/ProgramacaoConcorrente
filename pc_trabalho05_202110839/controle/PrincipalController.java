/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 26/05/2023
* Ultima alteracao.: 05/06/2023
* Nome.............: PrincipalController.java
* Funcao...........:  responsavel por lidar com eventos gerados pelos componentes da GUI LayoutPrincipal.fxml.
Eh tambem responsavel por controlar eventos ocorridos nas classes pertencenetes ao pacote modelo, assim como por
atualizar a GUI com dados do programa e o programa com dados advindos da GUI.
******************************************************************/
package controle;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;
import javafx.fxml.Initializable;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import modelo.Carros;

public class PrincipalController implements Initializable {
  @FXML
  private Button btCarro7;

  @FXML
  private Button btCarro8;

  @FXML
  private ImageView carro1Ci;

  @FXML
  private ImageView carro2Ye;

  @FXML
  private ImageView carro3Re;

  @FXML
  private ImageView carro4Bl;

  @FXML
  private ImageView carro5Gr;

  @FXML
  private ImageView carro6Wh;

  @FXML
  private ImageView carro7Or;

  @FXML
  private ImageView carro8Br;

  @FXML
  private Button idIniciar;

  @FXML
  private Button idReiniciar;

  @FXML
  private Button pausaCarro1;

  @FXML
  private Button pausaCarro2;

  @FXML
  private Button pausaCarro3;

  @FXML
  private Button pausaCarro4;

  @FXML
  private Button pausaCarro5;

  @FXML
  private Button pausaCarro6;

  @FXML
  private Button pausaCarro7;

  @FXML
  private Button pausaCarro8;

  @FXML
  private Slider sliderC1;

  @FXML
  private Slider sliderC2;

  @FXML
  private Slider sliderC3;

  @FXML
  private Slider sliderC4;

  @FXML
  private Slider sliderC5;

  @FXML
  private Slider sliderC6;

  @FXML
  private Slider sliderC7;

  @FXML
  private Slider sliderC8;

  private int velocidadeCar1; // velocidades do slider c1
  private int velocidadeCar2; // velocidades do slider c2
  private int velocidadeCar3; // velocidades do slider c3
  private int velocidadeCar4; // velocidades do slider c4
  private int velocidadeCar5; // velocidades do slider c5
  private int velocidadeCar6; // velocidades do slider c6
  private int velocidadeCar7; // velocidades do slider c7
  private int velocidadeCar8; // velocidades do slider c8

  public Semaphore s19_13 = new Semaphore(1); // p6p3
  public Semaphore s13_7_1 = new Semaphore(1); // p6-p3-p23-p7
  public Semaphore s1_2_3 = new Semaphore(1); // p6-p3-p7-p23
  public Semaphore s3_4_5 = new Semaphore(1);// p6-p3-p7-p13
  public Semaphore s5_12 = new Semaphore(1);// p6-p3
  public Semaphore s16_7_18 = new Semaphore(1);// p6-p3
  public Semaphore s30_36_35_34 = new Semaphore(1);// p6-p3
  public Semaphore s27_28 = new Semaphore(1);// p6-p3 -10
  public Semaphore s33_32_31_25 = new Semaphore(0);// p6-p3
  public Semaphore s25_23_22 = new Semaphore(1);// p6-p3
  public Semaphore s13_16 = new Semaphore(1);// p7-p3
  public Semaphore s14_15_16_17_18 = new Semaphore(1);// p6-p7
  public Semaphore s18_6 = new Semaphore(0);// p6-p7
  public Semaphore s2_4 = new Semaphore(0);// p6-p12-p3-p7
  public Semaphore s8_14 = new Semaphore(1);// p6-p12
  public Semaphore s20 = new Semaphore(0);// p6-p12-23
  public Semaphore s26 = new Semaphore(1);// p6-p12-p22
  public Semaphore s32_33_34 = new Semaphore(1);// p6-p12-p3
  public Semaphore s28 = new Semaphore(1);// p6-p12
  public Semaphore s22 = new Semaphore(1);// p6-p12
  public Semaphore s16 = new Semaphore(1);// p6-p12
  public Semaphore s10 = new Semaphore(1);// p6-p12-14
  public Semaphore s16_22 = new Semaphore(1);// p3-p12-p14
  public Semaphore s14 = new Semaphore(1); // p7-p12
  public Semaphore s9 = new Semaphore(1);// p6-p13-22-23
  public Semaphore s15 = new Semaphore(1);// p6-p13-23-p6
  public Semaphore s21 = new Semaphore(1);// p6-p13-23
  public Semaphore s27 = new Semaphore(1);// p6-p13-p3-p22-p23
  public Semaphore s33_34_35 = new Semaphore(1);// p6-p13
  public Semaphore s11 = new Semaphore(1);// p6-p13-22
  public Semaphore s27_33_34_35 = new Semaphore(1);// p3-p13
  public Semaphore s17 = new Semaphore(1);// p13-p7
  public Semaphore s34_33 = new Semaphore(1);// p13-p12
  public Semaphore s28_18 = new Semaphore(1);// p13-p12
  public Semaphore s12_6_5_4 = new Semaphore(1);// p13-p12
  public Semaphore s4_34 = new Semaphore(0);// p14-p12

  Carros carro1;
  Carros carro2;
  Carros carro3;
  Carros carro4;
  Carros carro5;
  Carros carro6;
  Carros carro7;
  Carros carro8;

  @FXML
  void iniciar(ActionEvent event) {
    carro1.start();
    carro2.start();
    carro3.start();
    carro4.start();
    carro5.start();
    carro6.start();
    carro7.start();
    carro8.start();
  }

  @FXML
  void btCarro7Action(ActionEvent event) {
    carro7Or.setVisible(true);
    sliderC7.setVisible(true);
    pausaCarro7.setVisible(true);
    btCarro7.setVisible(false);
  }

  @FXML
  void btCarro8Action(ActionEvent event) {
    carro8Br.setVisible(true);
    sliderC8.setVisible(true);
    pausaCarro8.setVisible(true);
    btCarro8.setVisible(false);
  }

  @FXML
  void pausaCarro1Action(ActionEvent event) {
    if (pausaCarro1.getText().equals("S")) { // verifica se o botao esta com o texto "s (start)"
      carro1.resume(); // faz a thread voltar a funcionar apos o pause
      pausaCarro1.setText("P"); // define o texto do botao como "P (pausar)""
    } else {
      pausaCarro1.setText("S"); // define o texto do botao com "s (start)"
      carro1.suspend(); // pausa a thread
    }
  }

  @FXML
  void pausaCarro2Action(ActionEvent event) {
    if (pausaCarro2.getText().equals("S")) { // verifica se o botao esta com o texto "s (start)"
      carro2.resume(); // faz a thread voltar a funcionar apos o pause
      pausaCarro2.setText("P"); // define o texto do botao como "P (pausar)""
    } else {
      pausaCarro2.setText("S"); // define o texto do botao com "s (start)"
      carro2.suspend(); // pausa a thread
    }
  }

  @FXML
  void pausaCarro3Action(ActionEvent event) {
    if (pausaCarro3.getText().equals("S")) { // verifica se o botao esta com o texto "s (start)"
      carro3.resume(); // faz a thread voltar a funcionar apos o pause
      pausaCarro3.setText("P"); // define o texto do botao como "P (pausar)""
    } else {
      pausaCarro3.setText("S"); // define o texto do botao com "s (start)"
      carro3.suspend(); // pausa a thread
    }
  }

  @FXML
  void pausaCarro4Action(ActionEvent event) {
    if (pausaCarro4.getText().equals("S")) { // verifica se o botao esta com o texto "s (start)"
      carro4.resume(); // faz a thread voltar a funcionar apos o pause
      pausaCarro4.setText("P"); // define o texto do botao como "P (pausar)""
    } else {
      pausaCarro4.setText("S"); // define o texto do botao com "s (start)"
      carro4.suspend(); // pausa a thread
    }
  }

  @FXML
  void pausaCarro5Action(ActionEvent event) {
    if (pausaCarro5.getText().equals("S")) { // verifica se o botao esta com o texto "s (start)"
      carro5.resume(); // faz a thread voltar a funcionar apos o pause
      pausaCarro5.setText("P"); // define o texto do botao como "P (pausar)""
    } else {
      pausaCarro5.setText("S"); // define o texto do botao com "s (start)"
      carro5.suspend(); // pausa a thread
    }
  }

  @FXML
  void pausaCarro6Action(ActionEvent event) {
    if (pausaCarro6.getText().equals("S")) { // verifica se o botao esta com o texto "s (start)"
      carro6.resume(); // faz a thread voltar a funcionar apos o pause
      pausaCarro6.setText("P"); // define o texto do botao como "P (pausar)""
    } else {
      pausaCarro6.setText("S"); // define o texto do botao com "s (start)"
      carro6.suspend(); // pausa a thread
    }
  }

  @FXML
  void pausaCarro7Action(ActionEvent event) {
    if (pausaCarro7.getText().equals("S")) { // verifica se o botao esta com o texto "s (start)"
      carro7.resume(); // faz a thread voltar a funcionar apos o pause
      pausaCarro7.setText("P"); // define o texto do botao como "P (pausar)""
    } else {
      pausaCarro7.setText("S"); // define o texto do botao com "s (start)"
      carro7.suspend(); // pausa a thread
    }
  }

  @FXML
  void pausaCarro8Action(ActionEvent event) {
    if (pausaCarro8.getText().equals("S")) { // verifica se o botao esta com o texto "s (start)"
      carro8.resume(); // faz a thread voltar a funcionar apos o pause
      pausaCarro8.setText("P"); // define o texto do botao como "P (pausar)""
    } else {
      pausaCarro8.setText("S"); // define o texto do botao com "s (start)"
      carro8.suspend(); // pausa a thread
    }
  }

  @FXML
  void reiniciar(ActionEvent event) {
    carro1.stop();
    carro2.stop();
    carro3.stop();
    carro4.stop();
    carro5.stop();
    carro6.stop();
    carro7.stop();
    carro8.stop();

    carro1 = new Carros(this, 6);
    carro2 = new Carros(this, 3);
    carro3 = new Carros(this, 7);
    carro4 = new Carros(this, 12);
    carro5 = new Carros(this, 13);
    carro6 = new Carros(this, 14);
    carro7 = new Carros(this, 22);
    carro8 = new Carros(this, 23);

    s19_13 = new Semaphore(1); // p6p3
    s13_7_1 = new Semaphore(1); // p6-p3-p23-p7
    s1_2_3 = new Semaphore(1); // p6-p3-p7-p23
    s3_4_5 = new Semaphore(1);// p6-p3-p7-p13
    s5_12 = new Semaphore(1);// p6-p3
    s16_7_18 = new Semaphore(1);// p6-p3
    s30_36_35_34 = new Semaphore(1);// p6-p3
    s27_28 = new Semaphore(1);// p6-p3 -10
    s33_32_31_25 = new Semaphore(0);// p6-p3
    s25_23_22 = new Semaphore(1);// p6-p3
    s13_16 = new Semaphore(1);// p7-p3
    s14_15_16_17_18 = new Semaphore(1);// p6-p7
    s18_6 = new Semaphore(0);// p6-p7
    s2_4 = new Semaphore(0);// p6-p12-p3-p7
    s8_14 = new Semaphore(1);// p6-p12
    s20 = new Semaphore(0);// p6-p12-23
    s26 = new Semaphore(1);// p6-p12-p22
    s32_33_34 = new Semaphore(1);// p6-p12-p3
    s28 = new Semaphore(1);// p6-p12
    s22 = new Semaphore(1);// p6-p12
    s16 = new Semaphore(1);// p6-p12
    s10 = new Semaphore(1);// p6-p12-14
    s16_22 = new Semaphore(1);// p3-p12-p14
    s14 = new Semaphore(1); // p7-p12
    s9 = new Semaphore(1);// p6-p13-22-23
    s15 = new Semaphore(1);// p6-p13-23-p6
    s21 = new Semaphore(1);// p6-p13-23
    s27 = new Semaphore(1);// p6-p13-p3-p22-p23
    s33_34_35 = new Semaphore(1);// p6-p13
    s11 = new Semaphore(1);// p6-p13-22
    s27_33_34_35 = new Semaphore(1);// p3-p13
    s17 = new Semaphore(1);// p13-p7
    s34_33 = new Semaphore(1);// p13-p12
    s28_18 = new Semaphore(1);// p13-p12
    s12_6_5_4 = new Semaphore(1);// p13-p12
    s4_34 = new Semaphore(0);// p14-p12

    Platform.runLater(() -> carro1Ci.setX(0));
    Platform.runLater(() -> carro1Ci.setY(0));
    Platform.runLater(() -> carro1Ci.setRotate(-90));

    Platform.runLater(() -> carro2Ye.setX(0));
    Platform.runLater(() -> carro2Ye.setY(0));
    Platform.runLater(() -> carro2Ye.setRotate(-90));

    Platform.runLater(() -> carro3Re.setX(0));
    Platform.runLater(() -> carro3Re.setY(0));
    Platform.runLater(() -> carro3Re.setRotate(90));

    Platform.runLater(() -> carro4Bl.setX(0));
    Platform.runLater(() -> carro4Bl.setY(0));
    Platform.runLater(() -> carro4Bl.setRotate(180));

    Platform.runLater(() -> carro5Gr.setX(0));
    Platform.runLater(() -> carro5Gr.setY(0));
    Platform.runLater(() -> carro5Gr.setRotate(180));

    Platform.runLater(() -> carro6Wh.setX(0));
    Platform.runLater(() -> carro6Wh.setY(0));
    Platform.runLater(() -> carro6Wh.setRotate(180));

    Platform.runLater(() -> carro7Or.setX(0));
    Platform.runLater(() -> carro7Or.setY(0));
    Platform.runLater(() -> carro7Or.setRotate(90));

    Platform.runLater(() -> carro8Br.setX(0));
    Platform.runLater(() -> carro8Br.setY(0));
    Platform.runLater(() -> carro8Br.setRotate(-90));

    sliderC1.setValue(0);
    sliderC2.setValue(0);
    sliderC3.setValue(0);
    sliderC4.setValue(0);
    sliderC5.setValue(0);
    sliderC6.setValue(0);
    sliderC7.setValue(0);
    sliderC8.setValue(0);

    pausaCarro1Action(event);
    pausaCarro2Action(event);
    pausaCarro3Action(event);
    pausaCarro4Action(event);
    pausaCarro5Action(event);
    pausaCarro6Action(event);
    pausaCarro7Action(event);
    pausaCarro8Action(event);
    pausaCarro1.setText("P");
    pausaCarro2.setText("P");
    pausaCarro3.setText("P");
    pausaCarro4.setText("P");
    pausaCarro5.setText("P");
    pausaCarro6.setText("P");
    pausaCarro7.setText("P");
    pausaCarro8.setText("P");

    carro7Or.setVisible(false);
    sliderC7.setVisible(false);
    pausaCarro7.setVisible(false);
    carro8Br.setVisible(false);
    sliderC8.setVisible(false);
    pausaCarro8.setVisible(false);
    
    btCarro7.setVisible(true);
    btCarro8.setVisible(true);

    carro1.start();
    carro2.start();
    carro3.start();
    carro4.start();
    carro5.start();
    carro6.start();
    carro7.start();
    carro8.start();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    carro1 = new Carros(this, 6);
    carro2 = new Carros(this, 3);
    carro3 = new Carros(this, 7);
    carro4 = new Carros(this, 12);
    carro5 = new Carros(this, 13);
    carro6 = new Carros(this, 14);
    carro7 = new Carros(this, 22);
    carro8 = new Carros(this, 23);

    
    carro7Or.setVisible(false);
    sliderC7.setVisible(false);
    pausaCarro7.setVisible(false);
    carro8Br.setVisible(false);
    sliderC8.setVisible(false);
    pausaCarro8.setVisible(false);

    sliderC1.valueProperty().addListener(new ChangeListener<Number>() { // configurando slider do carro 1s
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        velocidadeCar1 = newValue.intValue();
      }

    });

    sliderC2.valueProperty().addListener(new ChangeListener<Number>() { // configurando slider do carro 2
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        velocidadeCar2 = newValue.intValue();
      }

    });

    sliderC3.valueProperty().addListener(new ChangeListener<Number>() { // configurando slider do carro 3
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        velocidadeCar3 = newValue.intValue();
      }

    });

    sliderC4.valueProperty().addListener(new ChangeListener<Number>() { // configurando slider do carro 4
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        velocidadeCar4 = newValue.intValue();
      }

    });

    sliderC5.valueProperty().addListener(new ChangeListener<Number>() { // configurando slider do carro 5
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        velocidadeCar5 = newValue.intValue();
      }

    });

    sliderC6.valueProperty().addListener(new ChangeListener<Number>() { // configurando slider do carro 6
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        velocidadeCar6 = newValue.intValue();
      }

    });

    sliderC7.valueProperty().addListener(new ChangeListener<Number>() { // configurando slider do carro 7
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        velocidadeCar7 = newValue.intValue();
      }

    });

    sliderC8.valueProperty().addListener(new ChangeListener<Number>() { // configurando slider do carro 8
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        velocidadeCar8 = newValue.intValue();
      }

    });

  }

  public int getVelocidadeCar1() {
    return velocidadeCar1;
  }

  public int getVelocidadeCar2() {
    return velocidadeCar2;
  }

  public int getVelocidadeCar3() {
    return velocidadeCar3;
  }

  public int getVelocidadeCar4() {
    return velocidadeCar4;
  }

  public int getVelocidadeCar5() {
    return velocidadeCar5;
  }

  public int getVelocidadeCar6() {
    return velocidadeCar6;
  }

  public int getVelocidadeCar7() {
    return velocidadeCar7;
  }

  public int getVelocidadeCar8() {
    return velocidadeCar8;
  }

  public ImageView getCarro1Ci() {
    return carro1Ci;
  }

  public ImageView getCarro2Ye() {
    return carro2Ye;
  }

  public ImageView getCarro3Re() {
    return carro3Re;
  }

  public ImageView getCarro4Bl() {
    return carro4Bl;
  }

  public ImageView getCarro5Gr() {
    return carro5Gr;
  }

  public ImageView getCarro6Wh() {
    return carro6Wh;
  }

  public ImageView getCarro7Or() {
    return carro7Or;
  }

  public ImageView getCarro8Br() {
    return carro8Br;
  }
}
