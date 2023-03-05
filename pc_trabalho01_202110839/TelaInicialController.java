
/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 07/02/2023
* Ultima alteracao.: 14/02/2023
* Nome.............: TelaInicialController.java
* Funcao...........: Eh responsavel por lidar com eventos gerados pelos componentes da GUI LayoutInicial.fxml.
Ele tambem eh responsavel por atualizar a GUI com dados do programa e o programa com dados advindos da GUI. 
*******************************************************************/
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaInicialController {

  @FXML
  private Button btnComecar; // botao comecar

  @FXML
  private Button btnContato; // botao contato

  @FXML
  private Button btnhoroscop; // botao horoscopo

  @FXML
  void entrarSigno(ActionEvent event) throws IOException { // metodo de interacao com o botao "comecar" da tela inicial
                                                           // da GUI
    try {
      Principal.changescreen("cadastro01"); // troca para a primeira tela de cadastro
    } catch (Exception e) {
      e.getLocalizedMessage();
    }
  }

  @FXML
  void entrarContato(ActionEvent event) throws IOException { // metodo de interacao com o botao "contato" da tela
                                                             // inicial da GUI
    try {
      Principal.changescreen("contato"); // troca para a tela contato
    } catch (Exception e) {
      e.getLocalizedMessage();
    }
  }

  @FXML
  void entrarHoroscop(ActionEvent event) throws IOException { // metodo de interacao com o botao "conheca os 12 signos
                                                              // do zodiaco" da tela inicial da GUI
    try {
      Principal.changescreen("horoscopo"); // troca para a tela horoscopo
    } catch (Exception e) {
      e.getLocalizedMessage();
    }
  }

}
