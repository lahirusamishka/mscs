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
import lk.ijse.mscs.business.custom.FinishedRepairBO;
import lk.ijse.mscs.dto.FinishedRepairDTO;
import lk.ijse.mscs.service.custom.FinishedRepairsService;

/**
 *
 * @author samishka
 */
public class FinishedRepairsServiceImpl extends UnicastRemoteObject implements FinishedRepairsService {

    private FinishedRepairBO finishedRepairBO;

    public FinishedRepairsServiceImpl() throws RemoteException {
        this.finishedRepairBO = (FinishedRepairBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.FINISHEDREPAIR);
    }

    @Override
    public boolean addFinishedRepairs(FinishedRepairDTO finishedRepair) throws Exception {
        boolean result = finishedRepairBO.addFinishedRepairs(finishedRepair);
        return result;
    }

    @Override
    public boolean deleteFinishedRepair(String FinishedRepairId) throws Exception {
        boolean result = false;
        result = finishedRepairBO.deleteFinishedRepair(FinishedRepairId);
        return result;
    }

    @Override
    public boolean updateFinishedRepair(FinishedRepairDTO finishedRepair) throws Exception {
        boolean result = false;
        result = finishedRepairBO.updateFinishedRepair(finishedRepair);
        return result;
    }

    @Override
    public List<FinishedRepairDTO> getAllFinishedRepairs() throws Exception {
        return finishedRepairBO.getAllFinishedRepairs();
    }

    @Override
    public FinishedRepairDTO searchfinishedRepair(String FinishedRepairId) throws Exception {
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
