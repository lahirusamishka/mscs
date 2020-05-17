/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import lk.ijse.mscs.business.BOFactory;
import lk.ijse.mscs.business.custom.BatchBO;
import lk.ijse.mscs.dto.BatchDTO;
import lk.ijse.mscs.service.custom.BatchService;

/**
 *
 * @author samishka
 */
public class BatchServiceImpl extends UnicastRemoteObject implements BatchService {

    private BatchBO batchBO;

    public BatchServiceImpl() throws RemoteException {
        this.batchBO = (BatchBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.BATCH);
    }

    @Override
    public boolean addBatch(BatchDTO batch) throws Exception {
        boolean result = batchBO.addBatch(batch);
        return result;
    }

    @Override
    public boolean deleteBatch(String bacthId) throws Exception {
        boolean result = false;
        result = batchBO.deleteBatch(bacthId);
        return result;
    }

    @Override
    public boolean updateBatch(BatchDTO batch) throws Exception {
        boolean result = false;
        result = batchBO.updateBatch(batch);
        return result;
    }

    @Override
    public List<BatchDTO> getAllBatch() throws Exception {
        return batchBO.getAllBatch();
    }

    @Override
    public BatchDTO searchBatch(String batchId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
