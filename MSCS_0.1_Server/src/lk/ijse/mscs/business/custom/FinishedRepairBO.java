/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.business.custom;

import java.util.List;
import lk.ijse.mscs.business.SuperBO;
import lk.ijse.mscs.dto.FinishedRepairDTO;

/**
 *
 * @author samishka
 */
public interface FinishedRepairBO extends SuperBO {

    public boolean addFinishedRepairs(FinishedRepairDTO finishedRepair) throws Exception;

    public boolean deleteFinishedRepair(String FinishedRepairId) throws Exception;

    public boolean updateFinishedRepair(FinishedRepairDTO finishedRepair) throws Exception;

    public List<FinishedRepairDTO> getAllFinishedRepairs() throws Exception;

    public FinishedRepairDTO searchfinishedRepair(String FinishedRepairId) throws Exception;
}
