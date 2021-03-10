package sample.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Stage {

    private Scene esena;
    private TextField txtOperacion;
    private HBox[] hBoxes;
    private Button[] arBtn;
    private VBox vBox;
    private  char[] arNumeros = {'7','8','9','/','4','5','6','*','1','2','3','+','0','.','=','-'};

    public Calculadora() {

        CrearUI();

        this.setTitle("Calculadora");
        this.setScene(esena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        hBoxes = new HBox[4];
        arBtn = new Button[16];
        txtOperacion = new TextField();
        txtOperacion.setEditable(false);
        txtOperacion.setPrefHeight(50);
        txtOperacion.setText("0");

        int pos = 0;
        for (int i = 0; i < hBoxes.length; i++ ){//iterarme para el arreglo de HBox
            hBoxes[i] = new HBox();
            hBoxes[i].setSpacing(10);
            hBoxes[i].setPadding( new Insets(7));

            for (int j = 0; j < 4; j++) {//ciclo para crear y cargar 4 botones
                arBtn[pos] = new Button(arNumeros[pos]+"");
                arBtn[pos].setPrefSize(50,50);
                hBoxes[i].getChildren().add(arBtn[pos]);
                pos++;//contador de botones creados
            }
        }

        vBox.getChildren().addAll(txtOperacion,hBoxes[0],hBoxes[1],hBoxes[2],hBoxes[3]);
        vBox.setPadding(new Insets(8,5,5,5));

        esena = new Scene(vBox, 250, 250);
    }//cearUI

}//class
