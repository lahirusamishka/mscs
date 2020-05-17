/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import lk.ijse.mscs.business.BOFactory;
import lk.ijse.mscs.business.custom.GRNBO;
import lk.ijse.mscs.dto.GRNDTO;
import lk.ijse.mscs.service.custom.GRNService;

/**
 *
 * @author samishka
 */
public class GRNServiceImpl extends UnicastRemoteObject implements GRNService {

    private GRNBO grnbo;

    public GRNServiceImpl() throws RemoteException {
        this.grnbo = (GRNBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.GRN);
    }

    @Override
    public boolean addGRN(GRNDTO grn) throws Exception {
        boolean result = grnbo.addGRN(grn);
        return result;
    }

    @Override
    public boolean deleteGRN(String DTOId) throws Exception {
        boolean result = false;
        result = grnbo.deleteGRN(DTOId);
        return result;
    }

    @Override
    public boolean updateGRN(GRNDTO grn) throws Exception {
        boolean result = false;
        result = grnbo.updateGRN(grn);
        return result;
    }

    @Override
    public List<GRNDTO> getAllGRN() throws Exception {
        return grnbo.getAllGRN();
    }

    @Override
    public GRNDTO search(String DTOId) throws Exception {
        return grnbo.search(DTOId);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
