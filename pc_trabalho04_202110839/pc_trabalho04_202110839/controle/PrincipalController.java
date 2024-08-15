/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 07/0/2023
* Ultima alteracao.: 13/05/2023
* Nome.............: PrincipalController.java
* Funcao...........: Eh responsavel por lidar com eventos gerados pelos componentes da GUI LayoutPrincipal.fxml.
Eh tambem responsavel por controlar eventos ocorridos nas classes pertencenetes ao pacote modelo, assim como por
atualizar a GUI com dados do programa e o programa com dados advindos da GUI. 
*******************************************************************/

package controle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import modelo.Consumidor;
import modelo.Produtor;
import modelo.VariaveisGlobais;

public class PrincipalController implements Initializable {
  // instanciando imagens e botoes da tela

  @FXML
  private ImageView balaoCozinhando;

  @FXML
  private ImageView balaoComendo;

  @FXML
  private ImageView balaoEntregando;

  @FXML
  private ImageView balaoEsperando;

  @FXML
  private ImageView comida;

  @FXML
  private ImageView comida2;

  @FXML
  private ImageView comida3;

  @FXML
  private ImageView comida4;

  @FXML
  private ImageView cozinheiroCostas;

  @FXML
  private ImageView cozinheirofrente;

  @FXML
  private Button rein;

  @FXML
  private Slider sliderChef;

  @FXML
  private Slider sliderCliente;

  @FXML
  private Button iniciar;

  @FXML
  private Button pausaChef;

  @FXML
  private Button pausaCliente;

 private int  sliderChefAux; //velocidades do slide cliente
 private int sliderClienteAux; //velocidades do slide cliente
  // fim
  private Produtor prod; // instanciando produtor
  private Consumidor cons; // intanciando consumidor

  @FXML
  void iniciar(ActionEvent event) { // metodo de acoes que ocorrem ao clicar no botao iniciar
    prod = new Produtor(this); // instanciando produtor
    cons = new Consumidor(this); // intanciando consumidor
    prod.start(); // dando start na thread produtor
    cons.start(); // dando start na thread consumidor
  }

  @FXML
  void pausaChefAction(ActionEvent event) { // metodo de acoes que ocorrem ao clicar no botao pausaChef
    if (pausaChef.getText().equals("Play")) { // verifica se o botao esta com o texto "Play"
      prod.resume(); // faz a thread voltar a funcionar apos o pause
      pausaChef.setText("Pausar"); // define o texto do botao como "Pausar"
    } else {
      pausaChef.setText("Play"); // define o texto do botao com "play"
      prod.suspend(); // pausa a thread
    }
  }

  @FXML
  void pausaClienteAction(ActionEvent event) { // metodo de acoes que ocorrem ao clicar no botao pausaCliente
    if (pausaCliente.getText().equals("Play")) { // verifica se o botao esta com o texto "Play"
      cons.resume(); // faz a thread voltar a funcionar apos o pause
      pausaCliente.setText("Pausar"); // define o texto do botao como "Pausar"
    } else {
      pausaCliente.setText("Play"); // define o texto do botao com "play"
      cons.suspend(); // pausa a thread
    }
  }

  @FXML
  void reiniciar(ActionEvent event) { // reinicia todo o programa
    prod.stop(); // para a thread produtor
    cons.stop(); // para a thread consumidor
    prod = new Produtor(this); // instancia a classe produtor
    cons = new Consumidor(this); // instancia a classe consumidor
    comida.setVisible(false); // define como falsa a visibilidade da comida
    comida2.setVisible(false); // define como falsa a visibilidade da comida2
    comida3.setVisible(false); // define como falsa a visibilidade da comida3
    comida4.setVisible(false); // define como falsa a visibilidade da comida4
    balaoComendo.setVisible(false); // define como falsa a visibilidade do balao comendo
    balaoCozinhando.setVisible(false); // define como falsa a visibilidade do balao cozinhando
    balaoEntregando.setVisible(false); // define como falsa a visibilidade do balao entregando
    balaoEsperando.setVisible(false);// define como falsa a visibilidade do balao esperando
    cozinheirofrente.setVisible(false); // define como falsa a visibilidade do cozinheiro de frente
    VariaveisGlobais.setMutex(1); // define como 1 o semaforo mutex
    VariaveisGlobais.setVazio(4); // define como 4 o espaco do semaforo vazio
    VariaveisGlobais.setCheio(0); // define como 0 o semaforo cheio
    sliderChef.setValue(0);
    sliderCliente.setValue(0);
    pausaChefAction(event);
    pausaClienteAction(event);

    prod.start(); // dando start na thread produtor
    cons.start(); // // dando start na thread consumidor

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) { // metodo que define o que vai ser iniciado ou nao
                                                                   // primordialmente
    comida.setVisible(false); // define como falsa a visibilidade da comida
    comida2.setVisible(false); // define como falsa a visibilidade da comida2
    comida3.setVisible(false); // define como falsa a visibilidade da comida3
    comida4.setVisible(false); // define como falsa a visibilidade da comida4
    balaoComendo.setVisible(false); // define como falsa a visibilidade do balao comendo
    balaoCozinhando.setVisible(false); // define como falsa a visibilidade do balao cozinhando
    balaoEntregando.setVisible(false); // define como falsa a visibilidade do balao entregando
    balaoEsperando.setVisible(false); // define como falsa a visibilidade do balao esperando
    cozinheirofrente.setVisible(false); // define como falsa a visibilidade do cozinheiro de frente

    sliderChef.valueProperty().addListener(new ChangeListener<Number>() { //configurando slider do chef

      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        sliderChefAux = newValue.intValue();
      }
      
    }); 

    sliderCliente.valueProperty().addListener(new ChangeListener<Number>() { //configurando slider do cliente

      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        sliderClienteAux = newValue.intValue();
      }
      
    });
  }


  public ImageView getCozinheiroCostas() { // retorna o cozinheiro costas
    return cozinheiroCostas;
  }

  public ImageView getCozinheirofrente() { // retorna o cozinheiro frente
    return cozinheirofrente;
  }

  public ImageView getComida() { // retorna a comida
    return comida;
  }

  public ImageView getComida2() { // retorna a comida 2
    return comida2;
  }

  public ImageView getComida3() { // retorna a comida 3
    return comida3;
  }

  public ImageView getComida4() { // retorna a comida 4
    return comida4;
  }

  public ImageView getBalaoComendo() { // retorna o balao comendo
    return balaoComendo;
  }

  public ImageView getBalaoCozinhando() { // retorna o balao cozinhando
    return balaoCozinhando;
  }

  public ImageView getBalaoEntregando() { // retorna o balao entregando
    return balaoEntregando;
  }

  public ImageView getBalaoEsperando() { // retorna o balao esperando
    return balaoEsperando;
  }
  public int getSliderClienteAux() { // retorna o slider cliente aux
      return sliderClienteAux;
  }

  public int getSliderChefAux() { // retorna o slider chef aux
      return sliderChefAux;
  }


}
