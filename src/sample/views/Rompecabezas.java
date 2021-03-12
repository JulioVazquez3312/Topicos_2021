package sample.views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Rompecabezas extends Stage implements EventHandler {

    private BorderPane borderpane;
    private GridPane tablero;
    private Button [][] btnTarje;
    private HBox hBox;
    private Label lblTarjetas;
    private TextField txtTarje;
    private Button btnMezclar;
    private Scene escena;

    private int numPieza;

    public Rompecabezas(){
        CrearUI();
        this.setTitle("Rompecabezas");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {

        borderpane = new BorderPane();

        //instanciar hbox
        lblTarjetas = new Label("Cantidad de piezas");
        txtTarje = new TextField();
        btnMezclar = new Button("Mezclar Tarjetas");
        btnMezclar.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
        hBox    = new HBox();
        hBox.getChildren().addAll(lblTarjetas,txtTarje,btnMezclar);

        borderpane.setTop(hBox);

        tablero = new GridPane();
        borderpane.setCenter(tablero);

        escena = new Scene(borderpane,800,600);

    }//crearUI

    @Override
    public void handle(Event event) {

        numPieza = Integer.parseInt( txtTarje.getText() );
        btnTarje = new Button[numPieza][numPieza];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btnTarje[i][j] = new Button();
                tablero.add(btnTarje[i][j],j,i);
            }//for j
        }//for i
    }//handle
}//class
