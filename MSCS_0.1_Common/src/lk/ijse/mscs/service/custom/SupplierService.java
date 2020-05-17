/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.service.custom;

import java.util.List;
import lk.ijse.mscs.dto.SupplierDTO;
import lk.ijse.mscs.service.SuperService;

/**
 *
 * @author samishka
 */
public interface SupplierService extends SuperService {

    public boolean addSupplier(SupplierDTO supplier) throws Exception;

    public boolean deleteSupplier(String supplierId) throws Exception;

    public boolean updateSupplier(SupplierDTO supplier) throws Exception;

    public List<SupplierDTO> getAllSupplier() throws Exception;

    public SupplierDTO searchSupplier(String supplierId) throws Exception;
}
