/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.controllers.usuarios;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import uvframework.tools.WindowsManager;

/**
 * FXML Controller class
 *
 * @author Rafael Maldonado
 */
public class UsuariosViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML 
    private void NuevoBtnClick(){
        WindowsManager.getStage("/usuarios/nuevo").show();
    }
    @FXML 
    private void DetalleBtnClick(){
        WindowsManager.getStage("/usuarios/detalle").show();
    }
    
}
