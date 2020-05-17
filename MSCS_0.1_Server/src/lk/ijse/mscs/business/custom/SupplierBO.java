/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom;

import java.util.List;
import lk.ijse.mscs.business.SuperBO;
import lk.ijse.mscs.dto.SupplierDTO;

/**
 *
 * @author samishka
 */
public interface SupplierBO extends SuperBO {

    public boolean addSupplier(SupplierDTO supplier) throws Exception;

    public boolean deleteSupplier(String supplierId) throws Exception;

    public boolean updateSupplier(SupplierDTO supplier) throws Exception;

    public List<SupplierDTO> getAllSupplier() throws Exception;

    public SupplierDTO searchSupplier(String supplierId) throws Exception;
}
