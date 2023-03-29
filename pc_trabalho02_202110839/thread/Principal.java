/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 20/03/2023
* Ultima alteracao.: 23/03/2023
* Nome.............: Principal.java
* Funcao...........: EH Responsavel pela inicializacao do programa. O programa é, em suma, a aplicação 
de threads em java com uma GUI de Arvore genealogica. Nele, vemos uma familia de 7 membros (7 threads) morrerem após determinado periodo 
(as threads sao stardadas e acabam em um tempo programado especifico de cada uma). 
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
    primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/telinha.png"))); // Adiciona um icone
                                                                                                    // ao programa
    primaryStage.setTitle("Arvore Genealogica"); // Nomeia o programa
    primaryStage.setScene(tela); // Carrega o Stage com a tela
    primaryStage.show(); // Exibe o programa
  }
}
