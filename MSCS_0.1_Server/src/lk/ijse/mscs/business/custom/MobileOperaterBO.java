/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom;

import java.util.List;
import lk.ijse.mscs.business.SuperBO;
import lk.ijse.mscs.dto.MobileOperaterDTO;

/**
 *
 * @author samishka
 */
public interface MobileOperaterBO extends SuperBO {

    public boolean addOperater(MobileOperaterDTO operater) throws Exception;

    public boolean deleteOperater(String operaterId) throws Exception;

    public boolean updateOperater(MobileOperaterDTO operater) throws Exception;

    public List<MobileOperaterDTO> getAllOperater() throws Exception;

    public MobileOperaterDTO searchOperater(String operaterId) throws Exception;
}
