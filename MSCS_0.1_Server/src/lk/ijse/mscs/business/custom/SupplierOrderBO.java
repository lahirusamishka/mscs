/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom;

import java.util.List;
import lk.ijse.mscs.business.SuperBO;
import lk.ijse.mscs.dto.SupplierOrderDTO;

/**
 *
 * @author samishka
 */
public interface SupplierOrderBO extends SuperBO {

    public boolean addSupplierOrder(SupplierOrderDTO supplierOrder) throws Exception;

    public boolean deleteSupplierOrder(String SupplierOrderId) throws Exception;

    public boolean updateSupplierOrder(SupplierOrderDTO supplierOrder) throws Exception;

    public List<SupplierOrderDTO> getAllSupplierOrder() throws Exception;

    public SupplierOrderDTO searchSupplierOrder(String supplierOrder) throws Exception;
}
