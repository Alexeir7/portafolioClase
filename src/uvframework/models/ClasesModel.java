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

    public static Boolean Nuevo(ClaseEntity clase) {
        try {

            String qry = "INSERT INTO clase VALUES(?,?,?,?);";

            PreparedStatement pst = MySQLConn.conn.prepareStatement(qry);

            pst.setString(1, clase.ClsCod);
            pst.setString(2, clase.ClsNom);
            pst.setString(3, clase.ClsDsc);
            pst.setString(4, clase.ClsCrd);

            int err = pst.executeUpdate();

            if (err != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {

            Logger.getLogger(ClasesModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static Boolean Editar(ClaseEntity clase) {
        try {

            String qry = "UPDATE clase SET ClsNom = ?, ClsDsc = ?, ClsCrd = ? WHERE ClsCod = ?;";

            PreparedStatement pst = MySQLConn.conn.prepareStatement(qry);

            pst.setString(1, clase.ClsNom);
            pst.setString(2, clase.ClsDsc);
            pst.setString(3, clase.ClsCrd);
            pst.setString(4, clase.ClsCod);

            int err = pst.executeUpdate();

            return err != 0;

        } catch (SQLException ex) {

            Logger.getLogger(ClasesModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static ResultSet buscar(String key) {
        try {

            String qry = "SELECT * FROM clase WHERE ClsNom LIKE ?;";

            PreparedStatement pst = MySQLConn.conn.prepareStatement(qry);

            pst.setString(1, '%' + key + '%');

            return pst.executeQuery();

        } catch (SQLException ex) {

            Logger.getLogger(ClasesModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static ClaseEntity getOne(String ClsCod) {
        try {
            ClaseEntity row = new ClaseEntity();
            String qry = "SELECT * FROM clase WHERE ClsCod = ?;";

            PreparedStatement pst = MySQLConn.conn.prepareStatement(qry);
            pst.setString(1, ClsCod);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                row.ClsCod = rs.getString("ClsCod");
                row.ClsNom = rs.getString("ClsNom");
                row.ClsDsc = rs.getString("ClsDsc");
                row.ClsCrd = rs.getString("ClsCrd");
            } else {
                row = null;
            }

            return row;

        } catch (SQLException ex) {

            Logger.getLogger(ClasesModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
