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
import lk.ijse.mscs.business.custom.OrderDetailBO;
import lk.ijse.mscs.dto.OperaterOrderDTO;
import lk.ijse.mscs.dto.OrderDetailDTO;
import lk.ijse.mscs.observer.Observer1;
import lk.ijse.mscs.observer.Subject;
import lk.ijse.mscs.service.custom.OrderDetailService;

/**
 *
 * @author samishka
 */
public class OrderDetailServiceImpl extends UnicastRemoteObject implements OrderDetailService, Subject {

    private OrderDetailBO orderDetailBO;

    public OrderDetailServiceImpl() throws RemoteException {
        orderDetailBO = (OrderDetailBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDERDETAIL);
    }

    @Override
    public boolean addOrderDetails(List<OrderDetailDTO> list) throws Exception {
        return orderDetailBO.addOrderDetails(list);
    }

    @Override
    public boolean addPlaceOrder(OperaterOrderDTO operator) throws Exception {
        return orderDetailBO.addPlaceOrder(operator);
    }

    @Override
    public List<OrderDetailDTO> getallOrderDetails() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updatePlaceOrder(OperaterOrderDTO operator) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletePlaceOrder(String OID) throws Exception {
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

    @Override
    public void notifyObservers() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registerObserver(Observer1 observer) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unregisterObserver(Observer1 observer) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
