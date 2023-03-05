/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 07/02/2023
* Ultima alteracao.: 14/02/2023
* Nome.............: Principal.java
* Funcao...........: EH Responsavel pela inicializacao do programa e pela troca das cenas (telas). O programa eh uma aplicacao
que, atraves de dados passados pelo usuario, descobre qual eh o signo do mesmo e exibe as informacoes e imagens sobre este signo.
 Eh tambem possivel conhecer os 12 signos do horoscopo, entrar em contato com o desenvolvedor e navegar entre 6 telas.   
******************************************************************/

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Principal extends Application {
  // Instanciando as classes controller para que seja possivel compilar as classes
  ContatoController ct = new ContatoController();
  HoroscopoController hc = new HoroscopoController();
  TelaInicialController ti = new TelaInicialController();
  TelaCadastro01Controller tc1 = new TelaCadastro01Controller();
  TelaCadastro02Controller tc2 = new TelaCadastro02Controller();
  TelaFinalController tf = new TelaFinalController();

  public static void main(String[] args) {
    launch(args);
  }

  private static Stage stage; // Auxilia na navegacao das telas
  private static Scene inicialScene; // tela inicial
  private static Scene cadastro01Scene; // tela de cadastro 1
  private static Scene cadastro02Scene; // tela de cadastro 2
  private static Scene horoscopoScene; // tela dos signos
  private static Scene contatoScene; // tela do contato
  private static Scene finalScene; // tela final

  @Override
  public void start(Stage primaryStage) throws Exception {
    stage = primaryStage;
    // Configurando alguns dados da tela
    primaryStage.setTitle("Yastrologia - descubra seu signo"); // nomeia a tela
    primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("telinha.png")));
    primaryStage.resizableProperty().setValue(Boolean.FALSE); // nao deixa o usuario alterar o tamanho da tela

    // Carregando os arquivos das telas/ fazendo o casting das telas
    Parent fxmlInicial = FXMLLoader.load(getClass().getResource("LayoutInicial.fxml"));
    inicialScene = new Scene(fxmlInicial);
    Parent fxmlCadastro01 = FXMLLoader.load(getClass().getResource("LayoutCadastro01.fxml"));
    cadastro01Scene = new Scene(fxmlCadastro01);
    Parent fxmlCadastro02 = FXMLLoader.load(getClass().getResource("LayoutCadastro02.fxml"));
    cadastro02Scene = new Scene(fxmlCadastro02);
    Parent fxmlHoroscopo = FXMLLoader.load(getClass().getResource("LayoutHoroscopo.fxml"));
    horoscopoScene = new Scene(fxmlHoroscopo);
    Parent fxmlContato = FXMLLoader.load(getClass().getResource("LayoutContato.fxml"));
    contatoScene = new Scene(fxmlContato);
    Parent fxmlFinal = FXMLLoader.load(getClass().getResource("LayoutFinal.fxml"));
    finalScene = new Scene(fxmlFinal);

    // Definindo a cena inicial
    primaryStage.setScene(inicialScene);
    primaryStage.show();

  }

  // realiza a troca de telas e passa por parametro os dados que nela existem
  public static void changescreen(String cg, Object userData, Object userdata2) {
    switch (cg) {
      case "inicial": // quando cg == "inicial" a tela eh trocada para a inicial
        stage.setScene(inicialScene);
        notifyAllListners("Inicial", userData, userdata2); // carrega os listeners e avisa sobre as mudancas
        break;
      case "cadastro01": // quando cg == "cadastro01" a tela eh trocada para a cadastro01
        stage.setScene(cadastro01Scene);
        notifyAllListners("cadastro01", userData, userdata2); // carrega os listeners e avisa sobre as mudancas
        break;
      case "cadastro02": // quando cg == "cadastro02" a tela eh trocada para a cadastro02
        stage.setScene(cadastro02Scene);
        notifyAllListners("cadastro02", userData, userdata2); // carrega os listeners e avisa sobre as mudancas
        break;
      case "horoscopo": // quando cg == "horoscopo" a tela eh trocada para a horoscopo
        stage.setScene(horoscopoScene);
        notifyAllListners("horoscopo", userData, userdata2); // carrega os listeners e avisa sobre as mudancas
        break;
      case "contato": // quando cg == "contato" a tela eh trocada para a contato
        stage.setScene(contatoScene);
        notifyAllListners("contato", userData, userdata2); // carrega os listeners e avisa sobre as mudancas
        break;
      case "final": // quando cg == "final" a tela eh trocada para a final
        stage.setScene(finalScene);
        notifyAllListners("final", userData, userdata2);// carrega os listeners e avisa sobre as mudancas

    }
  }

  // sobrecarga do changescreen para somente trocar a tela e passar um dado
  public static void changescreen(String cg, Object userData) {
    changescreen(cg, userData, null);
  }

  // sobrecarga do changescreen para somente trocar a tela, sem passar nenhum dado
  public static void changescreen(String cg) {
    changescreen(cg, null, null);
  }

  private static ArrayList<OnChangeScreen> listeners = new ArrayList<>(); // ArrayList de armazenamento de listeners da
                                                                          // troca de telas

  public static interface OnChangeScreen { // avisa sobre a troca de telas
    void OnScreenChanged(String newScreen, Object userData, Object userData2);
  }

  public static void addOnChangeScreenListener(OnChangeScreen onChangeScreen) { // adiciona listeners no arraylist
    listeners.add(onChangeScreen);
  }

  private static void notifyAllListners(String newScreen, Object userData, Object userData2) { // envia aos listeners
                                                                                               // contidos no arraylist
                                                                                               // informacoes
    for (OnChangeScreen l : listeners) // sobre as telas (cenas e passagens)
      l.OnScreenChanged(newScreen, userData, userData2);
  }
}
