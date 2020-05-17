/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.mscs.service.ServiceFactory;
import lk.ijse.mscs.service.SuperService;
import lk.ijse.mscs.service.custom.AccessoriesService;
import lk.ijse.mscs.service.custom.BatchService;
import lk.ijse.mscs.service.custom.CustomerOrderService;
import lk.ijse.mscs.service.custom.CustomerService;
import lk.ijse.mscs.service.custom.FinishedRepairsService;
import lk.ijse.mscs.service.custom.GRNService;
import lk.ijse.mscs.service.custom.ItemsService;
import lk.ijse.mscs.service.custom.MobileOperaterService;
import lk.ijse.mscs.service.custom.OrderDetailService;
import lk.ijse.mscs.service.custom.ReceptionService;
import lk.ijse.mscs.service.custom.SupplierOrderService;
import lk.ijse.mscs.service.custom.SupplierService;
import lk.ijse.mscs.service.custom.WarrantyService;

/**
 *
 * @author samishka
 */
public class ProxyHandler implements ServiceFactory {

    private static ProxyHandler proxyHandler;

    private ServiceFactory serviceFactory;

    private AccessoriesService accessoriesService;
    private BatchService batchService;
    private CustomerOrderService customerOrderService;
    private FinishedRepairsService finishedRepairsService;
    private GRNService gRNService;
    private ItemsService itemsService;
    private MobileOperaterService mobileOperaterService;
    private ReceptionService receptionService;
    private SupplierOrderService supplierOrderService;
    private SupplierService supplierService;
    private WarrantyService warrantyService;
    private CustomerService customerService;
    private OrderDetailService orderDetailService;

    private ProxyHandler() {
        try {
            serviceFactory = (ServiceFactory) Naming.lookup("rmi://localhost:5050/MSCS");

            accessoriesService = (AccessoriesService) serviceFactory.getService(ServiceTypes.ACCESSORIES);
            batchService = (BatchService) serviceFactory.getService(ServiceTypes.BATCH);
            finishedRepairsService = (FinishedRepairsService) serviceFactory.getService(ServiceTypes.FINISHEDREPAIR);
            gRNService = (GRNService) serviceFactory.getService(ServiceTypes.GRN);
            itemsService = (ItemsService) serviceFactory.getService(ServiceTypes.ITEM);
            mobileOperaterService = (MobileOperaterService) serviceFactory.getService(ServiceTypes.MOBILEOPERATER);
            receptionService = (ReceptionService) serviceFactory.getService(ServiceTypes.RECEPTION);
            supplierOrderService = (SupplierOrderService) serviceFactory.getService(ServiceTypes.SUPPLIERORDER);
            supplierService = (SupplierService) serviceFactory.getService(ServiceTypes.SUPPLIER);
            warrantyService = (WarrantyService) serviceFactory.getService(ServiceTypes.WARRANTY);
            customerService = (CustomerService) serviceFactory.getService(ServiceTypes.CUSTOMER);
            orderDetailService = (OrderDetailService) serviceFactory.getService(ServiceTypes.ORDERDETAIL);

        } catch (NotBoundException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ProxyHandler getInstance() {
        if (proxyHandler == null) {
            proxyHandler = new ProxyHandler();
        }
        return proxyHandler;
    }

    @Override
    public SuperService getService(ServiceTypes type) throws Exception {
        switch (type) {
            case ACCESSORIES:
                return accessoriesService;
            case BATCH:
                return batchService;
            case FINISHEDREPAIR:
                return finishedRepairsService;
            case GRN:
                return gRNService;
            case ITEM:
                return itemsService;
            case MOBILEOPERATER:
                return mobileOperaterService;
            case RECEPTION:
                return receptionService;
            case SUPPLIER:
                return supplierService;
            case SUPPLIERORDER:
                return supplierOrderService;
            case WARRANTY:
                return warrantyService;
            case CUSTOMER:
                return customerService;
            case ORDERDETAIL:
                return orderDetailService;
            default:
                return null;
        }
    }
}
