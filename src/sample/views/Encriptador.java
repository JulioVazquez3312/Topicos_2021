package sample.views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
    private Button btnLimpiar;
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
        txtEncriptado.setWrapText(true);
        //txtEncriptado.addEventHandler(KeyEvent.KEY_TYPED, this);

        txtSalida = new TextArea();
        txtSalida.setEditable(false);
        txtSalida.setWrapText(true);

        hBox.getChildren().addAll(txtEncriptado, txtSalida);
        btnEncriptar = new Button("Encriptar entrada");
        btnEncriptar.setOnAction(event -> abrirArchivo());

        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setStyle("-fx-background-color: #759FD8;" +
                " -fx-font-size: 1em; " +
                "-fx-border-width: 5px;");
        btnLimpiar.setOnAction(event -> limpiar());

        vBox.getChildren().addAll(tolMenu, hBox,btnEncriptar, btnLimpiar);

        escena = new Scene(vBox, 600, 350);
    }

    private void limpiar() {
        txtEncriptado.clear();
        txtSalida.clear();
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
        texto = texto.toUpperCase();

        //System.out.println(texto);


        char[] caracteres = texto.toCharArray();

        for (char caracter : caracteres) {

            switch (caracter) {
                case 'A':
                    // int codigo = event.getCode().ordinal();
                    txtSalida.appendText("97");
                    break;
                case 'B':
                    txtSalida.appendText("98");
                    break;
                case 'C':
                    txtSalida.appendText("99");
                    break;
                case 'D':
                    txtSalida.appendText("100");
                    break;
                case 'E':
                    txtSalida.appendText("101");
                    break;
                case 'F':
                    txtSalida.appendText("102");
                    break;
                case 'G':
                    txtSalida.appendText("103");
                    break;
                case 'H':
                    txtSalida.appendText("104");
                    break;
                case 'I':
                    txtSalida.appendText("105");
                    break;
                case 'J':
                    txtSalida.appendText("106");
                    break;
                case 'K':
                    txtSalida.appendText("107");
                    break;
                case 'L':
                    txtSalida.appendText("108");
                    break;
                case 'M':
                    txtSalida.appendText("109");
                    break;
                case 'N':
                    txtSalida.appendText("110");
                    break;
                case 'Ñ':
                    txtSalida.appendText("164");
                    break;
                case 'O':
                    txtSalida.appendText("111");
                    break;
                case 'P':
                    txtSalida.appendText("112");
                    break;
                case 'Q':
                    txtSalida.appendText("113");
                    break;
                case 'R':
                    txtSalida.appendText("114");
                    break;
                case 'S':
                    txtSalida.appendText("115");
                    break;
                case 'T':
                    txtSalida.appendText("116");
                    break;
                case 'U':
                    txtSalida.appendText("117");
                    break;
                case 'V':
                    txtSalida.appendText("118");
                    break;
                case 'W':
                    txtSalida.appendText("119");
                    break;
                case 'X':
                    txtSalida.appendText("120");
                    break;
                case 'Y':
                    txtSalida.appendText("121");
                    break;
                case 'Z':
                    txtSalida.appendText("122");
                    break;
                case '\n':
                    txtSalida.appendText("\n");
                    break;
                default:
                    txtSalida.appendText("12312310");
            }
        }
    }

    @Override
    public void handle(KeyEvent event) {

        //txtSalida.appendText(event.getCode().ordinalg()+"");

        switch (event.getCode().toString()){
            case "A":
               // int codigo = event.getCode().ordinal();
                txtSalida.appendText("97");
                break;
            case "B":
                txtSalida.appendText("98");
                break;
            case "C":
                txtSalida.appendText("99");
                break;
            case "D":
                txtSalida.appendText("100");
                break;
            case "E":
                txtSalida.appendText("101");
                break;
            case "F":
                txtSalida.appendText("102");
                break;
            case "G":
                txtSalida.appendText("103");
                break;
            case "H":
                txtSalida.appendText("104");
                break;
            case "I":
                txtSalida.appendText("105");
                break;
            case "J":
                txtSalida.appendText("106");
                break;
            case "K":
                txtSalida.appendText("107");
                break;
            case "L":
                txtSalida.appendText("108");
                break;
            case "M":
                txtSalida.appendText("109");
                break;
            case "N":
                txtSalida.appendText("110");
                break;
            case "Ñ":
                txtSalida.appendText("164");
                break;
            case "O":
                txtSalida.appendText("111");
                break;
            case "P":
                txtSalida.appendText("112");
                break;
            case "Q":
                txtSalida.appendText("113");
                break;
            case "R":
                txtSalida.appendText("114");
                break;
            case "S":
                txtSalida.appendText("115");
                break;
            case "T":
                txtSalida.appendText("116");
                break;
            case "U":
                txtSalida.appendText("117");
                break;
            case "V":
                txtSalida.appendText("118");
                break;
            case "W":
                txtSalida.appendText("119");
                break;
            case "X":
                txtSalida.appendText("120");
                break;
            case "Y":
                txtSalida.appendText("121");
                break;
            case "Z":
                txtSalida.appendText("122");
                break;
            case "\n":
                txtSalida.appendText("\n");
                break;
            default:
                txtSalida.appendText("12312310");

        }
    }
}