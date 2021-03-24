package sample.views;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Encriptador extends Stage implements EventHandler<KeyEvent>{

    private Scene escena;
    private HBox hBox;
    private VBox vBox;
    private ToolBar tolMenu;
    private TextArea txtEncriptado;
    private TextArea txtSalida;
    private Button btnEncriptar;
    private Button btnTolAbrir;
    private FileChooser fileChooser;

    public Encriptador(){

        CrearUI();

        this.setTitle("Funcion de encriptacion con HASH");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        tolMenu = new ToolBar();
        btnTolAbrir = new Button();

        ImageView img = new ImageView("sample/assets/iconopen.png");
        img.setFitHeight(35);
        img.setPreserveRatio(true);

        btnTolAbrir.setGraphic(img);
        btnTolAbrir.setOnAction(event -> abrirArchivo());
        tolMenu.getItems().add(btnTolAbrir);

        hBox = new HBox();
        txtEncriptado = new TextArea();
        txtEncriptado.setOnKeyPressed(this);
        //txtEncriptado.addEventHandler(KeyEvent.KEY_TYPED, this);

        txtSalida = new TextArea();
        txtSalida.setEditable(false);


        hBox.getChildren().addAll(txtEncriptado, txtSalida);
        btnEncriptar = new Button("Encriptar entrada");
        btnEncriptar.setOnAction(event -> abrirArchivo());

        vBox.getChildren().addAll(tolMenu, hBox,btnEncriptar);

        escena = new Scene(vBox, 600, 350);
    }

    private void abrirArchivo() {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar archivo a encriptar : ");
        fileChooser.showOpenDialog(this);
    }

    @Override
    public void handle(KeyEvent event) {

        //txtSalida.appendText(event.getCode().ordinal()+"");

        switch (event.getCode().toString()){
            case "A":
               // int codigo = event.getCode().ordinal();
                txtSalida.appendText("bb");
                break;
            case "B":
                txtSalida.appendText("cc");
                break;
        }
    }
}//class Encriptador