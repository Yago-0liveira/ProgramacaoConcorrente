/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 18/04/2023
* Ultima alteracao.: 22/04/2023
* Nome.............: Principal.java
* Funcao...........: Eh Responsavel pela inicializacao do programa. O programa eh, em suma, a aplicação 
de threads em java utilizando a estrita alternancia para evitar que mais de um trem acesse uma regiao na GUI.   
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
    Parent root = FXMLLoader.load(getClass().getResource("/visao/LayoutPrincipal.fxml")); // carrega a tela fxml
    Scene scene = new Scene(root); // Carrega a tela com o root
    primaryStage.setTitle("Java Trens"); // nomeia a tela
    primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/visao/imagens/imagem programa.png"))); // adiciona
                                                                                                                      // uma imagem ao programa                                                                                                             
    primaryStage.setScene(scene); // Carrega o Stage com a tela
    primaryStage.setResizable(false); // nao permite ao usuario mudar o tamanho da tela
    primaryStage.show(); // apresenta a tela

    primaryStage.setOnCloseRequest(Event -> {
      System.exit(0);
    });
  }
}
