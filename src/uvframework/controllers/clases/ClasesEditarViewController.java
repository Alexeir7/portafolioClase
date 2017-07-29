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
import javax.swing.JOptionPane;
import uvframework.UVF;
import uvframework.models.ClasesModel;
import uvframework.models.entities.ClaseEntity;
import uvframework.tools.WindowsManager;

/**
 * FXML Controller class
 *
 * @author alexe
 */
public class ClasesEditarViewController implements Initializable {
    
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
        
        ClaseEntity data = ClasesModel.getOne(UVF.workdata.get("ClsCod").toString());
        ClsCod.setText(data.ClsCod);
        ClsNom.setText(data.ClsNom);
        ClsDsc.setText(data.ClsDsc);
        ClsCrd.setText(data.ClsCrd);
        
    }
    
    @FXML
    private void CancelarBtnClick() {
        WindowsManager.getStage("/clases/editar").hide();

    }
    
    @FXML
    private void GuardarBtnClick(){
        ClaseEntity clase = new ClaseEntity();
        
        clase.ClsCod = ClsCod.getText();
        clase.ClsNom = ClsNom.getText();
        clase.ClsDsc = ClsDsc.getText();
        clase.ClsCrd = ClsCrd.getText();
        
        if(ClasesModel.Editar(clase)){
            JOptionPane.showMessageDialog(null, "Clase Actualizada");
            WindowsManager.getStage("/clases/editar").hide();
        }else{
            JOptionPane.showMessageDialog(null, "Error Actualizando clase");
        }
    }
    
}
