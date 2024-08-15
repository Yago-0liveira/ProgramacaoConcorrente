/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 26/05/2023
* Ultima alteracao.: 05/06/2023
* Nome.............: Principal.java
* Funcao...........: Eh Responsavel pela inicializacao do programa. O programa eh, em suma, a aplicacao 
de threads em java utilizando semaforos para resolver o problema do transito, ou seja fazer com que 
os 8 carros (no meu caso 6) respeitem uns aos outros em questão dos seus percursos e nao apresentem condiçoes
de corrida entre eles. 
******************************************************************/

import controle.PrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Principal extends Application {
  public static void main(String[] args) throws Exception {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception { 
    PrincipalController control = new PrincipalController();
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/visao/LayoutPrincipal.fxml")); // Carrega a tela
                                                                                                   // fxml
    Parent root = fxmlLoader.load(); // Carrega a cena com a tela fxml
    Scene tela = new Scene(root); // Carrega a tela com o root

    primaryStage.resizableProperty().setValue(Boolean.FALSE); // Nao permite que o usuario altere o tamanho da tela
     primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("visao/imagens/semafofo.png"))); //Adiciona um icone ao programa
    primaryStage.setTitle("Transito"); // Nomeia o programa
    primaryStage.setScene(tela); // Carrega o Stage com a tela
    primaryStage.show(); // Exibe o programa
  }
}
