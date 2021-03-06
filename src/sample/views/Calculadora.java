package sample.views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Stage implements EventHandler {

    private Scene esena;
    private TextField txtOperacion;
    private HBox[] hBoxes;
    private Button[] arBtn;
    private VBox vBox;
    private  char[] arNumeros = {'7','8','9','/','4','5','6','*','1','2','3','-','0','.','+','='};
    private String cadena ="";
    private String operando = "";
    private String numeros = "";
    private double operaciones;

    public Calculadora() {

        CrearUI();

        this.setTitle("Calculadora");
        this.setScene(esena);
        this.show();
    }//Calculadora

    private void CrearUI() {
        vBox = new VBox();
        hBoxes = new HBox[4];
        arBtn = new Button[16];
        txtOperacion = new TextField();
        txtOperacion.setEditable(false);
        txtOperacion.setPrefHeight(50);
        txtOperacion.setText("0");

        int pos = 0;
        for (int i = 0; i < hBoxes.length; i++ ){//iterador para el arreglo de HBox
            hBoxes[i] = new HBox();
            hBoxes[i].setSpacing(10);
            hBoxes[i].setPadding( new Insets(7));

            for (int j = 0; j < 4; j++) {//ciclo para crear y cargar 4 botones
                arBtn[pos] = new Button(arNumeros[pos]+"");
                //arBtn[pos].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventoCalcu(arBtn[pos]));
                arBtn[pos].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {

                        String caract = "" + event.getSource();

                        if(!String.valueOf(btnPresionado(caract)).equals("=")){
                            cadena += btnPresionado(caract);
                            if(!String.valueOf(btnPresionado(caract)).equals("+") && !String.valueOf(btnPresionado(caract)).equals("-")
                                    && !String.valueOf(btnPresionado(caract)).equals("*") && !String.valueOf(btnPresionado(caract)).equals("/")){
                                numeros += btnPresionado(caract);
                                //txtOperacion.setText("" + btnPresionado(caract));
                                txtOperacion.setText(cadena);
                            } else if(String.valueOf(btnPresionado(caract)).equals("+") || String.valueOf(btnPresionado(caract)).equals("-")
                                    || String.valueOf(btnPresionado(caract)).equals("*") || String.valueOf(btnPresionado(caract)).equals("/")){
                                txtOperacion.setText("");
                                cadena = "";
                                operaciones ++;
                                numeros += "-";
                                if(operaciones == 1){
                                    operando += btnPresionado(caract);
                                } else{
                                    operando += " " + btnPresionado(caract);
                                }
                            }
                        } else{
                            txtOperacion.setText(String.valueOf(soloPrueba(numeros,operando)));
                            cadena = "";
                            operando = "";
                            numeros = "";
                        }

                    }
                });

                arBtn[pos].setPrefSize(50,50);
                hBoxes[i].getChildren().add(arBtn[pos]);
                pos++;//contador de botones creados
            }
        }

        arBtn[pos-1].setId("font-button");

        vBox.getChildren().addAll(txtOperacion,hBoxes[0],hBoxes[1],hBoxes[2],hBoxes[3]);
        vBox.setPadding(new Insets(8,5,5,5));

        esena = new Scene(vBox, 250, 250);
        esena.getStylesheets().add(getClass().getResource("../css/styles_calcu.css").toExternalForm());
    }//cearUI

    @Override
    public void handle(Event event) {
        System.out.println("mi primer evento UwU ");
    }

    private char btnPresionado(String entrada){
        char caracter = Character.MIN_VALUE;
        caracter = entrada.charAt(entrada.length()-2);
        return caracter;
    }

    public double soloPrueba (String entrada, String operandos){
        double resultado = 0;
        String partCadena[] = entrada.split("-");
        switch (operandos){
            case "+":
                resultado = Double.parseDouble(partCadena[0]) + Double.parseDouble(partCadena[1]);
                break;
            case "-":
                resultado = Double.parseDouble(partCadena[0]) - Double.parseDouble(partCadena[1]);
                break;
            case "*":
                resultado = Double.parseDouble(partCadena[0]) * Double.parseDouble(partCadena[1]);
                break;
            case "/":
                resultado = Double.parseDouble(partCadena[0]) / Double.parseDouble(partCadena[1]);
                break;
        }
        return resultado;
    }


}//class Calculadora

class EventoCalcu implements EventHandler{

    char tecla;
    public EventoCalcu(char tecla){
        this.tecla = tecla;
    }

    @Override
    public void handle(Event event) {
        System.out.println("segundo evento :)");
    }
}//class EventoCalcu
