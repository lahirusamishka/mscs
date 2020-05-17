/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Observer;
import lk.ijse.mscs.business.BOFactory;
import lk.ijse.mscs.business.custom.AccessoriesBO;
import lk.ijse.mscs.dto.AccessoriesDTO;
import lk.ijse.mscs.observer.Subject;
import lk.ijse.mscs.service.custom.AccessoriesService;

/**
 *
 * @author samishka
 */
public class AccessoriesServiceImpl extends UnicastRemoteObject implements AccessoriesService {

    private AccessoriesBO accessoriesBO;

    public AccessoriesServiceImpl() throws RemoteException {
        this.accessoriesBO = (AccessoriesBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ACCESSORIES);
    }

    @Override
    public boolean addAccessories(AccessoriesDTO accessories) throws Exception {
        boolean result = accessoriesBO.addAccessories(accessories);
        return result;
    }

    @Override
    public boolean deleteAccessories(String AccessoriesId) throws Exception {
        boolean result = false;
        result = accessoriesBO.deleteAccessories(AccessoriesId);
        return result;
    }

    @Override
    public boolean updateAccessories(AccessoriesDTO accessories) throws Exception {
        boolean result = false;
        result = accessoriesBO.updateAccessories(accessories);
        return result;
    }

    @Override
    public List<AccessoriesDTO> getAllAccessories() throws Exception {
        return accessoriesBO.getAllAccessories();
    }

    @Override
    public AccessoriesDTO searchAccessories(String accessories) throws Exception {
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
