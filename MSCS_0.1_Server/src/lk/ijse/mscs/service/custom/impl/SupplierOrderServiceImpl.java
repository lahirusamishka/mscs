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
import lk.ijse.mscs.business.custom.SupplierOrderBO;
import lk.ijse.mscs.dto.SupplierOrderDTO;
import lk.ijse.mscs.service.custom.SupplierOrderService;

/**
 *
 * @author samishka
 */
public class SupplierOrderServiceImpl extends UnicastRemoteObject implements SupplierOrderService {
    private SupplierOrderBO supplierOrderBO;
    public SupplierOrderServiceImpl() throws RemoteException {
        this.supplierOrderBO=(SupplierOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPPLIERORDER);
    }

    @Override
    public boolean addSupplierOrder(SupplierOrderDTO supplierOrder) throws Exception {
        boolean result=supplierOrderBO.addSupplierOrder(supplierOrder);
        return result;
    }

    @Override
    public boolean deleteSupplierOrder(String SupplierOrderId) throws Exception {
        boolean result=false;
        result = supplierOrderBO.deleteSupplierOrder(SupplierOrderId);
       return result;
    }

    @Override
    public boolean updateSupplierOrder(SupplierOrderDTO supplierOrder) throws Exception {
        boolean result=false;
        result = supplierOrderBO.updateSupplierOrder(supplierOrder);
        return result;
    }

    @Override
    public List<SupplierOrderDTO> getAllSupplierOrder() throws Exception {
        return supplierOrderBO.getAllSupplierOrder();
    }

    @Override
    public SupplierOrderDTO searchSupplierOrder(String supplierOrder) throws Exception {
        return supplierOrderBO.searchSupplierOrder(supplierOrder);
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
