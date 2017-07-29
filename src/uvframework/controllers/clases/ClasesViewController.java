/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.controllers.clases;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import uvframework.UVF;
import uvframework.models.ClasesModel;
import uvframework.models.UsuariosModel;
import uvframework.tools.TableViewAdapter;
import uvframework.tools.TableViewColumn;
import uvframework.tools.TableViewRow;
import uvframework.tools.WindowsManager;

/**
 * FXML Controller class
 *
 * @author alexe
 */
public class ClasesViewController implements Initializable {

    @FXML
    private TableView ResultadoTable;
    
    @FXML
    private TextField Key;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ResultSet rs = ClasesModel.buscar("");

        TableViewAdapter tva = new TableViewAdapter(ResultadoTable);
        ArrayList titles = new ArrayList();

        titles.add(new TableViewColumn("ClsCod", "Codigo", 100.0));
        titles.add(new TableViewColumn("ClsNom", "Nombre", 100.0));
        titles.add(new TableViewColumn("ClsDsc", "Descripcion", 200.0));
        titles.add(new TableViewColumn("ClsCrd", "Creditos", 100.0));
        
        try {
            tva.fromResultSet(rs, titles);
        } catch (SQLException ex) {
            Logger.getLogger(ClasesViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    }

    @FXML
    private void NuevoBtnClick() {
        WindowsManager.getStage("/clases/nuevo").show();
    }

    @FXML
    private void DetalleBtnClick() {
        String ClsCod = ((TableViewRow) ResultadoTable.getSelectionModel().getSelectedItem()).get("ClsCod").toString();
        UVF.workdata.put("ClsCod", ClsCod);
        WindowsManager.getStage("/clases/detalle", true).show();
    }
    
    @FXML
    private void EditarBtnClick(){
        String ClsCod = ((TableViewRow) ResultadoTable.getSelectionModel().getSelectedItem()).get("ClsCod").toString();
        UVF.workdata.put("ClsCod", ClsCod);
        WindowsManager.getStage("/clases/editar", true).show();
    }

    @FXML
    private void BuscarBtnClick() throws SQLException {
        
        
        ResultSet rs = ClasesModel.buscar(Key.getText());

        TableViewAdapter tva = new TableViewAdapter(ResultadoTable);
        ArrayList titles = new ArrayList();

        titles.add(new TableViewColumn("ClsCod", "Codigo", 100.0));
        titles.add(new TableViewColumn("ClsNom", "Nombre", 100.0));
        titles.add(new TableViewColumn("ClsDsc", "Descripcion", 200.0));
        titles.add(new TableViewColumn("ClsCrd", "Creditos", 100.0));

        tva.setRowDoubleClickHandler((e) -> {
            this.TableRowClick();
        });

        tva.fromResultSet(rs, titles);
    }

    private void TableRowClick() {
        String ClsCod = ((TableViewRow) ResultadoTable.getSelectionModel().getSelectedItem()).get("ClsCod").toString();
        UVF.workdata.put("ClsCod", ClsCod);
        WindowsManager.getStage("/clases/editar", true).show();
    }
}
