package sample.assets.components;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import sample.models.CancionesDAO;
import sample.views.FrmCancion;

import java.util.Optional;

public class CellCustom extends TableCell<CancionesDAO,String>{

    private Button btnCelda;
    private CancionesDAO objcanDAO;

    public CellCustom(int opc){
        //objcanDAO = CellCustom.this.getTableView().getItems().get(CellCustom.this.getIndex());
        if (opc == 1){
            btnCelda = new Button("Editar");
            btnCelda.setOnAction(event -> {
                objcanDAO= CellCustom.this.getTableView().getItems().get(CellCustom.this.getIndex());
                new FrmCancion(CellCustom.this.getTableView(),objcanDAO);
            });
        }
        else{
            btnCelda = new Button("Borrar");
            btnCelda.setOnAction(event ->{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Mensaje del Sistema");
                alert.setHeaderText("Confirmacion");
                alert.setContentText("¿Quiere usted borrar esta cancion?");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.get()==ButtonType.OK){
                    objcanDAO = CellCustom.this.getTableView().getItems().get(CellCustom.this.getIndex());
                    objcanDAO.DELETE();

                    CellCustom.this.getTableView().setItems(objcanDAO.SELECT());
                    CellCustom.this.getTableView().refresh();
                }
            });

        }
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty){
            setGraphic(btnCelda);
        }
    }
}
