
package sample.views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Rompecabezas extends Stage implements EventHandler {

    private String[] arImagenes = {"fila-1-col-1.jpg",
            "fila-1-col-2.jpg", "fila-1-col-3.jpg", "fila-2-col-1.jpg",
            "fila-2-col-2.jpg", "fila-2-col-3.jpg", "fila-3-col-1.jpg", "fila-3-col-2.jpg",
            "fila-3-col-3.jpg"};
    private String[][] arAsignacion;
    private BorderPane borderpane;
    private GridPane tablero;
    private Button[][] btnTarje;
    private HBox hBox;
    private Label lblTarjetas;
    private TextField txtTarje;
    private Button btnMezclar;
    private Scene escena;
    private int numPieza;
    private boolean NumSelect = false; //indica si ya se selecciono una carta para el intercambio

    private int xTemp, yTemp = 0;

    public Rompecabezas() {

        CrearUI();
        this.setTitle("RompeCabezas");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {

        borderpane = new BorderPane();

        lblTarjetas = new Label("Cantidad Piezas");
        txtTarje = new TextField();
        btnMezclar = new Button("Mezclar Tarjetas");
        btnMezclar.addEventHandler(MouseEvent.MOUSE_CLICKED, this);

        hBox = new HBox();
        hBox.getChildren().addAll(lblTarjetas, txtTarje, btnMezclar);

        borderpane.setTop(hBox);

        tablero = new GridPane();
        borderpane.setCenter(tablero);

        escena = new Scene(borderpane, 820, 600);

    }

    @Override
    public void handle(Event event) {
        numPieza = Integer.parseInt(txtTarje.getText());
        btnTarje = new Button[numPieza][numPieza];
        arAsignacion = new String[3][3];
        revolver();


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Image img = new Image("sample/assets/" + arAsignacion[i][j]);
                ImageView imv = new ImageView(img);
                imv.setFitHeight(80);
                imv.setPreserveRatio(true);

                btnTarje[i][j] = new Button();
                int finalI = i;
                int finalJ = j;
                btnTarje[i][j].setOnAction(event1 -> intercambio(finalI, finalJ));
                btnTarje[i][j].setGraphic(imv);
                btnTarje[i][j].setPrefSize(50, 50);
                tablero.add(btnTarje[i][j], j, i);
            }
        }
    }

    private void intercambio(int i, int j) {
        //System.out.println("Posicion : "+i+" - "+j);
        if (!NumSelect) {
            NumSelect = !NumSelect;
            xTemp = i;
            yTemp = j;
        } else {
            Image img = new Image("sample/assets/" + arAsignacion[i][j]);
            ImageView imv = new ImageView(img);
            imv.setFitHeight(80);
            imv.setPreserveRatio(true);

            Image img2 = new Image("sample/assets/" + arAsignacion[xTemp][yTemp]);
            ImageView imv2 = new ImageView(img2);
            imv2.setFitHeight(80);
            imv2.setPreserveRatio(true);

            btnTarje[xTemp][yTemp].setGraphic(imv);
            btnTarje[i][j].setGraphic(imv2);

            NumSelect = false;
        }
    }

    private void revolver() {
        //Definir objetos String y llenando el arreglo bidimencional
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arAsignacion[i][j] = new String();
            }

        }
        int posx, posy = 0;
        for (int i = 0; i < arImagenes.length; ) {
            posx = (int) (Math.random() * 3);
            posy = (int) (Math.random() * 3);
            if (arAsignacion[posx][posy].equals("")) {
                arAsignacion[posx][posy] = arImagenes[i];
                i++;
            }
        }
    }
}
