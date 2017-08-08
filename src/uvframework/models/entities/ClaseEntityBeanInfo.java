/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uvframework.models.entities;

import java.beans.*;

import uvframework.tools.validation.Validator;
import uvframework.tools.validation.ValidatorTypes;

/**
 *
 * @author Rafael Maldonado
 */
public class ClaseEntityBeanInfo extends SimpleBeanInfo {

    Class targetClass = ClaseEntity.class;

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {

        try {
            PropertyDescriptor ClsCod = new PropertyDescriptor("ClsCod", targetClass, "getClsCod", "setClsCod");
            PropertyDescriptor ClsNom = new PropertyDescriptor("ClsNom", targetClass, "getClsNom", "setClsNom");
            PropertyDescriptor ClsDsc = new PropertyDescriptor("ClsDsc", targetClass, "getClsDsc", "setClsDsc");
            PropertyDescriptor ClsCrd = new PropertyDescriptor("ClsCrd", targetClass, "getClsCrd", "setClsCrd");

            ClsCod.setValue(Validator.TYPE, ValidatorTypes.STRING);
            ClsCod.setValue(Validator.MAX_CHAR, 20);
            ClsCod.setValue(Validator.NO_EMPTY, true);

            ClsNom.setValue(Validator.TYPE, ValidatorTypes.STRING);
            ClsNom.setValue(Validator.MAX_CHAR, 80);
            ClsNom.setValue(Validator.NO_EMPTY, true);

            ClsDsc.setValue(Validator.TYPE, ValidatorTypes.STRING);
            ClsDsc.setValue(Validator.MAX_CHAR, 200);

            ClsCrd.setValue(Validator.TYPE, ValidatorTypes.INTEGER);
            ClsCrd.setValue(Validator.IS_INTEGER, true);
            ClsCrd.setValue(Validator.NO_EMPTY, true);

            PropertyDescriptor[] pds = new PropertyDescriptor[]{ClsCod, ClsNom, ClsDsc, ClsCrd};

            return pds;

        } catch (IntrospectionException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
