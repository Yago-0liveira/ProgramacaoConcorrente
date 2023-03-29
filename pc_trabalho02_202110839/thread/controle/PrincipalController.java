/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 20/03/2023
* Ultima alteracao.: 23/03/2023
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import modelo.ThreadPai;

public class PrincipalController implements Initializable {
  @FXML
  private ImageView ImageLBisneto = new ImageView();

  @FXML
  private ImageView ImageLFilho1 = new ImageView();

  @FXML
  private ImageView ImageLFilho2 = new ImageView();

  @FXML
  private ImageView ImageLFilho3 = new ImageView();

  @FXML
  private ImageView ImageLNeto1 = new ImageView();

  @FXML
  private ImageView ImageLNeto2 = new ImageView();

  @FXML
  private ImageView ImageLPai = new ImageView();

  @FXML
  private ImageView bisneto = new ImageView();

  @FXML
  private ImageView filho1 = new ImageView();

  @FXML
  private ImageView filho2 = new ImageView();

  @FXML
  private ImageView filho3 = new ImageView();

  @FXML
  private ImageView neto1 = new ImageView();

  @FXML
  private ImageView neto2 = new ImageView();

  @FXML
  private ImageView paii = new ImageView();

  @FXML
  private ImageView cBisneto;

  @FXML
  private ImageView cFilho1;

  @FXML
  private ImageView cFilho2;

  @FXML
  private ImageView cFilho3;

  @FXML
  private ImageView cNeto1;

  @FXML
  private ImageView cNeto2;

  @FXML
  private ImageView cPai;

  @FXML
  private Text iddFilho1;

  @FXML
  private Text iddFilho2;

  @FXML
  private Text iddFilho3;

  @FXML
  private Text iddNeto1;

  @FXML
  private Text iddNeto2;

  @FXML
  private Text iddPai;

  @FXML
  private Text iddbisneto;

  @FXML
  private ImageView imageNotas;

  @FXML
  private Text textFamilia;

  @FXML
  private Button bottonIniciar;

  public void pai(int moment) { // Metodo para adicionar as 6 imagens que o pai terá durante a vida
    Image image = null;

    switch (moment) {
      case 1:
        image = new Image("/imagens/PaiBebe.png");
        break;

      case 2:
        image = new Image("/imagens/PaiCrianca.png");
        break;

      case 3:
        image = new Image("/imagens/PaiAdolescente.png");
        break;

      case 4:
        image = new Image("/imagens/PaiAdulto.png");
        break;

      case 5:
        image = new Image("/imagens/PaiIdoso.png");
        break;

      default:
        image = new Image("/imagens/vazio.png");
        ImageLPai.setImage(new Image("/imagens/LapidePai.png"));
        break;
    }
    paii.setImage(image); // O imageview pai recebe o atributo image (que esta recebendo as imagens dentro
                          // dos cases)
  }

  public void filho1(int moment) { // Metodo para adicionar as 6 imagens que o filho1 terá durante a vida
    Image image = null;

    switch (moment) {
      case 1:
        image = new Image("/imagens/Filho1Bebe.png");
        break;

      case 2:
        image = new Image("/imagens/Filho1Crianca.png");
        break;

      case 3:
        image = new Image("/imagens/Filho1Adolescente.png");
        break;

      case 4:
        image = new Image("/imagens/Filho1Adulto.png");
        break;

      case 5:
        image = new Image("/imagens/Filho1Idoso.png");
        break;

      default:
        image = new Image("/imagens/vazio.png");
        ImageLFilho1.setImage(new Image("/imagens/LapideFIlho1.png"));
        break;

    }
    filho1.setImage(image); // O imageview filho1 recebe o atributo image (que esta recebendo as imagens
                            // dentro dos cases)
  }

  public void filha2(int moment) { // Metodo para adicionar as 6 imagens que o filho2 terá durante a vida
    Image image = null;

    switch (moment) {
      case 1:
        image = new Image("/imagens/Filha2bebe.png");
        break;

      case 2:
        image = new Image("/imagens/Filha2crianca.png");
        break;

      case 3:
        image = new Image("/imagens/Filha2adolescente.png");
        break;

      case 4:
        image = new Image("/imagens/Filha2Adulta.png");
        break;

      case 5:
        image = new Image("/imagens/Filha2Idosa.png");
        break;

      default:
        image = new Image("/imagens/vazio.png");
        ImageLFilho2.setImage(new Image("/imagens/LapideFilho2.png"));
        break;
    }
    filho2.setImage(image); // O imageview filho2 recebe o atributo image (que esta recebendo as imagens
                            // dentro dos cases)
  }

  public void filho3(int moment) { // Metodo para adicionar as 6 imagens que o filho3 terá durante a vida
    Image image = null;

    switch (moment) {
      case 1:
        image = new Image("/imagens/Filho3Bebe.png");
        break;

      case 2:
        image = new Image("/imagens/Filho3Crianca.png");
        break;

      case 3:
        image = new Image("/imagens/Filho3Adolescente.png");
        break;

      case 4:
        image = new Image("/imagens/Filho3Adulto.png");
        break;

      case 5:
        image = new Image("/imagens/Filho3Idoso.png");
        break;

      default:
        image = new Image("/imagens/vazio.png");
        ImageLFilho3.setImage(new Image("/imagens/LapideFilho3.png"));
        break;
    }
    filho3.setImage(image); // O imageview filho3 recebe o atributo image (que esta recebendo as imagens
                            // dentro dos cases)
  }

  public void neto1(int moment) { // Metodo para adicionar as 6 imagens que o neto1 terá durante a vida
    Image image = null;

    switch (moment) {
      case 1:
        image = new Image("/imagens/Neto1Crianca.png");
        break;

      case 2:
        image = new Image("/imagens/Neto1Crianca.png");
        break;

      case 3:
        image = new Image("/imagens/Neto1Adolescente.png");
        break;

      case 4:
        image = new Image("/imagens/Neto1Adulto.png");
        break;

      default:
        image = new Image("/imagens/vazio.png");
        ImageLNeto1.setImage(new Image("/imagens/LapideNeto1.png"));
        break;
    }
    neto1.setImage(image); // O imageview neto1 recebe o atributo image (que esta recebendo as imagens
                           // dentro dos cases)
  }

  public void neto2(int moment) { // Metodo para adicionar as 5 imagens que o neto2 terá durante a vida
    Image image = null;

    switch (moment) {
      case 1:
        image = new Image("/imagens/Neto2Bebe.png");
        break;

      case 2:
        image = new Image("/imagens/Neto2Crianca.png");
        break;

      case 3:
        image = new Image("/imagens/Neto2Adolescente.png");
        break;

      case 4:
        image = new Image("/imagens/Neto2Adulto.png");
        break;

      default:
        image = new Image("/imagens/vazio.png");
        ImageLNeto2.setImage(new Image("/imagens/LapideNeto2.png"));
        break;
    }
    neto2.setImage(image); // O imageview neto2 recebe o atributo image (que esta recebendo as imagens
                           // dentro dos cases)
  }

  public void bisneto(int moment) { // <Metodo para adicionar as 3 imagens que o bisneto terá durante a vida
    Image image = null;

    switch (moment) {
      case 1:
        image = new Image("/imagens/BisnetoBebe.png");
        break;

      case 2:
        image = new Image("/imagens/BisnetoCrianca.png");
        break;

      default:
        image = new Image("/imagens/vazio.png");
        ImageLBisneto.setImage(new Image("/imagens/LapideBisneto.png"));
        break;
    }
    bisneto.setImage(image); // O imageview bisneto recebe o atributo image (que esta recebendo as imagens
                             // dentro dos cases)
  }

  public void deadP(int d) { // Metodo para adicionar o simbolo de morte ao contador do pai
    Image image = null;
    switch (d) {
      case 1:
        image = new Image("/imagens/morte.png");
        break;
    }
    cPai.setImage(image); // O imageview cPai recebe o atributo image (que esta recebendo a imagem dentro
                          // do case)
  }

  public void deadF1(int d) { // Metodo para adicionar o simbolo de morte ao contador do filho1
    Image image = null;
    switch (d) {
      case 1:
        image = new Image("/imagens/morte.png");
        break;
    }
    cFilho1.setImage(image); // O imageview cFilho1 recebe o atributo image (que esta recebendo a imagem
                             // dentro do case)
  }

  public void deadF2(int d) { // Metodo para adicionar o simbolo de morte ao contador do filho2
    Image image = null;
    switch (d) {
      case 1:
        image = new Image("/imagens/morte.png");
        break;
    }
    cFilho2.setImage(image); // O imageview cFilho2 recebe o atributo image (que esta recebendo a imagem
                             // dentro do case)
  }

  public void deadF3(int d) { // Metodo para adicionar o simbolo de morte ao contador do filho3
    Image image = null;
    switch (d) {
      case 1:
        image = new Image("/imagens/morte.png");
        break;
    }
    cFilho3.setImage(image); // O imageview cFilho3 recebe o atributo image (que esta recebendo a imagem
                             // dentro do case)
  }

  public void deadN1(int d) { // Metodo para adicionar o simbolo de morte ao contador do neto1
    Image image = null;
    switch (d) {
      case 1:
        image = new Image("/imagens/morte.png");
        break;
    }
    cNeto1.setImage(image); // O imageview cNeto1 recebe o atributo image (que esta recebendo a imagem
                            // dentro do case)
  }

  public void deadN2(int d) { // Metodo para adicionar o simbolo de morte ao contador do neto1
    Image image = null;
    switch (d) {
      case 1:
        image = new Image("/imagens/morte.png");
        break;
    }
    cNeto2.setImage(image); // O imageview cNeto2 recebe o atributo image (que esta recebendo a imagem
                            // dentro do case)
  }

  public void deadB(int d) { // Metodo para adicionar o simbolo de morte ao contador do bisneto
    Image image = null;
    switch (d) {
      case 1:
        image = new Image("/imagens/morte.png");
        break;
    }
    cBisneto.setImage(image); // O imageview cBisneto recebe o atributo image (que esta recebendo a imagem
                              // dentro do case)
  }

  public void idadePai(int idade) { // Metodo para contar em tempo real o tempo corrido da vida do pai
    iddPai.setText("(" + String.valueOf(idade) + ")"); // Adicionando ao text iddpai o tempo corrido

  }

  public void idadeFilho1(int idade) { // Metodo para contar em tempo real o tempo corrido da vida do filho1
    iddFilho1.setText("(" + String.valueOf(idade) + ")"); // Adicionando ao text iddFilho1 o tempo corrido
  }

  public void idadeFilho2(int idade) { // Metodo para contar em tempo real o tempo corrido da vida do filho2
    iddFilho2.setText("(" + String.valueOf(idade) + ")"); // Adicionando ao text iddFilho2 o tempo corrido
  }

  public void idadeFilho3(int idade) { // Metodo para contar em tempo real o tempo corrido da vida do filho3
    iddFilho3.setText("(" + String.valueOf(idade) + ")"); // Adicionando ao text iddFilho3 o tempo corrido
  }

  public void idadeNeto1(int idade) { // Metodo para contar em tempo real o tempo corrido da vida do neto1
    iddNeto1.setText("(" + String.valueOf(idade) + ")"); // Adicionando ao text iddNeto1 o tempo corrido
  }

  public void idadeNeto2(int idade) { // Metodo para contar em tempo real o tempo corrido da vida do neto2
    iddNeto2.setText("(" + String.valueOf(idade) + ")"); // Adicionando ao text iddNeto2 o tempo corrido
  }

  public void idadeBisneto(int idade) { // Metodo para contar em tempo real o tempo corrido da vida do bisneto
    iddbisneto.setText("(" + String.valueOf(idade) + ")"); // Adicionando ao text iddBisneto o tempo corrido
  }

  @FXML
  void clicouStart(ActionEvent event) { // Botao para iniciar o programa
    ThreadPai pai = new ThreadPai(); // //Instanciando a classe ThreadPai
    pai.start(); // Iniciando a thread pai
    pai.setWindow(this); // Passando a classe PrincipalController para a classe ThreadPai
    bottonIniciar.setVisible(false); // Settando o botao iniciar como "invisivel" ao startar o programa
    textFamilia.setVisible(true); // Deixando a familia (contador) visivel apos o start
    imageNotas.setVisible(true); // Deixando a imagem (contador) visivel apos o start

  }

  @Override
  public void initialize(URL url, ResourceBundle rb) { // Metodo inicializador do controlador
    textFamilia.setVisible(false); // Deixando a familia (contador) invisivel antes do start
    imageNotas.setVisible(false); // Deixando a imagem (contador) invisivel antes do start
    bottonIniciar.setVisible(true); // Settando o botao iniciar como "visivel" antes de startar o programa
  }

}
