
/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 08/02/2023
* Ultima alteracao.: 14/02/2023
* Nome.............: TelaCadastro02Controller.java
* Funcao...........: Eh responsavel por lidar com eventos gerados pelos componentes da GUI LayoutCadastro02.fxml.
Ele tambem eh responsavel por atualizar a GUI com dados do programa e o programa com dados advindos da GUI. 
*******************************************************************/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

public class TelaCadastro02Controller {

  String nome; // a string nome sera usada para salvar na tela atual o nome definido pelo
               // usuario na tela anterior

  @FXML
  private Button btnContato; // botao contato

  @FXML
  private Button btnProximo; // botao para ir para a proxima tela (final)

  @FXML
  private ComboBox<Integer> comboDia; // combobox da escolha do dia

  @FXML
  private ComboBox<String> comboMes; // combobox da escolha do mes

  @FXML
  protected void initialize() { // cadastra eventos
    comboDia.getItems().addAll(
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
        18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31
      ); // setando os dias

    comboMes.getItems().addAll(
        "Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho",
        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
      ); // setando os meses

    Principal.addOnChangeScreenListener(new Principal.OnChangeScreen() { // evento para a troca de tela
      @Override
      public void OnScreenChanged(String newScreen, Object userData, Object userData2) {
        System.out.println("nova tela " + newScreen + " ," + userData + userData2);
        nome = (String) userData; // aloca o user data da telaCadastro01 na String nome
      }
    });
  }

  @FXML
  void clickMouseBack(MouseEvent event) { // metodo de interacao com o botao "home" da tela de cadastro02 da GUI
    try {
      Principal.changescreen("inicial"); // troca para a tela inicial
    } catch (Exception e) {
      e.getLocalizedMessage();
    }
    // limpa o combobox comboDia/ limpa o combobox comboMes
    comboDia.getSelectionModel().clearSelection();
    comboMes.getSelectionModel().clearSelection();
  }

  @FXML
  void entrarContato(ActionEvent event) { // metodo de interacao com o botao "contato" da tela cadastro02 da GUI
    try {
      Principal.changescreen("contato"); // troca para a tela contato
    } catch (Exception e) {
      e.getLocalizedMessage();
    }
    // limpa o combobox comboDia/ limpa o combobox comboMes
    comboDia.getSelectionModel().clearSelection();
    comboMes.getSelectionModel().clearSelection();
  }

  @FXML
  void entrarProxPergunta(ActionEvent event) { // metodo de interacao com o botao "proximo" da tela de cadastro02 da GUI
    Integer dia = comboDia.getSelectionModel().getSelectedItem(); // aloca a opcao da combobox dia escolhida pelo
                                                                  // usuario na variavel dia
    String mes = comboMes.getSelectionModel().getSelectedItem(); // aloca a opcao da combobox mes escolhida pelo usuario
                                                                 // na variavel mes
    String signo = ""; // inicializa a String signo como vazia

    // secao de ifs para descobrir o signo do usuario comparando as opcoes de dia e
    // mes escolhidas pelo +
    // mesmo com as datas de cada signo do zodiaco
    if (mes.equals("Dezembro") && dia > 21) {
      signo = "Capricornio";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }

    if (mes.equals("Janeiro") && dia <= 20) {
      signo = "Capricornio";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }

    if (mes.equals("Janeiro") && dia > 20) {
      signo = "Aquario";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }
    if (mes.equals("Fevereiro") && dia <= 18) {
      signo = "Aquario";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }

    if (mes.equals("Fevereiro") && dia > 18) {
      signo = "Peixes";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }
    if (mes.equals("Marco") && dia <= 20) {
      signo = "Peixes";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }

    if (mes.equals("Marco") && dia >= 21) {
      signo = "Aries";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }
    if (mes.equals("Abril") && dia <= 20) {
      signo = "Aries";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }

    if (mes.equals("Abril") && dia > 20) {
      signo = "Touro";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }
    if (mes.equals("Maio") && dia <= 20) {
      signo = "Touro";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }

    if (mes.equals("Maio") && dia > 20) {
      signo = "Gemeos";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }
    if (mes.equals("Junho") && dia <= 20) {
      signo = "Gemeos";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }

    if (mes.equals("Junho") && dia > 20) {
      signo = "Cancer";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }
    if (mes.equals("Julho") && dia <= 22) {
      signo = "Cancer";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }

    if (mes.equals("Julho") && dia > 22) {
      signo = "Leao";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }
    if (mes.equals("Agosto") && dia <= 22) {
      signo = "Leao";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }

    if (mes.equals("Agosto") && dia > 22) {
      signo = "Virgem";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }
    if (mes.equals("Setembro") && dia <= 22) {
      signo = "Virgem";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }

    if (mes.equals("Setembro") && dia > 22) {
      signo = "Libra";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }
    if (mes.equals("Outubro") && dia <= 22) {
      signo = "Libra";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }

    if (mes.equals("Outubro") && dia > 22) {
      signo = "Escorpiao";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }
    if (mes.equals("Novembro") && dia <= 21) {
      signo = "Escorpiao";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }

    if (mes.equals("Novembro") && dia > 21) {
      signo = "Sagitario";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }
    if (mes.equals("Dezembro") && dia <= 21) {
      signo = "Sagitario";
      Principal.changescreen("final", signo, nome); // troca para a tela final e passa, para ela, por parametro, as
                                                    // variaveis que armazenam o nome e o signo do usuario
      // limpa o combobox comboDia/ limpa o combobox comboMes
      comboDia.getSelectionModel().clearSelection();
      comboMes.getSelectionModel().clearSelection();
    }
  }

}
