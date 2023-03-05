
/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 08/02/2023
* Ultima alteracao.: 14/02/2023
* Nome.............: HoroscopoController.java
* Funcao...........: Eh responsavel por lidar com eventos gerados pelos componentes da GUI LayoutHoroscopo.fxml.
Ele tambem eh responsavel por atualizar a GUI com dados do programa e vice-versa.
*******************************************************************/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class HoroscopoController {

  @FXML
  private Button btnContato; // botao contato

  @FXML
  void clickMouseBack(MouseEvent event) { // metodo de interacao com o botao "home" da tela de signos do zodiaco da GUI
    try {
      Principal.changescreen("inicial"); // troca para a tela inicial
    } catch (Exception e) {
      e.getLocalizedMessage();
    }
  }

  @FXML
  void entrarContato(ActionEvent event) { // metodo de interacao com o botao "contato" e signos do zodiaco da GUI
    try {
      Principal.changescreen("contato"); // troca para a tela contato
    } catch (Exception e) {
      e.getLocalizedMessage();
    }
  }

}
