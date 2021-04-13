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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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
    private File archivo;
    private String texto = "";

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
        archivo = fileChooser.showOpenDialog(this);
        leerArchivo();

    }

    private void leerArchivo() {

        if (archivo != null) {
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;

            try {
                fileReader = new FileReader(archivo);
                bufferedReader = new BufferedReader(fileReader);
                String linea = bufferedReader.readLine();
                while (linea != null) {
                    texto = texto + linea + "\n";
                    linea = bufferedReader.readLine();
                }
            } catch (Exception e) {
                //txtEncriptado.appendText(e.toString());
                System.out.println(e.toString());
            } finally {
                try {
                    fileReader.close();
                } catch (Exception e2) {
                    //txtEncriptado.appendText(e2.toString());
                    System.out.println(e2.toString());
                }
            }
            txtEncriptado.appendText(texto);
            encriptarArchivo(texto);
        }
    }
    public void encriptarArchivo(String texto){
        System.out.println(texto);

        char[] caracteres = texto.toCharArray();

        for (int i = 0; i < caracteres.length; i++) {

            switch (caracteres[i]) {
                case 'A':
                case 'a':
                    txtSalida.appendText("bb");
                    break;
                case 'B':
                case 'b':
                    txtSalida.appendText("cc");
                    break;
                case 'C':
                case 'c':
                    txtSalida.appendText("aa");
                    break;
                case 'D':
                case 'd':
                    txtSalida.appendText("xx");
                    break;
                case 'M':
                case 'm':
                    txtSalida.appendText("ff");
                    break;
                case ' ':
                    txtSalida.appendText("\t");
                    break;
                case '\n':
                    txtSalida.appendText("\n");
                    break;
            }
        }
    }

    @Override
    public void handle(KeyEvent event) {

        //txtSalida.appendText(event.getCode().ordinalg()+"");

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
}