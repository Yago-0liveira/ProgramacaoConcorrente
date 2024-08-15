/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 18/04/2023
* Ultima alteracao.: 22/04/2023
* Nome.............: PrincipalController.java
* Funcao...........: Eh responsavel por lidar com eventos gerados pelos componentes da GUI LayoutPrincipal.fxml.
Eh tambem responsavel por controlar eventos ocorridos nas classes pertencenetes ao pacote modelo, assim como por
atualizar a GUI com dados do programa e o programa com dados advindos da GUI. 
*******************************************************************/


package controle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import modelo.ThreadTrem1;
import modelo.ThreadTrem2;

public class PrincipalController implements Initializable {

  @FXML
  private Button aumentaTrem1;

  @FXML
  private Button aumentaTrem2;

  @FXML
  private Button diminuiTrem2;

  @FXML
  private Button diminuitrem1;
  @FXML
  private ImageView nome;
  @FXML
  private ImageView iconet1;

  @FXML
  private ImageView iconet2;

  @FXML
  private Button idComecar;

  @FXML
  private ChoiceBox<String> idPosicao;

  @FXML
  private ChoiceBox<String> idTipo;

  @FXML
  private ImageView trem1;

  @FXML
  private ImageView trem2;

  private boolean ponte1 = true; // define a ponte 1 como livre
  private boolean ponte2 = true; // define a ponte 2 como livre
  private ThreadTrem1 t1;
  private ThreadTrem2 t2;

  @FXML
  void Comecar(ActionEvent event) { // eventos associados ao botao começar
    t1 = new ThreadTrem1(this);
    t2 = new ThreadTrem2(this);
    trem1.setVisible(true);
    trem2.setVisible(true);
    t1.start(); // dando start ao trem 1
    t2.start(); // dando start ao trem 2

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) { // inicializar funções básicas para o funcionameno do
                                                                   // codigo
    t1 = new ThreadTrem1(this);
    t2 = new ThreadTrem2(this);

    trem1.setVisible(false); // altera a visibilidade do trem1
    trem2.setVisible(false); // altera a visibilidade do trem2

    aumentaTrem1.setOnMouseClicked(Event -> {
      t1.aumentaVelocidade(); // aumenta velocidade do trem 1
    });
    aumentaTrem2.setOnMouseClicked(Event -> {
      t2.aumentaVelocidade(); // aumenta velocidade do trem 2
    });
    diminuitrem1.setOnMouseClicked(event -> {
      t1.diminuiVelocidade(); // diminui velocidade do trem 1
    });
    diminuiTrem2.setOnMouseClicked(event -> {
      t2.diminuiVelocidade(); // diminui velocidade do trem 2
    });

  }

  public ImageView getTrem1() { // retorna o trem 1
    return trem1;
  }

  public ImageView getTrem2() { // retorna o trem 2
    return trem2;
  }

  public boolean isPonte1() {
    return ponte1; // retorna se a ponte esta livre
  }

  public boolean isPonte2() {
    return ponte2; // retorna se a ponte esta livre
  }

  public void setPonte1(boolean ponte1) {
    this.ponte1 = ponte1; // define se a ponte esta livre ou nao
  }
  public void setPonte2(boolean ponte2) {
    this.ponte2 = ponte2; // define se a ponte esta livre ou nao
  }


}
