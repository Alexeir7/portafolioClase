/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.controllers.clases;

import java.beans.PropertyVetoException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import uvframework.models.ClasesModel;
import uvframework.models.entities.ClaseEntity;
import uvframework.tools.WindowsManager;

/**
 * FXML Controller class
 *
 * @author alexe
 */
public class ClasesNuevoViewController implements Initializable {

    @FXML private TextField ClsCod;
    @FXML private TextField ClsNom;
    @FXML private TextField ClsDsc;
    @FXML private TextField ClsCrd;

    @FXML
    private void CrearBtnClick() throws PropertyVetoException {
        
        ClaseEntity clase = new ClaseEntity();
        clase.setClsCod(ClsCod.getText());
        clase.setClsNom(ClsNom.getText());
        clase.setClsDsc(ClsDsc.getText());
        clase.setClsCrd(ClsCrd.getText());

        if (ClasesModel.Nuevo(clase)) {
            JOptionPane.showMessageDialog(null, "Clase Creada");
            WindowsManager.getStage("/clases/nuevo").hide();
        } else {
            JOptionPane.showMessageDialog(null, "Error creando clase");
        }
    }

    @FXML
    private void CancelarBtnClick() {
        WindowsManager.getStage("/clases/nuevo").hide();

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
