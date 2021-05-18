package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.assets.components.Runner;

public class Pista extends Stage {
    Scene scene;
    private VBox vBox;
    private ProgressBar[] carriles;
    private Runner[] Runners;
    private String[] nameRunners = {"Bob Toronja", "Homero", "Flash","Quick Silver","Chuerk"};

    public Pista(){
        CrearUI();
        this.setTitle("Pista de Atletismo :)");
        this.setScene(scene);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        vBox.setSpacing(10.0);
        vBox.setPadding(new Insets(10.0));
        carriles = new ProgressBar[5];
        Runners = new Runner[5];
        for (int i=0; i < carriles.length; i++){
            carriles[i] = new ProgressBar(0);
            carriles[i].setPrefWidth(180);
            Runners[i] = new Runner(nameRunners[i],carriles[i]);
            //|||Runners[i].setPriority();
            Runners[i].start();
            vBox.getChildren().add(carriles[i]);

        }
        scene =new Scene(vBox,200,180);
    }
}