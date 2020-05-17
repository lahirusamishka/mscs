/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom;

import java.util.List;
import lk.ijse.mscs.business.SuperBO;
import lk.ijse.mscs.dto.WarrantyDTO;

/**
 *
 * @author samishka
 */
public interface WarrantyBO extends SuperBO {

    public boolean addWarranty(WarrantyDTO warranty) throws Exception;

    public boolean deleteWarranty(String warrantyId) throws Exception;

    public boolean updateWarranty(WarrantyDTO warranty) throws Exception;

    public List<WarrantyDTO> getAllWarranty() throws Exception;

    public WarrantyDTO search(String warrantyId) throws Exception;
}
