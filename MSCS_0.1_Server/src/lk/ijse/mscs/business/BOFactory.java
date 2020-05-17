/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business;

import lk.ijse.mscs.business.custom.impl.AccessoriesBOImpl;
import lk.ijse.mscs.business.custom.impl.BatchBOImpl;
import lk.ijse.mscs.business.custom.impl.CustomerBOImpl;
import lk.ijse.mscs.business.custom.impl.FinishedRepairBOImpl;
import lk.ijse.mscs.business.custom.impl.GRNBOImpl;
import lk.ijse.mscs.business.custom.impl.ItemBOImpl;
import lk.ijse.mscs.business.custom.impl.MobileOperaterBOImpl;
import lk.ijse.mscs.business.custom.impl.OrderDetailBOImpl;
import lk.ijse.mscs.business.custom.impl.ReceptionBOImpl;
import lk.ijse.mscs.business.custom.impl.SupplierBOImpl;
import lk.ijse.mscs.business.custom.impl.SupplierOrderBOImpl;
import lk.ijse.mscs.business.custom.impl.WarrantyBOImpl;

/**
 *
 * @author samishka
 */
public class BOFactory {

    public enum BOTypes {
        ACCESSORIES, BATCH, FINISHEDREPAIR, GRN, ITEM, MOBILEOPERATER, RECEPTION, SUPPLIER, SUPPLIERORDER, WARRANTY, CUSTOMER, ORDERDETAIL
    }
    private static BOFactory bOFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }

    public SuperBO getBO(BOTypes type) {
        switch (type) {
            case ACCESSORIES:
                return new AccessoriesBOImpl();
            case BATCH:
                return new BatchBOImpl();
            case FINISHEDREPAIR:
                return new FinishedRepairBOImpl();
            case GRN:
                return new GRNBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case MOBILEOPERATER:
                return new MobileOperaterBOImpl();
            case RECEPTION:
                return new ReceptionBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case SUPPLIERORDER:
                return new SupplierOrderBOImpl();
            case WARRANTY:
                return new WarrantyBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case ORDERDETAIL:
                return new OrderDetailBOImpl();
            default:
                return null;
        }
    }
}
