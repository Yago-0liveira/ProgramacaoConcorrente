/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 07/02/2023
* Ultima alteracao.: 14/02/2023
* Nome.............: TelaCadastro01Controller.java
* Funcao...........: Eh responsavel por lidar com eventos gerados pelos componentes da GUI LayoutCadastro01.fxml.
Ele tambem eh responsavel por atualizar a GUI com dados do programa  e o programa com dados advindos da GUI. 
*******************************************************************/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class TelaCadastro01Controller {

  @FXML
  private Button btnContato; // botao contato

  @FXML
  private Button btnProximo; // botao para ir para a proxima tela (cadastro 02)

  @FXML
  private TextField campNome; // Usuario deve inserir o nome neste local

  @FXML
  void clickMouseBack(MouseEvent event) { // metodo de interacao com o botao "home" da tela de cadastro01 da GUI
    try {
      Principal.changescreen("inicial"); // troca para a tela inicial
    } catch (Exception e) {
      e.getLocalizedMessage();
    }
    campNome.clear(); // limpa a caixa de texto apos a troca de tela
  }

  @FXML
  void entrarContato(ActionEvent event) { // metodo de interacao com o botao "contato" da tela cadastro01 da GUI
    try {
      Principal.changescreen("contato"); // troca para a tela contato
    } catch (Exception e) {
      e.getLocalizedMessage();
    }
    campNome.clear(); // limpa a caixa de texto apos a troca de tela
  }

  @FXML
  void clickMouseEntrar(MouseEvent event) { // metodo de interacao com o botao "proximo" da tela de cadastro 01 da GUI
    String nome = campNome.getText(); // a string nome recebera o nome que o usuario informar na GUI

    if (nome.isEmpty() == false) {
      String tramop = nome;
      tramop = tramop.replaceAll("\\s", "");
      if (tramop.isEmpty() == false) {
        Principal.changescreen("cadastro02", nome, null); // os ifs so permitem a troca para a tela cadastro02 se +
      } // o texto estiver preenchido com um nome (nao adiantta dar espaco) +
    } // vemos a chamada da troca de tela + a passagem de um dado por parametro
    campNome.clear(); // limpa a caixa de texto apos a troca de tela
  }

}
