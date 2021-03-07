package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private HBox hBox;
    private VBox vBox;
    private Button btn1, btn2, btn3;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        CrearUi();

        primaryStage.setTitle("clase 3");
        primaryStage.setScene(new Scene(vBox, 100, 200));
        primaryStage.show();
    }

    private void CrearUi() {
        btn1 = new Button("Boton1" );
        btn2 = new Button("Boton2" );
        btn3 = new Button("Boton3" );

        hBox = new HBox();
        vBox = new VBox();

        hBox.getChildren().addAll(btn1,btn2,btn3);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(20,20,20,20));

        vBox.getChildren().addAll(btn1,btn2, btn3);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20));
    }

    public static void main(String[] args) {

        launch(args);
    }

}
