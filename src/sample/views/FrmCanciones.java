package sample.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.models.CancionesDAO;

public class FrmCanciones extends Stage {
    private TableView<CancionesDAO> tbvCanciones;
    private Button btnAgregar;
    private VBox vBox;
    private Scene escena;
    private CancionesDAO objCDAO;

    public FrmCanciones() {

        objCDAO = new CancionesDAO();
        CrearUI();
        this.setTitle("Gestion de conciones");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        tbvCanciones = new TableView<>();
        btnAgregar = new Button("Agregar");
        vBox.getChildren().addAll(tbvCanciones,btnAgregar);
        CrearTabla();
        escena = new Scene(vBox, 600,250);
    }

    private void CrearTabla() {
        TableColumn<CancionesDAO,Integer>  tbcIdCancion = new TableColumn<>("ID");
        tbcIdCancion.setCellValueFactory(new PropertyValueFactory<>("id_cancion"));

        TableColumn<CancionesDAO, String> tbcNomCancion = new TableColumn<>("Cancion");
        tbcIdCancion.setCellValueFactory(new PropertyValueFactory<>("nombre_canciones"));

        TableColumn<CancionesDAO, Integer> tbcDuracion = new TableColumn<>("Duracion");
        tbcDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));

        TableColumn<CancionesDAO, String> tbcPortada = new TableColumn<>("Portada");
        tbcPortada.setCellValueFactory(new PropertyValueFactory<>("portada"));

        TableColumn<CancionesDAO, Integer> tbcAnio = new TableColumn<>("Año");
        tbcAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));

        TableColumn<CancionesDAO, String> tbcLetra = new TableColumn<>("Letra");
        tbcLetra.setCellValueFactory(new PropertyValueFactory<>("letra"));

        TableColumn<CancionesDAO,String> tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(
                new Callback<TableColumn<CancionesDAO, String>, TableCell<CancionesDAO, String>>() {
                    @Override
                    public TableCell<CancionesDAO, String> call(TableColumn<CancionesDAO, String> param) {
                        return null;
                    }
                }
        );

        tbvCanciones.getColumns().addAll(tbcIdCancion,tbcNomCancion,tbcDuracion,tbcPortada,tbcAnio,tbcLetra, tbcEditar);
        tbvCanciones.setItems(objCDAO.SELECT());

    }

}
