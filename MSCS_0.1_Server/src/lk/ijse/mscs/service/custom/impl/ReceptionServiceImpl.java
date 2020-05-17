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
import lk.ijse.mscs.business.custom.ReceptionBO;
import lk.ijse.mscs.dto.ReceptionDTO;
import lk.ijse.mscs.service.custom.ReceptionService;

/**
 *
 * @author samishka
 */
public class ReceptionServiceImpl extends UnicastRemoteObject implements ReceptionService {
    private ReceptionBO receptionBO;
    public ReceptionServiceImpl() throws RemoteException{
        this.receptionBO=(ReceptionBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RECEPTION);
    }

    @Override
    public boolean addReception(ReceptionDTO reception) throws Exception {
        boolean result= receptionBO.addReception(reception);
        return true;
    }

    @Override
    public boolean deleteReception(String receptionId) throws Exception {
        boolean result=false;
        result= receptionBO.deleteReception(receptionId);
        return result;
    }

    @Override
    public boolean updateReception(ReceptionDTO reception) throws Exception {
        boolean result=false;
        result = receptionBO.updateReception(reception);
        return result;
    }

    @Override
    public List<ReceptionDTO> getAllReception() throws Exception {
        return receptionBO.getAllReception();
    }

    @Override
    public ReceptionDTO searchReception(String receptionId) throws Exception {
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
