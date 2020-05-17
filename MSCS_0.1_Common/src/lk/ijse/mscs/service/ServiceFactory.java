/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.service;

import java.rmi.Remote;

/**
 *
 * @author samishka
 */
public interface ServiceFactory extends Remote{
     
    public enum ServiceTypes{
        ACCESSORIES,BATCH,FINISHEDREPAIR,GRN,ITEM,MOBILEOPERATER,RECEPTION,SUPPLIER,SUPPLIERORDER,WARRANTY,CUSTOMER,ORDERDETAIL
    }
    
    public SuperService getService(ServiceTypes type) throws Exception;
}
