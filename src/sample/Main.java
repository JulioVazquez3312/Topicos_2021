package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.views.Calculadora;
import sample.views.Encriptador;
import sample.views.Rompecabezas;

public class Main extends Application {

    private VBox vBox;
    private MenuBar mnbarPrincipal;
    private Menu menComp1, menComp2, menCerrar;
    private MenuItem miCalc, miRompecabeza, miEncriptar, miSalir;
    private Scene escena;

    /*
    private HBox hBox;

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    private FlowPane flowpane = new FlowPane();
    */  //codigo de la tarea

    @Override
    public void start(Stage primaryStage) throws Exception{

        CrearUi();

        primaryStage.setTitle("clase 3");
        primaryStage.setScene(escena);
        primaryStage.setMaximized(true);
        primaryStage.show();

    }

    private void CrearUi() {
        vBox = new VBox();

        mnbarPrincipal = new MenuBar();
        menComp1 = new Menu("Competencia 1");
        menComp2 = new Menu("Competencia 1");
        menCerrar = new Menu("Cerrar ");
        mnbarPrincipal.getMenus().addAll( menComp1, menComp2, menCerrar);

        miCalc = new MenuItem("Calculadora");
        miCalc.setOnAction(event -> opcionesMenu(1));

        miRompecabeza = new MenuItem("Rompecabezas");//se agrega el item rompecabeza
        miRompecabeza.setOnAction(event -> opcionesMenu(2));

        miEncriptar = new MenuItem("Encriptar");
        miEncriptar.setOnAction( event -> opcionesMenu(3));

        menComp1.getItems().addAll(miCalc,miRompecabeza, miEncriptar);//se agrega item calc y rompecabeza

        miSalir = new MenuItem("Salir");
        miSalir.setOnAction( event -> { System.exit(0);});

        menCerrar.getItems().add(miSalir);
        vBox.getChildren().add(mnbarPrincipal);

        escena = new Scene(vBox, 300,100);

    /*
        GridPane grid = new GridPane();
        btn1 = new Button("Boton 1" );
        btn2 = new Button("Boton 2" );
        btn3 = new Button("Boton 3" );
        btn4 = new Button("Boton 4" );
        btn5 = new Button("Boton 5" );
        btn6 = new Button("Boton 6" );
        btn7 = new Button("Boton 7" );

        btn1.setStyle("-fx-background-color: #DCD429; -fx-font-size: 2em; ");
        btn2.setStyle("-fx-background-color: #43CD1E; -fx-font-size: 1.5em;  ");
        btn3.setStyle("-fx-background-color: #759FD8; -fx-font-size: 2em; -fx-border-width: 15px;");
        btn4.setStyle("-fx-background-color: #D153D5; -fx-font-size: 2.2em; -fx-border-width: 15px;");
        btn5.setStyle("-fx-background-color: #F66724; -fx-font-size: 2.2em; -fx-border-width: 15px;");
        btn6.setStyle("-fx-background-color: #E9F31C; -fx-font-size: 2.2em; -fx-border-width: 15px;");
        btn7.setStyle("-fx-background-color: #F794CA; -fx-font-size: 2.2em; -fx-border-width: 15px;");

        hBox = new HBox();
        vBox = new VBox();

        BorderPane pane = new BorderPane();
        Label lbl = new Label("Esta es una etiqueta");
        lbl.setStyle("-fx-background-color: #B5EEDB;");
        pane.setCenter(lbl);

        AnchorPane anchor= new AnchorPane();
        AnchorPane.setTopAnchor(btn6,7.0);
        AnchorPane.setRightAnchor(btn6,15.0);
        AnchorPane.setBottomAnchor(btn7,300.0);
        AnchorPane.setLeftAnchor(btn7,200.0);
        anchor.getChildren().addAll(btn6, btn7,new Button("botoncito"));


        hBox.getChildren().addAll(btn6,btn7,anchor );
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(20,20,20,20));

        flowpane.getChildren().addAll(btn1,btn2, btn3,lbl,grid, anchor, btn6, btn7 );
        flowpane.setHgap(10);
        flowpane.setVgap(10);
        flowpane.setPadding(new Insets(20));
        grid.add(btn4, 0, 1, 1, 1);
        grid.add(btn5, 1, 1, 1, 1);
*/  //codigo de la tarea
    }

    private void opcionesMenu(int opc) {
        switch (opc){
            case 1: new Calculadora(); break;
            case 2: new Rompecabezas();break;
            case 3: new Encriptador();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
