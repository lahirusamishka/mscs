/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.service.custom;

import java.util.List;
import lk.ijse.mscs.dto.MobileOperaterDTO;
import lk.ijse.mscs.dto.ReceptionDTO;
import lk.ijse.mscs.service.SuperService;

/**
 *
 * @author samishka
 */
public interface MobileOperaterService extends SuperService{
    
    public boolean addOperater(MobileOperaterDTO operater) throws Exception;

    public boolean deleteOperater(String operaterId) throws Exception;

    public boolean updateOperater(MobileOperaterDTO operater) throws Exception;

    public List<MobileOperaterDTO> getAllOperater() throws Exception;

    public MobileOperaterDTO searchOperater(String operaterId) throws Exception;
}
