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
import lk.ijse.mscs.business.custom.WarrantyBO;
import lk.ijse.mscs.dto.WarrantyDTO;
import lk.ijse.mscs.service.custom.WarrantyService;

/**
 *
 * @author samishka
 */
public class WarrantyServiceImpl extends UnicastRemoteObject implements WarrantyService {

    private WarrantyBO warrantyBO;

    public WarrantyServiceImpl() throws RemoteException {
        this.warrantyBO = (WarrantyBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.WARRANTY);
    }

    @Override
    public boolean addWarranty(WarrantyDTO warranty) throws Exception {
        boolean result = warrantyBO.addWarranty(warranty);
        return result;

    }

    @Override
    public boolean deleteWarranty(String warrantyId) throws Exception {
        boolean result = false;
        result = warrantyBO.deleteWarranty(warrantyId);
        return result;
    }

    @Override
    public boolean updateWarranty(WarrantyDTO warranty) throws Exception {
        boolean result = false;
        result = warrantyBO.updateWarranty(warranty);
        return result;

    }

    @Override
    public List<WarrantyDTO> getAllWarranty() throws Exception {
        return warrantyBO.getAllWarranty();
    }

    @Override
    public WarrantyDTO search(String warrantyId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
