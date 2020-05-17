/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.ijse.mscs.service.ServiceFactory;
import lk.ijse.mscs.service.SuperService;
import lk.ijse.mscs.service.custom.impl.AccessoriesServiceImpl;
import lk.ijse.mscs.service.custom.impl.BatchServiceImpl;
import lk.ijse.mscs.service.custom.impl.CustomerServiceImpl;
import lk.ijse.mscs.service.custom.impl.FinishedRepairsServiceImpl;
import lk.ijse.mscs.service.custom.impl.GRNServiceImpl;
import lk.ijse.mscs.service.custom.impl.ItemsServiceImpl;
import lk.ijse.mscs.service.custom.impl.MobileOperaterServiceImpl;
import lk.ijse.mscs.service.custom.impl.OrderDetailServiceImpl;
import lk.ijse.mscs.service.custom.impl.ReceptionServiceImpl;
import lk.ijse.mscs.service.custom.impl.SupplierOrderServiceImpl;
import lk.ijse.mscs.service.custom.impl.SupplierServiceImpl;
import lk.ijse.mscs.service.custom.impl.WarrantyServiceImpl;

/**
 *
 * @author samishka
 */
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory {

    private static ServiceFactoryImpl serviceFactoryImpl;

    private ServiceFactoryImpl() throws RemoteException {

    }

    public static ServiceFactoryImpl getInstance() throws RemoteException {
        if (serviceFactoryImpl == null) {
            serviceFactoryImpl = new ServiceFactoryImpl();
        }
        return serviceFactoryImpl;
    }

    @Override
    public SuperService getService(ServiceTypes type) throws Exception {
        switch (type) {
            case ACCESSORIES:
                return new AccessoriesServiceImpl();
            case BATCH:
                return new BatchServiceImpl();
            case FINISHEDREPAIR:
                return new FinishedRepairsServiceImpl();
            case GRN:
                return new GRNServiceImpl();
            case ITEM:
                return new ItemsServiceImpl();
            case MOBILEOPERATER:
                return new MobileOperaterServiceImpl();
            case RECEPTION:
                return new ReceptionServiceImpl();
            case SUPPLIERORDER:
                return new SupplierOrderServiceImpl();
            case SUPPLIER:
                return new SupplierServiceImpl();
            case WARRANTY:
                return new WarrantyServiceImpl();
            case ORDERDETAIL:
                return new OrderDetailServiceImpl();
            case CUSTOMER:
                return new CustomerServiceImpl();
            default:
            
                return null;

        }
    }

}
