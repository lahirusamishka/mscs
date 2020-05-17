/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom;

import java.util.List;
import lk.ijse.mscs.business.SuperBO;
import lk.ijse.mscs.dto.AccessoriesDTO;

/**
 *
 * @author samishka
 */
public interface AccessoriesBO extends SuperBO {

    public boolean addAccessories(AccessoriesDTO accessories) throws Exception;

    public boolean deleteAccessories(String AccessoriesId) throws Exception;

    public boolean updateAccessories(AccessoriesDTO accessories) throws Exception;

    public List<AccessoriesDTO> getAllAccessories() throws Exception;

    public AccessoriesDTO searchAccessories(String accessories) throws Exception;
    
    
   
}
