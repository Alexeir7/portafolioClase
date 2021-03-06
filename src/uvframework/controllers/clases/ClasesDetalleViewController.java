/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.controllers.clases;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import uvframework.UVF;
import uvframework.models.ClasesModel;
import uvframework.models.entities.ClaseEntity;
import uvframework.tools.WindowsManager;

/**
 *
 * @author Jessica Reyes
 */
public class ClasesDetalleViewController implements Initializable {

    @FXML
    private TextField ClsCod;
    @FXML
    private TextField ClsNom;
    @FXML
    private TextField ClsDsc;
    @FXML
    private TextField ClsCrd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ClaseEntity data = ClasesModel.getOne(UVF.workdata.get("ClsCod").toString());
        ClsCod.setText(data.ClsCod);
        ClsNom.setText(data.ClsNom);
        ClsDsc.setText(data.ClsDsc);
        ClsCrd.setText(data.ClsCrd);
    }

    @FXML
    private void SalirBtnClick() {
        WindowsManager.getStage("/clases/detalle").hide();

    }
}
