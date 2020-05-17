/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.service.custom;

import java.util.List;
import lk.ijse.mscs.dto.BatchDTO;
import lk.ijse.mscs.service.SuperService;

/**
 *
 * @author samishka
 */
public interface BatchService extends SuperService{

    public boolean addBatch(BatchDTO batch) throws Exception;

    public boolean deleteBatch(String bacthId) throws Exception;

    public boolean updateBatch(BatchDTO batch) throws Exception;

    public List<BatchDTO> getAllBatch() throws Exception;

    public BatchDTO searchBatch(String batchId) throws Exception;
}
