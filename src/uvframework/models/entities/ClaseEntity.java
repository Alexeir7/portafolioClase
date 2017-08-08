/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.models.entities;

import java.beans.PropertyVetoException;
import uvframework.tools.validation.ConstrainedObject;

/**
 *
 * @author VILLALTA
 */
public class ClaseEntity extends ConstrainedObject{
    public String ClsCod;
    public String ClsNom;
    public String ClsDsc;
    public String ClsCrd;
    
    public void setClsCod(String newClsCod) throws PropertyVetoException{
        validate("ClsCod", ClsCod, newClsCod);
        ClsCod = newClsCod;
    }
    
    public void setClsNom(String newClsNom) throws PropertyVetoException{
        validate("ClsNom", ClsNom, newClsNom);
        ClsNom = newClsNom;
    }
    
    public void setClsDsc(String newClsDsc) throws PropertyVetoException{
        validate("ClsDsc", ClsDsc, newClsDsc);
        ClsDsc = newClsDsc;
    }
    
    public void setClsCrd(String newClsCrd) throws PropertyVetoException{
        validate("ClsCrd", ClsCrd, newClsCrd);
        ClsCrd = newClsCrd;
    }
    
    public String getClsCod(){
        return ClsCod;
    }
    
    public String getClsNom(){
        return ClsNom;
    }
    
    public String getClsDsc(){
        return ClsDsc;
    }
    
    public String getClsCrd(){
        return ClsCrd;
    }
}
