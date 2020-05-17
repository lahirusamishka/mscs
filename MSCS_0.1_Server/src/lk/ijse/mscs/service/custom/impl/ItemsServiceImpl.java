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
import lk.ijse.mscs.business.custom.ItemBO;
import lk.ijse.mscs.dto.ItemsDTO;
import lk.ijse.mscs.service.custom.ItemsService;

/**
 *
 * @author samishka
 */
public class ItemsServiceImpl extends UnicastRemoteObject implements ItemsService {

    private ItemBO itemBO;

    public ItemsServiceImpl() throws RemoteException {
        this.itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
    }

    @Override
    public boolean addItem(ItemsDTO items) throws Exception {
        boolean result = itemBO.addItem(items);
        return result;
    }

    @Override
    public boolean deleteItem(String itemId) throws Exception {
        boolean result = false;
        result = itemBO.deleteItem(itemId);
        return result;
    }

    @Override
    public boolean updateItem(ItemsDTO items) throws Exception {
        boolean result = false;
        result = itemBO.updateItem(items);
        return result;
    }

    @Override
    public List<ItemsDTO> getAllItems() throws Exception {
        return itemBO.getAllItems();
    }

    @Override
    public ItemsDTO searchItem(String itemId) throws Exception {
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
