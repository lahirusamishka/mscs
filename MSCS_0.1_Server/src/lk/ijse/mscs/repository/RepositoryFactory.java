/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.repository;

import lk.ijse.mscs.repository.custom.impl.AccessoriesRepositoryImpl;
import lk.ijse.mscs.repository.custom.impl.BatchRepositoryImpl;
import lk.ijse.mscs.repository.custom.impl.CustomerOrderRepositoryImpl;
import lk.ijse.mscs.repository.custom.impl.CustomerRepositoryImpl;
import lk.ijse.mscs.repository.custom.impl.FinishedRepairRepositoryImpl;
import lk.ijse.mscs.repository.custom.impl.GRNRepositoryImpl;
import lk.ijse.mscs.repository.custom.impl.ItemRepositoryImpl;
import lk.ijse.mscs.repository.custom.impl.MobileOperaterRepositoryImpl;
import lk.ijse.mscs.repository.custom.impl.OrderDetailRepositoryImpl;
import lk.ijse.mscs.repository.custom.impl.ReceptionRepositoryImpl;
import lk.ijse.mscs.repository.custom.impl.SupplierOrderRepositoryImpl;
import lk.ijse.mscs.repository.custom.impl.SupplierRepositoryImpl;
import lk.ijse.mscs.repository.custom.impl.WarrantyRepositoryImpl;

/**
 *
 * @author samishka
 */
public class RepositoryFactory {

    public enum RepositoryTypes {
        ACCESSORIES, BATCH, CUSTOMERORDER, FINISHEDREPAIR, GRN, ITEM, MOBILEOPERATER, RECEPTION, SUPPLIER, SUPPLIERORDER, WARRANTY,CUSTOMER,ORDERDETAIL
    }

    private static RepositoryFactory repositoryFactory;

    private RepositoryFactory() {
    }

    public static RepositoryFactory getInstance() {
        if (repositoryFactory == null) {
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }

    public SuperRepository getRepository(RepositoryTypes types) {
        switch (types) {
            case ACCESSORIES:
                return new AccessoriesRepositoryImpl();
            case BATCH:
                return new BatchRepositoryImpl();
            case CUSTOMERORDER:
                return new CustomerOrderRepositoryImpl();
            case FINISHEDREPAIR:
                return new FinishedRepairRepositoryImpl();
            case GRN:
                return new GRNRepositoryImpl();
            case ITEM:
                return new ItemRepositoryImpl();
            case MOBILEOPERATER:
                return new MobileOperaterRepositoryImpl();
            case RECEPTION:
                return new ReceptionRepositoryImpl();
            case SUPPLIER:
                return new SupplierRepositoryImpl();
            case SUPPLIERORDER:
                return new SupplierOrderRepositoryImpl();
            case WARRANTY:
                return new WarrantyRepositoryImpl();
            case CUSTOMER:
                return new CustomerRepositoryImpl();
            case ORDERDETAIL:
                return new OrderDetailRepositoryImpl();
            default:
                
                return null;
        }

    }
}
