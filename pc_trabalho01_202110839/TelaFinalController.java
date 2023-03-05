/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 09/02/2023
* Ultima alteracao.: 14/02/2023
* Nome.............: TelaFinalController.java
* Funcao...........: Eh responsavel por lidar com eventos gerados pelos componentes da GUI LayoutFinal.fxml.
Ele tambem eh responsavel por atualizar a GUI com dados do programa e vice-versa.
*******************************************************************/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TelaFinalController {

  @FXML
  private ImageView ImageSigno; // imagem do signo do usuario
  @FXML
  private Button btnContato; // botao contato
  @FXML
  private Label signoMensagem; // mensagem sobre o signo do usuario
  @FXML
  private Label nomeid; // mensagem que aparecerá o nome do usuario que foi digitado na tela cadastro01

  @FXML
  protected void initialize() {
    Principal.addOnChangeScreenListener(new Principal.OnChangeScreen() { // cadastra eventos
      @Override
      public void OnScreenChanged(String newScreen, Object userData, Object userData2) { // evento para a troca de tela
        System.out.println("Nova tela" + newScreen + " ," + userData + userData2);
        String nome = (String) userData2; // aloca o user data da telaCadastro01 na String nome
        nomeid.setText(nome); // setta o texto nomeid como o nome do usuario
        String signo = (String) userData; // aloca o signo derivado dos dados fornecidos pelo usuario na segunda tela na variacvel signo
  
          // Esses ifs definem a mensagem e a imagem que aparecerao na tela do usuario (signoMensagem e ImagemSigno, respectivamente) +
          // dependendo do signo de cada usuario
        if (signo.equals("Capricornio")) {
          signoMensagem.setText(
            "Capricornio eh um dos signos mais julgados do zodiaco. Sem querer inserir trocadilhos, mas, por coincidencia, Capricornio eh o proprio signo ligado ao julgamento," +
            " Capricornianos pensam no longo prazo e nao tem problema nenhum em deixar os pequenos prazeres para depois do trabalho importante. Capricornio pensa muito sobre tudo o que eh necessario" +
            " para a estabilidade durar para sempre. ");
  
          ImageSigno.setImage(new Image("capricorniof.png"));
        }

        if (signo.equals("Aquario")) {
          signoMensagem.setText(
            "Aquario eh o signo ligado ao novo, ao futuro, a tecnologia, a liberdade e a tudo que eh diferente. Ele veio para questionar e renovar tudo o que veio antes dele, e" +
            " muitas vezes, pensando em como essas mudancas afetariam a sociedade. Inovador, racional, rapido e imprevisivel, ele ri da cara das regras e detesta a sensacao de estar preso a algo.");
    
          ImageSigno.setImage(new Image("aquariof.png"));
        }
    
        if (signo.equals("Peixes")) {
          signoMensagem.setText(
            "Peixes, o ultimo signo do zodiaco eh profundo como um oceano e consegue navegar em dimensoes aonde os mais racionais nao chegam. Peixes esta ligado a assuntos que" +
            " envolvem introspeccao, como espiritualidade, empatia, a conexao universal e o inconsciente. Esse signo vem para nos lembrar das coisas que dao um sentido maior para a vida.");
    
          ImageSigno.setImage(new Image("peixesf.png"));
        }
    
        if (signo.equals("Aries")) {
          signoMensagem.setText(
            "Voce, ariana(o), eh independente e sempre da um jeito de resolver os desafios que estao a sua frente. Isso porque o primeiro signo do zodiaco tem uma natureza" +
            " competitiva, o que faz com que voce tenha uma motivacao propria, que independe da presenca de outras pessoas a sua volta. E, assim, alcanca sempre novos niveis de habilidade.");
  
          ImageSigno.setImage(new Image("ariesf.png"));
        }
        
        if (signo.equals("Touro")) {
          signoMensagem.setText(
            "Touro eh o signo ligado a vida material e, por isso, podemos dizer que ele esta relacionado ao seu dinheiro, a comida, posses, ao conforto e ao corpo." +
            " Touro eh ouro, saiba disso, taurina(o). Voce sabe valorizar tudo que eh tatil e que ativa o seu sensorial. Voce sabe enxergar a qualidade das coisas so de olhar.");
        
          ImageSigno.setImage(new Image("tourof.png"));
        }
        
        if (signo.equals("Gemeos")) {
          signoMensagem.setText(
            "Gemeos eh um dos signos mais engracados do zodiaco, gracas ao seu raciocinio rapido e sua habilidade de enxergar as coisas de um ponto de vista mais" +
            " leve. Essas qualidades fazem com que as geminianas possuam uma criatividade muito grande, no sentido de conseguirem pensar em solucoes inusitadas para qualquer problema.");
        
          ImageSigno.setImage(new Image("gemeosf.png"));
        }
        
        if (signo.equals("Cancer")) {
          signoMensagem.setText(
            "Algumas pessoas associam Cancer com carencia e choradeira. Seria como se ele ainda estivesse aprendendo a lidar com os sentimentos, e eh o que se ve em seu" +
            " jeito fofo, carinhoso e, as vezes, manhoso, infantil ou birrentinho. Cancer pode ter reacoes um pouco dramaticas, mas nao deixa de ter razao, afinal, o cuidado caloroso esta em" +
            " falta na sociedade.");
        
          ImageSigno.setImage(new Image("cancerf.png"));
        }
        
        if (signo.equals("Leao")) {
          signoMensagem.setText(
            "Se voce pensa que isso se traduziria em um desejo de ser famoso, pode ter razao. Mas, no caso de Leao, vamos rever esses parametros de sucesso. Sucesso para Leao" +
            " nao eh aonde voce chega, pois esse signo ja eh um sucesso so por nascer.");
        
          ImageSigno.setImage(new Image("leaof.png"));
        }
        
        if (signo.equals("Virgem")) {
          signoMensagem.setText(
            "A maioria das virginianas se orgulha das qualidades de seu signo, pois ele eh sinonimo de pragmatismo, trabalho, funcionalidade, organizacao e saude, coisas que sao" +
            " muito bem vindas por todos nos nos dias de hoje. Por se tratar de seres mais racionais, eles tendem a racionalizar tudo, inclusive os sentimentos, colocando assuntos mais dificeis ou doloridos" +
            " numa caixinha para organizar mais tarde." );

          ImageSigno.setImage(new Image("virgemf.png"));
        }

        if (signo.equals("Libra")) {
          signoMensagem.setText(
            " Libra eh um signo que usa suas habilidades para trazer harmonia a tudo que a cerca atraves de seu talento de enxergar a mesma coisa atraves de muitos pontos de vista." +
            " Num conflito, os librianos sabem olhar para a situacao e ver os pontos que as partes tem em comum, mostrando caminhos para o entendimento." );
            
          ImageSigno.setImage(new Image("libraf.png"));
        }
        
        if (signo.equals("Escorpiao")) {
          signoMensagem.setText(
            " Escorpiao eh o mais indecifravel de todos os signos, e ele prefere manter as coisas assim, do jeito que estao, sob seu controle, pois seu enigmatismo lhe confere" +
            " bastante poder. Esse signo tem a habilidade de ser invisivel e incapturavel, passar por lugares sem deixar rastros e envolver as pessoas de forma silenciosa e definitiva.");
            
          ImageSigno.setImage(new Image("escorpiaof.png"));
        }
        
        if (signo.equals("Sagitario")) {
          signoMensagem.setText(
            "Sagitario esta ligado ao elemento Fogo e eh o primeiro do grupo dos signos sociais. Eh o Fogo sem limites, e isso se reflete no seu jeito de olhar para o mundo." +
            " Fronteiras sao apenas conceitos, vagas de estacionamento sao mera marcacao e objetos nao tem dono, eles existem para serem compartilhados. Um misto de folgado, generoso e engracado por" +
            " natureza define.");
          
          ImageSigno.setImage(new Image("Sagitariof.png"));
        } 
      }

    });
  }
    
  @FXML
  void clickMouseBack(MouseEvent event) { //metodo de interacao com o botao "home" da tela final da GUI
    try{
      Principal.changescreen("inicial"); // troca para a tela inicial
    } catch(Exception e) {
      e.getLocalizedMessage();
    }
  }
  
  @FXML
  void entrarContato(ActionEvent event) { //metodo de interacao com o botao "contato" da tela final da GUI
    try {
      Principal.changescreen("contato"); //troca para a tela contato
    } catch(Exception e) {
      e.getLocalizedMessage();
    }
  }
    
}
