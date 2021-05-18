package sample.views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.CancionesDAO;


public class FrmCancion extends Stage {
    private Scene scene;
    private VBox vBox;
    private TextField txtNombre, textDuracion, txtPortada, txtYear;
    private TextArea txtLetra;
    private Button btnSave;
    private CancionesDAO objcanDAO;
    private TableView<CancionesDAO> tableVCansiones;

    public FrmCancion(TableView<CancionesDAO>tableVCansiones,CancionesDAO objcanDAO){
        this.tableVCansiones = tableVCansiones;
        if (objcanDAO != null)
            this.objcanDAO = objcanDAO;
        else
            this.objcanDAO = new CancionesDAO();
        CreateUI();
        this.setTitle("Gestion de canciones");
        this.setScene(scene);
        this.show();
    }

    private void CreateUI() {
        vBox= new VBox();
        vBox.setSpacing(10.0);
        vBox.setPadding(new Insets(10.0));

        txtNombre= new TextField();
        txtNombre.setText(objcanDAO.getNombre_canciones());
        txtNombre.setPromptText("Nombre de la cancion");
        textDuracion = new TextField();
        textDuracion.setText(String.valueOf(objcanDAO.getDuracion()));
        textDuracion.setPromptText("Duracion");
        txtPortada = new TextField();
        txtPortada.setText(objcanDAO.getPortada());
        txtPortada.setPromptText("portada");
        txtYear = new TextField();
        txtYear.setText(String.valueOf(objcanDAO.getAnio()));
        txtYear.setPromptText("Año");
        txtLetra = new TextArea();
        txtLetra.setText(objcanDAO.getLetra());
        txtLetra.setPromptText("Letra");
        btnSave= new Button("Save");

        btnSave.setOnAction(event -> {
            objcanDAO.setNombre_canciones(txtNombre.getText());
            objcanDAO.setDuracion(Integer.parseInt(textDuracion.getText()));
            objcanDAO.setPortada(txtPortada.getText());
            objcanDAO.setAnio(Integer.parseInt(txtYear.getText()));
            objcanDAO.setLetra(txtLetra.getText());

            if (objcanDAO.getId_cancion() > 0)
                objcanDAO.UPDATE();
            else
                objcanDAO.INSERT();

            tableVCansiones.setItems(objcanDAO.SELECT());
            tableVCansiones.refresh();
            this.close();
        });
        vBox.getChildren().addAll(txtNombre,textDuracion,txtPortada,txtYear,txtLetra,btnSave);
        scene = new Scene(vBox,250,300);

    }
}
