/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.mscs.business.BOFactory;
import lk.ijse.mscs.business.custom.CustomerBO;
import lk.ijse.mscs.dto.CustomerDTO;
import lk.ijse.mscs.observer.Subject;
import lk.ijse.mscs.reservation.impl.ReservationImpl;
import lk.ijse.mscs.service.custom.CustomerService;
import lk.ijse.mscs.observer.*;

/**
 *
 * @author samishka
 */
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService, Subject {

    private CustomerBO customerBO;
    private static ArrayList<Observer1> alObservers = new ArrayList<>();
    private static ReservationImpl<CustomerService> cusResBook = new ReservationImpl<>();

    public CustomerServiceImpl() throws RemoteException {
        customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
    }

    @Override
    public boolean addCustomer(CustomerDTO customer) throws Exception {
        boolean result = customerBO.addCustomer(customer);
        notifyObservers();
        return result;
    }

    @Override
    public boolean deleteCustomer(String customerid) throws Exception {
        boolean result = false;
        if (cusResBook.reserve(customerid, this, true)) {
            result = customerBO.deleteCustomer(customerid);
            notifyObservers();
            if (cusResBook.isInternalReservation(customerid)) {
                release(customerid);
            }
        }
        return result;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) throws Exception {
        boolean result = false;
        if (cusResBook.reserve(customer.getCustomerId(), this, true)) {
            result = customerBO.updateCustomer(customer);
            notifyObservers();
            if (cusResBook.isInternalReservation(customer.getCustomerId())) {
                release(customer.getCustomerId());
            }
        }
        return result;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        return customerBO.getAllCustomers();
    }

    @Override
    public CustomerDTO searchCustomer(String customerId) throws Exception {
        return customerBO.searchCustomer(customerId);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return cusResBook.reserve(id, this, false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return cusResBook.release(id);
    }

   

    @Override
    public void notifyObservers() throws Exception {
        new Thread(() -> {
            for (Observer1 observerss : alObservers) {

                try {
                    observerss.updateObservers();
                } catch (Exception ex) {
                    Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }).start();
    }

    @Override
    public List<CustomerDTO> findAllCustomers(String CustID) throws Exception {
        return customerBO.getAllCustomers();
    }

    @Override
    public void registerObserver(Observer1 observer) throws Exception {
        alObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer1 observer) throws Exception {
        alObservers.remove(observer);
    }

}
