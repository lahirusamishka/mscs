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
import lk.ijse.mscs.business.custom.SupplierBO;
import lk.ijse.mscs.dto.SupplierDTO;
import lk.ijse.mscs.service.custom.SupplierService;

/**
 *
 * @author samishka
 */
public class SupplierServiceImpl extends UnicastRemoteObject implements SupplierService {

    private SupplierBO supplierBO;

    public SupplierServiceImpl() throws RemoteException {
        this.supplierBO = (SupplierBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPPLIER);
    }

    @Override
    public boolean addSupplier(SupplierDTO supplier) throws Exception {
        boolean result = supplierBO.addSupplier(supplier);
        return result;
    }

    @Override
    public boolean deleteSupplier(String supplierId) throws Exception {
        boolean result = false;
        result = supplierBO.deleteSupplier(supplierId);
        return result;
    }

    @Override
    public boolean updateSupplier(SupplierDTO supplier) throws Exception {
        boolean result = false;
        result = supplierBO.updateSupplier(supplier);
        return result;
    }

    @Override
    public List<SupplierDTO> getAllSupplier() throws Exception {
        return supplierBO.getAllSupplier();
    }

    @Override
    public SupplierDTO searchSupplier(String supplierId) throws Exception {
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
