/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uvframework.models.entities.ClaseEntity;
import uvframework.tools.MySQLConn;
/**
 *
 * @author VILLALTA
 */
public class ClasesModel {
        public static Boolean Nuevo(ClaseEntity clase){
        try {
           
            String qry = "INSERT INTO clase VALUES(?,?,?,?);";
            
            PreparedStatement pst = MySQLConn.conn.prepareStatement(qry);
            
            pst.setString(1, clase.ClsCod);
            pst.setString(2, clase.ClsNom);
            pst.setString(3, clase.ClsDsc);
            pst.setString(4, clase.ClsCrd);
            
            int err = pst.executeUpdate();
            
            return err != 0;
            
        } catch (SQLException ex) {
                       
            Logger.getLogger(UsuariosModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
